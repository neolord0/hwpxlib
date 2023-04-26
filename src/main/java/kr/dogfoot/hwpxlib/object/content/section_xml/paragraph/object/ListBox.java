package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;

import java.util.ArrayList;

/**
 * 리스트 박스
 */
public class ListBox extends FormObject<ListBox> {
    /**
     * 아이템 높이
     */
    private Integer itemHeight;
    /**
     * 첫번째 아이템의 인덱스
     */
    private Integer topIdx;
    /**
     * 선택된 값
     */
    private String selectedValue;
    /**
     * 목록 아이템 리스트
     */
    private final ArrayList<ListItem> listItemList;

    public ListBox() {
        listItemList = new ArrayList<ListItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_listBox;
    }

    public Integer itemHeight() {
        return itemHeight;
    }

    public void itemHeight(Integer itemHeight) {
        this.itemHeight = itemHeight;
    }

    public ListBox itemHeightAnd(Integer itemHeight) {
        this.itemHeight = itemHeight;
        return this;
    }

    public Integer topIdx() {
        return topIdx;
    }

    public void topIdx(Integer topIdx) {
        this.topIdx = topIdx;
    }

    public ListBox topIdxAnd(Integer topIdx) {
        this.topIdx = topIdx;
        return this;
    }

    public String selectedValue() {
        return selectedValue;
    }

    public void selectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public ListBox selectedValueAnd(String selectedValue) {
        this.selectedValue = selectedValue;
        return this;
    }

    public int countOfListItem() {
        return listItemList.size();
    }

    public ListItem getListItem(int index) {
        return listItemList.get(index);
    }

    public int getListItemIndex(ListItem listItem) {
        int count = listItemList.size();
        for (int index = 0; index < count; index++) {
            if (listItemList.get(index) == listItem) {
                return index;
            }
        }
        return -1;
    }

    public void addListItem(ListItem listItem) {
        listItemList.add(listItem);
    }

    public ListItem addNewListItem() {
        ListItem listItem = new ListItem();
        listItemList.add(listItem);
        return listItem;
    }

    public void insertListItem(ListItem listItem, int position) {
        listItemList.add(position, listItem);
    }

    public void removeListItem(int position) {
        listItemList.remove(position);
    }

    public Iterable<ListItem> listItems() {
        return listItemList;
    }
}
