package kr.dogfoot.hwpxlib.reader.header_xml.docoption;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.LinkInfo;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class LinkInfoReader extends ElementReader {
    private LinkInfo linkInfo;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LinkInfo;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.path:
                linkInfo.path(value);
                break;
            case AttributeNames.pageInherit:
                linkInfo.pageInherit(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.footnoteInherit:
                linkInfo.footnoteInherit(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void linkInfo(LinkInfo linkInfo) {
        this.linkInfo = linkInfo;
    }
}
