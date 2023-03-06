package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ListBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.etc.ListItemReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.formobject.FormObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class ListBoxReader extends FormObjectReader {
    private ListBox listBox;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ListBox;
    }

    @Override
    public FormObject formObject() {
        return listBox;
    }

    public void listBox(ListBox listBox) {
        this.listBox = listBox;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.selectedValue:
                listBox.selectedValue(value);
                break;
            case AttributeNames.itemHeight:
                listBox.itemHeight(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.topIdx:
                listBox.topIdx(ValueConvertor.toInteger(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_listItem:
                listItem(listBox.addNewListItem(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_seg:
                ListItem listItem = new ListItem();
                listItem(listItem, name, attrs);
                return listItem;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void listItem(ListItem listItem, String name, Attributes attrs) {
        ((ListItemReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ListItem))
                .listItem(listItem);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return listBox;
    }
}
