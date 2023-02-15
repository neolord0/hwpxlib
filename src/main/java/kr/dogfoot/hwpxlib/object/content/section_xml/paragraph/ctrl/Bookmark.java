package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 북마크
 */
public class Bookmark extends CtrlItem {
    /**
     * 이름
     */
    private String name;

    public Bookmark() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_bookmark;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public Bookmark nameAnd(String name) {
        this.name = name;
        return this;
    }

}
