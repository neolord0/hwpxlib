package kr.dogfoot.hwpxlib.object.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

import java.util.ArrayList;

public abstract class InSwitchObject extends HWPXObject {
    private final ArrayList<HWPXObject> childList;

    protected InSwitchObject() {
        childList = new ArrayList<HWPXObject>();
    }

    public int countOfChild() {
        return childList.size();
    }

    public HWPXObject getChild(int index) {
        return childList.get(index);
    }

    public void addChild(HWPXObject child) {
        childList.add(child);
    }

    public void insertChild(HWPXObject child, int position) {
        childList.add(position, child);
    }

    public void removeChild(int position) {
        childList.remove(position);
    }

    public void removeChild(HWPXObject child) {
        childList.remove(child);
    }

    public void removeAllChildren() {
        childList.clear();
    }

    public Iterable<HWPXObject> children() {
        return childList;
    }



    protected void copyForm(InSwitchObject from) {
        for (HWPXObject child : from.childList) {
            addChild(child.clone());
        }
    }
}

