package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TabItemType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 탭
 */
public class Tab extends TItem {
    /**
     * 너비, 단위는 hwpunit
     */
    private Integer width;
    /**
     * 탭 채움 종류
     */
    private LineType2 leader;
    /**
     * 탭 종류
     */
    private TabItemType type;

    public Tab() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Tab;
    }

    public Integer width() {
        return width;
    }

    public Tab width(Integer width) {
        this.width = width;
        return this;
    }

    public Tab widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public LineType2 leader() {
        return leader;
    }

    public void leader(LineType2 leader) {
        this.leader = leader;
    }

    public Tab leaderAnd(LineType2 leader) {
        this.leader = leader;
        return this;
    }

    public TabItemType type() {
        return type;
    }

    public void type(TabItemType type) {
        this.type = type;
    }

    public Tab typeAnd(TabItemType type) {
        this.type = type;
        return this;
    }
}
