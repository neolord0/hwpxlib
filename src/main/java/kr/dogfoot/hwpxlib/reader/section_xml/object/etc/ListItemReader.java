package kr.dogfoot.hwpxlib.reader.section_xml.object.etc;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ListItemReader extends ElementReader {
    private ListItem listItem;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ListItem;
    }

    public void listItem(ListItem listItem) {
        this.listItem = listItem;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.displayText:
                listItem.displayText(value);
                break;
            case AttributeNames.value:
                listItem.value(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
