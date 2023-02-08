package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class CtrlReader extends ElementReader {
    private Ctrl ctrl;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Ctrl;
    }

    public void ctrl(Ctrl ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ColPr:
                colPr(ctrl.addNewColPr(), name, attrs);
                break;
            case ElementNames.FieldBegin:
                fieldBegin(ctrl.addNewFieldBegin(), name, attrs);
                break;
            case ElementNames.FieldEnd:
                fieldEnd(ctrl.addNewFieldEnd(), name, attrs);
                break;
            case ElementNames.Bookmark:
                bookmark(ctrl.addNewBookmark(), name, attrs);
                break;
            case ElementNames.Header:
                header(ctrl.addNewHeader(), name, attrs);
                break;
            case ElementNames.Footer:
                footer(ctrl.addNewFooter(), name, attrs);
                break;
            case ElementNames.FootNote:
                footNote(ctrl.addNewFootNote(), name, attrs);
                break;
            case ElementNames.EndNote:
                endNote(ctrl.addNewEndNote(), name, attrs);
                break;
            case ElementNames.AutoNum:
                autoNum(ctrl.addNewAutoNum(), name, attrs);
                break;
            case ElementNames.NewNum:
                newNum(ctrl.addNewNewNum(), name, attrs);
                break;
            case ElementNames.PageNumCtrl:
                pageNumCtrl(ctrl.addNewPageNumCtrl(), name, attrs);
                break;
            case ElementNames.PageHiding:
                pageHiding(ctrl.addNewPageHiding(), name, attrs);
                break;
            case ElementNames.PageNum:
                pageNum(ctrl.addNewPageNum(), name, attrs);
                break;
            case ElementNames.Indexmark:
                indexmark(ctrl.addNewIndexmark(), name, attrs);
                break;
            case ElementNames.HiddenComment:
                hiddenComment(ctrl.addNewHiddenComment(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.ColPr) {
            colPr((ColPr) child, name, attrs);
        } else if (child.objectType() == ObjectType.FieldBegin) {
            fieldBegin((FieldBegin) child, name, attrs);
        } else if (child.objectType() == ObjectType.FieldEnd) {
            fieldEnd((FieldEnd) child, name, attrs);
        } else if (child.objectType() == ObjectType.Bookmark) {
            bookmark((Bookmark) child, name, attrs);
        } else if (child.objectType() == ObjectType.Header) {
            header((Header) child, name, attrs);
        } else if (child.objectType() == ObjectType.Footer) {
            footer((Footer) child, name, attrs);
        } else if (child.objectType() == ObjectType.FootNote) {
            footNote((FootNote) child, name, attrs);
        } else if (child.objectType() == ObjectType.EndNote) {
            endNote((EndNote) child, name, attrs);
        } else if (child.objectType() == ObjectType.AutoNum) {
            autoNum((AutoNum) child, name, attrs);
        } else if (child.objectType() == ObjectType.NewNum) {
            newNum((NewNum) child, name, attrs);
        } else if (child.objectType() == ObjectType.PageNumCtrl) {
            pageNumCtrl((PageNumCtrl) child, name, attrs);
        } else if (child.objectType() == ObjectType.PageHiding) {
            pageHiding((PageHiding) child, name, attrs);
        } else if (child.objectType() == ObjectType.PageNum) {
            pageNum((PageNum) child, name, attrs);
        } else if (child.objectType() == ObjectType.Indexmark) {
            indexmark((Indexmark) child, name, attrs);
        } else if (child.objectType() == ObjectType.HiddenComment) {
            hiddenComment((HiddenComment) child, name, attrs);
        }
    }

    private void colPr(ColPr colPr, String name, Attributes attrs) {
        ((ColPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColPr))
                .colPr(colPr);

        xmlFileReader().startElement(name, attrs);
    }

    private void fieldBegin(FieldBegin fieldBegin, String name, Attributes attrs) {
        ((FieldBeginReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FieldBegin))
                .fieldBegin(fieldBegin);

        xmlFileReader().startElement(name, attrs);
    }

    private void fieldEnd(FieldEnd fieldEnd, String name, Attributes attrs) {
        ((FieldEndReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FieldEnd))
                .fieldEnd(fieldEnd);

        xmlFileReader().startElement(name, attrs);
    }

    private void bookmark(Bookmark bookmark, String name, Attributes attrs) {
        ((BookmarkReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Bookmark))
                .bookmark(bookmark);

        xmlFileReader().startElement(name, attrs);
    }

    private void header(Header header, String name, Attributes attrs) {
        ((HeaderFooterReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HeaderFooter))
                .headerFooter(header);

        xmlFileReader().startElement(name, attrs);
    }

    private void footer(Footer footer, String name, Attributes attrs) {
        ((HeaderFooterReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HeaderFooter))
                .headerFooter(footer);

        xmlFileReader().startElement(name, attrs);
    }

    private void footNote(FootNote footNote, String name, Attributes attrs) {
        ((FootNoteEndNoteReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FootNoteEndNote))
                .footNoteEndNote(footNote);

        xmlFileReader().startElement(name, attrs);
    }

    private void endNote(EndNote endNote, String name, Attributes attrs) {
        ((FootNoteEndNoteReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FootNoteEndNote))
                .footNoteEndNote(endNote);

        xmlFileReader().startElement(name, attrs);
    }

    private void autoNum(AutoNum autoNum, String name, Attributes attrs) {
        ((AutoNumNewNumReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.AutoNumNewNum))
                .autoNumNewNum(autoNum);

        xmlFileReader().startElement(name, attrs);
    }

    private void newNum(NewNum newNum, String name, Attributes attrs) {
        ((AutoNumNewNumReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.AutoNumNewNum))
                .autoNumNewNum(newNum);

        xmlFileReader().startElement(name, attrs);
    }

    private void pageNumCtrl(PageNumCtrl pageNumCtrl, String name, Attributes attrs) {
        ((PageNumCtrlReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PageNumCtrl))
                .pageNumCtrl(pageNumCtrl);

        xmlFileReader().startElement(name, attrs);
    }

    private void pageHiding(PageHiding pageHiding, String name, Attributes attrs) {
        ((PageHidingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PageHiding))
                .pageHiding(pageHiding);

        xmlFileReader().startElement(name, attrs);
    }

    private void pageNum(PageNum pageNum, String name, Attributes attrs) {
        ((PageNumReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PageNum))
                .pageNum(pageNum);

        xmlFileReader().startElement(name, attrs);
    }

    private void indexmark(Indexmark indexmark, String name, Attributes attrs) {
        ((IndexmarkReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Indexmark))
                .indexmark(indexmark);

        xmlFileReader().startElement(name, attrs);
    }

    private void hiddenComment(HiddenComment hiddenComment, String name, Attributes attrs) {
        ((HiddenCommentReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HiddenComment))
                .hiddenComment(hiddenComment);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return ctrl;
    }
}
