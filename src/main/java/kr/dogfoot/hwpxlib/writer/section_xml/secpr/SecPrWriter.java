package kr.dogfoot.hwpxlib.writer.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class SecPrWriter extends ElementWriter {
    public SecPrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.SecPr;
    }

    @Override
    public void write(HWPXObject object) {
        SecPr secPr = (SecPr) object;
        switchObject(secPr.switchObject());

        xsb()
                .openElement(ElementNames.hp_secPr)
                .elementWriter(this)
                .attribute(AttributeNames.id, secPr.id())
                .attribute(AttributeNames.textDirection, secPr.textDirection())
                .attribute(AttributeNames.spaceColumns, secPr.spaceColumns())
                .attribute(AttributeNames.tabStop, secPr.tabStop())
                .attribute(AttributeNames.tabStopVal, secPr.tabStopVal())
                .attribute(AttributeNames.tabStopUnit, secPr.tabStopUnit())
                .attribute(AttributeNames.outlineShapeIDRef, secPr.outlineShapeIDRef())
                .attribute(AttributeNames.memoShapeIDRef, secPr.memoShapeIDRef())
                .attribute(AttributeNames.textVerticalWidthHead, secPr.textVerticalWidthHead())
                .attribute(AttributeNames.masterPageCnt, secPr.masterPageCnt());

        if (secPr.grid() != null) {
            grid(secPr.grid());
        }

        if (secPr.startNum() != null) {
            startNum(secPr.startNum());
        }

        if (secPr.visibility() != null) {
            visibility(secPr.visibility());
        }

        if (secPr.lineNumberShape() != null) {
            lineNumberShape(secPr.lineNumberShape());
        }

        if (secPr.pagePr() != null) {
            writeChild(ElementWriterSort.PagePr, secPr.pagePr());
        }

        if (secPr.footNotePr() != null) {
            writeChild(ElementWriterSort.FootNotePr, secPr.footNotePr());
        }

        if (secPr.endNotePr() != null) {
            writeChild(ElementWriterSort.EndNotePr, secPr.endNotePr());
        }

        for (PageBorderFill pageBorderFill : secPr.pageBorderFills()) {
            writeChild(ElementWriterSort.PageBorderFill, pageBorderFill);
        }

        for (MasterPage masterPage : secPr.masterPages()) {
            masterPage(masterPage);
        }

        if (secPr.presentation() != null) {
            writeChild(ElementWriterSort.Presentation, secPr.presentation());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void grid(Grid grid) {
        xsb()
                .openElement(ElementNames.hp_grid)
                .attribute(AttributeNames.lineGrid, grid.lineGrid())
                .attribute(AttributeNames.charGrid, grid.charGrid())
                .attribute(AttributeNames.wonggojiFormat, grid.wonggojiFormat())
                .closeElement();
    }

    private void startNum(StartNum startNum) {
        xsb()
                .openElement(ElementNames.hp_startNum)
                .attribute(AttributeNames.pageStartsOn, startNum.pageStartsOn())
                .attribute(AttributeNames.page, startNum.page())
                .attribute(AttributeNames.pic, startNum.pic())
                .attribute(AttributeNames.tbl, startNum.tbl())
                .attribute(AttributeNames.equation, startNum.equation())
                .closeElement();
    }

    private void visibility(Visibility visibility) {
        xsb()
                .openElement(ElementNames.hp_visibility)
                .attribute(AttributeNames.hideFirstHeader, visibility.hideFirstHeader())
                .attribute(AttributeNames.hideFirstFooter, visibility.hideFirstFooter())
                .attribute(AttributeNames.hideFirstMasterPage, visibility.hideFirstMasterPage())
                .attribute(AttributeNames.border, visibility.border())
                .attribute(AttributeNames.fill, visibility.fill())
                .attribute(AttributeNames.hideFirstPageNum, visibility.hideFirstPageNum())
                .attribute(AttributeNames.hideFirstEmptyLine, visibility.hideFirstEmptyLine())
                .attribute(AttributeNames.showLineNumber, visibility.showLineNumber())
                .closeElement();
    }

    private void lineNumberShape(LineNumberShape lineNumberShape) {
        xsb()
                .openElement(ElementNames.hp_lineNumberShape)
                .attribute(AttributeNames.restartType, lineNumberShape.restartType())
                .attribute(AttributeNames.countBy, lineNumberShape.countBy())
                .attribute(AttributeNames.distance, lineNumberShape.distance())
                .attribute(AttributeNames.startNumber, lineNumberShape.startNumber())
                .closeElement();
    }

    private void masterPage(MasterPage masterPage) {
        xsb()
                .openElement(ElementNames.hp_masterPage)
                .attribute(AttributeNames.idRef, masterPage.idRef())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_grid:
                grid((Grid) child);
                break;
            case hp_startNum:
                startNum((StartNum) child);
                break;
            case hp_visibility:
                visibility((Visibility) child);
                break;
            case hp_lineNumberShape:
                lineNumberShape((LineNumberShape) child);
                break;
            case hp_pagePr:
                writeChild(ElementWriterSort.PagePr, child);
                break;
            case hp_footNotePr:
                writeChild(ElementWriterSort.FootNotePr, child);
                break;
            case hp_endNotePr:
                writeChild(ElementWriterSort.EndNotePr, child);
                break;
            case hp_pageBorderFill:
                writeChild(ElementWriterSort.PageBorderFill, child);
                break;
            case hp_presentation:
                writeChild(ElementWriterSort.Presentation, child);
                break;
        }
    }
}
