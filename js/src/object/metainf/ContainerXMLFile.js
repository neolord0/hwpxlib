import { SwitchableObject } from '../common/SwitchableObject.js';
import { ObjectType } from '../common/ObjectType.js';
import { ObjectList } from '../common/ObjectList.js';

/**
 * Root file entry
 */
export class RootFile {
  constructor() {
    this._fullPath = null;
    this._mediaType = null;
    this._attachedFile = null;
  }

  _objectType() {
    return ObjectType.ocf_rootfile;
  }

  fullPath() { return this._fullPath; }
  fullPathSet(value) { this._fullPath = value; }
  fullPathAnd(value) { this._fullPath = value; return this; }

  mediaType() { return this._mediaType; }
  mediaTypeSet(value) { this._mediaType = value; }
  mediaTypeAnd(value) { this._mediaType = value; return this; }

  attachedFile() { return this._attachedFile; }

  createAttachedFile() {
    this._attachedFile = { data: null };
    return this._attachedFile;
  }

  clone() {
    const cloned = new RootFile();
    cloned._fullPath = this._fullPath;
    cloned._mediaType = this._mediaType;
    if (this._attachedFile) {
      cloned._attachedFile = { data: this._attachedFile.data };
    }
    return cloned;
  }
}

/**
 * Root files container
 */
export class RootFiles {
  constructor() {
    this._list = [];
  }

  _objectType() {
    return ObjectType.ocf_rootfiles;
  }

  items() {
    return this._list;
  }

  addNew() {
    const rootFile = new RootFile();
    this._list.push(rootFile);
    return rootFile;
  }

  clone() {
    const cloned = new RootFiles();
    for (const item of this._list) {
      cloned._list.push(item.clone());
    }
    return cloned;
  }
}

/**
 * META-INF/container.xml file representation
 */
export class ContainerXMLFile extends SwitchableObject {
  constructor() {
    super();
    this._rootFiles = null;
  }

  _objectType() {
    return ObjectType.ocf_container;
  }

  rootFiles() { return this._rootFiles; }

  createRootFiles() {
    this._rootFiles = new RootFiles();
    return this._rootFiles;
  }

  removeRootFiles() {
    this._rootFiles = null;
  }

  /**
   * Gets the path to the package XML file (content.hpf)
   * @returns {string|null}
   */
  packageXMLFilePath() {
    if (!this._rootFiles) return null;
    for (const rootFile of this._rootFiles.items()) {
      if (rootFile.mediaType() === 'application/hwpml-package+xml') {
        return rootFile.fullPath();
      }
    }
    return null;
  }

  clone() {
    const cloned = new ContainerXMLFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    if (from._rootFiles) {
      this._rootFiles = from._rootFiles.clone();
    } else {
      this._rootFiles = null;
    }
    this._copyFromSwitchable(from);
  }
}

export default ContainerXMLFile;
