import { RunItem } from './RunItem.js';
import { ObjectType } from '../../../common/ObjectType.js';

/**
 * Normal text item
 */
export class NormalText {
  constructor() {
    this._text = null;
  }

  _objectType() {
    return ObjectType.NormalText;
  }

  text() { return this._text; }
  textSet(value) { this._text = value; }
  textAnd(value) { this._text = value; return this; }

  clone() {
    const cloned = new NormalText();
    cloned._text = this._text;
    return cloned;
  }
}

/**
 * Text element (hp:t)
 */
export class T extends RunItem {
  constructor() {
    super();
    this._charPrIDRef = null;
    this._onlyText = null;
    this._itemList = null;
  }

  _objectType() {
    return ObjectType.hp_t;
  }

  charPrIDRef() { return this._charPrIDRef; }
  charPrIDRefSet(value) { this._charPrIDRef = value; }
  charPrIDRefAnd(value) { this._charPrIDRef = value; return this; }

  addText(text) {
    if (this._itemList !== null && this._itemList.length > 0) {
      this._itemList.push(new NormalText().textAnd(text));
    } else {
      if (this._onlyText === null) {
        this._onlyText = text;
      } else {
        this._preprocess();
        this._itemList.push(new NormalText().textAnd(text));
      }
    }
  }

  clear() {
    this._onlyText = null;
    this._itemList = null;
  }

  isEmpty() {
    return this._onlyText === null && this._itemList === null;
  }

  isOnlyText() {
    return this._onlyText !== null;
  }

  onlyText() {
    return this._onlyText;
  }

  countOfItems() {
    if (this._itemList === null) return 0;
    return this._itemList.length;
  }

  getItem(index) {
    if (this._itemList === null) return null;
    return this._itemList[index];
  }

  addItem(item) {
    this._preprocess();
    this._itemList.push(item);
  }

  addNewText() {
    this._preprocess();
    const text = new NormalText();
    this._itemList.push(text);
    return text;
  }

  _preprocess() {
    if (this._itemList === null) {
      this._itemList = [];
    }
    if (this._onlyText !== null) {
      this._itemList.push(new NormalText().textAnd(this._onlyText));
      this._onlyText = null;
    }
  }

  items() {
    return this._itemList || [];
  }

  /**
   * Gets all text content as a single string
   * @returns {string}
   */
  getText() {
    if (this._onlyText !== null) {
      return this._onlyText;
    }
    if (this._itemList === null) {
      return '';
    }
    return this._itemList
      .filter(item => item instanceof NormalText)
      .map(item => item.text() || '')
      .join('');
  }

  clone() {
    const cloned = new T();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._charPrIDRef = from._charPrIDRef;
    this._onlyText = from._onlyText;
    if (from._itemList !== null) {
      this._itemList = [];
      for (const item of from._itemList) {
        this._itemList.push(item.clone ? item.clone() : { ...item });
      }
    } else {
      this._itemList = null;
    }
  }
}

export default T;
