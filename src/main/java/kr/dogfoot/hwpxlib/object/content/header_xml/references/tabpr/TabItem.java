package kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TabItemType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;

public class TabItem extends HWPXObject {
    /**
     * 탭 위치, 단위는 hwpunit
     */
    private Integer pos;
    /**
     * 탭 종류
     */
    private TabItemType type;
    /**
     * 탭 채움 종류
     */
    private LineType2 leader;
    /**
     * 단위
     */
    private ValueUnit2 unit;

    public TabItem() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_tabItem;
    }

    public Integer pos() {
        return pos;
    }

    public void pos(Integer pos) {
        this.pos = pos;
    }

    public TabItem posAnd(Integer pos) {
        this.pos = pos;
        return this;
    }

    public TabItemType type() {
        return type;
    }

    public void type(TabItemType type) {
        this.type = type;
    }

    public TabItem typeAnd(TabItemType type) {
        this.type = type;
        return this;
    }

    public LineType2 leader() {
        return leader;
    }

    public void leader(LineType2 leader) {
        this.leader = leader;
    }

    public TabItem leaderAnd(LineType2 leader) {
        this.leader = leader;
        return this;
    }

    public ValueUnit2 unit() {
        return unit;
    }

    public void unit(ValueUnit2 unit) {
        this.unit = unit;
    }

    public TabItem unitAnd(ValueUnit2 unit) {
        this.unit = unit;
        return this;
    }
}
