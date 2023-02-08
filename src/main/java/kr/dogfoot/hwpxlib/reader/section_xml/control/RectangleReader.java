package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Rectangle;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class RectangleReader extends ElementReader {
    private Rectangle rectangle;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Rect;
    }

    public void rectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public SwitchableObject switchableObject() {
        return rectangle;
    }
}
