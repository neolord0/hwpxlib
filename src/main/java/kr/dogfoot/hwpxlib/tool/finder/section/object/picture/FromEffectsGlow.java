package kr.dogfoot.hwpxlib.tool.finder.section.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsGlow;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEffectsGlow extends FinderBase {
    public FromEffectsGlow(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_glow;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        EffectsGlow effectsGlow = (EffectsGlow) from;
        pushPath(effectsGlow);

        checkWithChildren(effectsGlow.effectsColor());

        checkSwitchObject(effectsGlow.switchObject());
        popPath();
    }
}
