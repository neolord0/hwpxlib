package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class TReader extends ElementReader {
    private T t;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.T;
    }

    public void t(T t) {
        this.t = t;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.charPrIDRef:
                t.charPrIDRef(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        t.addText(text);
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_markpenBegin:
                markpenBegin(t.addNewMarkpenBegin(), name, attrs);
                break;
            case ElementNames.hp_markpenEnd:
                t.addNewMarkpenEnd();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hp_titleMark:
                titleMark(t.addNewTitleMark(), name, attrs);
                break;
            case ElementNames.hp_tab:
                tab(t.addNewTab(), name, attrs);
                break;
            case ElementNames.hp_lineBreak:
                t.addNewLineBreak();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hp_hyphen:
                t.addNewHyphen();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hp_nbSpace:
                t.addNewNBSpace();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hp_fwSpace:
                t.addNewFWSpace();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hp_insertBegin:
                insertBegin(t.addNewInsertBegin(), name, attrs);
                break;
            case ElementNames.hp_insertEnd:
                insertEnd(t.addNewInsertEnd(), name, attrs);
                break;
            case ElementNames.hp_deleteBegin:
                deleteBegin(t.addNewDeleteBegin(), name, attrs);
                break;
            case ElementNames.hp_deleteEnd:
                deleteEnd(t.addNewDeleteEnd(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_markpenBegin:
                MarkpenBegin markpenBegin = new MarkpenBegin();
                markpenBegin(markpenBegin, name, attrs);
                return markpenBegin;
            case ElementNames.hp_markpenEnd:
                MarkpenEnd markpenEnd = new MarkpenEnd();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return markpenEnd;
            case ElementNames.hp_titleMark:
                TitleMark titleMark = new TitleMark();
                titleMark(titleMark, name, attrs);
                return titleMark;
            case ElementNames.hp_tab:
                Tab tab = new Tab();
                tab(tab, name, attrs);
                return tab;
            case ElementNames.hp_lineBreak:
                LineBreak lineBreak = new LineBreak();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return lineBreak;
            case ElementNames.hp_hyphen:
                Hyphen hyphen = new Hyphen();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return hyphen;
            case ElementNames.hp_nbSpace:
                NBSpace nbSpace = new NBSpace();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return nbSpace;
            case ElementNames.hp_fwSpace:
                FWSpace fwSpace = new FWSpace();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return fwSpace;
            case ElementNames.hp_insertBegin:
                InsertBegin insertBegin = new InsertBegin();
                insertBegin(insertBegin, name, attrs);
                return insertBegin;
            case ElementNames.hp_insertEnd:
                InsertEnd insertEnd = new InsertEnd();
                insertEnd(insertEnd, name, attrs);
                return insertEnd;
            case ElementNames.hp_deleteBegin:
                DeleteBegin deleteBegin = new DeleteBegin();
                deleteBegin(deleteBegin, name, attrs);
                return deleteBegin;
            case ElementNames.hp_deleteEnd:
                DeleteEnd deleteEnd = new DeleteEnd();
                deleteEnd(deleteEnd, name, attrs);
                return deleteEnd;
        }
        return null;
    }

    private void markpenBegin(MarkpenBegin markpenBegin, String name, Attributes attrs) {
        ((MarkpenBeginReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.MarkpenBegin))
                .markpenBegin(markpenBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void titleMark(TitleMark titleMark, String name, Attributes attrs) {
        ((TitleMarkReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TitleMark))
                .titleMark(titleMark);

        xmlFileReader().startElement(name, attrs);
    }

    private void tab(Tab tab, String name, Attributes attrs) {
        ((TabReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Tab))
                .tab(tab);

        xmlFileReader().startElement(name, attrs);
    }

    private void insertBegin(InsertBegin insertBegin, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(insertBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void insertEnd(InsertEnd insertEnd, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(insertEnd);

        xmlFileReader().startElement(name, attrs);
    }

    private void deleteBegin(DeleteBegin deleteBegin, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(deleteBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void deleteEnd(DeleteEnd deleteEnd, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(deleteEnd);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return t;
    }
}
