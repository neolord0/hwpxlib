package kr.dogfoot.hwpxlib.tool.finder.section.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.MasterPage;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.SecPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromSecPr extends FinderBase {
    public FromSecPr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_secPr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        SecPr secPr = (SecPr) from;
        pushPath(secPr);

        check(secPr.grid());
        check(secPr.startNum());
        check(secPr.visibility());
        check(secPr.lineNumberShape());
        checkWithChildren(secPr.pagePr());
        checkWithChildren(secPr.footNotePr());
        checkWithChildren(secPr.endNotePr());
        for (PageBorderFill pageBorderFill : secPr.pageBorderFills()) {
            checkWithChildren(pageBorderFill);
        }
        for (MasterPage masterPage : secPr.masterPages()) {
            check(masterPage);
        }
        checkWithChildren(secPr.presentation());

        checkSwitchObject(secPr.switchObject());
        popPath();
    }
}
