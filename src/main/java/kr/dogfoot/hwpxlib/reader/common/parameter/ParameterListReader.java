package kr.dogfoot.hwpxlib.reader.common.parameter;

import com.sun.org.apache.xpath.internal.operations.Bool;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.parameter.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.Parameters;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.ctrl.ColSzReader;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ParameterListReader extends ElementReader {
    private ParameterListCore parameterList;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ParameterList;
    }

    public void parameterList(ParameterListCore parameterList) {
        this.parameterList  = parameterList;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                parameterList.name(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.IntegerParam:
                integerParam(parameterList.addNewIntegerParam(), name, attrs);
                break;
            case ElementNames.StringParam:
                stringParam(parameterList.addNewStringParam(), name, attrs);
                break;
            case ElementNames.BooleanParam:
                booleanParam(parameterList.addNewBooleanParam(), name, attrs);
                break;
            case ElementNames.FloatParam:
                floatParam(parameterList.addNewFloatParam(), name, attrs);
                break;
            case ElementNames.ListParam:
                listParam(parameterList.addNewListParam(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.IntegerParam) {
            integerParam((IntegerParam) child, name, attrs);
        } else if (child.objectType() == ObjectType.StringParam) {
            stringParam((StringParam) child, name, attrs);
        } else if (child.objectType() == ObjectType.BooleanParam) {
            booleanParam((BooleanParam) child, name, attrs);
        } else if (child.objectType() == ObjectType.FloatParam) {
            floatParam((FloatParam) child, name, attrs);
        } else if (child.objectType() == ObjectType.ListParam) {
            listParam((ListParam) child, name, attrs);
        }
    }

    private void integerParam(IntegerParam integerParam, String name, Attributes attrs) {
        ((IntegerParamReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.IntegerParam))
                .integerParam(integerParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void stringParam(StringParam stringParam, String name, Attributes attrs) {
        ((StringParamReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.StringParam))
                .stringParam(stringParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void booleanParam(BooleanParam booleanParam, String name, Attributes attrs) {
        ((BooleanParamReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.BooleanParam))
                .booleanParam(booleanParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void floatParam(FloatParam floatParam, String name, Attributes attrs) {
        ((FloatParamReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FloatParam))
                .floatParam(floatParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void listParam(ListParam listParam, String name, Attributes attrs) {
        ((ListParamReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ListParam))
                .listParam(listParam);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return parameterList;
    }
}
