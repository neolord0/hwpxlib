package kr.dogfoot.hwpxlib.tool.finder.section.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsReflection;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEffectsReflection extends FinderBase {
    public FromEffectsReflection(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_reflection;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        EffectsReflection reflection = (EffectsReflection) from;
        pushPath(reflection);

        check(reflection.skew());
        check(reflection.scale());
        check(reflection.alpha());
        check(reflection.pos());

        checkSwitchList(reflection.switchList());
        popPath();
    }
}
