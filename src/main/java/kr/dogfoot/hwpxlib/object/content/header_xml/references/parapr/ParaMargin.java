package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

/**
 * 문단 여백
 */
public class ParaMargin extends SwitchableObject {
    /**
     * 들여쓰기/내여쓰기, value > 0 이면 들여쓰기, value < 0 이면 내여쓰기
     */
    private Intent intent;
    /**
     * 왼쪽 여백
     */
    private LeftMargin left;
    /**
     * 오른쪽 여백
     */
    private RightMargin right;
    /**
     * 이전 문단과의 여백
     */
    private PrevParaMargin prev;
    /**
     * 다음 문단과의 여백
     */
    private NextParaMargin next;

    public ParaMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_margin;
    }

    public Intent intent() {
        return intent;
    }

    public void createIntent() {
        intent = new Intent();
    }

    public void removeIntent() {
        intent = null;
    }

    public LeftMargin left() {
        return left;
    }

    public void createLeft() {
        left = new LeftMargin();
    }

    public void removeLeft() {
        left = null;
    }

    public RightMargin right() {
        return right;
    }

    public void createRight() {
        right = new RightMargin();
    }

    public void removeRight() {
        right = null;
    }

    public PrevParaMargin prev() {
        return prev;
    }

    public void createPrev() {
        prev = new PrevParaMargin();
    }

    public void removePrev() {
        prev = null;
    }

    public NextParaMargin next() {
        return next;
    }

    public void createNext() {
        next = new NextParaMargin();
    }

    public void removeNext() {
        next = null;
    }
}
