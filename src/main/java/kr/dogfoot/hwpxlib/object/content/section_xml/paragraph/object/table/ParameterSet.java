package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.parameter.ParameterListCore;

public class ParameterSet extends ParameterListCore<ParameterSet> {
    public ParameterSet() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_parameterset;
    }

    @Override
    public ParameterSet clone() {
        ParameterSet cloned = new ParameterSet();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ParameterSet from) {
        super.copyFrom(from);
    }
}


