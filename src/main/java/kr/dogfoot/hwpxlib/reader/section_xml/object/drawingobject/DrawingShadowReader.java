package kr.dogfoot.hwpxlib.reader.section_xml.object.drawingobject;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DrawingShadowType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class DrawingShadowReader extends ElementReader {
    private DrawingShadow shadow;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.DrawingShadow;
    }

    public void shadow(DrawingShadow shadow) {
        this.shadow = shadow;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                shadow.type(DrawingShadowType.fromString(value));
                break;
            case AttributeNames.color:
                shadow.color(value);
                break;
            case AttributeNames.offsetX:
                shadow.offsetX(ValueConvertor.toLong(value));
                break;
            case AttributeNames.offsetY:
                shadow.offsetY(ValueConvertor.toLong(value));
                break;
            case AttributeNames.alpha:
                shadow.alpha(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
