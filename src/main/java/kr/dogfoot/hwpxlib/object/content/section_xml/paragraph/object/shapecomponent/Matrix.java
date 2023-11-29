package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Matrix extends HWPXObject {
    private ObjectType _objectType;
    private Float e1;
    private Float e2;
    private Float e3;
    private Float e4;
    private Float e5;
    private Float e6;

    public Matrix(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Float e1() {
        return e1;
    }

    public void e1(Float e1) {
        this.e1 = e1;
    }

    public Matrix e1And(Float e1) {
        this.e1 = e1;
        return this;
    }

    public Float e2() {
        return e2;
    }

    public void e2(Float e2) {
        this.e2 = e2;
    }

    public Matrix e2And(Float e2) {
        this.e2 = e2;
        return this;
    }

    public Float e3() {
        return e3;
    }

    public void e3(Float e3) {
        this.e3 = e3;
    }

    public Matrix e3And(Float e3) {
        this.e3 = e3;
        return this;
    }

    public Float e4() {
        return e4;
    }

    public void e4(Float e4) {
        this.e4 = e4;
    }

    public Matrix e4And(Float e4) {
        this.e4 = e4;
        return this;
    }

    public Float e5() {
        return e5;
    }

    public void e5(Float e5) {
        this.e5 = e5;
    }

    public Matrix e5And(Float e5) {
        this.e5 = e5;
        return this;
    }

    public Float e6() {
        return e6;
    }

    public void e6(Float e6) {
        this.e6 = e6;
    }

    public Matrix e6And(Float e6) {
        this.e6 = e6;
        return this;
    }

    @Override
    public Matrix clone() {
        Matrix cloned = new Matrix(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Matrix from) {
        this.e1 = from.e1;
        this.e2 = from.e2;
        this.e3 = from.e3;
        this.e4 = from.e4;
        this.e5 = from.e5;
        this.e6 = from.e6;
    }
}
