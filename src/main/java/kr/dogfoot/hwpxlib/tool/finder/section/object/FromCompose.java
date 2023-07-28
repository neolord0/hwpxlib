package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Compose;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose.ComposeCharPr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromCompose extends FinderBase {
    public FromCompose(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_compose;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Compose compose = (Compose) from;
        pushPath(compose);

        for (ComposeCharPr charPr : compose.charPrs()) {
            check(charPr);
        }

        checkSwitchList(compose.switchList());
        popPath();
    }
}
