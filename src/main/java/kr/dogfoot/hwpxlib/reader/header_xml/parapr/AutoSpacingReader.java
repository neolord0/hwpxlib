package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.AutoSpacing;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class AutoSpacingReader extends ElementReader {
    private AutoSpacing autoSpacing;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.AutoSpacing;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.eAsianEng:
                autoSpacing.eAsianEng(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.eAsianNum:
                autoSpacing.eAsianNum(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void autoSpacing(AutoSpacing autoSpacing) {
        this.autoSpacing = autoSpacing;
    }
}
