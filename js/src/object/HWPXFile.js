import { HWPXObject } from './common/HWPXObject.js';
import { ObjectType } from './common/ObjectType.js';
import { ObjectList } from './common/ObjectList.js';
import { VersionXMLFile } from './root/VersionXMLFile.js';
import { SettingsXMLFile } from './root/SettingsXMLFile.js';
import { ManifestXMLFile } from './metainf/ManifestXMLFile.js';
import { ContainerXMLFile } from './metainf/ContainerXMLFile.js';
import { ContentHPFFile } from './content/context_hpf/ContentHPFFile.js';
import { HeaderXMLFile } from './content/header_xml/HeaderXMLFile.js';
import { SectionXMLFile } from './content/section_xml/SectionXMLFile.js';

/**
 * Unparsed XML file (for files that couldn't be parsed)
 */
export class UnparsedXMLFile {
  constructor() {
    this._href = null;
    this._xml = null;
  }

  href() { return this._href; }
  hrefSet(value) { this._href = value; }
  hrefAnd(value) { this._href = value; return this; }

  xml() { return this._xml; }
  xmlSet(value) { this._xml = value; }
  xmlAnd(value) { this._xml = value; return this; }

  clone() {
    const cloned = new UnparsedXMLFile();
    cloned._href = this._href;
    cloned._xml = this._xml;
    return cloned;
  }
}

/**
 * Chart XML file
 */
export class ChartXMLFile {
  constructor() {
    this._path = null;
    this._data = null;
  }

  path() { return this._path; }
  pathSet(value) { this._path = value; }
  pathAnd(value) { this._path = value; return this; }

  data() { return this._data; }
  dataSet(value) { this._data = value; }
  dataAnd(value) { this._data = value; return this; }

  clone() {
    const cloned = new ChartXMLFile();
    cloned._path = this._path;
    cloned._data = this._data;
    return cloned;
  }
}

/**
 * Main HWPX file object - represents the entire document
 */
export class HWPXFile extends HWPXObject {
  constructor() {
    super();
    this._versionXMLFile = new VersionXMLFile();
    this._manifestXMLFile = new ManifestXMLFile();
    this._containerXMLFile = new ContainerXMLFile();
    this._contentHPFFile = new ContentHPFFile();
    this._headerXMLFile = new HeaderXMLFile();
    this._masterPageXMLFileList = new ObjectList(null); // MasterPageXMLFile
    this._sectionXMLFileList = new ObjectList(SectionXMLFile);
    this._settingsXMLFile = new SettingsXMLFile();
    this._historyXMLFileList = new ObjectList(null); // HistoryXMLFile
    this._chartXMLFileList = new ObjectList(ChartXMLFile);
    this._unparsedXMLFileList = [];
  }

  _objectType() {
    return ObjectType.HWPXFile;
  }

  versionXMLFile() { return this._versionXMLFile; }
  manifestXMLFile() { return this._manifestXMLFile; }
  containerXMLFile() { return this._containerXMLFile; }
  contentHPFFile() { return this._contentHPFFile; }
  headerXMLFile() { return this._headerXMLFile; }
  masterPageXMLFileList() { return this._masterPageXMLFileList; }
  sectionXMLFileList() { return this._sectionXMLFileList; }
  settingsXMLFile() { return this._settingsXMLFile; }
  historyXMLFileList() { return this._historyXMLFileList; }
  chartXMLFileList() { return this._chartXMLFileList; }

  addUnparsedXMLFile(href, xml) {
    this._unparsedXMLFileList.push(
      new UnparsedXMLFile().hrefAnd(href).xmlAnd(xml)
    );
  }

  unparsedXMLFiles() {
    return this._unparsedXMLFileList;
  }

  removeUnparsedXMLFile(file) {
    const index = this._unparsedXMLFileList.indexOf(file);
    if (index !== -1) {
      this._unparsedXMLFileList.splice(index, 1);
    }
  }

  removeAllUnparsedXMLFiles() {
    this._unparsedXMLFileList = [];
  }

  /**
   * Gets all text from all sections
   * @param {string} paraSeparator - Separator between paragraphs
   * @param {string} sectionSeparator - Separator between sections
   * @returns {string}
   */
  getText(paraSeparator = '\n', sectionSeparator = '\n\n') {
    const sections = [];
    for (const section of this._sectionXMLFileList.items()) {
      sections.push(section.getText(paraSeparator));
    }
    return sections.join(sectionSeparator);
  }

  clone() {
    const cloned = new HWPXFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._versionXMLFile.copyFrom(from._versionXMLFile);
    this._manifestXMLFile.copyFrom(from._manifestXMLFile);
    this._containerXMLFile.copyFrom(from._containerXMLFile);
    this._contentHPFFile.copyFrom(from._contentHPFFile);
    this._headerXMLFile.copyFrom(from._headerXMLFile);

    for (const masterPage of from._masterPageXMLFileList.items()) {
      this._masterPageXMLFileList.add(masterPage.clone ? masterPage.clone() : masterPage);
    }

    for (const section of from._sectionXMLFileList.items()) {
      this._sectionXMLFileList.add(section.clone());
    }

    this._settingsXMLFile.copyFrom(from._settingsXMLFile);

    for (const history of from._historyXMLFileList.items()) {
      this._historyXMLFileList.add(history.clone ? history.clone() : history);
    }

    for (const chart of from._chartXMLFileList.items()) {
      this._chartXMLFileList.add(chart.clone());
    }

    for (const unparsed of from._unparsedXMLFileList) {
      this._unparsedXMLFileList.push(unparsed.clone());
    }
  }
}

export default HWPXFile;
