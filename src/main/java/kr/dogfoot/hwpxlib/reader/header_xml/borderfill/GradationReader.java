package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.GradationType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Color;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Gradation;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class GradationReader extends ElementReader {
    private Gradation gradation;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Gradation;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                gradation.type(GradationType.fromString(value));
                break;
            case AttributeNames.angle:
                gradation.angle(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.centerX:
                gradation.centerX(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.centerY:
                gradation.centerY(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.step:
                gradation.step(ValueConvertor.toShort(value));
                break;
            case AttributeNames.stepCenter:
                gradation.stepCenter(ValueConvertor.toShort(value));
                break;
            case AttributeNames.alpha:
                gradation.alpha(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Color:
                color(gradation.addNewColor(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.Color) {
            color((Color) child, name, attrs);
        }
    }

    private void color(Color color, String name, Attributes attrs) {
        ((ColorReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Color))
                .color(color);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return gradation;
    }

    public void gradation(Gradation gradation) {
        this.gradation = gradation;
    }
}
