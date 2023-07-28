package kr.dogfoot.hwpxlib.object.common;

import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;

import java.util.ArrayList;

public abstract class SwitchableObject extends HWPXObject {
    private ArrayList<Switch> switchList;

    public ArrayList<Switch> switchList() {
        return switchList;
    }

    public void removeSwitchList() {
        switchList = null;
    }

    public Switch addNewSwitch() {
        if (switchList == null) {
            switchList = new ArrayList<Switch>();
        }
        Switch newSwitch = new Switch();
        switchList.add(newSwitch);
        return newSwitch;
    }
}
