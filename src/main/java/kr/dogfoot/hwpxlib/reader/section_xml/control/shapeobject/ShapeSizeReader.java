package kr.dogfoot.hwpxlib.reader.section_xml.control.shapeobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.HeightRelTo;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.WidthRelTo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class ShapeSizeReader extends ElementReader {
    private ShapeSize sz;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ShapeSize;
    }

    public void sz(ShapeSize sz) {
        this.sz = sz;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.width:
                sz.width(ValueConvertor.toLong(value));
                break;
            case AttributeNames.widthRelTo:
                sz.widthRelTo(WidthRelTo.fromString(value));
                break;
            case AttributeNames.height:
                sz.height(ValueConvertor.toLong(value));
                break;
            case AttributeNames.heightRelTo:
                sz.heightRelTo(HeightRelTo.fromString(value));
                break;
            case AttributeNames.protect:
                sz.protect(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

}
