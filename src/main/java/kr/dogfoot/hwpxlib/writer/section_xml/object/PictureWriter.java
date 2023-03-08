package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Picture;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageDim;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill.ImageBrushWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent.ShapeComponentWriter;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class PictureWriter extends ShapeComponentWriter {
    public PictureWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Picture;
    }

    @Override
    public void write(HWPXObject object) {
        Picture picture = (Picture) object;
        switchObject(picture.switchObject());

        xsb()
                .openElement(ElementNames.hp_pic)
                .elementWriter(this);
        writeAttributeForShapeComponent(picture);
        xsb().attribute(AttributeNames.reverse, picture.reverse());

        writeChildrenForShapeComponent(picture);

        if (picture.lineShape() != null) {
            lineShape(picture.lineShape(), xsb());
        }

        if (picture.imgRect() != null) {
            writeChild(ElementWriterSort.ImageRect, picture.imgRect());
        }

        if (picture.imgClip() != null) {
            leftRightTopBottom(ElementNames.hp_imgClip, picture.imgClip());
        }

        if (picture.inMargin() != null) {
            leftRightTopBottom(ElementNames.hp_inMargin, picture.inMargin());
        }

        if (picture.imgDim() != null) {
            imgDim(picture.imgDim());
        }

        if (picture.img() != null) {
            ImageBrushWriter.img(picture.img(), xsb());
        }

        if (picture.effects() != null) {
            writeChild(ElementWriterSort.Effects, picture.effects());
        }

        xsb().closeElement();
        releaseMe();
    }

    public static void lineShape(LineShape lineShape, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hp_lineShape)
                .attribute(AttributeNames.color, lineShape.color())
                .attribute(AttributeNames.width, lineShape.width())
                .attribute(AttributeNames.style, lineShape.style())
                .attribute(AttributeNames.endCap, lineShape.endCap())
                .attribute(AttributeNames.headStyle, lineShape.headStyle())
                .attribute(AttributeNames.tailStyle, lineShape.tailStyle())
                .attribute(AttributeNames.headfill, lineShape.headfill())
                .attribute(AttributeNames.tailfill, lineShape.tailfill())
                .attribute(AttributeNames.headSz, lineShape.headSz())
                .attribute(AttributeNames.tailSz, lineShape.tailSz())
                .attribute(AttributeNames.outlineStyle, lineShape.outlineStyle())
                .attribute(AttributeNames.alpha, lineShape.alpha())
                .closeElement();
    }

    private void imgDim(ImageDim imgDim) {
        xsb()
                .openElement(ElementNames.hp_imgDim)
                .attribute(AttributeNames.dimwidth, imgDim.dimwidth())
                .attribute(AttributeNames.dimheight, imgDim.dimheight())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_lineShape:
                lineShape((LineShape) child, xsb());
                break;
            case hp_imgRect:
                writeChild(ElementWriterSort.ImageBrush, child);
                break;
            case hp_imgClip:
                leftRightTopBottom(ElementNames.hp_imgClip, (LeftRightTopBottom) child);
                break;
            case hp_inMargin:
                leftRightTopBottom(ElementNames.hp_inMargin, (LeftRightTopBottom) child);
                break;
            case hp_imgDim:
                imgDim((ImageDim) child);
                break;
            case hc_img:
                ImageBrushWriter.img((Image) child, xsb());
                break;
            case hp_effects:
                writeChild(ElementWriterSort.Effects, child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
