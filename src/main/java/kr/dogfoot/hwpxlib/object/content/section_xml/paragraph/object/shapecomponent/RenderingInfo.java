package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 변환 정보
 */
public class RenderingInfo extends SwitchableObject {
    private TransMatrix transMatrix;
    private ScaleMatrix scaMatrix;
    private RotateMatrix rotMatrix;

    public RenderingInfo() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.RenderingInfo;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.TransMatrix.equalElementName(name)) {
            return new TransMatrix();
        } else if (ObjectType.ScaMatrix.equalElementName(name)) {
            return new ScaleMatrix();
        } else if (ObjectType.RotMatrix.equalElementName(name)) {
            return new RotateMatrix();
        }
        return null;
    }

    public TransMatrix transMatrix() {
        return transMatrix;
    }

    public void createTransMatrix() {
        transMatrix = new TransMatrix();
    }

    public void removeTransMatrix() {
        transMatrix = null;
    }

    public ScaleMatrix scaMatrix() {
        return scaMatrix;
    }

    public void createScaMatrix() {
        scaMatrix = new ScaleMatrix();
    }

    public void removeScaMatrix() {
        scaMatrix = null;
    }

    public RotateMatrix rotMatrix() {
        return rotMatrix;
    }

    public void createRotMatrix() {
        rotMatrix = new RotateMatrix();
    }

    public void removeRotMatrix() {
        rotMatrix = null;
    }
}
