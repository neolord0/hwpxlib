package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ParaHeadingType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.VerticalAlign1;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.Heading;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class HeadingReader extends ElementReader {
    private Heading heading;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Heading;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                heading.type(ParaHeadingType.fromString(value));
                break;
            case AttributeNames.idRef:
                heading.idRef(value);
                break;
            case AttributeNames.level:
                heading.level(ValueConvertor.toByte(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void heading(Heading heading) {
        this.heading = heading;
    }
}
