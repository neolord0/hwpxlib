package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TabItemType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.Tab;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class TabReader extends ElementReader {
    private Tab tab;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Tab;
    }

    public void tab(Tab tab) {
        this.tab = tab;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.width:
                tab.width(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.leader:
                tab.leader(LineType2.fromIndex(ValueConvertor.toInteger(value)));
                break;
            case AttributeNames.type:
                tab.type(TabItemType.fromIndex(ValueConvertor.toInteger(value)));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
