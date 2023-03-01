package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PageMargin;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class PageMarginReader extends ElementReader {
    private PageMargin pageMargin;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PageMargin;
    }

    public void margin(PageMargin pageMargin) {
        this.pageMargin = pageMargin;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.left:
                pageMargin.left(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.right:
                pageMargin.right(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.top:
                pageMargin.top(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.bottom:
                pageMargin.bottom(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.header:
                pageMargin.header(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.footer:
                pageMargin.footer(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.gutter:
                pageMargin.gutter(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
