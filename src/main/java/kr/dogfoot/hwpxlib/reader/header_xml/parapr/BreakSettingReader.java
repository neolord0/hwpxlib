package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineBreakForLatin;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineBreakForNonLatin;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWrap;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.BreakSetting;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class BreakSettingReader extends ElementReader {
    private BreakSetting breakSetting;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.BreakSetting;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.breakLatinWord:
                breakSetting.breakLatinWordAnd(LineBreakForLatin.fromString(value));
                break;
            case AttributeNames.breakNonLatinWord:
                breakSetting.breakNonLatinWordAnd(LineBreakForNonLatin.fromString(value));
                break;
            case AttributeNames.widowOrphan:
                breakSetting.widowOrphan(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.keepWithNext:
                breakSetting.keepWithNext(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.keepLines:
                breakSetting.keepLines(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.pageBreakBefore:
                breakSetting.pageBreakBefore(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.lineWrap:
                breakSetting.lineWrap(LineWrap.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void breakSetting(BreakSetting breakSetting) {
        this.breakSetting = breakSetting;
    }
}
