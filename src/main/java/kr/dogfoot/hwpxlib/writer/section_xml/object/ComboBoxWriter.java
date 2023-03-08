package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ComboBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.formobject.FormObjectWriter;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class ComboBoxWriter extends FormObjectWriter {
    public ComboBoxWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ComboBox;
    }

    @Override
    public void write(HWPXObject object) {
        ComboBox comboBox = (ComboBox) object;
        switchObject(comboBox.switchObject());

        xsb()
                .openElement(ElementNames.hp_comboBox)
                .elementWriter(this);
        writeAttributeForFormObject(comboBox);
        xsb()
                .attribute(AttributeNames.listBoxRows, comboBox.listBoxRows())
                .attribute(AttributeNames.listBoxWidth, comboBox.listBoxWidth())
                .attribute(AttributeNames.editEnable, comboBox.editEnable())
                .attribute(AttributeNames.selectedValue, comboBox.selectedValue());

        writeChildrenForFormObject(comboBox);

        for (ListItem listItem : comboBox.listItems()) {
            listItem(listItem, xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    public static void listItem(ListItem listItem, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hp_listItem)
                .attribute(AttributeNames.displayText, listItem.displayText())
                .attribute(AttributeNames.value, listItem.value())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_listItem:
                listItem((ListItem) child, xsb());
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
