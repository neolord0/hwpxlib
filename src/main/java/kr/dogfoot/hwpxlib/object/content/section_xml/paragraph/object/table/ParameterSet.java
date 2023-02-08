package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.parameter.ParameterListCore;

public class ParameterSet extends ParameterListCore<ParameterSet> {
    public ParameterSet() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ParameterSet;
    }
}


