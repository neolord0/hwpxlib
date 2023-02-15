package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.AutoNumNewNumType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.AutoNumFormat;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.secpr.AutoNumFormatReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class AutoNumNewNumReader extends ElementReader {
    private AutoNumNewNumType autoNumNewNum;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.AutoNumNewNum;
    }

    public void autoNumNewNum(AutoNumNewNumType autoNumNewNum) {
        this.autoNumNewNum = autoNumNewNum;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.num:
                autoNumNewNum.num(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.numType:
                autoNumNewNum.numType(NumType.fromString(value));
                break;
        }
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_autoNumFormat:
                autoNumNewNum.createAutoNumFormat();
                autoNumFormat(autoNumNewNum.autoNumFormat(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_autoNumFormat:
                AutoNumFormat autoNumFormat = new AutoNumFormat();
                autoNumFormat(autoNumFormat, name, attrs);
                return autoNumFormat;
        }
        return null;
    }

    private void autoNumFormat(AutoNumFormat autoNumFormat, String name, Attributes attrs) {
        ((AutoNumFormatReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.AutoNumFormat))
                .autoNumFormat(autoNumFormat);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return autoNumNewNum;
    }
}
