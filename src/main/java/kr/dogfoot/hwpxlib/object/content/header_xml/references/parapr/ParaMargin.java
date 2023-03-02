package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;

/**
 * 문단 여백
 */
public class ParaMargin extends SwitchableObject {
    /**
     * 들여쓰기/내여쓰기, value > 0 이면 들여쓰기, value < 0 이면 내여쓰기
     */
    private ValueAndUnit intent;
    /**
     * 왼쪽 여백
     */
    private ValueAndUnit left;
    /**
     * 오른쪽 여백
     */
    private ValueAndUnit right;
    /**
     * 이전 문단과의 여백
     */
    private ValueAndUnit prev;
    /**
     * 다음 문단과의 여백
     */
    private ValueAndUnit next;

    public ParaMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_margin;
    }

    public ValueAndUnit intent() {
        return intent;
    }

    public void createIntent() {
        intent = new ValueAndUnit(ObjectType.hc_intent);
    }

    public void removeIntent() {
        intent = null;
    }

    public ValueAndUnit left() {
        return left;
    }

    public void createLeft() {
        left = new ValueAndUnit(ObjectType.hc_left);
    }

    public void removeLeft() {
        left = null;
    }

    public ValueAndUnit right() {
        return right;
    }

    public void createRight() {
        right = new ValueAndUnit(ObjectType.hc_right);
    }

    public void removeRight() {
        right = null;
    }

    public ValueAndUnit prev() {
        return prev;
    }

    public void createPrev() {
        prev = new ValueAndUnit(ObjectType.hc_prev);
    }

    public void removePrev() {
        prev = null;
    }

    public ValueAndUnit next() {
        return next;
    }

    public void createNext() {
        next = new ValueAndUnit(ObjectType.hc_next);
    }

    public void removeNext() {
        next = null;
    }
}
