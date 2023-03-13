package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageBrushMode;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.ImgBrush;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class ImageBrushReader extends ElementReader {
    private ImgBrush imgBrush;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ImageBrush;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.mode:
                imgBrush.mode(ImageBrushMode.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_img:
                imgBrush.createImg();
                image(imgBrush.img(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_img:
                Image image = new Image();
                image(image, name, attrs);
                return image;
        }
        return null;
    }

    private void image(Image img, String name, Attributes attrs) {
        ((ImageReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Image))
                .img(img);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return imgBrush;
    }

    public void imgBrush(ImgBrush imgBrush) {
        this.imgBrush = imgBrush;
    }
}
