package kr.dogfoot.hwpxlib.writer.header_xml.reflist.tabpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TabPropertiesWriter extends ElementWriter {
    public TabPropertiesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TabProperties;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<TabPr> tabProperties = (ObjectList<TabPr>) object;
        switchList(tabProperties.switchList());
        if (tabProperties.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_tabProperties)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, tabProperties.count());

        for (TabPr tabPr : tabProperties.items()) {
            writeChild(ElementWriterSort.TabPr, tabPr);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_tabPr:
                writeChild(ElementWriterSort.TabPr, child);
                break;
        }
    }
}
