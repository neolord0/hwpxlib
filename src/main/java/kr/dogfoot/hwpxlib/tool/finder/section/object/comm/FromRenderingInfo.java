package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Matrix;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromRenderingInfo extends FinderBase {
    public FromRenderingInfo(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_renderingInfo;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        RenderingInfo renderingInfo = (RenderingInfo) from;
        pushPath(renderingInfo);

        for (Matrix matrix : renderingInfo.matrices()) {
            check(matrix);
        }

        checkSwitchList(renderingInfo.switchList());
        popPath();
    }
}
