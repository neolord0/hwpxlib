import { SwitchableObject } from './SwitchableObject.js';

/**
 * Generic list class for HWPX objects
 * @template T
 */
export class ObjectList extends SwitchableObject {
  /**
   * Creates an ObjectList
   * @param {Function} ItemClass - The class constructor for items
   * @param {string} [objectType=null] - Optional object type
   */
  constructor(ItemClass, objectType = null) {
    super();
    this._objectTypeValue = objectType;
    this._list = [];
    this._ItemClass = ItemClass;
  }

  _objectType() {
    return this._objectTypeValue;
  }

  /**
   * Returns the number of items
   * @returns {number}
   */
  count() {
    return this._list.length;
  }

  /**
   * Gets an item at the specified index
   * @param {number} index
   * @returns {T}
   */
  get(index) {
    return this._list[index];
  }

  /**
   * Gets the index of an item
   * @param {T} item
   * @returns {number}
   */
  getIndex(item) {
    return this._list.indexOf(item);
  }

  /**
   * Adds an item to the list
   * @param {T} item
   */
  add(item) {
    this._list.push(item);
  }

  /**
   * Creates and adds a new item
   * @returns {T}
   */
  addNew() {
    if (!this._ItemClass) {
      return null;
    }
    const instance = new this._ItemClass();
    this._list.push(instance);
    return instance;
  }

  /**
   * Inserts an item at the specified position
   * @param {T} item
   * @param {number} position
   */
  insert(item, position) {
    this._list.splice(position, 0, item);
  }

  /**
   * Removes an item at the specified position
   * @param {number} position
   */
  removeAt(position) {
    this._list.splice(position, 1);
  }

  /**
   * Removes an item from the list
   * @param {T} item
   */
  remove(item) {
    const index = this._list.indexOf(item);
    if (index !== -1) {
      this._list.splice(index, 1);
    }
  }

  /**
   * Removes all items
   */
  removeAll() {
    this._list = [];
  }

  /**
   * Returns an iterable of items
   * @returns {T[]}
   */
  items() {
    return this._list;
  }

  /**
   * Checks if the list is empty
   * @returns {boolean}
   */
  empty() {
    return this._list.length === 0;
  }

  /**
   * Iterator support
   */
  [Symbol.iterator]() {
    return this._list[Symbol.iterator]();
  }

  clone() {
    const cloned = new ObjectList(this._ItemClass, this._objectTypeValue);
    for (const item of this._list) {
      if (item && typeof item.clone === 'function') {
        cloned.add(item.clone());
      } else {
        cloned.add(item);
      }
    }
    return cloned;
  }
}

export default ObjectList;
