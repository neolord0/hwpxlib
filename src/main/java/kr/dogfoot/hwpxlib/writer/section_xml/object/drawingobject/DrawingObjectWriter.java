package kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.PictureWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent.ShapeComponentWriter;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public abstract class DrawingObjectWriter extends ShapeComponentWriter {
    protected DrawingObjectWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    protected void writeAttributeForDrawingObject(DrawingObject drawingObject) {
        writeChildrenForShapeComponent(drawingObject);
    }


    protected void writeChildrenForDrawingObject(DrawingObject drawingObject) {
        writeChildrenForShapeComponent(drawingObject);

        if (drawingObject.lineShape() != null) {
            PictureWriter.lineShape(drawingObject.lineShape(), xsb());
        }

        if (drawingObject.fillBrush() != null) {
            writeChild(ElementWriterSort.FillBrush, drawingObject.fillBrush());
        }

        if (drawingObject.drawText() != null) {
            writeChild(ElementWriterSort.DrawText, drawingObject.drawText());
        }

        if (drawingObject.shadow() != null) {
            shadow(drawingObject.shadow(), xsb());
        }
    }

    public static void shadow(DrawingShadow shadow, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hp_shadow)
                .attribute(AttributeNames.type, shadow.type())
                .attribute(AttributeNames.color, shadow.color())
                .attribute(AttributeNames.offsetX, shadow.offsetX())
                .attribute(AttributeNames.offsetY, shadow.offsetY())
                .attribute(AttributeNames.alpha, shadow.alpha())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_lineShape:
                PictureWriter.lineShape((LineShape) child, xsb());
                break;
            case hc_fillBrush:
                writeChild(ElementWriterSort.FillBrush, child);
                break;
            case hp_drawText:
                writeChild(ElementWriterSort.DrawText, child);
                break;
            case hp_shadow_for_drawingObject:
                shadow((DrawingShadow) child, xsb());
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
