package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.LineWrapMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VerticalAlign2;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class SubListReader extends ElementReader {
    private SubList subList;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.SubList;
    }

    public void subList(SubList subList) {
        this.subList = subList;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                subList.id(value);
                break;
            case AttributeNames.textDirection:
                subList.textDirection(TextDirection.fromString(value));
                break;
            case AttributeNames.lineWrap:
                subList.lineWrap(LineWrapMethod.fromString(value));
                break;
            case AttributeNames.vertAlign:
                subList.vertAlign(VerticalAlign2.fromString(value));
                break;
            case AttributeNames.linkListIDRef:
                subList.linkListIDRef(value);
                break;
            case AttributeNames.linkListNextIDRef:
                subList.linkListNextIDRef(value);
                break;
            case AttributeNames.textWidth:
                subList.textWidth(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.textHeight:
                subList.textHeight(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.hasTextRef:
                subList.hasTextRef(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hasNumRef:
                subList.hasNumRef(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_p:
                para(subList.addNewPara(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_p:
                Para para = new Para();
                para(para, name, attrs);
                return para;
        }
        return null;
    }

    private void para(Para para, String name, Attributes attrs) {
        ((ParaReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Para))
                .para(para);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return subList;
    }
}
