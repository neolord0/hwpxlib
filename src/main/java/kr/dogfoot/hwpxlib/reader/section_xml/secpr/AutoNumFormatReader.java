package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumberType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.AutoNumFormat;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class AutoNumFormatReader extends ElementReader {
    private AutoNumFormat autoNumFormat;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.AutoNumFormat;
    }

    public void autoNumFormat(AutoNumFormat autoNumFormat) {
        this.autoNumFormat = autoNumFormat;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                autoNumFormat.type(NumberType2.fromString(value));
                break;
            case AttributeNames.userChar:
                autoNumFormat.userChar(value);
                break;
            case AttributeNames.prefixChar:
                autoNumFormat.prefixChar(value);
                break;
            case AttributeNames.suffixChar:
                autoNumFormat.suffixChar(value);
                break;
            case AttributeNames.supscript:
                autoNumFormat.supscript(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
