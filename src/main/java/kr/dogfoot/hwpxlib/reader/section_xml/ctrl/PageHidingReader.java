package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.PageHiding;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class PageHidingReader extends ElementReader {
    private PageHiding pageHiding;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PageHiding;
    }

    public void pageHiding(PageHiding pageHiding) {
        this.pageHiding = pageHiding;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.hideHeader:
                pageHiding.hideHeader(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideFooter:
                pageHiding.hideFooter(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideMasterPage:
                pageHiding.hideMasterPage(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideBorder:
                pageHiding.hideBorder(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideFill:
                pageHiding.hideFill(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hidePageNum:
                pageHiding.hidePageNum(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
