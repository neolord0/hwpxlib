package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr.TabItem;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromTabPr extends FinderBase {
    public FromTabPr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_tabPr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        TabPr tabPr = (TabPr) from;
        pushPath(tabPr);

        for (TabItem tabItem : tabPr.tabItems()) {
            check(tabItem);
        }

        checkSwitchList(tabPr.switchList());
        popPath();
    }
}
