package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Container;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeComponent;

public class FromContainer extends FromShapeComponent {
    public FromContainer(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_container;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Container container = (Container) from;
        pushPath(container);

        checkFromShapeComponent(container);

        for (ShapeComponent child : container.children()) {
            checkWithChildren(child);
        }

        checkSwitchObject(container.switchObject());
        popPath();
    }
}
