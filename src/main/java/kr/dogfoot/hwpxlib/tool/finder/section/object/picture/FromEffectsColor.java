package kr.dogfoot.hwpxlib.tool.finder.section.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsColor;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEffectsColor extends FinderBase {
    public FromEffectsColor(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_effectsColor;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        EffectsColor effectsColor = (EffectsColor) from;
        pushPath(effectsColor);

        check(effectsColor.rgb());
        check(effectsColor.cmyk());
        check(effectsColor.scheme());
        check(effectsColor.system());
        check(effectsColor.effect());

        checkSwitchList(effectsColor.switchList());
        popPath();
    }
}
