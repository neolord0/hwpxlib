package kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Matrix;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class MatrixReader extends ElementReader {
    private Matrix matrix;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Matrix;
    }

    public void matrix(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.e1:
                matrix.e1(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.e2:
                matrix.e2(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.e3:
                matrix.e3(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.e4:
                matrix.e4(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.e5:
                matrix.e5(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.e6:
                matrix.e6(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
