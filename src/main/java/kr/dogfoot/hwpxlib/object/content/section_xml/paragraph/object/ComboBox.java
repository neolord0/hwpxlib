package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;

import java.util.ArrayList;

/**
 * 콤보 박스
 */
public class ComboBox extends FormObject<ComboBox> {
    /**
     * 콤보박스가 펼쳐졌을 때 최대로 보일 수 있는 줄 수
     */
    private Integer listBoxRows;
    /**
     * 콤보박스가 펼쳐졌을 때 최대로 보일 수 있는 너비
     */
    private Integer listBoxWidth;
    /**
     * 텍스트 편집 여부
     */
    private Boolean editEnable;
    /**
     * 선택된 값
     */
    private String selectedValue;
    /**
     * 목록 아이템 리스트
     */
    private final ArrayList<ListItem> listItemList;

    public ComboBox() {
        listItemList = new ArrayList<ListItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_comboBox;
    }

    public Integer listBoxRows() {
        return listBoxRows;
    }

    public void listBoxRows(Integer listBoxRows) {
        this.listBoxRows = listBoxRows;
    }

    public ComboBox listBoxRowsAnd(Integer listBoxRows) {
        this.listBoxRows = listBoxRows;
        return this;
    }

    public Integer listBoxWidth() {
        return listBoxWidth;
    }

    public void listBoxWidth(Integer listBoxWidth) {
        this.listBoxWidth = listBoxWidth;
    }

    public ComboBox listBoxWidthAnd(Integer listBoxWidth) {
        this.listBoxWidth = listBoxWidth;
        return this;
    }

    public Boolean editEnable() {
        return editEnable;
    }

    public void editEnable(Boolean editEnable) {
        this.editEnable = editEnable;
    }

    public ComboBox editEnableAnd(Boolean editEnable) {
        this.editEnable = editEnable;
        return this;
    }

    public String selectedValue() {
        return selectedValue;
    }

    public void selectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public ComboBox selectedValueAnd(String selectedValue) {
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

    @Override
    public ComboBox clone() {
        ComboBox cloned = new ComboBox();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ComboBox from) {
        this.listBoxRows = from.listBoxRows;
        this.listBoxWidth = from.listBoxWidth;
        this.editEnable = from.editEnable;
        this.selectedValue = from.selectedValue;

        for (ListItem listItem : from.listItemList) {
            listItemList.add(listItem.clone());
        }

        super.copyFrom(from);
    }
}
