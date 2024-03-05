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
        return ObjectType.hp_listParam;
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

    public int getParamIndex(Param parameter) {
        int count = parameterList.size();
        for (int index = 0; index < count; index++) {
            if (parameterList.get(index) == parameter) {
                return index;
            }
        }
        return -1;
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

    public UnsignedIntegerParam addNewUnsignedIntegerParam() {
        UnsignedIntegerParam parameter = new UnsignedIntegerParam();
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

    public void removeParam(Param parameter) {
        parameterList.remove(parameter);
    }

    public Iterable<Param> params() {
        return parameterList;
    }

    @Override
    public ListParam clone() {
        ListParam cloned = new ListParam();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ListParam from) {
        for (Param param : from.parameterList) {
            parameterList.add((Param) param.clone());
        }

        super.copyFrom(from);
    }
}
