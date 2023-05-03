package kr.dogfoot.hwpxlib.tool.textextractor.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForDrawingObject extends ExtractorBase {
    private ObjectType objectType;
    public ForDrawingObject(ExtractorManager extractorManager, Parameter parameter, ObjectType objectType) {
        super(extractorManager, parameter);
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        DrawingObject drawingObject = (DrawingObject) from;
        textBuilder().objectStart(drawingObject._objectType());

        if (drawingObject.drawText() != null) {
            extractChild(drawingObject.drawText().subList());
        }

        textBuilder().objectEnd(drawingObject._objectType());
    }
}
