import JSZip from 'jszip';
import { MimeTypes } from '../commonstrings/MimeTypes.js';
import { ZipEntryName } from '../commonstrings/ZipEntryName.js';
import { FileIDs } from '../commonstrings/FileIDs.js';
import { T, NormalText } from '../object/content/section_xml/paragraph/T.js';
import fs from 'fs';

/**
 * XML String Builder - helps construct XML documents
 */
class XMLStringBuilder {
  constructor() {
    this._buffer = [];
    this._indent = 0;
  }

  /**
   * Adds XML declaration
   */
  xmlDeclaration(version = '1.0', encoding = 'UTF-8') {
    this._buffer.push(`<?xml version="${version}" encoding="${encoding}"?>`);
    return this;
  }

  /**
   * Opens an element with attributes
   * @param {string} name - Element name
   * @param {Object} attrs - Attributes
   * @param {boolean} selfClose - Whether to self-close the element
   */
  openElement(name, attrs = {}, selfClose = false) {
    let tag = `<${name}`;
    for (const [key, value] of Object.entries(attrs)) {
      if (value !== null && value !== undefined) {
        tag += ` ${key}="${this._escapeAttr(String(value))}"`;
      }
    }
    tag += selfClose ? '/>' : '>';
    this._buffer.push(tag);
    if (!selfClose) this._indent++;
    return this;
  }

  /**
   * Closes an element
   * @param {string} name - Element name
   */
  closeElement(name) {
    this._indent--;
    this._buffer.push(`</${name}>`);
    return this;
  }

  /**
   * Adds text content
   * @param {string} text - Text content
   */
  text(text) {
    if (text !== null && text !== undefined) {
      this._buffer.push(this._escapeText(String(text)));
    }
    return this;
  }

  /**
   * Adds an element with text content
   * @param {string} name - Element name
   * @param {string} content - Text content
   * @param {Object} attrs - Attributes
   */
  element(name, content, attrs = {}) {
    if (content === null || content === undefined) {
      this.openElement(name, attrs, true);
    } else {
      this.openElement(name, attrs);
      this.text(content);
      this.closeElement(name);
    }
    return this;
  }

  /**
   * Returns the built XML string
   */
  toString() {
    return this._buffer.join('');
  }

  /**
   * Clears the buffer
   */
  clear() {
    this._buffer = [];
    this._indent = 0;
    return this;
  }

  _escapeAttr(str) {
    return str
      .replace(/&/g, '&amp;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&apos;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;');
  }

  _escapeText(str) {
    return str
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;');
  }
}

/**
 * HWPX file writer
 */
export class HWPXWriter {
  /**
   * Writes an HWPX file to a file path
   * @param {HWPXFile} hwpxFile - The HWPX file object
   * @param {string} filepath - Output file path
   */
  static async toFilepath(hwpxFile, filepath) {
    const buffer = await HWPXWriter.toBuffer(hwpxFile);
    fs.writeFileSync(filepath, buffer);
  }

  /**
   * Writes an HWPX file to a Buffer
   * @param {HWPXFile} hwpxFile - The HWPX file object
   * @returns {Promise<Buffer>}
   */
  static async toBuffer(hwpxFile) {
    const writer = new HWPXWriter(hwpxFile);
    await writer._write();
    return writer._zip.generateAsync({ type: 'nodebuffer', compression: 'DEFLATE' });
  }

  /**
   * Writes an HWPX file to a Uint8Array
   * @param {HWPXFile} hwpxFile - The HWPX file object
   * @returns {Promise<Uint8Array>}
   */
  static async toBytes(hwpxFile) {
    const writer = new HWPXWriter(hwpxFile);
    await writer._write();
    return writer._zip.generateAsync({ type: 'uint8array', compression: 'DEFLATE' });
  }

  constructor(hwpxFile) {
    this._hwpxFile = hwpxFile;
    this._zip = new JSZip();
    this._xsb = new XMLStringBuilder();
  }

  async _write() {
    this._writeMimeType();
    this._writeVersionXML();
    this._writeManifestXML();
    this._writeContainerXML();
    this._writeContentHPF();
    this._writeContentFiles();
    this._writeChartFiles();
    this._writeUnparsedXMLFiles();
  }

  _writeMimeType() {
    this._zip.file(ZipEntryName.MimeType, MimeTypes.HWPX);
  }

  _writeVersionXML() {
    const version = this._hwpxFile.versionXMLFile();
    const v = version.version();

    this._xsb.clear()
      .xmlDeclaration()
      .openElement('hv:HCFVersion', {
        'xmlns:hv': 'urn:hancom:hwp:version',
        'tagetApplication': version.targetApplication(),
        'major': v.major(),
        'minor': v.minor(),
        'micro': v.micro(),
        'buildNumber': v.buildNumber(),
        'os': version.os(),
        'application': version.application(),
        'appVersion': version.appVersion()
      }, true);

    this._zip.file(ZipEntryName.Version, this._xsb.toString());
  }

  _writeManifestXML() {
    const manifest = this._hwpxFile.manifestXMLFile();

    this._xsb.clear()
      .xmlDeclaration()
      .openElement('odf:manifest', {
        'xmlns:odf': 'urn:oasis:names:tc:opendocument:xmlns:manifest:1.0'
      });

    for (const entry of manifest.fileEntries()) {
      this._xsb.openElement('odf:file-entry', {
        'full-path': entry.fullPath(),
        'media-type': entry.mediaType(),
        'size': entry.size()
      }, true);
    }

    this._xsb.closeElement('odf:manifest');
    this._zip.file(ZipEntryName.Manifest, this._xsb.toString());
  }

  _writeContainerXML() {
    const container = this._hwpxFile.containerXMLFile();

    this._xsb.clear()
      .xmlDeclaration()
      .openElement('ocf:container', {
        'xmlns:ocf': 'urn:oasis:names:tc:opendocument:xmlns:container'
      });

    if (container.rootFiles()) {
      this._xsb.openElement('ocf:rootfiles');
      for (const rootFile of container.rootFiles().items()) {
        this._xsb.openElement('ocf:rootfile', {
          'full-path': rootFile.fullPath(),
          'media-type': rootFile.mediaType()
        }, true);
      }
      this._xsb.closeElement('ocf:rootfiles');
    }

    this._xsb.closeElement('ocf:container');
    this._zip.file(ZipEntryName.Container, this._xsb.toString());
  }

  _writeContentHPF() {
    const content = this._hwpxFile.contentHPFFile();
    const packagePath = this._hwpxFile.containerXMLFile().packageXMLFilePath();
    if (!packagePath) return;

    this._xsb.clear()
      .xmlDeclaration()
      .openElement('opf:package', {
        'xmlns:opf': 'http://www.idpf.org/2007/opf',
        'version': content.version() || '1.0',
        'unique-identifier': content.uniqueIdentifier() || 'bookid'
      });

    // Metadata
    this._xsb.openElement('opf:metadata');
    if (content.title()) {
      this._xsb.element('opf:title', content.title());
    }
    if (content.language()) {
      this._xsb.element('opf:language', content.language());
    }
    this._xsb.closeElement('opf:metadata');

    // Manifest
    if (content.manifest()) {
      this._xsb.openElement('opf:manifest');
      for (const item of content.manifest().items()) {
        this._xsb.openElement('opf:item', {
          'id': item.id(),
          'href': item.href(),
          'media-type': item.mediaType()
        }, true);
      }
      this._xsb.closeElement('opf:manifest');
    }

    // Spine
    if (content.spine()) {
      this._xsb.openElement('opf:spine');
      for (const ref of content.spine().itemRefs()) {
        this._xsb.openElement('opf:itemref', {
          'idref': ref.idref()
        }, true);
      }
      this._xsb.closeElement('opf:spine');
    }

    this._xsb.closeElement('opf:package');
    this._zip.file(packagePath, this._xsb.toString());
  }

  _writeContentFiles() {
    const manifest = this._hwpxFile.contentHPFFile().manifest();
    if (!manifest) return;

    for (const item of manifest.items()) {
      const id = item.id();
      const href = item.href();

      if (id === FileIDs.Settings) {
        this._writeSettingsXML(href);
      } else if (id === FileIDs.Header) {
        this._writeHeaderXML(href);
      } else if (id && id.startsWith(FileIDs.Section_Prefix)) {
        const sectionIndex = parseInt(id.substring(FileIDs.Section_Prefix.length));
        this._writeSectionXML(href, sectionIndex);
      } else if (item.hasAttachedFile() && item.attachedFile()) {
        this._zip.file(href, item.attachedFile().data);
      }
    }
  }

  _writeSettingsXML(href) {
    const settings = this._hwpxFile.settingsXMLFile();

    this._xsb.clear()
      .xmlDeclaration()
      .openElement('ha:HWPApplicationSetting', {
        'xmlns:ha': 'urn:hancom:hwp:app'
      });

    if (settings.caretPosition()) {
      const cp = settings.caretPosition();
      this._xsb.openElement('ha:CaretPosition', {
        'listIDRef': cp.listIDRef(),
        'paraIDRef': cp.paraIDRef(),
        'pos': cp.pos()
      }, true);
    }

    this._xsb.closeElement('ha:HWPApplicationSetting');
    this._zip.file(href, this._xsb.toString());
  }

  _writeHeaderXML(href) {
    // Simplified header XML - full implementation would write all header elements
    this._xsb.clear()
      .xmlDeclaration()
      .openElement('hh:head', {
        'xmlns:hh': 'urn:hancom:hwp:head',
        'xmlns:hc': 'urn:hancom:hwp:core'
      });

    // Write minimal required elements
    this._xsb.openElement('hh:refList');
    this._xsb.openElement('hh:fontfaces').closeElement('hh:fontfaces');
    this._xsb.openElement('hh:borderFills').closeElement('hh:borderFills');
    this._xsb.openElement('hh:charProperties').closeElement('hh:charProperties');
    this._xsb.openElement('hh:tabProperties').closeElement('hh:tabProperties');
    this._xsb.openElement('hh:numberings').closeElement('hh:numberings');
    this._xsb.openElement('hh:bullets').closeElement('hh:bullets');
    this._xsb.openElement('hh:paraProperties').closeElement('hh:paraProperties');
    this._xsb.openElement('hh:styles').closeElement('hh:styles');
    this._xsb.openElement('hh:memoProperties').closeElement('hh:memoProperties');
    this._xsb.closeElement('hh:refList');

    this._xsb.closeElement('hh:head');
    this._zip.file(href, this._xsb.toString());
  }

  _writeSectionXML(href, sectionIndex) {
    const sectionList = this._hwpxFile.sectionXMLFileList();
    if (sectionIndex >= sectionList.count()) return;

    const section = sectionList.get(sectionIndex);

    this._xsb.clear()
      .xmlDeclaration()
      .openElement('hs:sec', {
        'xmlns:hs': 'urn:hancom:hwp:sec',
        'xmlns:hp': 'urn:hancom:hwp:paragraph',
        'xmlns:hc': 'urn:hancom:hwp:core'
      });

    for (const para of section.paras()) {
      this._writePara(para);
    }

    this._xsb.closeElement('hs:sec');
    this._zip.file(href, this._xsb.toString());
  }

  _writePara(para) {
    const attrs = {};
    if (para.id()) attrs['id'] = para.id();
    if (para.paraPrIDRef()) attrs['paraPrIDRef'] = para.paraPrIDRef();
    if (para.styleIDRef()) attrs['styleIDRef'] = para.styleIDRef();
    if (para.pageBreak() !== null) attrs['pageBreak'] = para.pageBreak();
    if (para.columnBreak() !== null) attrs['columnBreak'] = para.columnBreak();

    this._xsb.openElement('hp:p', attrs);

    for (const run of para.runs()) {
      this._writeRun(run);
    }

    this._xsb.closeElement('hp:p');
  }

  _writeRun(run) {
    const attrs = {};
    if (run.charPrIDRef()) attrs['charPrIDRef'] = run.charPrIDRef();

    this._xsb.openElement('hp:run', attrs);

    for (const item of run.runItems()) {
      if (item instanceof T) {
        this._writeT(item);
      }
      // Add other item types as needed
    }

    this._xsb.closeElement('hp:run');
  }

  _writeT(t) {
    const attrs = {};
    if (t.charPrIDRef()) attrs['charPrIDRef'] = t.charPrIDRef();

    this._xsb.openElement('hp:t', attrs);

    if (t.isOnlyText()) {
      this._xsb.text(t.onlyText());
    } else {
      for (const item of t.items()) {
        if (item instanceof NormalText) {
          this._xsb.text(item.text());
        }
        // Add other item types as needed
      }
    }

    this._xsb.closeElement('hp:t');
  }

  _writeChartFiles() {
    for (const chart of this._hwpxFile.chartXMLFileList().items()) {
      if (chart.path() && chart.data()) {
        this._zip.file(chart.path(), chart.data());
      }
    }
  }

  _writeUnparsedXMLFiles() {
    for (const unparsed of this._hwpxFile.unparsedXMLFiles()) {
      if (unparsed.href() && unparsed.xml()) {
        this._zip.file(unparsed.href(), unparsed.xml());
      }
    }
  }
}

export default HWPXWriter;
