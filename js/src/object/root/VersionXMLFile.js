import { SwitchableObject } from '../common/SwitchableObject.js';
import { ObjectType } from '../common/ObjectType.js';
import { Version } from './Version.js';

/**
 * Target application types
 */
export const TargetApplicationSort = {
  WordProcessor: 'WORDPROCESSOR',
  Presentation: 'PRESENTATION',
  SpreadSheet: 'SPREADSHEET',

  fromString(str) {
    if (!str) return null;
    const upper = str.toUpperCase();
    for (const key of ['WordProcessor', 'Presentation', 'SpreadSheet']) {
      if (this[key] === upper) return this[key];
    }
    return null;
  }
};

/**
 * /version.xml file representation
 */
export class VersionXMLFile extends SwitchableObject {
  constructor() {
    super();
    this._targetApplication = TargetApplicationSort.WordProcessor;
    this._version = new Version();
    this._os = null;
    this._application = null;
    this._appVersion = null;
  }

  _objectType() {
    return ObjectType.hv_HCFVersion;
  }

  targetApplication() { return this._targetApplication; }
  targetApplicationSet(value) { this._targetApplication = value; }
  targetApplicationAnd(value) { this._targetApplication = value; return this; }

  version() { return this._version; }

  os() { return this._os; }
  osSet(value) { this._os = value; }
  osAnd(value) { this._os = value; return this; }

  application() { return this._application; }
  applicationSet(value) { this._application = value; }
  applicationAnd(value) { this._application = value; return this; }

  appVersion() { return this._appVersion; }
  appVersionSet(value) { this._appVersion = value; }
  appVersionAnd(value) { this._appVersion = value; return this; }

  clone() {
    const cloned = new VersionXMLFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._targetApplication = from._targetApplication;
    this._version.copyFrom(from._version);
    this._os = from._os;
    this._application = from._application;
    this._appVersion = from._appVersion;
    this._copyFromSwitchable(from);
  }
}

export default VersionXMLFile;
