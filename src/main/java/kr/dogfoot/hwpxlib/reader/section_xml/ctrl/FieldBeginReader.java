package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColumnDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FieldType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.MultiColumnType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.Parameters;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.parameter.ParameterListReader;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
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
            case ElementNames.Parameters:
                fieldBegin.createParameters();
                parameters(fieldBegin.parameters(), name, attrs);
                break;
            case ElementNames.SubList:
                fieldBegin.createSubList();
                subList(fieldBegin.subList(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.Parameters) {
            parameters((Parameters) child, name, attrs);
        } else if (child.objectType() == ObjectType.SubList) {
            subList((SubList) child, name, attrs);
        }
    }

    private void parameters(Parameters parameters, String name, Attributes attrs) {
        ((ParameterListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParameterList))
                .parameterList(parameters);

        xmlFileReader().startElement(name, attrs);
    }

    private void subList(SubList subList, String name, Attributes attrs) {
        ((SubListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.SubList))
                .subList(subList);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return fieldBegin;
    }
}