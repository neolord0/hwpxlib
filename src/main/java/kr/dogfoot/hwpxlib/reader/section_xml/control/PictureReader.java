package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Picture;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class PictureReader extends ElementReader {
    private Picture picture;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Pic;
    }

    public void picture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public SwitchableObject switchableObject() {
        return picture;
    }
}
