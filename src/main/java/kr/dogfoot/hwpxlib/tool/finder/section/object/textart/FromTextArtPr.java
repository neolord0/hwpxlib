package kr.dogfoot.hwpxlib.tool.finder.section.object.textart;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.textart.TextArtPr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromTextArtPr extends FinderBase {
    public FromTextArtPr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_textartPr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        TextArtPr textArtPr = (TextArtPr) from;
        pushPath(textArtPr);

        check(textArtPr.shadow());

        checkSwitchList(textArtPr.switchList());
        popPath();
    }
}
