package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 문단 자동 간격 조정
 */
public class AutoSpacing extends HWPXObject {
    /**
     * 한글과 영어 간격을 자동 조절 여부
     */
    private Boolean eAsianEng;
    /**
     * 한글과 숫자 간격을 자동 조절 여부
     */
    private Boolean eAsianNum;

    public AutoSpacing() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_autoSpacing;
    }

    public Boolean eAsianEng() {
        return eAsianEng;
    }

    public void eAsianEng(Boolean eAsianEng) {
        this.eAsianEng = eAsianEng;
    }

    public AutoSpacing eAsianEngAnd(Boolean eAsianEng) {
        this.eAsianEng = eAsianEng;
        return this;
    }

    public Boolean eAsianNum() {
        return eAsianNum;
    }

    public void eAsianNum(Boolean eAsianNum) {
        this.eAsianNum = eAsianNum;
    }

    public AutoSpacing eAsianNumAnd(Boolean eAsianNum) {
        this.eAsianNum = eAsianNum;
        return this;
    }

    @Override
    public AutoSpacing clone() {
        AutoSpacing cloned = new AutoSpacing();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(AutoSpacing from) {
        this.eAsianEng = from.eAsianEng;
        this.eAsianNum = from.eAsianNum;
    }
}
