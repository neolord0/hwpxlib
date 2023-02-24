package kr.dogfoot.hwpxlib.reader.section_xml.control.picture;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageDim;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class ImageDimReader extends ElementReader {
    private ImageDim imgDim;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ImageDim;
    }

    public void imgDim(ImageDim imgDim) {
        this.imgDim = imgDim;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.dimwidth:
                imgDim.dimwidth(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.dimheight:
                imgDim.dimheight(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}

