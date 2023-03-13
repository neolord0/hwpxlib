package kr.dogfoot.hwpxlib.reader.common.parameter;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.parameter.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
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
            case ElementNames.hp_integerParam:
                integerParam(parameterList.addNewIntegerParam(), name, attrs);
                break;
            case ElementNames.hp_stringParam:
                stringParam(parameterList.addNewStringParam(), name, attrs);
                break;
            case ElementNames.hp_booleanParam:
                booleanParam(parameterList.addNewBooleanParam(), name, attrs);
                break;
            case ElementNames.hp_floatParam:
                floatParam(parameterList.addNewFloatParam(), name, attrs);
                break;
            case ElementNames.hp_listParam:
                listParam(parameterList.addNewListParam(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_integerParam:
                IntegerParam integerParam = new IntegerParam();
                integerParam(integerParam, name, attrs);
                return integerParam;
            case ElementNames.hp_stringParam:
                StringParam stringParam = new StringParam();
                stringParam(stringParam, name, attrs);
                return stringParam;
            case ElementNames.hp_booleanParam:
                BooleanParam booleanParam = new BooleanParam();
                booleanParam(booleanParam, name, attrs);
                return booleanParam;
            case ElementNames.hp_floatParam:
                FloatParam floatParam = new FloatParam();
                floatParam(floatParam, name, attrs);
                return floatParam;
            case ElementNames.hp_listParam:
                ListParam listParam = new ListParam();
                listParam(listParam, name, attrs);
                return listParam;
        }
        return null;
    }

    private void integerParam(IntegerParam integerParam, String name, Attributes attrs) {
        ((IntegerParamReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.IntegerParam))
                .integerParam(integerParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void stringParam(StringParam stringParam, String name, Attributes attrs) {
        ((StringParamReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.StringParam))
                .stringParam(stringParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void booleanParam(BooleanParam booleanParam, String name, Attributes attrs) {
        ((BooleanParamReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.BooleanParam))
                .booleanParam(booleanParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void floatParam(FloatParam floatParam, String name, Attributes attrs) {
        ((FloatParamReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.FloatParam))
                .floatParam(floatParam);

        xmlFileReader().startElement(name, attrs);
    }

    private void listParam(ListParam listParam, String name, Attributes attrs) {
        ((ListParamReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ListParam))
                .listParam(listParam);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return parameterList;
    }
}
