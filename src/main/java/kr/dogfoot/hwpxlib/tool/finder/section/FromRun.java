package kr.dogfoot.hwpxlib.tool.finder.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.RunItem;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromRun extends FinderBase {
    public FromRun(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_run;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Run run = (Run) from;
        pushPath(run);

        checkWithChildren(run.secPr());
        for (RunItem runItem : run.runItems()) {
            checkWithChildren(runItem);
        }

        checkSwitchList(run.switchList());
        popPath();
    }
}
