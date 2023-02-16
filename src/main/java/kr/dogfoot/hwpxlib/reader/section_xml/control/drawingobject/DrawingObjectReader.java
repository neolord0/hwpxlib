package kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.borderfill.FillBrushReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.picture.LineShapeReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent.ShapeComponentReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public abstract class DrawingObjectReader extends ShapeComponentReader {
    public abstract DrawingObject drawingObject();

    @Override
    public ShapeComponent shapeComponent() {
        return drawingObject();
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_lineShape:
                drawingObject().createLineShape();
                lineShape(drawingObject().lineShape(), name, attrs);
                break;
            case ElementNames.hc_fillBrush:
                drawingObject().createFillBrush();
                fillBrush(drawingObject().fillBrush(), name, attrs);
                break;
            case ElementNames.hp_drawText:
                drawingObject().createDrawText();
                drawText(drawingObject().drawText(), name, attrs);
                break;
            case ElementNames.hp_shadow:
                drawingObject().createShadow();
                shadow(drawingObject().shadow(), name, attrs);
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
            case ElementNames.hc_fillBrush:
                FillBrush fillBrush = new FillBrush();
                fillBrush(fillBrush, name, attrs);
                return fillBrush;
            case ElementNames.hp_drawText:
                DrawText drawText = new DrawText();
                drawText(drawText, name, attrs);
                return drawText;
            case ElementNames.hp_shadow:
                DrawingShadow shadow = new DrawingShadow();
                shadow(shadow, name, attrs);
                return shadow;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void lineShape(LineShape lineShape, String name, Attributes attrs) {
        ((LineShapeReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LineShape))
                .lineShape(lineShape);

        xmlFileReader().startElement(name, attrs);
    }

    private void fillBrush(FillBrush fillBrush, String name, Attributes attrs) {
        ((FillBrushReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FillBrush))
                .fillBrush(fillBrush);

        xmlFileReader().startElement(name, attrs);
    }

    private void drawText(DrawText drawText, String name, Attributes attrs) {
        ((DrawTextReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.DrawText))
                .drawText(drawText);

        xmlFileReader().startElement(name, attrs);
    }

    private void shadow(DrawingShadow shadow, String name, Attributes attrs) {
        ((DrawingShadowReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.DrawingShadow))
                .shadow(shadow);

        xmlFileReader().startElement(name, attrs);
    }
}
