import { SwitchableObject } from '../../../common/SwitchableObject.js';
import { ObjectType } from '../../../common/ObjectType.js';
import { Run } from './Run.js';

/**
 * Paragraph element (hp:p)
 */
export class Para extends SwitchableObject {
  constructor() {
    super();
    this._id = null;
    this._paraPrIDRef = null;
    this._styleIDRef = null;
    this._pageBreak = null;
    this._columnBreak = null;
    this._merged = null;
    this._paraTcId = null;
    this._runList = [];
    this._lineSegArray = null;
  }

  _objectType() {
    return ObjectType.hp_p;
  }

  id() { return this._id; }
  idSet(value) { this._id = value; }
  idAnd(value) { this._id = value; return this; }

  paraPrIDRef() { return this._paraPrIDRef; }
  paraPrIDRefSet(value) { this._paraPrIDRef = value; }
  paraPrIDRefAnd(value) { this._paraPrIDRef = value; return this; }

  styleIDRef() { return this._styleIDRef; }
  styleIDRefSet(value) { this._styleIDRef = value; }
  styleIDRefAnd(value) { this._styleIDRef = value; return this; }

  pageBreak() { return this._pageBreak; }
  pageBreakSet(value) { this._pageBreak = value; }
  pageBreakAnd(value) { this._pageBreak = value; return this; }

  columnBreak() { return this._columnBreak; }
  columnBreakSet(value) { this._columnBreak = value; }
  columnBreakAnd(value) { this._columnBreak = value; return this; }

  merged() { return this._merged; }
  mergedSet(value) { this._merged = value; }
  mergedAnd(value) { this._merged = value; return this; }

  paraTcId() { return this._paraTcId; }
  paraTcIdSet(value) { this._paraTcId = value; }
  paraTcIdAnd(value) { this._paraTcId = value; return this; }

  countOfRun() {
    return this._runList.length;
  }

  getRun(index) {
    return this._runList[index];
  }

  getRunIndex(run) {
    return this._runList.indexOf(run);
  }

  addRun(run) {
    this._runList.push(run);
  }

  addNewRun() {
    const run = new Run();
    this._runList.push(run);
    return run;
  }

  insertRun(run, position) {
    this._runList.splice(position, 0, run);
  }

  removeRun(positionOrRun) {
    if (typeof positionOrRun === 'number') {
      this._runList.splice(positionOrRun, 1);
    } else {
      const index = this._runList.indexOf(positionOrRun);
      if (index !== -1) {
        this._runList.splice(index, 1);
      }
    }
  }

  removeAllRuns() {
    this._runList = [];
  }

  runs() {
    return this._runList;
  }

  lineSegArray() { return this._lineSegArray; }

  createLineSegArray() {
    this._lineSegArray = [];
    return this._lineSegArray;
  }

  removeLineSegArray() {
    this._lineSegArray = null;
  }

  /**
   * Gets all text from this paragraph
   * @returns {string}
   */
  getText() {
    return this._runList
      .map(run => run.getText())
      .join('');
  }

  clone() {
    const cloned = new Para();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._id = from._id;
    this._paraPrIDRef = from._paraPrIDRef;
    this._styleIDRef = from._styleIDRef;
    this._pageBreak = from._pageBreak;
    this._columnBreak = from._columnBreak;
    this._merged = from._merged;
    this._paraTcId = from._paraTcId;

    this._runList = [];
    for (const run of from._runList) {
      this._runList.push(run.clone());
    }

    if (from._lineSegArray !== null) {
      this._lineSegArray = [...from._lineSegArray];
    } else {
      this._lineSegArray = null;
    }

    this._copyFromSwitchable(from);
  }
}

export default Para;
