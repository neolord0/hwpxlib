package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeObject;

public class FromTable extends FromShapeObject {
    public FromTable(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tbl;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Table table = (Table) from;
        pushPath(table);

        checkFromShapeObject(table);

        check(table.inMargin());
        checkWithChildren(table.cellzoneList());
        for (Tr tr : table.trs()) {
            checkWithChildren(tr);
        }
        checkWithChildren(table.parameterSet());

        checkSwitchObject(table.switchObject());
        popPath();
    }
}
