package kr.dogfoot.hwpxlib.object.common;

import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;

public abstract class SwitchableObject extends HWPXObject {
    private Switch switchObject;

    public Switch switchObject() {
        return switchObject;
    }

    public void createSwitchObject() {
        switchObject = new Switch();
    }

    public void removeSwitchObject() {
        switchObject = null;
    }

    public abstract HWPXObject createChildWithElementName(String name);
}
