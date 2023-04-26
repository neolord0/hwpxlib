package kr.dogfoot.hwpxlib.object.chart;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class ChartXMLFile extends SwitchableObject {
    private String path;
    private byte[] data;

    public ChartXMLFile() {
    }
    @Override
    public ObjectType _objectType() {
        return ObjectType.c_chartSpace;
    }

    public String path() {
        return path;
    }

    public void path(String path) {
        this.path = path;
    }

    public ChartXMLFile pathAnd(String path) {
        this.path = path;
        return this;
    }

    public byte[] data() {
        return data;
    }

    public void data(byte[] data) {
        this.data = data;
    }

    public ChartXMLFile dataAnd(byte[] data) {
        this.data = data;
        return this;
    }
}
