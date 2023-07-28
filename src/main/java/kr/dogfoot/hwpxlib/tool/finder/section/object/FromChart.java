package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Chart;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeObject;

public class FromChart extends FromShapeObject {
    public FromChart(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_chart;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Chart chart = (Chart) from;
        pushPath(chart);

        checkFromShapeObject(chart);

        checkSwitchList(chart.switchList());
        popPath();
    }
}
