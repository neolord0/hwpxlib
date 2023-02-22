package kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Matrix;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotateMatrix;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ScaleMatrix;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.TransMatrix;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class RenderingInfoReader extends ElementReader {
    private RenderingInfo renderingInfo;

    @Override
    public ElementReaderSort sort() {
        return null;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_transMatrix:
                renderingInfo.createTransMatrix();
                matrix(renderingInfo.transMatrix(), name, attrs);
                break;
            case ElementNames.hc_scaMatrix:
                renderingInfo.createScaMatrix();
                matrix(renderingInfo.scaMatrix(), name, attrs);
                break;
            case ElementNames.hc_rotMatrix:
                renderingInfo.createRotMatrix();
                matrix(renderingInfo.rotMatrix(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_transMatrix:
                TransMatrix transMatrix = new TransMatrix();
                matrix(transMatrix, name, attrs);
                return transMatrix;
            case ElementNames.hc_scaMatrix:
                ScaleMatrix scaleMatrix = new ScaleMatrix();
                matrix(scaleMatrix, name, attrs);
                return scaleMatrix;
            case ElementNames.hc_rotMatrix:
                RotateMatrix rotateMatrix = new RotateMatrix();
                matrix(rotateMatrix, name, attrs);
                return rotateMatrix;
        }
        return null;
    }

    private void matrix(Matrix matrix, String name, Attributes attrs) {
        ((MatrixReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Matrix))
                .matrix(matrix);

        xmlFileReader().startElement(name, attrs);
    }

    public void renderingInfo(RenderingInfo renderingInfo) {
        this.renderingInfo = renderingInfo;
    }

    @Override
    public SwitchableObject switchableObject() {
        return renderingInfo;
    }
}
