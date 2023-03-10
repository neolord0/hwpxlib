package kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject.ShapeObjectWriter;

public abstract class ShapeComponentWriter extends ShapeObjectWriter {
    protected ShapeComponentWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    protected void writeAttributeForShapeComponent(ShapeComponent shapeComponent) {
        writeAttributeForShapeObject(shapeComponent);

        xsb()
                .attribute(AttributeNames.href, shapeComponent.href())
                .attribute(AttributeNames.groupLevel, shapeComponent.groupLevel())
                .attribute(AttributeNames.instid, shapeComponent.instid());
    }

    protected void writeChildrenForShapeComponent(ShapeComponent shapeComponent) {
        if (shapeComponent.offset() != null) {
            xAndY(ElementNames.hp_offset, shapeComponent.offset());
        }

        if (shapeComponent.orgSz() != null) {
            widthAndHeight(ElementNames.hp_orgSz, shapeComponent.orgSz());
        }

        if (shapeComponent.curSz() != null) {
            widthAndHeight(ElementNames.hp_curSz, shapeComponent.curSz());
        }

        if (shapeComponent.flip() != null) {
            flip(shapeComponent.flip());
        }

        if (shapeComponent.rotationInfo() != null) {
            rotationInfo(shapeComponent.rotationInfo());
        }

        if (shapeComponent.renderingInfo() != null) {
            writeChild(ElementWriterSort.RenderingInfo, shapeComponent.renderingInfo());
        }
    }

    private void flip(Flip flip) {
        xsb()
                .openElement(ElementNames.hp_flip)
                .attribute(AttributeNames.horizontal, flip.horizontal())
                .attribute(AttributeNames.vertical, flip.vertical())
                .closeElement();
    }

    private void rotationInfo(RotationInfo rotationInfo) {
        xsb()
                .openElement(ElementNames.hp_rotationInfo)
                .attribute(AttributeNames.angle, rotationInfo.angle())
                .attribute(AttributeNames.centerX, rotationInfo.centerX())
                .attribute(AttributeNames.centerY, rotationInfo.centerY())
                .attribute(AttributeNames.rotateimage, rotationInfo.rotateimage())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_offset_for_shapeComponent:
                xAndY(ElementNames.hp_offset, (XAndY) child);
                break;
            case hp_orgSz:
                widthAndHeight(ElementNames.hp_orgSz, (WidthAndHeight) child);
                break;
            case hp_curSz:
                widthAndHeight(ElementNames.hp_curSz, (WidthAndHeight) child);
                break;
            case hp_flip:
                flip((Flip) child);
                break;
            case hp_rotationInfo:
                rotationInfo((RotationInfo) child);
                break;
            case hp_renderingInfo:
                writeChild(ElementWriterSort.RenderingInfo, child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}

