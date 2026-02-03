import { SwitchableObject } from '../common/SwitchableObject.js';
import { ObjectType } from '../common/ObjectType.js';

/**
 * Caret position in document
 */
export class CaretPosition {
  constructor() {
    this._listIDRef = null;
    this._paraIDRef = null;
    this._pos = null;
  }

  listIDRef() { return this._listIDRef; }
  listIDRefSet(value) { this._listIDRef = value; }
  listIDRefAnd(value) { this._listIDRef = value; return this; }

  paraIDRef() { return this._paraIDRef; }
  paraIDRefSet(value) { this._paraIDRef = value; }
  paraIDRefAnd(value) { this._paraIDRef = value; return this; }

  pos() { return this._pos; }
  posSet(value) { this._pos = value; }
  posAnd(value) { this._pos = value; return this; }

  clone() {
    const cloned = new CaretPosition();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._listIDRef = from._listIDRef;
    this._paraIDRef = from._paraIDRef;
    this._pos = from._pos;
  }
}

/**
 * Settings.xml file representation
 */
export class SettingsXMLFile extends SwitchableObject {
  constructor() {
    super();
    this._caretPosition = null;
    this._configItemSets = [];
  }

  _objectType() {
    return ObjectType.ha_HWPApplicationSetting;
  }

  caretPosition() { return this._caretPosition; }

  createCaretPosition() {
    this._caretPosition = new CaretPosition();
    return this._caretPosition;
  }

  removeCaretPosition() {
    this._caretPosition = null;
  }

  configItemSets() { return this._configItemSets; }

  addConfigItemSet(name) {
    const set = { name, items: [] };
    this._configItemSets.push(set);
    return set;
  }

  clone() {
    const cloned = new SettingsXMLFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    if (from._caretPosition) {
      this.createCaretPosition();
      this._caretPosition.copyFrom(from._caretPosition);
    } else {
      this._caretPosition = null;
    }
    this._configItemSets = from._configItemSets.map(set => ({
      name: set.name,
      items: [...set.items]
    }));
    this._copyFromSwitchable(from);
  }
}

export default SettingsXMLFile;
