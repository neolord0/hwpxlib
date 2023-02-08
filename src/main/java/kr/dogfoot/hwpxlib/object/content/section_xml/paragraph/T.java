package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.*;

import java.util.ArrayList;

/**
 * text
 */
public class T extends RunItem {
    /**
     * 글자모양 아이디 참조
     */
    private String charPrIDRef;

    /**
     * 텍스트 하나만 있을 경우
     */
    private String onlyText;
    /**
     * text Item 리스트(문자열, 변경추적 기록)
     */
    public ArrayList<TItem> itemList;

    public T() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.T;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.MarkpenBegin.equalElementName(name)) {
            return new MarkpenBegin();
        } else if (ObjectType.MarkpenEnd.equalElementName(name)) {
            return new MarkpenEnd();
        } else if (ObjectType.TitleMark.equalElementName(name)) {
            return new TitleMark();
        } else if (ObjectType.Tab.equalElementName(name)) {
            return new Tab();
        } else if (ObjectType.LineBreak.equalElementName(name)) {
            return new LineBreak();
        } else if (ObjectType.Hyphen.equalElementName(name)) {
            return new Hyphen();
        } else if (ObjectType.NBSpace.equalElementName(name)) {
            return new NBSpace();
        } else if (ObjectType.FWSpace.equalElementName(name)) {
            return new FWSpace();
        } else if (ObjectType.InsertBegin.equalElementName(name)) {
            return new InsertBegin();
        } else if (ObjectType.InsertEnd.equalElementName(name)) {
            return new InsertEnd();
        } else if (ObjectType.DeleteBegin.equalElementName(name)) {
            return new DeleteBegin();
        } else if (ObjectType.DeleteEnd.equalElementName(name)) {
            return new DeleteEnd();
        }
        return null;
    }


    public String charPrIDRef() {
        return charPrIDRef;
    }

    public void charPrIDRef(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
    }

    public T charPrIDRefAnd(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
        return this;
    }


    public void addText(String text) {
        if (itemList != null && itemList.size() > 0) {
            itemList.add(new NormalText().textAnd(text));
        } else {
            if (onlyText == null) {
                onlyText = text;
            } else {
                preprocess();

                itemList.add(new NormalText().textAnd(text));
            }
        }
    }

    public void clear() {
        onlyText = null;
        itemList = null;
    }

    public boolean isEmpty() {
        return onlyText == null && itemList == null;
    }

    public boolean isOnlyText() {
        return onlyText != null;
    }

    public String onlyText() {
        return onlyText;
    }

    public int countOfItems() {
        return itemList.size();
    }

    public TItem getItem(int index) {
        return itemList.get(index);
    }

    public void addItem(TItem textItem) {
        itemList.add(textItem);
    }

    public NormalText addNewText() {
        preprocess();

        NormalText text = new NormalText();
        itemList.add(text);
        return text;
    }

    private void preprocess() {
        if (itemList == null) {
            itemList = new ArrayList<TItem>();
        }

        if (onlyText != null) {
            itemList.add(new NormalText().textAnd(onlyText));
            onlyText = null;
        }
    }

    public MarkpenBegin addNewMarkpenBegin() {
        preprocess();

        MarkpenBegin markpenBegin = new MarkpenBegin();
        itemList.add(markpenBegin);
        return markpenBegin;
    }

    public MarkpenEnd addNewMarkpenEnd() {
        preprocess();

        MarkpenEnd markpenEnd = new MarkpenEnd();
        itemList.add(markpenEnd);
        return markpenEnd;
    }

    public TitleMark addNewTitleMark() {
        preprocess();

        TitleMark titleMark = new TitleMark();
        itemList.add(titleMark);
        return titleMark;
    }

    public Tab addNewTab() {
        preprocess();

        Tab tab = new Tab();
        itemList.add(tab);
        return tab;
    }

    public LineBreak addNewLineBreak() {
        preprocess();

        LineBreak lineBreak = new LineBreak();
        itemList.add(lineBreak);
        return lineBreak;
    }

    public Hyphen addNewHyphen() {
        preprocess();

        Hyphen hyphen = new Hyphen();
        itemList.add(hyphen);
        return hyphen;
    }

    public NBSpace addNewNBSpace() {
        preprocess();

        NBSpace nbSpace = new NBSpace();
        itemList.add(nbSpace);
        return nbSpace;
    }

    public FWSpace addNewFWSpace() {
        preprocess();

        FWSpace fwSpace = new FWSpace();
        itemList.add(fwSpace);
        return fwSpace;
    }

    public InsertBegin addNewInsertBegin() {
        preprocess();

        InsertBegin insertBegin = new InsertBegin();
        itemList.add(insertBegin);
        return insertBegin;
    }

    public InsertEnd addNewInsertEnd() {
        preprocess();

        InsertEnd insertEnd = new InsertEnd();
        itemList.add(insertEnd);
        return insertEnd;
    }

    public DeleteBegin addNewDeleteBegin() {
        preprocess();

        DeleteBegin deleteBegin = new DeleteBegin();
        itemList.add(deleteBegin);
        return deleteBegin;
    }

    public DeleteEnd addNewDeleteEnd() {
        preprocess();

        DeleteEnd deleteEnd = new DeleteEnd();
        itemList.add(deleteEnd);
        return deleteEnd;
    }

    public void insertItem(TItem textItem, int position) {
        preprocess();

        itemList.add(position, textItem);
    }

    public void removeItem(int position) {
        if (itemList != null) {
            itemList.remove(position);
        }
    }

    public Iterable<TItem> items() {
        return itemList;
    }
}