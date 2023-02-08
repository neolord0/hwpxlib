package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 채우기 정보
 */
public class FillBrush extends SwitchableObject {
    /**
     * 기본 채우기 정보
     */
    private WinBrush winBrush;
    /**
     * 그라데이션 채우기 정보
     */
    private Gradation gradation;
    /**
     * 이미지 채우기 정보
     */
    private ImgBrush imgBrush;

    public FillBrush() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FillBrush;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.WinBrush.equalElementName(name)) {
            return new WinBrush();
        } else if (ObjectType.Gradation.equalElementName(name)) {
            return new Gradation();
        } else if (ObjectType.ImgBrush.equalElementName(name)) {
            return new ImgBrush();
        }
        return null;
    }

    public WinBrush winBrush() {
        return winBrush;
    }

    public void createWinBrush() {
        winBrush = new WinBrush();
    }

    public void removeWinBrush() {
        winBrush = null;
    }

    public Gradation gradation() {
        return gradation;
    }

    public void createGradation() {
        gradation = new Gradation();
    }

    public void removeGradation() {
        gradation = null;
    }

    public ImgBrush imgBrush() {
        return imgBrush;
    }

    public void createImgBrush() {
        imgBrush = new ImgBrush();
    }

    public void removeImgBrush() {
        imgBrush = null;
    }
}
