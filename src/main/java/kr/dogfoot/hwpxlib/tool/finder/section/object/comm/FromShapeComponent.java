package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public abstract class FromShapeComponent extends FromShapeObject {
    public FromShapeComponent(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    public void checkFromShapeComponent(ShapeComponent shapeComponent) throws Exception {
        checkFromShapeObject(shapeComponent);

        check(shapeComponent.offset());
        check(shapeComponent.orgSz());
        check(shapeComponent.curSz());
        check(shapeComponent.flip());
        check(shapeComponent.rotationInfo());
        checkWithChildren(shapeComponent.renderingInfo());
    }
}
