package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ListBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.formobject.FormObjectWriter;

public class ListBoxWriter extends FormObjectWriter {
    public ListBoxWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ListBox;
    }

    @Override
    public void write(HWPXObject object) {
        ListBox listBox = (ListBox) object;
        switchObject(listBox.switchObject());

        xsb()
                .openElement(ElementNames.hp_listBox)
                .elementWriter(this);
        writeAttributeForFormObject(listBox);
        xsb()
                .attribute(AttributeNames.selectedValue, listBox.selectedValue())
                .attribute(AttributeNames.itemHeight, listBox.itemHeight())
                .attribute(AttributeNames.topIdx, listBox.topIdx());

        writeChildrenForFormObject(listBox);

        for (ListItem listItem : listBox.listItems()) {
            ComboBoxWriter.listItem(listItem, xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_listItem:
                ComboBoxWriter.listItem((ListItem) child, xsb());
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
