import { HWPXObject } from './HWPXObject.js';

/**
 * Switch object for compatibility handling
 */
export class Switch {
  constructor() {
    this._cases = [];
    this._default = null;
  }

  get cases() {
    return this._cases;
  }

  get defaultCase() {
    return this._default;
  }

  set defaultCase(value) {
    this._default = value;
  }

  addCase(caseObj) {
    this._cases.push(caseObj);
    return caseObj;
  }

  clone() {
    const cloned = new Switch();
    for (const c of this._cases) {
      cloned._cases.push(c.clone ? c.clone() : { ...c });
    }
    if (this._default) {
      cloned._default = this._default.clone ? this._default.clone() : { ...this._default };
    }
    return cloned;
  }

  copyFrom(from) {
    this._cases = [];
    for (const c of from._cases) {
      this._cases.push(c.clone ? c.clone() : { ...c });
    }
    if (from._default) {
      this._default = from._default.clone ? from._default.clone() : { ...from._default };
    }
  }
}

/**
 * Base class for HWPX objects that can contain switch elements
 */
export class SwitchableObject extends HWPXObject {
  constructor() {
    super();
    this._switchList = null;
  }

  get switchList() {
    return this._switchList;
  }

  removeSwitchList() {
    this._switchList = null;
  }

  addNewSwitch() {
    if (this._switchList === null) {
      this._switchList = [];
    }
    const newSwitch = new Switch();
    this._switchList.push(newSwitch);
    return newSwitch;
  }

  _copyFromSwitchable(from) {
    if (from._switchList !== null) {
      this._switchList = [];
      for (const sw of from._switchList) {
        const newSw = this.addNewSwitch();
        newSw.copyFrom(sw);
      }
    } else {
      this._switchList = null;
    }
  }
}

export default SwitchableObject;
