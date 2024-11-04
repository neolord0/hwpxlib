package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FieldType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.Parameters;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.HasOnlyTextReader;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class FieldBeginReader extends ElementReader {
    private FieldBegin fieldBegin;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FieldBegin;
    }

    public void fieldBegin(FieldBegin fieldBegin) {
        this.fieldBegin = fieldBegin;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                fieldBegin.id(value);
                break;
            case AttributeNames.type:
                fieldBegin.type(FieldType.fromString(value));
                break;
            case AttributeNames.name:
                fieldBegin.name(value);
                break;
            case AttributeNames.editable:
                fieldBegin.editable(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.dirty:
                fieldBegin.dirty(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.zorder:
                fieldBegin.zorder(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.fieldid:
                fieldBegin.fieldid(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_parameters:
                fieldBegin.createParameters();
                parameterList(fieldBegin.parameters(), name, attrs);
                break;
            case ElementNames.hp_subList:
                fieldBegin.createSubList();
                subList(fieldBegin.subList(), name, attrs);
                break;
                case ElementNames.hp_metaTag:
                fieldBegin.createMetaTag();
                metaTag(fieldBegin.metaTag(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_parameters:
                Parameters parameters = new Parameters();
                parameterList(parameters, name, attrs);
                return parameters;
            case ElementNames.hp_subList:
                SubList subList = new SubList();
                subList(subList, name, attrs);
                return subList;
            case ElementNames.hp_metaTag:
                HasOnlyText metaTag = new HasOnlyText(ObjectType.hp_metaTag);
                metaTag(metaTag, name, attrs);
                return metaTag;
        }
        return null;
    }

    private void subList(SubList subList, String name, Attributes attrs) {
        ((SubListReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.SubList))
                .subList(subList);

        xmlFileReader().startElement(name, attrs);
    }

    private void metaTag(HasOnlyText hasOnlyText, String name, Attributes attrs) {
        ((HasOnlyTextReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.HasOnlyText))
                .hasOnlyText(hasOnlyText);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return fieldBegin;
    }
}
