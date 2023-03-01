package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ApplyPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.PageNumCtrl;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class PageNumCtrlReader extends ElementReader {
    private PageNumCtrl pageNumCtrl;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PageNumCtrl;
    }

    public void pageNumCtrl(PageNumCtrl pageNumCtrl) {
        this.pageNumCtrl = pageNumCtrl;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.pageStartsOn:
                pageNumCtrl.pageStartsOn(ApplyPageType.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
