package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageEffect;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ImageReader extends ElementReader {
    private Image img;
    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Image;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.binaryItemIDRef:
                img.binaryItemIDRef(value);
                break;
            case AttributeNames.bright:
                img.bright(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.contrast:
                img.contrast(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.effect:
                img.effect(ImageEffect.fromString(value));
                break;
            case AttributeNames.alpha:
                img.alpha(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void img(Image img) {
        this.img = img;
    }
}
