package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.*;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CtrlWriter extends ElementWriter {
    public CtrlWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Ctrl;
    }

    @Override
    public void write(HWPXObject object) {
        Ctrl ctrl = (Ctrl) object;
        switchObject(ctrl.switchObject());

        xsb()
                .openElement(ElementNames.hp_ctrl)
                .elementWriter(this);

        for (CtrlItem item : ctrl.ctrlItems()) {
            item(item);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void item(CtrlItem item) {
        switch (item._objectType()) {
            case hp_colPr:
                writeChild(ElementWriterSort.ColPr, item);
                break;
            case hp_fieldBegin:
                writeChild(ElementWriterSort.FieldBegin, item);
                break;
            case hp_fieldEnd:
                fieldEnd((FieldEnd) item);
                break;
            case hp_bookmark:
                bookmark((Bookmark) item);
                break;
            case hp_header:
            case hp_footer:
                writeChild(ElementWriterSort.HeaderFooter, item);
                break;
            case hp_footNote:
            case hp_endNote:
                writeChild(ElementWriterSort.FootNoteEndNote, item);
                break;
            case hp_autoNum:
            case hp_newNum:
                writeChild(ElementWriterSort.AutoNumNewNum, item);
                break;
            case hp_pageNumCtrl:
                pageNumCtrl((PageNumCtrl) item);
                break;
            case hp_pageHiding:
                pageHiding((PageHiding) item);
                break;
            case hp_pageNum:
                pageNum((PageNum) item);
                break;
            case hp_indexmark:
                writeChild(ElementWriterSort.Indexmark, item);
                break;
            case hp_hiddenComment:
                writeChild(ElementWriterSort.HiddenComment, item);
                break;
        }
    }

    private void fieldEnd(FieldEnd fieldEnd) {
        xsb()
                .openElement(ElementNames.hp_fieldEnd)
                .attribute(AttributeNames.beginIDRef, fieldEnd.beginIDRef())
                .attribute(AttributeNames.fieldid, fieldEnd.fieldid())
                .closeElement();
    }

    private void bookmark(Bookmark bookmark) {
        xsb()
                .openElement(ElementNames.hp_bookmark)
                .attribute(AttributeNames.name, bookmark.name())
                .closeElement();
    }

    private void pageNumCtrl(PageNumCtrl pageNumCtrl) {
        xsb()
                .openElement(ElementNames.hp_pageNumCtrl)
                .attribute(AttributeNames.pageStartsOn, pageNumCtrl.pageStartsOn())
                .closeElement();
    }

    private void pageHiding(PageHiding pageHiding) {
        xsb()
                .openElement(ElementNames.hp_pageHiding)
                .attribute(AttributeNames.hideHeader, pageHiding.hideHeader())
                .attribute(AttributeNames.hideFooter, pageHiding.hideFooter())
                .attribute(AttributeNames.hideMasterPage, pageHiding.hideMasterPage())
                .attribute(AttributeNames.hideBorder, pageHiding.hideBorder())
                .attribute(AttributeNames.hideFill, pageHiding.hideFill())
                .attribute(AttributeNames.hidePageNum, pageHiding.hidePageNum())
                .closeElement();
    }

    private void pageNum(PageNum pageNum) {
        xsb()
                .openElement(ElementNames.hp_pageNum)
                .attribute(AttributeNames.pos, pageNum.pos())
                .attribute(AttributeNames.formatType, pageNum.formatType())
                .attribute(AttributeNames.sideChar, pageNum.sideChar())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        if (child instanceof CtrlItem) {
            item((CtrlItem) child);
        }
    }
}
