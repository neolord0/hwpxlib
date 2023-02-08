package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.Heading;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.*;

import java.awt.print.Book;
import java.util.ArrayList;

public class Ctrl extends RunItem {
    private final ArrayList<CtrlItem> itemList;

    public Ctrl() {
        itemList = new ArrayList<CtrlItem>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Ctrl;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.ColPr.equalElementName(name)) {
            return new ColPr();
        } else if (ObjectType.FieldBegin.equalElementName(name)) {
            return new FieldBegin();
        } else if (ObjectType.FieldEnd.equalElementName(name)) {
            return new FieldEnd();
        } else if (ObjectType.Bookmark.equalElementName(name)) {
            return new Bookmark();
        } else if (ObjectType.Header.equalElementName(name)) {
            return new Header();
        } else if (ObjectType.Footer.equalElementName(name)) {
            return new Footer();
        } else if (ObjectType.FootNote.equalElementName(name)) {
            return new FootNote();
        } else if (ObjectType.EndNote.equalElementName(name)) {
            return new EndNote();
        } else if (ObjectType.AutoNum.equalElementName(name)) {
            return new AutoNum();
        } else if (ObjectType.NewNum.equalElementName(name)) {
            return new NewNum();
        } else if (ObjectType.PageNumCtrl.equalElementName(name)) {
            return new PageNumCtrl();
        } else if (ObjectType.PageHiding.equalElementName(name)) {
            return new PageHiding();
        } else if (ObjectType.PageNum.equalElementName(name)) {
            return new PageNum();
        } else if (ObjectType.Indexmark.equalElementName(name)) {
            return new Indexmark();
        } else if (ObjectType.HiddenComment.equalElementName(name)) {
            return new HiddenComment();
        }

        return null;
    }

    public int countOfCtrlItems() {
        return itemList.size();
    }

    public CtrlItem getCtrlItem(int index) {
        return itemList.get(index);
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
}
