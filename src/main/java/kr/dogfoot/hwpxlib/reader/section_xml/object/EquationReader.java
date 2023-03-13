package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EquationLineMode;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Equation;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class EquationReader extends ShapeObjectReader {
    private Equation equation;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Equation;
    }

    @Override
    public ShapeObject shapeObject() {
        return equation;
    }

    public void equation(Equation equation) {
        this.equation = equation;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.version:
                equation.version(value);
                break;
            case AttributeNames.baseLine:
                equation.baseLine(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.textColor:
                equation.textColor(value);
                break;
            case AttributeNames.baseUnit:
                equation.baseUnit(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.lineMode:
                equation.lineMode(EquationLineMode.fromString(value));
                break;
            case AttributeNames.font:
                equation.font(value);
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_script:
                equation.createScript();
                hasOnlyText(equation.script(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_script:
                HasOnlyText script = new HasOnlyText(ObjectType.hp_script);
                hasOnlyText(script, name, attrs);
                return script;
        }

        return super.childElementInSwitch(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return equation;
    }
}
