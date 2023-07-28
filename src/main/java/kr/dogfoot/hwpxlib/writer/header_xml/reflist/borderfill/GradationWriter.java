package kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Color;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Gradation;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class GradationWriter extends ElementWriter {
    public GradationWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Gradation;
    }

    @Override
    public void write(HWPXObject object) {
        Gradation gradation = (Gradation) object;
        switchList(gradation.switchList());

        xsb()
                .openElement(ElementNames.hc_gradation)
                .elementWriter(this)
                .attribute(AttributeNames.type, gradation.type())
                .attribute(AttributeNames.angle, gradation.angle())
                .attribute(AttributeNames.centerX, gradation.centerX())
                .attribute(AttributeNames.centerY, gradation.centerY())
                .attribute(AttributeNames.step, gradation.step())
                .attribute(AttributeNames.colorNum, gradation.colorNum())
                .attribute(AttributeNames.stepCenter, gradation.stepCenter())
                .attribute(AttributeNames.alpha, gradation.alpha());

        for (Color color : gradation.colors()) {
            color(color);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void color(Color color) {
        xsb()
                .openElement(ElementNames.hc_color)
                .attribute(AttributeNames.value, color.value())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_color:
                color((Color) child);
                break;
        }
    }
}
