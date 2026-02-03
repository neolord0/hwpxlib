import { SwitchableObject } from '../../common/SwitchableObject.js';
import { ObjectType } from '../../common/ObjectType.js';

/**
 * Manifest item in content.hpf
 */
export class ManifestItem {
  constructor() {
    this._id = null;
    this._href = null;
    this._mediaType = null;
    this._attachedFile = null;
  }

  _objectType() {
    return ObjectType.opf_item;
  }

  id() { return this._id; }
  idSet(value) { this._id = value; }
  idAnd(value) { this._id = value; return this; }

  href() { return this._href; }
  hrefSet(value) { this._href = value; }
  hrefAnd(value) { this._href = value; return this; }

  mediaType() { return this._mediaType; }
  mediaTypeSet(value) { this._mediaType = value; }
  mediaTypeAnd(value) { this._mediaType = value; return this; }

  hasAttachedFile() {
    return this._mediaType && (
      this._mediaType.startsWith('image/') ||
      this._mediaType === 'application/ole' ||
      this._mediaType.startsWith('application/x-javascript')
    );
  }

  attachedFile() { return this._attachedFile; }

  createAttachedFile() {
    this._attachedFile = { data: null };
    return this._attachedFile;
  }

  clone() {
    const cloned = new ManifestItem();
    cloned._id = this._id;
    cloned._href = this._href;
    cloned._mediaType = this._mediaType;
    if (this._attachedFile) {
      cloned._attachedFile = { data: this._attachedFile.data };
    }
    return cloned;
  }
}

/**
 * Manifest in content.hpf
 */
export class Manifest {
  constructor() {
    this._items = [];
  }

  _objectType() {
    return ObjectType.opf_manifest;
  }

  items() {
    return this._items;
  }

  addItem() {
    const item = new ManifestItem();
    this._items.push(item);
    return item;
  }

  clone() {
    const cloned = new Manifest();
    for (const item of this._items) {
      cloned._items.push(item.clone());
    }
    return cloned;
  }
}

/**
 * Spine item ref
 */
export class SpineItemRef {
  constructor() {
    this._idref = null;
  }

  idref() { return this._idref; }
  idrefSet(value) { this._idref = value; }
  idrefAnd(value) { this._idref = value; return this; }

  clone() {
    const cloned = new SpineItemRef();
    cloned._idref = this._idref;
    return cloned;
  }
}

/**
 * Spine in content.hpf
 */
export class Spine {
  constructor() {
    this._itemRefs = [];
  }

  itemRefs() {
    return this._itemRefs;
  }

  addItemRef() {
    const ref = new SpineItemRef();
    this._itemRefs.push(ref);
    return ref;
  }

  clone() {
    const cloned = new Spine();
    for (const ref of this._itemRefs) {
      cloned._itemRefs.push(ref.clone());
    }
    return cloned;
  }
}

/**
 * Contents/content.hpf file representation
 */
export class ContentHPFFile extends SwitchableObject {
  constructor() {
    super();
    this._version = null;
    this._uniqueIdentifier = null;
    this._title = null;
    this._language = null;
    this._manifest = null;
    this._spine = null;
  }

  _objectType() {
    return ObjectType.opf_package;
  }

  version() { return this._version; }
  versionSet(value) { this._version = value; }

  uniqueIdentifier() { return this._uniqueIdentifier; }
  uniqueIdentifierSet(value) { this._uniqueIdentifier = value; }

  title() { return this._title; }
  titleSet(value) { this._title = value; }

  language() { return this._language; }
  languageSet(value) { this._language = value; }

  manifest() { return this._manifest; }

  createManifest() {
    this._manifest = new Manifest();
    return this._manifest;
  }

  spine() { return this._spine; }

  createSpine() {
    this._spine = new Spine();
    return this._spine;
  }

  clone() {
    const cloned = new ContentHPFFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._version = from._version;
    this._uniqueIdentifier = from._uniqueIdentifier;
    this._title = from._title;
    this._language = from._language;
    if (from._manifest) {
      this._manifest = from._manifest.clone();
    }
    if (from._spine) {
      this._spine = from._spine.clone();
    }
    this._copyFromSwitchable(from);
  }
}

export default ContentHPFFile;
