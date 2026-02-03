import { ParaListCore } from './ParaListCore.js';
import { ObjectType } from '../../common/ObjectType.js';

/**
 * Section XML file representation (section0.xml, section1.xml, etc.)
 */
export class SectionXMLFile extends ParaListCore {
  constructor() {
    super();
  }

  _objectType() {
    return ObjectType.hs_sec;
  }

  clone() {
    const cloned = new SectionXMLFile();
    cloned.copyFrom(this);
    return cloned;
  }

  copyFrom(from) {
    this._copyFromParaListCore(from);
  }
}

export default SectionXMLFile;
