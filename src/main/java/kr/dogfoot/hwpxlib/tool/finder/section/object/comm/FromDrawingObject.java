package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public abstract class FromDrawingObject extends FromShapeComponent {
    public FromDrawingObject(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    public void checkFromDrawingObject(DrawingObject drawingObject) throws Exception {
        checkFromShapeComponent(drawingObject);

        check(drawingObject.lineShape());
        checkWithChildren(drawingObject.fillBrush());
        checkWithChildren(drawingObject.drawText());
        check(drawingObject.shadow());
    }
}
