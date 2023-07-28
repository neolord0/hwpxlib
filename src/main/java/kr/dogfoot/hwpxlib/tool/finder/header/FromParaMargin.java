package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.ParaMargin;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromParaMargin extends FinderBase {
    public FromParaMargin(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_margin;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ParaMargin paraMargin = (ParaMargin) from;
        pushPath(paraMargin);

        check(paraMargin.intent());
        check(paraMargin.left());
        check(paraMargin.right());
        check(paraMargin.prev());
        check(paraMargin.next());

        checkSwitchList(paraMargin.switchList());
        popPath();
    }
}
