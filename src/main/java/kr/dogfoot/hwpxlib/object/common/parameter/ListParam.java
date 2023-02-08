package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.ForbiddenWord;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Slash;

import java.util.ArrayList;

public class ListParam extends Param<ListParam> {
    private final ArrayList<Param> parameterList;

    public ListParam() {
        parameterList = new ArrayList<Param>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ListParam;
    }


    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.BooleanParam.equalElementName(name)) {
            return new BooleanParam();
        } else if (ObjectType.IntegerParam.equalElementName(name)) {
            return new IntegerParam();
        } else if (ObjectType.FloatParam.equalElementName(name)) {
            return new FloatParam();
        } else if (ObjectType.StringParam.equalElementName(name)) {
            return new StringParam();
        } else if (ObjectType.ListParam.equalElementName(name)) {
            return new ListParam();
        }
        return null;
    }

    public int cnt() {
        return countOfParam();
    }

    public int countOfParam() {
        return parameterList.size();
    }

    public Param getParam(int index) {
        return parameterList.get(index);
    }

    public void addParam(Param parameter) {
        parameterList.add(parameter);
    }

    public BooleanParam addNewBooleanParam() {
        BooleanParam parameter = new BooleanParam();
        parameterList.add(parameter);
        return parameter;
    }

    public IntegerParam addNewIntegerParam() {
        IntegerParam parameter = new IntegerParam();
        parameterList.add(parameter);
        return parameter;
    }
    public FloatParam addNewFloatParam() {
        FloatParam parameter = new FloatParam();
        parameterList.add(parameter);
        return parameter;
    }

    public StringParam addNewStringParam() {
        StringParam parameter = new StringParam();
        parameterList.add(parameter);
        return parameter;
    }

    public ListParam addNewListParam() {
        ListParam parameter = new ListParam();
        parameterList.add(parameter);
        return parameter;
    }

    public void insertParam(Param parameter, int position) {
        parameterList.add(position, parameter);
    }

    public void removeParam(int position) {
        parameterList.remove(position);
    }

    public Iterable<Param> params() {
        return parameterList;
    }
}
