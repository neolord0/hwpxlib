package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ScrollBarType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ScrollBar;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.formobject.FormObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ScrollBarReader extends FormObjectReader {
    private ScrollBar scrollBar;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ScrollBar;
    }

    @Override
    public FormObject formObject() {
        return scrollBar;
    }

    public void scrollBar(ScrollBar scrollBar) {
        this.scrollBar = scrollBar;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.delay:
                scrollBar.delay(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.largeChange:
                scrollBar.largeChange(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.smallChange:
                scrollBar.smallChange(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.min:
                scrollBar.min(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.max:
                scrollBar.max(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.page:
                scrollBar.page(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.value:
                scrollBar.value(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.type:
                scrollBar.type(ScrollBarType.fromString(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return scrollBar;
    }
}
