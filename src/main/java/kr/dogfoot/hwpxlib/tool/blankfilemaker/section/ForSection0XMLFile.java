package kr.dogfoot.hwpxlib.tool.blankfilemaker.section;

import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.SecPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.EndNotePr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.FootNotePr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;

public class ForSection0XMLFile {
    public static void make(SectionXMLFile sectionXMLFile) {
        Para para = sectionXMLFile.addNewPara();
        para
                .idAnd("2764991984")
                .paraPrIDRefAnd("3")
                .styleIDRefAnd("0")
                .pageBreakAnd(false)
                .columnBreakAnd(false)
                .merged(false);

        run(para.addNewRun());

        para.createLineSegArray();
        para.lineSegArray().addNew()
                .textposAnd(0)
                .vertposAnd(0)
                .vertsizeAnd(1000)
                .textheightAnd(1000)
                .baselineAnd(850)
                .spacingAnd(600)
                .horzposAnd(0)
                .horzsizeAnd(42520)
                .flags(393216);
    }

    private static void run(Run run) {
        run.charPrIDRef("0");

        run.createSecPr();
        secPr(run.secPr());

        Ctrl ctrl = run.addNewCtrl();
        ctrl.addNewColPr()
                .idAnd("")
                .typeAnd(MultiColumnType.NEWSPAPER)
                .layoutAnd(ColumnDirection.LEFT)
                .colCountAnd(1)
                .sameSzAnd(true)
                .sameGap(0);

        run.addNewT();
    }

    private static void secPr(SecPr secPr) {
        secPr
                .idAnd("")
                .textDirectionAnd(TextDirection.HORIZONTAL)
                .spaceColumnsAnd(1134)
                .tabStopAnd(8000)
                .tabStopValAnd(4000)
                .tabStopUnitAnd(ValueUnit1.HWPUNIT)
                .outlineShapeIDRefAnd("1")
                .memoShapeIDRefAnd("0")
                .textVerticalWidthHeadAnd(false);

        secPr.createGrid();
        secPr.grid()
                .lineGridAnd(0)
                .charGridAnd(0)
                .wonggojiFormat(false);

        secPr.createStartNum();
        secPr.startNum()
                .pageStartsOnAnd(PageStartON.BOTH)
                .pageAnd(0)
                .picAnd(0)
                .tblAnd(0)
                .equation(0);

        secPr.createVisibility();
        secPr.visibility()
                .hideFirstHeaderAnd(false)
                .hideFirstFooterAnd(false)
                .hideFirstMasterPageAnd(false)
                .borderAnd(VisibilityOption.SHOW_ALL)
                .fillAnd(VisibilityOption.SHOW_ALL)
                .hideFirstPageNumAnd(false)
                .hideFirstEmptyLineAnd(false)
                .showLineNumber(false);

        secPr.createLineNumberShape();;
        secPr.lineNumberShape()
                .restartTypeAnd(LineNumberRestartType.Unknown)
                .countByAnd(0)
                .distanceAnd(0)
                .startNumber(0);

        secPr.createPagePr();
        secPr.pagePr()
                .landscapeAnd(PageDirection.WIDELY)
                .widthAnd(59528)
                .heightAnd(84188)
                .gutterType(GutterMethod.LEFT_ONLY);

        secPr.pagePr().createMargin();
        secPr.pagePr().margin()
                .headerAnd(4252)
                .footerAnd(4252)
                .gutterAnd(0)
                .leftAnd(8504)
                .rightAnd(8504)
                .topAnd(5668)
                .bottom(4252);

        secPr.createFootNotePr();
        footNotePr(secPr.footNotePr());

        secPr.createEndNotePr();
        endNotePr(secPr.endNotePr());

        pageBorderFillForBoth(secPr.addNewPageBorderFill());
        pageBorderFillForEven(secPr.addNewPageBorderFill());
        pageBorderFillForOdd(secPr.addNewPageBorderFill());
    }

    private static void footNotePr(FootNotePr footNotePr) {
        footNotePr.createAutoNumFormat();
        footNotePr.autoNumFormat()
                .typeAnd(NumberType2.DIGIT)
                .userCharAnd("")
                .prefixCharAnd("")
                .suffixCharAnd(")")
                .supscript(false);

        footNotePr.createNoteLine();
        footNotePr.noteLine()
                .lengthAnd(-1)
                .typeAnd(LineType2.SOLID)
                .widthAnd(LineWidth.MM_0_12)
                .color("#000000");

        footNotePr.createNoteSpacing();
        footNotePr.noteSpacing()
                .betweenNotesAnd(283)
                .belowLineAnd(567)
                .aboveLine(850);

        footNotePr.createNumbering();
        footNotePr.numbering()
                .typeAnd(FootNoteNumberingType.CONTINUOUS)
                .newNum(1);

        footNotePr.createPlacement();;
        footNotePr.placement()
                .placeAnd(FootNotePlace.EACH_COLUMN)
                .beneathText(false);
    }

    private static void endNotePr(EndNotePr endNotePr) {
        endNotePr.createAutoNumFormat();
        endNotePr.autoNumFormat()
                .typeAnd(NumberType2.DIGIT)
                .userCharAnd("")
                .prefixCharAnd("")
                .suffixCharAnd(")")
                .supscript(false);

        endNotePr.createNoteLine();
        endNotePr.noteLine()
                .lengthAnd(14692344)
                .typeAnd(LineType2.SOLID)
                .widthAnd(LineWidth.MM_0_12)
                .color("#000000");

        endNotePr.createNoteSpacing();
        endNotePr.noteSpacing()
                .betweenNotesAnd(0)
                .belowLineAnd(567)
                .aboveLine(850);

        endNotePr.createNumbering();
        endNotePr.numbering()
                .typeAnd(EndNoteNumberingType.CONTINUOUS)
                .newNum(1);

        endNotePr.createPlacement();
        endNotePr.placement()
                .placeAnd(EndNotePlace.END_OF_DOCUMENT)
                .beneathText(false);
    }

    private static void pageBorderFillForBoth(PageBorderFill pbf) {
        pbf
                .typeAnd(ApplyPageType.BOTH)
                .borderFillIDRefAnd("1")
                .textBorderAnd(PageBorderPositionCriterion.PAPER)
                .headerInsideAnd(false)
                .footerInsideAnd(false)
                .fillArea(PageFillArea.PAPER);

        pbf.createOffset();
        pbf.offset()
                .leftAnd(1417L)
                .rightAnd(1417L)
                .topAnd(1417L)
                .bottom(1417L);
    }

    private static void pageBorderFillForEven(PageBorderFill pbf) {
        pbf
                .typeAnd(ApplyPageType.EVEN)
                .borderFillIDRefAnd("1")
                .textBorderAnd(PageBorderPositionCriterion.PAPER)
                .headerInsideAnd(false)
                .footerInsideAnd(false)
                .fillArea(PageFillArea.PAPER);

        pbf.createOffset();
        pbf.offset()
                .leftAnd(1417L)
                .rightAnd(1417L)
                .topAnd(1417L)
                .bottom(1417L);
    }

    private static void pageBorderFillForOdd(PageBorderFill pbf) {
        pbf
                .typeAnd(ApplyPageType.ODD)
                .borderFillIDRefAnd("1")
                .textBorderAnd(PageBorderPositionCriterion.PAPER)
                .headerInsideAnd(false)
                .footerInsideAnd(false)
                .fillArea(PageFillArea.PAPER);

        pbf.createOffset();
        pbf.offset()
                .leftAnd(1417L)
                .rightAnd(1417L)
                .topAnd(1417L)
                .bottom(1417L);
    }
}
