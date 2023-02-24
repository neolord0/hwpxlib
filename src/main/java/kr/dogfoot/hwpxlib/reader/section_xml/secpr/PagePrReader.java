package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.GutterMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PageMargin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PagePr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class PagePrReader extends ElementReader {
    private PagePr pagePr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PagePr;
    }

    public void pagePr(PagePr pagePr) {
        this.pagePr = pagePr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.landscape:
                pagePr.landscape(PageDirection.fromString(value));
                break;
            case AttributeNames.width:
                pagePr.width(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.height:
                pagePr.height(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.gutterType:
                pagePr.gutterType(GutterMethod.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_margin:
                pagePr.createMargin();
                margin(pagePr.margin(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_margin:
                PageMargin margin = new PageMargin();
                margin(margin, name, attrs);
                return margin;
        }
        return null;
    }

    private void margin(PageMargin margin, String name, Attributes attrs) {
        ((PageMarginReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PageMargin))
                .margin(margin);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return pagePr;
    }
}
