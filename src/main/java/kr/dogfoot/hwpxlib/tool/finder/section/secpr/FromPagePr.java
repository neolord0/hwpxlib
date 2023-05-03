package kr.dogfoot.hwpxlib.tool.finder.section.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PagePr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromPagePr extends FinderBase {
    public FromPagePr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_pagePr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        PagePr pagePr = (PagePr) from;
        pushPath(pagePr);

        check(pagePr.margin());

        checkSwitchObject(pagePr.switchObject());
        popPath();
    }
}
