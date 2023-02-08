package kr.dogfoot.hwpxlib.reader.header_xml.tabpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TabItemType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr.TabItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class TabItemReader extends ElementReader {
    private TabItem tabItem;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TabItem;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.pos:
                tabItem.pos(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.type:
                tabItem.type(TabItemType.fromString(value));
                break;
            case AttributeNames.leader:
                tabItem.leader(LineType2.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void tabItem(TabItem tabItem) {
        this.tabItem = tabItem;
    }
}
