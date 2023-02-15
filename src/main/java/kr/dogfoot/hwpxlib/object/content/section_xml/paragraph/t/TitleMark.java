package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 제목 차례 표시
 */
public class TitleMark extends TItem {
    private Boolean ignore;

    public TitleMark() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_titleMark;
    }

    public Boolean ignore() {
        return ignore;
    }

    public void ignore(Boolean ignore) {
        this.ignore = ignore;
    }

    public TitleMark ignoreAnd(Boolean ignore) {
        this.ignore = ignore;
        return this;
    }
}
