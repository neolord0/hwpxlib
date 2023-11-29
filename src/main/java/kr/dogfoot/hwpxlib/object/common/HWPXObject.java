package kr.dogfoot.hwpxlib.object.common;

public abstract class HWPXObject {
    public abstract ObjectType _objectType();
    public abstract HWPXObject clone();
}
