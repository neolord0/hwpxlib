import JSZip from 'jszip';
import { XMLParser } from 'fast-xml-parser';
import { HWPXFile } from '../object/HWPXFile.js';
import { MimeTypes } from '../commonstrings/MimeTypes.js';
import { ZipEntryName } from '../commonstrings/ZipEntryName.js';
import { FileIDs } from '../commonstrings/FileIDs.js';
import { TargetApplicationSort } from '../object/root/VersionXMLFile.js';
import { Para } from '../object/content/section_xml/paragraph/Para.js';
import { Run } from '../object/content/section_xml/paragraph/Run.js';
import { T, NormalText } from '../object/content/section_xml/paragraph/T.js';
import fs from 'fs';

/**
 * HWPX file reader
 */
export class HWPXReader {
  /**
   * Reads an HWPX file from a file path
   * @param {string} filepath - Path to the HWPX file
   * @returns {Promise<HWPXFile>}
   */
  static async fromFilepath(filepath) {
    const data = fs.readFileSync(filepath);
    return HWPXReader.fromBuffer(data);
  }

  /**
   * Reads an HWPX file from a Buffer or ArrayBuffer
   * @param {Buffer|ArrayBuffer|Uint8Array} data - File data
   * @returns {Promise<HWPXFile>}
   */
  static async fromBuffer(data) {
    const reader = new HWPXReader();
    await reader._openZipFile(data);
    await reader._checkMimeType();
    reader._createHWPXFileObject();
    await reader._read();
    return reader._hwpxFile;
  }

  constructor() {
    this._zip = null;
    this._hwpxFile = null;
    this._xmlParser = new XMLParser({
      ignoreAttributes: false,
      attributeNamePrefix: '@_',
      textNodeName: '#text',
      preserveOrder: false,
      trimValues: true,
      parseTagValue: false,
      parseAttributeValue: false
    });
  }

  async _openZipFile(data) {
    this._zip = await JSZip.loadAsync(data);
  }

  async _checkMimeType() {
    const mimetypeEntry = this._zip.file(ZipEntryName.MimeType);
    if (!mimetypeEntry) {
      throw new Error('Not a valid HWPX file: mimetype entry not found');
    }
    const mimetype = await mimetypeEntry.async('string');
    if (mimetype.trim() !== MimeTypes.HWPX) {
      throw new Error(`Not a valid HWPX file: unexpected mimetype "${mimetype}"`);
    }
  }

  _createHWPXFileObject() {
    this._hwpxFile = new HWPXFile();
  }

  async _read() {
    await this._readVersionXML();
    await this._readContainerXML();
    await this._readManifestXML();
    await this._readContentHPF();
    await this._readPackagedFiles();
  }

  async _readVersionXML() {
    const content = await this._readXMLFile(ZipEntryName.Version);
    if (!content) return;

    const version = content['hv:HCFVersion'] || content['HCFVersion'];
    if (!version) return;

    const versionFile = this._hwpxFile.versionXMLFile();

    // Read attributes
    const targetApp = version['@_tagetApplication'] || version['@_targetApplication'];
    if (targetApp) {
      versionFile.targetApplicationSet(TargetApplicationSort.fromString(targetApp) || targetApp);
    }

    if (version['@_application']) {
      versionFile.applicationSet(version['@_application']);
    }
    if (version['@_appVersion']) {
      versionFile.appVersionSet(version['@_appVersion']);
    }
    if (version['@_os']) {
      versionFile.osSet(version['@_os']);
    }

    // Read version numbers
    const v = versionFile.version();
    if (version['@_major']) v.majorSet(parseInt(version['@_major']));
    if (version['@_minor']) v.minorSet(parseInt(version['@_minor']));
    if (version['@_micro']) v.microSet(parseInt(version['@_micro']));
    if (version['@_buildNumber']) v.buildNumberSet(parseInt(version['@_buildNumber']));
  }

  async _readContainerXML() {
    const content = await this._readXMLFile(ZipEntryName.Container);
    if (!content) return;

    const container = content['ocf:container'] || content['container'];
    if (!container) return;

    const containerFile = this._hwpxFile.containerXMLFile();

    const rootfilesElem = container['ocf:rootfiles'] || container['rootfiles'];
    if (rootfilesElem) {
      containerFile.createRootFiles();

      let rootfiles = rootfilesElem['ocf:rootfile'] || rootfilesElem['rootfile'];
      if (!Array.isArray(rootfiles)) {
        rootfiles = rootfiles ? [rootfiles] : [];
      }

      for (const rf of rootfiles) {
        const rootFile = containerFile.rootFiles().addNew();
        rootFile.fullPathSet(rf['@_full-path']);
        rootFile.mediaTypeSet(rf['@_media-type']);
      }
    }
  }

  async _readManifestXML() {
    try {
      const content = await this._readXMLFile(ZipEntryName.Manifest);
      if (!content) return;

      const manifest = content['odf:manifest'] || content['manifest'];
      if (!manifest) return;

      let fileEntries = manifest['odf:file-entry'] || manifest['file-entry'];
      if (!Array.isArray(fileEntries)) {
        fileEntries = fileEntries ? [fileEntries] : [];
      }

      const manifestFile = this._hwpxFile.manifestXMLFile();
      for (const entry of fileEntries) {
        const fileEntry = manifestFile.addFileEntry();
        fileEntry.fullPathSet(entry['@_full-path']);
        fileEntry.mediaTypeSet(entry['@_media-type']);
        if (entry['@_size']) {
          fileEntry.sizeSet(parseInt(entry['@_size']));
        }
      }
    } catch (e) {
      // Manifest is optional
    }
  }

  async _readContentHPF() {
    const packagePath = this._hwpxFile.containerXMLFile().packageXMLFilePath();
    if (!packagePath) return;

    const content = await this._readXMLFile(packagePath);
    if (!content) return;

    const pkg = content['opf:package'] || content['package'];
    if (!pkg) return;

    const contentFile = this._hwpxFile.contentHPFFile();
    contentFile.versionSet(pkg['@_version']);
    contentFile.uniqueIdentifierSet(pkg['@_unique-identifier']);

    // Read metadata
    const metadata = pkg['opf:metadata'] || pkg['metadata'];
    if (metadata) {
      const title = metadata['opf:title'] || metadata['title'];
      if (title) {
        contentFile.titleSet(typeof title === 'string' ? title : title['#text']);
      }
      const lang = metadata['opf:language'] || metadata['language'];
      if (lang) {
        contentFile.languageSet(typeof lang === 'string' ? lang : lang['#text']);
      }
    }

    // Read manifest
    const manifestElem = pkg['opf:manifest'] || pkg['manifest'];
    if (manifestElem) {
      contentFile.createManifest();

      let items = manifestElem['opf:item'] || manifestElem['item'];
      if (!Array.isArray(items)) {
        items = items ? [items] : [];
      }

      for (const item of items) {
        const manifestItem = contentFile.manifest().addItem();
        manifestItem.idSet(item['@_id']);
        manifestItem.hrefSet(item['@_href']);
        manifestItem.mediaTypeSet(item['@_media-type']);
      }
    }

    // Read spine
    const spineElem = pkg['opf:spine'] || pkg['spine'];
    if (spineElem) {
      contentFile.createSpine();

      let itemrefs = spineElem['opf:itemref'] || spineElem['itemref'];
      if (!Array.isArray(itemrefs)) {
        itemrefs = itemrefs ? [itemrefs] : [];
      }

      for (const ref of itemrefs) {
        const itemRef = contentFile.spine().addItemRef();
        itemRef.idrefSet(ref['@_idref']);
      }
    }
  }

  async _readPackagedFiles() {
    const manifest = this._hwpxFile.contentHPFFile().manifest();
    if (!manifest) return;

    for (const item of manifest.items()) {
      const mediaType = item.mediaType();
      const href = item.href();
      const id = item.id();

      if (mediaType === MimeTypes.XML) {
        // Read XML content files
        if (id === FileIDs.Settings) {
          await this._readSettingsXML(href);
        } else if (id === FileIDs.Header) {
          await this._readHeaderXML(href);
        } else if (id && id.startsWith(FileIDs.Section_Prefix)) {
          const sectionIndex = parseInt(id.substring(FileIDs.Section_Prefix.length));
          await this._readSectionXML(href, sectionIndex);
        } else if (id && id.startsWith(FileIDs.MasterPage_Prefix)) {
          // MasterPage - skip for now
        }
      } else if (item.hasAttachedFile()) {
        // Read binary files (images, OLE, etc.)
        await this._readBinaryFile(item);
      }
    }
  }

  async _readSettingsXML(href) {
    const content = await this._readXMLFile(href);
    if (!content) return;

    const settings = content['ha:HWPApplicationSetting'] || content['HWPApplicationSetting'];
    if (!settings) return;

    const settingsFile = this._hwpxFile.settingsXMLFile();

    const caretPos = settings['ha:CaretPosition'] || settings['CaretPosition'];
    if (caretPos) {
      settingsFile.createCaretPosition();
      const cp = settingsFile.caretPosition();
      if (caretPos['@_listIDRef']) cp.listIDRefSet(parseInt(caretPos['@_listIDRef']));
      if (caretPos['@_paraIDRef']) cp.paraIDRefSet(parseInt(caretPos['@_paraIDRef']));
      if (caretPos['@_pos']) cp.posSet(parseInt(caretPos['@_pos']));
    }
  }

  async _readHeaderXML(href) {
    const content = await this._readXMLFile(href);
    if (!content) return;

    // Header parsing is complex - we store the raw content for now
    // Full implementation would parse all header elements
    const header = content['hh:head'] || content['head'];
    if (!header) return;

    // Basic parsing can be expanded as needed
  }

  async _readSectionXML(href, sectionIndex) {
    const content = await this._readXMLFile(href);
    if (!content) return;

    const section = content['hs:sec'] || content['sec'];
    if (!section) return;

    // Ensure we have enough sections in the list
    while (this._hwpxFile.sectionXMLFileList().count() <= sectionIndex) {
      this._hwpxFile.sectionXMLFileList().addNew();
    }

    const sectionFile = this._hwpxFile.sectionXMLFileList().get(sectionIndex);

    // Read paragraphs
    let paras = section['hp:p'] || section['p'];
    if (!Array.isArray(paras)) {
      paras = paras ? [paras] : [];
    }

    for (const p of paras) {
      const para = sectionFile.addNewPara();
      this._readPara(para, p);
    }
  }

  _readPara(para, pData) {
    // Set attributes
    if (pData['@_id']) para.idSet(pData['@_id']);
    if (pData['@_paraPrIDRef']) para.paraPrIDRefSet(pData['@_paraPrIDRef']);
    if (pData['@_styleIDRef']) para.styleIDRefSet(pData['@_styleIDRef']);
    if (pData['@_pageBreak']) para.pageBreakSet(pData['@_pageBreak'] === 'true');
    if (pData['@_columnBreak']) para.columnBreakSet(pData['@_columnBreak'] === 'true');

    // Read runs
    let runs = pData['hp:run'] || pData['run'];
    if (!Array.isArray(runs)) {
      runs = runs ? [runs] : [];
    }

    for (const r of runs) {
      const run = para.addNewRun();
      this._readRun(run, r);
    }
  }

  _readRun(run, rData) {
    if (rData['@_charPrIDRef']) run.charPrIDRefSet(rData['@_charPrIDRef']);

    // Read run items - text elements
    let texts = rData['hp:t'] || rData['t'];
    if (!Array.isArray(texts)) {
      texts = texts ? [texts] : [];
    }

    for (const t of texts) {
      const tObj = run.addNewT();
      this._readT(tObj, t);
    }

    // Read other run items (tables, pictures, etc.) - simplified for now
    // Full implementation would handle all object types
  }

  _readT(tObj, tData) {
    if (tData['@_charPrIDRef']) tObj.charPrIDRefSet(tData['@_charPrIDRef']);

    // Get text content
    if (typeof tData === 'string') {
      tObj.addText(tData);
    } else if (tData['#text']) {
      tObj.addText(tData['#text']);
    }
  }

  async _readBinaryFile(item) {
    const href = item.href();
    const file = this._zip.file(href);
    if (!file) return;

    item.createAttachedFile();
    item.attachedFile().data = await file.async('uint8array');
  }

  async _readXMLFile(path) {
    const file = this._zip.file(path);
    if (!file) return null;

    const xmlString = await file.async('string');
    try {
      return this._xmlParser.parse(xmlString);
    } catch (e) {
      console.error(`Error parsing XML at ${path}:`, e.message);
      return null;
    }
  }
}

export default HWPXReader;
