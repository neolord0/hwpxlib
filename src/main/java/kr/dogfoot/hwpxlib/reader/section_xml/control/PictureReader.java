package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Picture;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageDim;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.Effects;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.borderfill.ImageReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.picture.ImageDimReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.picture.ImageRectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.picture.LineShapeReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects.EffectsReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent.ShapeComponentReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class PictureReader extends ShapeComponentReader {
    private Picture picture;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Pic;
    }

    @Override
    public ShapeComponent shapeComponent() {
        return picture;
    }

    public void picture(Picture picture) {
        this.picture = picture;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.reverse:
                picture.reverse(ValueConvertor.toBoolean(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_lineShape:
                picture.createLineShape();
                lineShape(picture.lineShape(), name, attrs);
                break;
            case ElementNames.hp_imgRect:
                picture.createImgRect();
                imgRect(picture.imgRect(), name, attrs);
                break;
            case ElementNames.hp_imgClip:
                picture.createImgClip();
                leftRightTopBottom(picture.imgClip(), name, attrs);
                break;
            case ElementNames.hp_inMargin:
                picture.createInMargin();
                leftRightTopBottom(picture.inMargin(), name, attrs);
                break;
            case ElementNames.hp_imgDim:
                picture.createImgDim();
                imgDim(picture.imgDim(), name, attrs);
                break;
            case ElementNames.hc_img:
                picture.createImg();
                img(picture.img(), name, attrs);
                break;
            case ElementNames.hp_effects:
                picture.createEffects();
                effects(picture.effects(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_lineShape:
                LineShape lineShape = new LineShape();
                lineShape(lineShape, name, attrs);
                return lineShape;
            case ElementNames.hp_imgRect:
                ImageRect imageRect = new ImageRect();
                imgRect(imageRect, name, attrs);
                return imageRect;
            case ElementNames.hp_imgClip:
                LeftRightTopBottom imageClip = new LeftRightTopBottom(ObjectType.hp_imgClip);
                leftRightTopBottom(imageClip, name, attrs);
                return imageClip;
            case ElementNames.hp_inMargin:
                LeftRightTopBottom inMargin = new LeftRightTopBottom(ObjectType.hp_inMargin);
                leftRightTopBottom(inMargin, name, attrs);
                return inMargin;
            case ElementNames.hp_imgDim:
                ImageDim imageDim = new ImageDim();
                imgDim(imageDim, name, attrs);
                return imageDim;
            case ElementNames.hc_img:
                Image image = new Image();
                img(image, name, attrs);
                return image;
            case ElementNames.hp_effects:
                Effects effects = new Effects();
                effects(effects, name, attrs);
                return effects;
        }

        return super.childElementInSwitch(name, attrs);
    }


    private void lineShape(LineShape lineShape, String name, Attributes attrs) {
        ((LineShapeReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LineShape))
                .lineShape(lineShape);

        xmlFileReader().startElement(name, attrs);
    }

    private void imgRect(ImageRect imgRect, String name, Attributes attrs) {
        ((ImageRectReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ImageRect))
                .imgRect(imgRect);

        xmlFileReader().startElement(name, attrs);
    }

    private void imgDim(ImageDim imgDim, String name, Attributes attrs) {
        ((ImageDimReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ImageDim))
                .imgDim(imgDim);

        xmlFileReader().startElement(name, attrs);
    }

    private void img(Image img, String name, Attributes attrs) {
        ((ImageReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Image))
                .img(img);

        xmlFileReader().startElement(name, attrs);
    }

    private void effects(Effects effects, String name, Attributes attrs) {
        ((EffectsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Effects))
                .effects(effects);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return picture;
    }
}
