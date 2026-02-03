import { SwitchableObject } from '../../common/SwitchableObject.js';
import { ObjectType } from '../../common/ObjectType.js';

/**
 * Header XML file representation (header.xml)
 * Contains document styles, fonts, numbering definitions, etc.
 */
export class HeaderXMLFile extends SwitchableObject {
  constructor() {
    super();
    this._beginNum = null;
    this._refList = null;
    this._fontfaces = [];
    this._borderFills = [];
    this._charProperties = [];
    this._tabProperties = [];
    this._numberings = [];
    this._bullets = [];
    this._paraProperties = [];
    this._styles = [];
    this._memoProperties = [];
    this._trackChanges = [];
    this._trackChangeAuthors = [];
    this._compatibleDocument = null;
    this._docOption = null;
    this._trackChangeConfig = null;
  }

  _objectType() {
    return ObjectType.hh_head;
  }

  beginNum() { return this._beginNum; }
  beginNumSet(value) { this._beginNum = value; }

  refList() { return this._refList; }
  refListSet(value) { this._refList = value; }

  fontfaces() { return this._fontfaces; }
  addFontface(fontface) { this._fontfaces.push(fontface); }

  borderFills() { return this._borderFills; }
  addBorderFill(borderFill) { this._borderFills.push(borderFill); }

  charProperties() { return this._charProperties; }
  addCharProperty(charPr) { this._charProperties.push(charPr); }

  tabProperties() { return this._tabProperties; }
  addTabProperty(tabPr) { this._tabProperties.push(tabPr); }

  numberings() { return this._numberings; }
  addNumbering(numbering) { this._numberings.push(numbering); }

  bullets() { return this._bullets; }
  addBullet(bullet) { this._bullets.push(bullet); }

  paraProperties() { return this._paraProperties; }
  addParaProperty(paraPr) { this._paraProperties.push(paraPr); }

  styles() { return this._styles; }
  addStyle(style) { this._styles.push(style); }

  memoProperties() { return this._memoProperties; }
  addMemoProperty(memoPr) { this._memoProperties.push(memoPr); }

  trackChanges() { return this._trackChanges; }
  addTrackChange(trackChange) { this._trackChanges.push(trackChange); }

  trackChangeAuthors() { return this._trackChangeAuthors; }
  addTrackChangeAuthor(author) { this._trackChangeAuthors.push(author); }

  compatibleDocument() { return this._compatibleDocument; }
  compatibleDocumentSet(value) { this._compatibleDocument = value; }

  docOption() { return this._docOption; }
  docOptionSet(value) { this._docOption = value; }

  trackChangeConfig() { return this._trackChangeConfig; }
  trackChangeConfigSet(value) { this._trackChangeConfig = value; }

  clone() {
    const cloned = new HeaderXMLFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._beginNum = from._beginNum;
    this._refList = from._refList;
    this._fontfaces = [...from._fontfaces];
    this._borderFills = [...from._borderFills];
    this._charProperties = [...from._charProperties];
    this._tabProperties = [...from._tabProperties];
    this._numberings = [...from._numberings];
    this._bullets = [...from._bullets];
    this._paraProperties = [...from._paraProperties];
    this._styles = [...from._styles];
    this._memoProperties = [...from._memoProperties];
    this._trackChanges = [...from._trackChanges];
    this._trackChangeAuthors = [...from._trackChangeAuthors];
    this._compatibleDocument = from._compatibleDocument;
    this._docOption = from._docOption;
    this._trackChangeConfig = from._trackChangeConfig;
    this._copyFromSwitchable(from);
  }
}

export default HeaderXMLFile;
