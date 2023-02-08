package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
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
    public ObjectType objectType() {
        return ObjectType.Bookmark;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        return null;    // no child
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
