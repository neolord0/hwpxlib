package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr.TabItem;

import java.util.ArrayList;

/**
 * 탭 정의
 */
public class TabPr extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 문단 왼쪽 끝 자동 탭 여부
     */
    private Boolean autoTabLeft;
    /**
     * 문단 오른쪽 끝 자동 탭 여부(0 or 1)
     */
    private Boolean autoTabRight;
    /**
     * 탭 아이템 리스트
     */
    private final ArrayList<TabItem> tabItemList;

    public TabPr() {
        tabItemList = new ArrayList<TabItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_tabPr;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public TabPr idAnd(String id) {
        this.id = id;
        return this;
    }

    public Boolean autoTabLeft() {
        return autoTabLeft;
    }

    public void autoTabLeft(Boolean autoTabLeft) {
        this.autoTabLeft = autoTabLeft;
    }

    public TabPr autoTabLeftAnd(Boolean autoTabLeft) {
        this.autoTabLeft = autoTabLeft;
        return this;
    }

    public Boolean autoTabRight() {
        return autoTabRight;
    }

    public void autoTabRight(Boolean autoTabRight) {
        this.autoTabRight = autoTabRight;
    }

    public TabPr autoTabRightAnd(Boolean autoTabRight) {
        this.autoTabRight = autoTabRight;
        return this;
    }

    public int countOfTabItem() {
        return tabItemList.size();
    }

    public TabItem getTabItem(int index) {
        return tabItemList.get(index);
    }

    public int getTabItemIndex(TabItem tabItem) {
        int count = tabItemList.size();
        for (int index = 0; index < count; index++) {
            if (tabItemList.get(index) == tabItem) {
                return index;
            }
        }
        return -1;
    }

    public void addTabItem(TabItem tabItem) {
        tabItemList.add(tabItem);
    }

    public TabItem addNewTabItem() {
        TabItem tabItem = new TabItem();
        tabItemList.add(tabItem);
        return tabItem;
    }

    public void insertTabItem(TabItem tabItem, int position) {
        tabItemList.add(position, tabItem);
    }

    public void removeTabItem(int position) {
        tabItemList.remove(position);
    }

    public Iterable<TabItem> tabItems() {
        return tabItemList;
    }
}
