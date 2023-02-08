package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageStartON;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.StartNum;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class StartNumReader extends ElementReader {
    private StartNum startNum;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.StartNum;
    }

    public void startNum(StartNum startNum) {
        this.startNum = startNum;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.pageStartsOn:
                startNum.pageStartsOn(PageStartON.fromString(value));
                break;
            case AttributeNames.page:
                startNum.page(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.pic:
                startNum.pic(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.tbl:
                startNum.tbl(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.equation:
                startNum.equation(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
