import { SwitchableObject } from '../common/SwitchableObject.js';
import { ObjectType } from '../common/ObjectType.js';

/**
 * File entry in manifest
 */
export class FileEntry {
  constructor() {
    this._fullPath = null;
    this._mediaType = null;
    this._size = null;
  }

  _objectType() {
    return ObjectType.odf_file_entry;
  }

  fullPath() { return this._fullPath; }
  fullPathSet(value) { this._fullPath = value; }
  fullPathAnd(value) { this._fullPath = value; return this; }

  mediaType() { return this._mediaType; }
  mediaTypeSet(value) { this._mediaType = value; }
  mediaTypeAnd(value) { this._mediaType = value; return this; }

  size() { return this._size; }
  sizeSet(value) { this._size = value; }
  sizeAnd(value) { this._size = value; return this; }

  clone() {
    const cloned = new FileEntry();
    cloned._fullPath = this._fullPath;
    cloned._mediaType = this._mediaType;
    cloned._size = this._size;
    return cloned;
  }
}

/**
 * META-INF/manifest.xml file representation
 */
export class ManifestXMLFile extends SwitchableObject {
  constructor() {
    super();
    this._fileEntries = [];
  }

  _objectType() {
    return ObjectType.odf_manifest;
  }

  fileEntries() {
    return this._fileEntries;
  }

  addFileEntry() {
    const entry = new FileEntry();
    this._fileEntries.push(entry);
    return entry;
  }

  clone() {
    const cloned = new ManifestXMLFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._fileEntries = [];
    for (const entry of from._fileEntries) {
      this._fileEntries.push(entry.clone());
    }
    this._copyFromSwitchable(from);
  }
}

export default ManifestXMLFile;
