package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ComboBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.etc.ListItemReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.formobject.FormObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class ComboBoxReader extends FormObjectReader {
    private ComboBox comboBox;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ComboBox;
    }

    @Override
    public FormObject formObject() {
        return comboBox;
    }

    public void comboBox(ComboBox comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.listBoxRows:
                comboBox.listBoxRows(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.listBoxWidth:
                comboBox.listBoxWidth(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.editEnable:
                comboBox.editEnable(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.selectedValue:
                comboBox.selectedValue(value);
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
                listItem(comboBox.addNewListItem(), name, attrs);
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
        ((ListItemReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ListItem))
                .listItem(listItem);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return comboBox;
    }
}
