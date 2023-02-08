package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
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
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ColPr:
                ColPr colPr = new ColPr();
                colPr(colPr, name, attrs);
                return colPr;
            case ElementNames.FieldBegin:
                FieldBegin fieldBegin = new FieldBegin();
                fieldBegin(fieldBegin, name, attrs);
                return fieldBegin;
            case ElementNames.FieldEnd:
                FieldEnd fieldEnd = new FieldEnd();
                fieldEnd(fieldEnd, name, attrs);
                return fieldEnd;
            case ElementNames.Bookmark:
                Bookmark bookmark = new Bookmark();
                bookmark(bookmark, name, attrs);
                return bookmark;
            case ElementNames.Header:
                Header header = new Header();
                header(header, name, attrs);
                return header;
            case ElementNames.Footer:
                Footer footer = new Footer();
                footer(footer, name, attrs);
                return footer;
            case ElementNames.FootNote:
                FootNote footNote = new FootNote();
                footNote(footNote, name, attrs);
                return footNote;
            case ElementNames.EndNote:
                EndNote endNote = new EndNote();
                endNote(endNote, name, attrs);
                return endNote;
            case ElementNames.AutoNum:
                AutoNum autoNum = new AutoNum();
                autoNum(autoNum, name, attrs);
                return autoNum;
            case ElementNames.NewNum:
                NewNum newNum = new NewNum();
                newNum(newNum, name, attrs);
                return newNum;
            case ElementNames.PageNumCtrl:
                PageNumCtrl pageNumCtrl = new PageNumCtrl();
                pageNumCtrl(pageNumCtrl, name, attrs);
                return pageNumCtrl;
            case ElementNames.PageHiding:
                PageHiding pageHiding = new PageHiding();
                pageHiding(pageHiding, name, attrs);
                return pageHiding;
            case ElementNames.PageNum:
                PageNum pageNum = new PageNum();
                pageNum(pageNum, name, attrs);
                return pageNum;
            case ElementNames.Indexmark:
                Indexmark indexmark = new Indexmark();
                indexmark(indexmark, name, attrs);
                return indexmark;
            case ElementNames.HiddenComment:
                HiddenComment hiddenComment = new HiddenComment();
                hiddenComment(hiddenComment, name, attrs);
                return hiddenComment;
        }
        return null;
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
