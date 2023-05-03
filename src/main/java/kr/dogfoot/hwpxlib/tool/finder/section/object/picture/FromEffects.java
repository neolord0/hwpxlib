package kr.dogfoot.hwpxlib.tool.finder.section.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.Effects;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEffects extends FinderBase {
    public FromEffects(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_effects;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Effects effects = (Effects) from;
        pushPath(effects);

        checkWithChildren(effects.shadow());
        checkWithChildren(effects.glow());
        check(effects.softEdge());
        checkWithChildren(effects.reflection());

        checkSwitchObject(effects.switchObject());
        popPath();
    }
}
