package kr.dogfoot.hwpxlib.tool.finder.section.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsShadow;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEffectsShadow extends FinderBase {
    public FromEffectsShadow(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_shadow_for_effects;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        EffectsShadow shadow = (EffectsShadow) from;
        pushPath(shadow);

        check(shadow.skew());
        check(shadow.scale());
        checkWithChildren(shadow.effectsColor());

        checkSwitchObject(shadow.switchObject());
        popPath();
    }
}
