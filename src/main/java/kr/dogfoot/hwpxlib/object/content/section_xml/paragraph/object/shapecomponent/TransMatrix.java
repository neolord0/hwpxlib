package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Matrix;

/**
 * 이동 행렬
 */
public class TransMatrix extends Matrix<TransMatrix> {
    public TransMatrix() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.TransMatrix;
    }
}
