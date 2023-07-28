package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Equation;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject.ShapeObjectWriter;

public class EquationWriter extends ShapeObjectWriter {
    public EquationWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Equation;
    }

    @Override
    public void write(HWPXObject object) {
        Equation equation = (Equation) object;
        switchList(equation.switchList());

        xsb()
                .openElement(ElementNames.hp_equation)
                .elementWriter(this);
        writeAttributeForShapeObject(equation);
        xsb()
                .attribute(AttributeNames.version, equation.version())
                .attribute(AttributeNames.baseLine,  equation.baseLine())
                .attribute(AttributeNames.textColor, equation.textColor())
                .attribute(AttributeNames.baseUnit, equation.baseUnit())
                .attribute(AttributeNames.lineMode, equation.lineMode())
                .attribute(AttributeNames.font, equation.font());

        writeChildrenForShapeObject(equation);

        if (equation.script() != null) {
            hasOnlyText(ElementNames.hp_script, equation.script());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_script:
                hasOnlyText(ElementNames.hp_script, (HasOnlyText) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
