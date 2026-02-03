import { ObjectType } from './ObjectType.js';

/**
 * Base class for all HWPX objects
 */
export class HWPXObject {
  /**
   * Returns the object type
   * @returns {string} The object type
   */
  _objectType() {
    return ObjectType.Unknown;
  }

  /**
   * Creates a deep clone of this object
   * @returns {HWPXObject} The cloned object
   */
  clone() {
    throw new Error('clone() must be implemented by subclass');
  }
}

export default HWPXObject;
