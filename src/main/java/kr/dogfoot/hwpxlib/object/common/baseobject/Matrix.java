package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class Matrix<ChildType> extends HWPXObject {
    private Float e1;
    private Float e2;
    private Float e3;
    private Float e4;
    private Float e5;
    private Float e6;

    public Float e1() {
        return e1;
    }

    public void e1(Float e1) {
        this.e1 = e1;
    }

    public ChildType e1And(Float e1) {
        this.e1 = e1;
        return (ChildType) this;
    }

    public Float e2() {
        return e2;
    }

    public void e2(Float e2) {
        this.e2 = e2;
    }

    public ChildType e2And(Float e2) {
        this.e2 = e2;
        return (ChildType) this;
    }

    public Float e3() {
        return e3;
    }

    public void e3(Float e3) {
        this.e3 = e3;
    }

    public ChildType e3And(Float e3) {
        this.e3 = e3;
        return (ChildType) this;
    }

    public Float e4() {
        return e4;
    }

    public void e4(Float e4) {
        this.e4 = e4;
    }

    public ChildType e4And(Float e4) {
        this.e4 = e4;
        return (ChildType) this;
    }

    public Float e5() {
        return e5;
    }

    public void e5(Float e5) {
        this.e5 = e5;
    }

    public ChildType e5And(Float e5) {
        this.e5 = e5;
        return (ChildType) this;
    }

    public Float e6() {
        return e6;
    }

    public void e6(Float e6) {
        this.e6 = e6;
    }

    public ChildType e6And(Float e6) {
        this.e6 = e6;
        return (ChildType) this;
    }
}
