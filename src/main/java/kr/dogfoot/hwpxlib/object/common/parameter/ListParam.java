package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

import java.util.ArrayList;

public class ListParam extends Param<ListParam> {
    private final ArrayList<Param> parameterList;

    public ListParam() {
        parameterList = new ArrayList<Param>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_ListParam;
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
