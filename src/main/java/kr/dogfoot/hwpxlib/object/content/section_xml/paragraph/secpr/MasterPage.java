package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 바탕쪽 정보
 */
public class MasterPage extends HWPXObject {
    /**
     * 바탕쪽 아이디 참조
     */
    private String idRef;

    public MasterPage() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_masterPage;
    }

    public String idRef() {
        return idRef;
    }

    public void idRef(String idRef) {
        this.idRef = idRef;
    }

    public MasterPage idRefAnd(String idRef) {
        this.idRef = idRef;
        return this;
    }

    @Override
    public MasterPage clone() {
        MasterPage cloned = new MasterPage();
        cloned.copyFrom(this);
        return cloned;
    }

    private void copyFrom(MasterPage from) {
        this.idRef = from.idRef;
    }
}
