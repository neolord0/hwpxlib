package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Equation;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeObject;

public class FromEquation extends FromShapeObject {
    public FromEquation(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_equation;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Equation equation = (Equation) from;
        pushPath(equation);

        checkFromShapeObject(equation);

        check(equation.script());

        checkSwitchList(equation.switchList());
        popPath();
    }
}
