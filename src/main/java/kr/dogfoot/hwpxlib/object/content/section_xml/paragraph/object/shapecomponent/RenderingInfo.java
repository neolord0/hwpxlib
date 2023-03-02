package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

/**
 * 변환 정보
 */
public class RenderingInfo extends SwitchableObject {
    private Matrix transMatrix;
    private Matrix scaMatrix;
    private Matrix rotMatrix;

    public RenderingInfo() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_renderingInfo;
    }

    public Matrix transMatrix() {
        return transMatrix;
    }

    public void createTransMatrix() {
        transMatrix = new Matrix(ObjectType.hc_transMatrix);
    }

    public void removeTransMatrix() {
        transMatrix = null;
    }

    public Matrix scaMatrix() {
        return scaMatrix;
    }

    public void createScaMatrix() {
        scaMatrix = new Matrix(ObjectType.hc_scaMatrix);
    }

    public void removeScaMatrix() {
        scaMatrix = null;
    }

    public Matrix rotMatrix() {
        return rotMatrix;
    }

    public void createRotMatrix() {
        rotMatrix = new Matrix(ObjectType.hc_rotMatrix);
    }

    public void removeRotMatrix() {
        rotMatrix = null;
    }
}
