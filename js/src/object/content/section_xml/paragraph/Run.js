import { SwitchableObject } from '../../../common/SwitchableObject.js';
import { ObjectType } from '../../../common/ObjectType.js';
import { T } from './T.js';

/**
 * Run element (hp:run) - contains text and objects with same character formatting
 */
export class Run extends SwitchableObject {
  constructor() {
    super();
    this._charPrIDRef = null;
    this._charTcId = null;
    this._secPr = null;
    this._itemList = [];
  }

  _objectType() {
    return ObjectType.hp_run;
  }

  charPrIDRef() { return this._charPrIDRef; }
  charPrIDRefSet(value) { this._charPrIDRef = value; }
  charPrIDRefAnd(value) { this._charPrIDRef = value; return this; }

  charTcId() { return this._charTcId; }
  charTcIdSet(value) { this._charTcId = value; }
  charTcIdAnd(value) { this._charTcId = value; return this; }

  secPr() { return this._secPr; }

  createSecPr() {
    // For now, use a simple object - can be expanded later
    this._secPr = {};
    return this._secPr;
  }

  removeSecPr() {
    this._secPr = null;
  }

  countOfRunItem() {
    return this._itemList.length;
  }

  getRunItem(index) {
    return this._itemList[index];
  }

  getRunItemIndex(runItem) {
    return this._itemList.indexOf(runItem);
  }

  addRunItem(runItem) {
    this._itemList.push(runItem);
  }

  addNewT() {
    const t = new T();
    this._itemList.push(t);
    return t;
  }

  insertRunItem(runItem, position) {
    this._itemList.splice(position, 0, runItem);
  }

  removeRunItem(positionOrItem) {
    if (typeof positionOrItem === 'number') {
      this._itemList.splice(positionOrItem, 1);
    } else {
      const index = this._itemList.indexOf(positionOrItem);
      if (index !== -1) {
        this._itemList.splice(index, 1);
      }
    }
  }

  removeAllRunItems() {
    this._itemList = [];
  }

  runItems() {
    return this._itemList;
  }

  /**
   * Gets all text from this run
   * @returns {string}
   */
  getText() {
    return this._itemList
      .filter(item => item instanceof T)
      .map(item => item.getText())
      .join('');
  }

  clone() {
    const cloned = new Run();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._charPrIDRef = from._charPrIDRef;
    this._charTcId = from._charTcId;
    if (from._secPr !== null) {
      this._secPr = { ...from._secPr };
    } else {
      this._secPr = null;
    }
    this._itemList = [];
    for (const item of from._itemList) {
      this._itemList.push(item.clone ? item.clone() : { ...item });
    }
    this._copyFromSwitchable(from);
  }
}

export default Run;
