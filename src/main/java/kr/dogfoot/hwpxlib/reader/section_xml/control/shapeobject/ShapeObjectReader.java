package kr.dogfoot.hwpxlib.reader.section_xml.control.shapeobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DropCapStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextFlowSide;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextWrapMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public abstract class ShapeObjectReader extends ElementReader {
    public abstract ShapeObject shapeObject();

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                shapeObject().id(value);
                break;
            case AttributeNames.zOrder:
                shapeObject().zOrder(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.numberingType:
                shapeObject().numberingType(NumberingType.fromString(value));
                break;
            case AttributeNames.textWrap:
                shapeObject().textWrap(TextWrapMethod.fromString(value));
                break;
            case AttributeNames.textFlow:
                shapeObject().textFlow(TextFlowSide.fromString(value));
                break;
            case AttributeNames.lock:
                shapeObject().lock(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.dropcapstyle:
                shapeObject().dropcapstyle(DropCapStyle.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_sz:
                shapeObject().createSZ();
                sz(shapeObject().sz(), name, attrs);
                break;
            case ElementNames.hp_pos:
                shapeObject().createPos();
                pos(shapeObject().pos(), name, attrs);
                break;
            case ElementNames.hp_outMargin:
                shapeObject().createOutMargin();
                leftRightTopBottom(shapeObject().outMargin(), name, attrs);
                break;
            case ElementNames.hp_caption:
                shapeObject().createCaption();
                caption(shapeObject().caption(), name, attrs);
                break;
            case ElementNames.hp_shapeComment:
                shapeObject().createShapeComment();
                hasOnlyText(shapeObject().shapeComment(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_sz:
                ShapeSize sz = new ShapeSize();
                sz(sz, name, attrs);
                return sz;
            case ElementNames.hp_pos:
                ShapePosition pos = new ShapePosition();
                pos(pos, name, attrs);
                return pos;
            case ElementNames.hp_outMargin:
                LeftRightTopBottom outMargin = new LeftRightTopBottom(ObjectType.hp_outMargin);
                leftRightTopBottom(outMargin, name, attrs);
                return outMargin;
            case ElementNames.hp_caption:
                Caption caption = new Caption();
                caption(caption, name, attrs);
                return caption;
            case ElementNames.hp_shapeComment:
                HasOnlyText shapeComment = new HasOnlyText(ObjectType.hp_shapeComment);
                hasOnlyText(shapeComment, name, attrs);
                return shapeComment;
        }
        return null;
    }

    private void sz(ShapeSize sz, String name, Attributes attrs) {
        ((ShapeSizeReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ShapeSize))
                .sz(sz);

        xmlFileReader().startElement(name, attrs);
    }

    private void pos(ShapePosition pos, String name, Attributes attrs) {
        ((ShapePositionReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ShapePosition))
                .pos(pos);

        xmlFileReader().startElement(name, attrs);
    }

    private void caption(Caption caption, String name, Attributes attrs) {
        ((CaptionReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Caption))
                .caption(caption);

        xmlFileReader().startElement(name, attrs);
    }
}
