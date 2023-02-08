package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.NumberType1;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageNumPosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.PageNum;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class PageNumReader extends ElementReader {
    private PageNum pageNum;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PageNum;
    }

    public void pageNum(PageNum pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.pos:
                pageNum.pos(PageNumPosition.fromString(value));
                break;
            case AttributeNames.formatType:
                pageNum.formatType(NumberType1.fromString(value));
                break;
            case AttributeNames.sideChar:
                pageNum.sideChar(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
