package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.*;

import java.util.ArrayList;

public class Ctrl extends RunItem {
    private final ArrayList<CtrlItem> itemList;

    public Ctrl() {
        itemList = new ArrayList<CtrlItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_ctrl;
    }

    public int countOfCtrlItems() {
        return itemList.size();
    }

    public CtrlItem getCtrlItem(int index) {
        return itemList.get(index);
    }

    public int getCtrlItemIndex(CtrlItem ctrlItem) {
        int count = itemList.size();
        for (int index = 0; index < count; index++) {
            if (itemList.get(index) == ctrlItem) {
                return index;
            }
        }
        return -1;
    }

    public void addCtrlItem(CtrlItem ctrlItem) {
        itemList.add(ctrlItem);
    }

    public ColPr addNewColPr() {
        ColPr colPr = new ColPr();
        itemList.add(colPr);
        return colPr;
    }

    public FieldBegin addNewFieldBegin() {
        FieldBegin fieldBegin = new FieldBegin();
        itemList.add(fieldBegin);
        return fieldBegin;
    }

    public FieldEnd addNewFieldEnd() {
        FieldEnd fieldEnd = new FieldEnd();
        itemList.add(fieldEnd);
        return fieldEnd;
    }

    public Bookmark addNewBookmark() {
        Bookmark bookmark = new Bookmark();
        itemList.add(bookmark);
        return bookmark;
    }

    public Header addNewHeader() {
        Header header = new Header();
        itemList.add(header);
        return header;
    }

    public Footer addNewFooter() {
        Footer footer = new Footer();
        itemList.add(footer);
        return footer;
    }

    public FootNote addNewFootNote() {
        FootNote footNote = new FootNote();
        itemList.add(footNote);
        return footNote;
    }

    public EndNote addNewEndNote() {
        EndNote endNote = new EndNote();
        itemList.add(endNote);
        return endNote;
    }

    public AutoNum addNewAutoNum() {
        AutoNum autoNum = new AutoNum();
        itemList.add(autoNum);
        return autoNum;
    }

    public NewNum addNewNewNum() {
        NewNum newNum = new NewNum();
        itemList.add(newNum);
        return newNum;
    }

    public PageNumCtrl addNewPageNumCtrl() {
        PageNumCtrl pageNumCtrl = new PageNumCtrl();
        itemList.add(pageNumCtrl);
        return pageNumCtrl;
    }

    public PageHiding addNewPageHiding() {
        PageHiding pageHiding = new PageHiding();
        itemList.add(pageHiding);
        return pageHiding;
    }

    public PageNum addNewPageNum() {
        PageNum pageNum = new PageNum();
        itemList.add(pageNum);
        return pageNum;
    }

    public Indexmark addNewIndexmark() {
        Indexmark indexmark = new Indexmark();
        itemList.add(indexmark);
        return indexmark;
    }

    public HiddenComment addNewHiddenComment() {
        HiddenComment hiddenComment = new HiddenComment();
        itemList.add(hiddenComment);
        return hiddenComment;
    }

    public void insertCtrlItem(CtrlItem ctrlItem, int position) {
        itemList.add(position, ctrlItem);
    }

    public void removeCtrlItem(int position) {
        itemList.remove(position);
    }

    public Iterable<CtrlItem> ctrlItems() {
        return itemList;
    }

    @Override
    public Ctrl clone() {
        Ctrl cloned = new Ctrl();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Ctrl from) {
        for (CtrlItem item : from.itemList) {
            itemList.add((CtrlItem) item.clone());
        }

        super.copyFrom(from);
    }
}
