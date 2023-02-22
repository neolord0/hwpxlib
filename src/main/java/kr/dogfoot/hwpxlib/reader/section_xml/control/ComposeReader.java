package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ComposeCircleType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ComposeType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Compose;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose.ComposeCharPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.etc.ComposeCharPrReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class ComposeReader extends ElementReader {
    private Compose compose;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Compose;
    }

    public void compose(Compose compose) {
        this.compose = compose;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.circleType:
                compose.circleType(ComposeCircleType.fromString(value));
                break;
            case AttributeNames.charSz:
                compose.charSz(ValueConvertor.toShort(value));
                break;
            case AttributeNames.composeType:
                compose.composeType(ComposeType.fromString(value));
                break;
            case AttributeNames.composeText:
                compose.composeText(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_charPr:
                charPr(compose.addNewCharPr(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_seg:
                ComposeCharPr charPr = new ComposeCharPr();
                charPr(charPr, name, attrs);
                return charPr;
        }

        return null;
    }

    private void charPr(ComposeCharPr charPr, String name, Attributes attrs) {
        ((ComposeCharPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ComposeCharPr))
                .charPr(charPr);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return compose;
    }
}
