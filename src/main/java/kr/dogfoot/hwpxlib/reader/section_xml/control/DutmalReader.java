package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DutmalPosType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Dutmal;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class DutmalReader extends ElementReader {
    private Dutmal dutmal;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Dutmal;
    }

    public void dutmal(Dutmal dutmal) {
        this.dutmal = dutmal;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.posType:
                dutmal.posType(DutmalPosType.fromString(value));
                break;
            case AttributeNames.szRatio:
                dutmal.szRatio(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.option:
                dutmal.option(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.styleIDRef:
                dutmal.styleIDRef(value);
                break;
            case AttributeNames.align:
                dutmal.align(HorizontalAlign2.fromString(value));
                break;
        }
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_mainText:
                dutmal.createMainText();
                hasOnlyText(dutmal.mainText(), name, attrs);
                break;
            case ElementNames.hp_subText:
                dutmal.createSubText();
                hasOnlyText(dutmal.subText(), name, attrs);
                break;
        }
    }


    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_mainText:
                HasOnlyText mainText = new HasOnlyText(ObjectType.hp_mainText);
                hasOnlyText(mainText, name, attrs);
                return mainText;
            case ElementNames.hp_subText:
                HasOnlyText subText = new HasOnlyText(ObjectType.hp_subText);
                hasOnlyText(subText, name, attrs);
                return subText;
        }

        return null;
    }

    @Override
    public SwitchableObject switchableObject() {
        return dutmal;
    }
}
