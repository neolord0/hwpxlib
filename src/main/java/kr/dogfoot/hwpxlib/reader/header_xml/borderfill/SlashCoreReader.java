package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SlashType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.SlashCore;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class SlashCoreReader extends ElementReader {
    private SlashCore slashCore;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.SlashCore;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                slashCore.type(SlashType.fromString(value));
                break;
            case AttributeNames.Crooked:
                slashCore.Crooked(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.isCounter:
                slashCore.isCounter(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void slashCore(SlashCore slashCore) {
        this.slashCore = slashCore;
    }
}
