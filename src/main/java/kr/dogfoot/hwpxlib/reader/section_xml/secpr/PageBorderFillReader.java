package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ApplyPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageBorderPositionCriterion;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageFillArea;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFillOffset;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.LeftRightTopBottomReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class PageBorderFillReader extends ElementReader {
    private PageBorderFill pageBorderFill;

    @Override

    public ElementReaderSort sort() {
        return ElementReaderSort.PageBorderFill;
    }

    public void pageBorderFill(PageBorderFill pageBorderFill) {
        this.pageBorderFill = pageBorderFill;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                pageBorderFill.type(ApplyPageType.fromString(value));
                break;
            case AttributeNames.borderFillIDRef:
                pageBorderFill.borderFillIDRefAnd(value);
                break;
            case AttributeNames.textBorder:
                pageBorderFill.textBorder(PageBorderPositionCriterion.fromString(value));
                break;
            case AttributeNames.headerInside:
                pageBorderFill.headerInside(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.footerInside:
                pageBorderFill.footerInside(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.fillArea:
                pageBorderFill.fillArea(PageFillArea.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.PageBorderFillOffset:
                pageBorderFill.createOffset();
                offset(pageBorderFill.offset(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.PageBorderFillOffset:
                PageBorderFillOffset offset = new PageBorderFillOffset();
                offset(offset, name, attrs);
                return offset;
        }
        return null;
    }

    private void offset(PageBorderFillOffset offset, String name, Attributes attrs) {
        ((LeftRightTopBottomReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LeftRightTopBottom))
                .leftRightTopBottom(offset);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return pageBorderFill;
    }
}
