package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromCtrl extends FinderBase {
    public FromCtrl(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_ctrl;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Ctrl ctrl = (Ctrl) from;
        pushPath(ctrl);

        for (CtrlItem ctrlItem : ctrl.ctrlItems()) {
            switch (ctrlItem._objectType()) {
                case hp_colPr:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_fieldBegin:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_fieldEnd:
                    check(ctrlItem);
                    break;
                case hp_bookmark:
                    check(ctrlItem);
                    break;
                case hp_header:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_footer:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_footNote:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_endNote:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_autoNum:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_newNum:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_pageNumCtrl:
                    check(ctrlItem);
                    break;
                case hp_pageHiding:
                    check(ctrlItem);
                    break;
                case hp_pageNum:
                    check(ctrlItem);
                    break;
                case hp_indexmark:
                    checkWithChildren(ctrlItem);
                    break;
                case hp_hiddenComment:
                    checkWithChildren(ctrlItem);
                    break;
            }
        }

        checkSwitchObject(ctrl.switchObject());
        popPath();
    }
}
