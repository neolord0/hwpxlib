package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.EndNotePr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.FootNotePr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PagePr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class SecPrReader extends ElementReader {
    private SecPr secPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.SecPr;
    }

    public void secPr(SecPr secPr) {
        this.secPr = secPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                secPr.id(value);
                break;
            case AttributeNames.textDirection:
                secPr.textDirection(TextDirection.fromString(value));
                break;
            case AttributeNames.spaceColumns:
                secPr.spaceColumns(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.tabStop:
                secPr.tabStop(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.tabStopVal:
                secPr.tabStopVal(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.tabStopUnit:
                secPr.tabStopUnit(ValueUnit1.fromString(value));
                break;
            case AttributeNames.outlineShapeIDRef:
                secPr.outlineShapeIDRef(value);
                break;
            case AttributeNames.memoShapeIDRef:
                secPr.memoShapeIDRef(value);
                break;
            case AttributeNames.textVerticalWidthHead:
                secPr.textVerticalWidthHead(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Grid:
                secPr.createGrid();
                grid(secPr.grid(), name, attrs);
                break;
            case ElementNames.StartNum:
                secPr.createStartNum();
                startNum(secPr.startNum(), name, attrs);
                break;
            case ElementNames.Visibility:
                secPr.createVisibility();
                visibility(secPr.visibility(), name, attrs);
                break;
            case ElementNames.LineNumberShape:
                secPr.createLineNumberShape();
                lineNumberShape(secPr.lineNumberShape(), name, attrs);
                break;
            case ElementNames.PagePr:
                secPr.createPagePr();
                pagePr(secPr.pagePr(), name, attrs);
                break;
            case ElementNames.FootNotePr:
                secPr.createFootNotePr();
                footNotePr(secPr.footNotePr(), name, attrs);
                break;
            case ElementNames.EndNotePr:
                secPr.createEndNotePr();
                endNotePr(secPr.endNotePr(), name, attrs);
                break;
            case ElementNames.PageBorderFill:
                pageBorderFill(secPr.addNewPageBorderFill(), name, attrs);
                break;
            case ElementNames.MasterPage:
                masterPage(secPr.addNewMasterPage(), name, attrs);
                break;
            case ElementNames.Presentation:
                secPr.createPresentation();
                presentation(secPr.presentation(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.Grid) {
            grid((Grid) child, name, attrs);
        } else if (child.objectType() == ObjectType.StartNum) {
            startNum((StartNum) child, name, attrs);
        } else if (child.objectType() == ObjectType.Visibility) {
            visibility((Visibility) child, name, attrs);
        } else if (child.objectType() == ObjectType.LineNumberShape) {
            lineNumberShape((LineNumberShape) child, name, attrs);
        } else if (child.objectType() == ObjectType.PagePr) {
            pagePr((PagePr) child, name, attrs);
        } else if (child.objectType() == ObjectType.FootNotePr) {
            footNotePr((FootNotePr) child, name, attrs);
        } else if (child.objectType() == ObjectType.EndNotePr) {
            endNotePr((EndNotePr) child, name, attrs);
        } else if (child.objectType() == ObjectType.PageBorderFill) {
            pageBorderFill((PageBorderFill) child, name, attrs);
        } else if (child.objectType() == ObjectType.MasterPage) {
            masterPage((MasterPage) child, name, attrs);
        } else if (child.objectType() == ObjectType.Presentation) {
            presentation((Presentation) child, name, attrs);
        }
    }

    private void grid(Grid grid, String name, Attributes attrs) {
        ((GridReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Grid))
                .grid(grid);

        xmlFileReader().startElement(name, attrs);
    }

    private void startNum(StartNum startNum, String name, Attributes attrs) {
        ((StartNumReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.StartNum))
                .startNum(startNum);

        xmlFileReader().startElement(name, attrs);
    }

    private void visibility(Visibility visibility, String name, Attributes attrs) {
        ((VisibilityReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Visibility))
                .visibility(visibility);

        xmlFileReader().startElement(name, attrs);
    }

    private void lineNumberShape(LineNumberShape lineNumberShape, String name, Attributes attrs) {
        ((LineNumberShapeReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LineNumberShape))
                .lineNumberShape(lineNumberShape);

        xmlFileReader().startElement(name, attrs);
    }

    private void pagePr(PagePr pagePr, String name, Attributes attrs) {
        ((PagePrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PagePr))
                .pagePr(pagePr);

        xmlFileReader().startElement(name, attrs);
    }

    private void footNotePr(FootNotePr footNotePr, String name, Attributes attrs) {
        ((FootNotePrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FootNotePr))
                .footNotePr(footNotePr);

        xmlFileReader().startElement(name, attrs);
    }

    private void endNotePr(EndNotePr endNotePr, String name, Attributes attrs) {
        ((EndNotePrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.EndNotePr))
                .endNotePr(endNotePr);

        xmlFileReader().startElement(name, attrs);
    }

    private void pageBorderFill(PageBorderFill pageBorderFill, String name, Attributes attrs) {
        ((PageBorderFillReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PageBorderFill))
                .pageBorderFill(pageBorderFill);

        xmlFileReader().startElement(name, attrs);
    }

    private void masterPage(MasterPage masterPage, String name, Attributes attrs) {
        ((MasterPageReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.MasterPage))
                .masterPage(masterPage);

        xmlFileReader().startElement(name, attrs);
    }

    private void presentation(Presentation presentation, String name, Attributes attrs) {
        ((PresentationReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Presentation))
                .presentation(presentation);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return secPr;
    }
}