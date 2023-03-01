package kr.dogfoot.hwpxlib.writer.header_xml.reflist.tabpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr.TabItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TabPrWriter extends ElementWriter {
    public TabPrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TabPr;
    }

    @Override
    public void write(HWPXObject object) {
        TabPr tabPr = (TabPr) object;
        storeSwitchObject(tabPr.switchObject());

        xsb()
                .openElement(ElementNames.hh_tabPr)
                .elementWriter(this)
                .attribute(AttributeNames.id, tabPr.id())
                .attribute(AttributeNames.autoTabLeft, tabPr.autoTabLeft())
                .attribute(AttributeNames.autoTabRight, tabPr.autoTabRight());

        for (TabItem tabItem : tabPr.tabItems()) {
            tabItem(tabItem);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void tabItem(TabItem tabItem) {
        xsb()
                .openElement(ElementNames.hh_tabItem)
                .attribute(AttributeNames.pos, tabItem.pos());
        if (tabItem.type() != null) {
            xsb().attribute(AttributeNames.type, tabItem.type().str());
        }
        if (tabItem.leader() != null) {
            xsb().attribute(AttributeNames.leader, tabItem.leader().str());
        }
        xsb().closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_tabItem:
                tabItem((TabItem) child);
                break;
        }
    }
}
