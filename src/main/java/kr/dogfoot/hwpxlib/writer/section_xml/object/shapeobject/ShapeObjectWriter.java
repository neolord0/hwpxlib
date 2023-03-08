package kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public abstract class ShapeObjectWriter extends ElementWriter {
    protected ShapeObjectWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    protected void writeAttributeForShapeObject(ShapeObject shapeObject) {
         xsb()
                 .attribute(AttributeNames.id, shapeObject.id())
                 .attribute(AttributeNames.zOrder, shapeObject.zOrder())
                 .attribute(AttributeNames.numberingType, shapeObject.numberingType())
                 .attribute(AttributeNames.textWrap, shapeObject.textWrap())
                 .attribute(AttributeNames.textFlow, shapeObject.textFlow())
                 .attribute(AttributeNames.lock, shapeObject.lock())
                 .attribute(AttributeNames.dropcapstyle, shapeObject.dropcapstyle());
    }

    protected void writeChildrenForShapeObject(ShapeObject shapeObject) {
        if (shapeObject.sz() != null) {
            sz(shapeObject.sz());
        }

        if (shapeObject.pos() != null) {
            pos(shapeObject.pos());
        }

        if (shapeObject.outMargin() != null) {
            leftRightTopBottom(ElementNames.hp_outMargin, shapeObject.outMargin());
        }

        if (shapeObject.caption() != null) {
            writeChild(ElementWriterSort.Caption, shapeObject.caption());
        }

        if (shapeObject.shapeComment() != null) {
            hasOnlyText(ElementNames.hp_shapeComment, shapeObject.shapeComment());
        }
    }

    private void sz(ShapeSize sz) {
        xsb()
                .openElement(ElementNames.hp_sz)
                .attribute(AttributeNames.width, sz.width())
                .attribute(AttributeNames.widthRelTo, sz.widthRelTo())
                .attribute(AttributeNames.height, sz.height())
                .attribute(AttributeNames.heightRelTo, sz.heightRelTo())
                .attribute(AttributeNames.protect, sz.protect())
                .closeElement();
    }

    private void pos(ShapePosition pos) {
        xsb()
                .openElement(ElementNames.hp_pos)
                .attribute(AttributeNames.treatAsChar, pos.treatAsChar())
                .attribute(AttributeNames.affectLSpacing, pos.affectLSpacing())
                .attribute(AttributeNames.flowWithText, pos.flowWithText())
                .attribute(AttributeNames.allowOverlap, pos.allowOverlap())
                .attribute(AttributeNames.holdAnchorAndSO, pos.holdAnchorAndSO())
                .attribute(AttributeNames.vertRelTo, pos.vertRelTo())
                .attribute(AttributeNames.horzRelTo, pos.horzRelTo())
                .attribute(AttributeNames.vertAlign, pos.vertAlign())
                .attribute(AttributeNames.horzAlign, pos.horzAlign())
                .attribute(AttributeNames.vertOffset, pos.vertOffset())
                .attribute(AttributeNames.horzOffset, pos.horzOffset())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_sz:
                sz((ShapeSize) child);
                break;
            case hp_pos:
                pos((ShapePosition) child);
                break;
            case hp_caption:
                writeChild(ElementWriterSort.Caption, child);
                break;
            case hp_shapeComment:
                hasOnlyText(ElementNames.hp_shapeComment, (HasOnlyText) child);
                break;
        }
    }
}
