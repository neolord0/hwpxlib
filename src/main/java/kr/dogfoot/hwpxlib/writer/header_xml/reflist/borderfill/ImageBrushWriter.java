package kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.ImgBrush;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class ImageBrushWriter extends ElementWriter {
    public ImageBrushWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ImageBrush;
    }

    @Override
    public void write(HWPXObject object) {
        ImgBrush imgBrush = (ImgBrush) object;
        switchList(imgBrush.switchList());

        xsb()
                .openElement(ElementNames.hc_imgBrush)
                .elementWriter(this)
                .attribute(AttributeNames.mode, imgBrush.mode());

        if (imgBrush.img() != null) {
            img(imgBrush.img(), xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    public static void img(Image img, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hc_img)
                .attribute(AttributeNames.binaryItemIDRef, img.binaryItemIDRef())
                .attribute(AttributeNames.bright, img.bright())
                .attribute(AttributeNames.contrast, img.contrast())
                .attribute(AttributeNames.effect, img.effect())
                .attribute(AttributeNames.alpha, img.alpha())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_img:
                img((Image) child, xsb());
                break;
        }
    }
}
