package kr.dogfoot.hwpxlib.tool.finder.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromPara extends FinderBase {
    public FromPara(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_p;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Para para = (Para) from;
        pushPath(para);

        for (Run run : para.runs()) {
            checkWithChildren(run);
        }
        checkWithChildren(para.lineSegArray());

        checkSwitchList(para.switchList());
        popPath();
    }
}
