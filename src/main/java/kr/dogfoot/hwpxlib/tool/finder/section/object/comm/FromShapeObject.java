package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public abstract class FromShapeObject extends FinderBase {
    public FromShapeObject(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    public void checkFromShapeObject(ShapeObject shapeObject) throws Exception {
        check(shapeObject.sz());
        check(shapeObject.pos());
        check(shapeObject.outMargin());
        checkWithChildren(shapeObject.caption());
        check(shapeObject.shapeComment());
    }
}

