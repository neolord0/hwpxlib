package kr.dogfoot.hwpxlib.reader.section_xml.control.formobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormCharPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class FormCharPrReader extends ElementReader {
    private FormCharPr formCharPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FormCharPr;
    }

    public void formCharPr(FormCharPr formCharPr) {
        this.formCharPr = formCharPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.charPrIDRef:
                formCharPr.charPrIDRef(value);
                break;
            case AttributeNames.followContext:
                formCharPr.followContext(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.autoSz:
                formCharPr.autoSz(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.wordWrap:
                formCharPr.wordWrap(ValueConvertor.toBoolean(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
