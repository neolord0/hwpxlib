import { SwitchableObject } from '../../../common/SwitchableObject.js';
import { ObjectType } from '../../../common/ObjectType.js';

/**
 * Base class for run items (text, objects, controls)
 */
export class RunItem extends SwitchableObject {
  constructor() {
    super();
  }

  _objectType() {
    return ObjectType.Unknown;
  }
}

export default RunItem;
