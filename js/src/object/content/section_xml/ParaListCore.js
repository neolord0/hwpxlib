import { SwitchableObject } from '../../common/SwitchableObject.js';
import { Para } from './paragraph/Para.js';

/**
 * Base class for objects that contain a list of paragraphs
 */
export class ParaListCore extends SwitchableObject {
  constructor() {
    super();
    this._paraList = [];
  }

  countOfPara() {
    return this._paraList.length;
  }

  getPara(index) {
    return this._paraList[index];
  }

  getParaIndex(para) {
    return this._paraList.indexOf(para);
  }

  addPara(para) {
    this._paraList.push(para);
  }

  addNewPara() {
    const para = new Para();
    this._paraList.push(para);
    return para;
  }

  insertPara(para, position) {
    this._paraList.splice(position, 0, para);
  }

  removePara(positionOrPara) {
    if (typeof positionOrPara === 'number') {
      this._paraList.splice(positionOrPara, 1);
    } else {
      const index = this._paraList.indexOf(positionOrPara);
      if (index !== -1) {
        this._paraList.splice(index, 1);
      }
    }
  }

  removeAllParas() {
    this._paraList = [];
  }

  paras() {
    return this._paraList;
  }

  /**
   * Gets all text from all paragraphs
   * @param {string} separator - Separator between paragraphs (default: newline)
   * @returns {string}
   */
  getText(separator = '\n') {
    return this._paraList
      .map(para => para.getText())
      .join(separator);
  }

  _copyFromParaListCore(from) {
    this._paraList = [];
    for (const para of from._paraList) {
      this._paraList.push(para.clone());
    }
    this._copyFromSwitchable(from);
  }
}

export default ParaListCore;
