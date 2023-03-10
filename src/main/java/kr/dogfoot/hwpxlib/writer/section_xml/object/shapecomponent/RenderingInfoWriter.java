package kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Matrix;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class RenderingInfoWriter extends ElementWriter {
    public RenderingInfoWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.RenderingInfo;
    }

    @Override
    public void write(HWPXObject object) {
        RenderingInfo renderingInfo = (RenderingInfo) object;
        switchObject(renderingInfo.switchObject());

        xsb()
                .openElement(ElementNames.hp_renderingInfo)
                .elementWriter(this);

        for (Matrix matrix : renderingInfo.matrices()) {
            switch (matrix._objectType()) {
                case hc_transMatrix:
                    matrix(ElementNames.hc_transMatrix, matrix);
                    break;
                case hc_scaMatrix:
                    matrix(ElementNames.hc_scaMatrix, matrix);
                    break;
                case hc_rotMatrix:
                    matrix(ElementNames.hc_rotMatrix, matrix);
                    break;
            }
        }

        xsb().closeElement();
        releaseMe();
    }

    private void matrix(String elementName, Matrix matrix) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.e1, matrix.e1())
                .attribute(AttributeNames.e2, matrix.e2())
                .attribute(AttributeNames.e3, matrix.e3())
                .attribute(AttributeNames.e4, matrix.e4())
                .attribute(AttributeNames.e5, matrix.e5())
                .attribute(AttributeNames.e6, matrix.e6())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_transMatrix:
                matrix(ElementNames.hc_transMatrix, (Matrix) child);
                break;
            case hc_scaMatrix:
                matrix(ElementNames.hc_scaMatrix, (Matrix) child);
                break;
            case hc_rotMatrix:
                matrix(ElementNames.hc_rotMatrix, (Matrix) child);
                break;
        }
    }
}
