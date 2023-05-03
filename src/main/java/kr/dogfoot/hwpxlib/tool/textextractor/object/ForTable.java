package kr.dogfoot.hwpxlib.tool.textextractor.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForTable extends ExtractorBase {
    public ForTable(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tbl;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        Table table = (Table) from;

        textBuilder().objectStart(table._objectType());

        int rowCount = table.countOfTr();
        int cellCount;
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Tr tr = table.getTr(rowIndex);
            cellCount = tr.countOfTc();

            for (int cellIndex = 0; cellIndex < cellCount; cellIndex++) {
                extractChild(tr.getTc(cellIndex));

                if (cellIndex < cellCount - 1) {
                    textBuilder().tableCellSeparator();
                }
            }

            if (rowIndex < rowCount - 1) {
                textBuilder().tableRowSeparator();
            }
        }

        textBuilder().objectEnd(table._objectType());
    }
}
