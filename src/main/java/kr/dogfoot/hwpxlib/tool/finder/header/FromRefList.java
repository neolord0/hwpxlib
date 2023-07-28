package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.RefList;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromRefList extends FinderBase {
    public FromRefList(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_refList;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        RefList refList = (RefList) from;
        pushPath(refList);

        checkWithChildren(refList.fontfaces());
        checkWithChildren(refList.borderFills());
        checkWithChildren(refList.charProperties());
        checkWithChildren(refList.tabProperties());
        checkWithChildren(refList.numberings());
        checkWithChildren(refList.bullets());
        checkWithChildren(refList.paraProperties());
        checkWithChildren(refList.styles());
        checkWithChildren(refList.memoProperties());
        checkWithChildren(refList.trackChanges());
        checkWithChildren(refList.trackChangeAuthors());

        checkSwitchList(refList.switchList());
        popPath();
    }
}
