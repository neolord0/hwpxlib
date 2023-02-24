package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.BeginNum;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class BeginNumReader extends ElementReader {
    private BeginNum beginNum;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.BeginNum;
    }

    public void beginNum(BeginNum beginNum) {
        this.beginNum = beginNum;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.page:
                beginNum.page(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.footnote:
                beginNum.footnote(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.endnote:
                beginNum.endnote(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.pic:
                beginNum.pic(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.tbl:
                beginNum.tbl(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.equation:
                beginNum.equation(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
