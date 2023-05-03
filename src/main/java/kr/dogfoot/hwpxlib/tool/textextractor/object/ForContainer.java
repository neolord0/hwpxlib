package kr.dogfoot.hwpxlib.tool.textextractor.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Container;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForContainer extends ExtractorBase {
    public ForContainer(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_container;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        Container container = (Container) from;

        textBuilder().objectStart(container._objectType());

        for (ShapeComponent child : container.children()) {
            extractChild(child);
        }


        textBuilder().objectEnd(container._objectType());
    }
}
