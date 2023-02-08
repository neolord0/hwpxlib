package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Matrix;

/**
 * 회전 행렬
 */
public class RotateMatrix extends Matrix<RotateMatrix> {
    public RotateMatrix() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.RotMatrix;
    }
}
