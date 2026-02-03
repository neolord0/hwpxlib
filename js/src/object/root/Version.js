/**
 * Version information
 */
export class Version {
  constructor() {
    this._major = null;
    this._minor = null;
    this._micro = null;
    this._buildNumber = null;
  }

  major() { return this._major; }
  majorSet(value) { this._major = value; }
  majorAnd(value) { this._major = value; return this; }

  minor() { return this._minor; }
  minorSet(value) { this._minor = value; }
  minorAnd(value) { this._minor = value; return this; }

  micro() { return this._micro; }
  microSet(value) { this._micro = value; }
  microAnd(value) { this._micro = value; return this; }

  buildNumber() { return this._buildNumber; }
  buildNumberSet(value) { this._buildNumber = value; }
  buildNumberAnd(value) { this._buildNumber = value; return this; }

  clone() {
    const cloned = new Version();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._major = from._major;
    this._minor = from._minor;
    this._micro = from._micro;
    this._buildNumber = from._buildNumber;
  }
}

export default Version;
