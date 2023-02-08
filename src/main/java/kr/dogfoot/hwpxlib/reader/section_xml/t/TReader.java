package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.ctrl.ColSzReader;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
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
            case ElementNames.MarkpenBegin:
                markpenBegin(t.addNewMarkpenBegin(), name, attrs);
                break;
            case ElementNames.MarkpenEnd:
                t.addNewMarkpenEnd();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.TitleMark:
                titleMark(t.addNewTitleMark(), name, attrs);
                break;
            case ElementNames.Tab:
                tab(t.addNewTab(), name, attrs);
                break;
            case ElementNames.LineBreak:
                t.addNewLineBreak();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.Hyphen:
                t.addNewHyphen();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.NBSpace:
                t.addNewNBSpace();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.FWSpace:
                t.addNewFWSpace();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.InsertBegin:
                insertBegin(t.addNewInsertBegin(), name, attrs);
                break;
            case ElementNames.InsertEnd:
                insertEnd(t.addNewInsertEnd(), name, attrs);
                break;
            case ElementNames.DeleteBegin:
                deleteBegin(t.addNewDeleteBegin(), name, attrs);
                break;
            case ElementNames.DeleteEnd:
                deleteEnd(t.addNewDeleteEnd(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        switch (child.objectType()) {
            case MarkpenBegin:
                markpenBegin((MarkpenBegin) child, name, attrs);
                break;
            case TitleMark:
                titleMark((TitleMark) child, name, attrs);
                break;
            case Tab:
                tab((Tab) child, name, attrs);
                break;
            case InsertBegin:
                insertBegin((InsertBegin) child, name, attrs);
                break;
            case InsertEnd:
                insertEnd((InsertEnd) child, name, attrs);
                break;
            case DeleteBegin:
                deleteBegin((DeleteBegin) child, name, attrs);
                break;
            case DeleteEnd:
                deleteEnd((DeleteEnd) child, name, attrs);
                break;
        }
    }

    private void markpenBegin(MarkpenBegin markpenBegin, String name, Attributes attrs) {
        ((MarkpenBeginReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.MarkpenBegin))
                .markpenBegin(markpenBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void titleMark(TitleMark titleMark, String name, Attributes attrs) {
        ((TitleMarkReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TitleMark))
                .titleMark(titleMark);

        xmlFileReader().startElement(name, attrs);
    }

    private void tab(Tab tab, String name, Attributes attrs) {
        ((TabReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Tab))
                .tab(tab);

        xmlFileReader().startElement(name, attrs);
    }

    private void insertBegin(InsertBegin insertBegin, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(insertBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void insertEnd(InsertEnd insertEnd, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(insertEnd);

        xmlFileReader().startElement(name, attrs);
    }

    private void deleteBegin(DeleteBegin deleteBegin, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(deleteBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void deleteEnd(DeleteEnd deleteEnd, String name, Attributes attrs) {
        ((TrackChangeTagReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChangeTag))
                .trackChangeTag(deleteEnd);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return t;
    }
}
