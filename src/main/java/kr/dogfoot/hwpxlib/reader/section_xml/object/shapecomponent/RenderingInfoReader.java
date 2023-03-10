package kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Matrix;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
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
            case ElementNames.hc_transMatrix: ;
                matrix(renderingInfo.addNewTransMatrix(), name, attrs);
                break;
            case ElementNames.hc_scaMatrix:
                matrix(renderingInfo.addNewScaMatrix(), name, attrs);
                break;
            case ElementNames.hc_rotMatrix:
                matrix(renderingInfo.addNewRotMatrix(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_transMatrix:
                Matrix transMatrix = new Matrix(ObjectType.hc_transMatrix);
                matrix(transMatrix, name, attrs);
                return transMatrix;
            case ElementNames.hc_scaMatrix:
                Matrix scaleMatrix = new Matrix(ObjectType.hc_scaMatrix);
                matrix(scaleMatrix, name, attrs);
                return scaleMatrix;
            case ElementNames.hc_rotMatrix:
                Matrix rotateMatrix = new Matrix(ObjectType.hc_rotMatrix);
                matrix(rotateMatrix, name, attrs);
                return rotateMatrix;
        }
        return null;
    }

    private void matrix(Matrix matrix, String name, Attributes attrs) {
        ((MatrixReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Matrix))
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
