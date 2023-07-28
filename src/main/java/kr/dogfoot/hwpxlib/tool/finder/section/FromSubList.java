package kr.dogfoot.hwpxlib.tool.finder.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromSubList extends FinderBase {
    public FromSubList(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_subList;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        SubList subList = (SubList) from;
        pushPath(subList);

        for (Para para : subList.paras()) {
            checkWithChildren(para);
        }

        checkSwitchList(subList.switchList());
        popPath();
    }
}
