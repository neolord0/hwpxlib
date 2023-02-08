package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Equation;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class EquationReader extends ElementReader {
    private Equation equation;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Equation;
    }

    public void equation(Equation equation) {
        this.equation = equation;
    }

    @Override
    public SwitchableObject switchableObject() {
        return equation;
    }
}
