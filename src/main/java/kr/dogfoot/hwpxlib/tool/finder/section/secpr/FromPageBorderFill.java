package kr.dogfoot.hwpxlib.tool.finder.section.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromPageBorderFill extends FinderBase {
    public FromPageBorderFill(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_pageBorderFill;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        PageBorderFill pageBorderFill = (PageBorderFill) from;
        pushPath(pageBorderFill);

        check(pageBorderFill.offset());

        checkSwitchObject(pageBorderFill.switchObject());
        popPath();
    }
}
