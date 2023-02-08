package kr.dogfoot.hwpxlib.reader.header_xml.tabpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr.TabItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class TabPrReader extends ElementReader {
    private TabPr tabPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TabPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                tabPr.id(value);
                break;
            case AttributeNames.autoTabLeft:
                tabPr.autoTabLeft(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.autoTabRight:
                tabPr.autoTabRight(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.TabItem:
                tabItem(tabPr.addNewTabItem(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.TabItem:
                TabItem tabItem = new TabItem();
                tabItem(tabItem, name, attrs);
                return tabItem;
        }
        return null;
    }

    private void tabItem(TabItem tabItem, String name, Attributes attrs) {
        ((TabItemReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TabItem))
                .tabItem(tabItem);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return tabPr;
    }

    public void tabPr(TabPr tabPr) {
        this.tabPr = tabPr;
    }
}
