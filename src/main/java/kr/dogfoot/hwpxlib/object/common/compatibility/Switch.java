package kr.dogfoot.hwpxlib.object.common.compatibility;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

import java.util.ArrayList;

public class Switch extends HWPXObject {
    private final ArrayList<Case> caseObjectList;
    private Default defaultObject;

    /**
     * XML 형제 노드 사이에서 위치
     * -1 : 이면 마지막에 위치한다.
     */
    private int position;

    public Switch() {
        caseObjectList = new ArrayList<Case>();
        position = -1;
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_switch;
    }


    public int countOfCaseObject() {
        return caseObjectList.size();
    }

    public Case getCaseObject(int index) {
        return caseObjectList.get(index);
    }

    public void addCaseObject(Case caseObject) {
        caseObjectList.add(caseObject);
    }

    public Case addNewCaseObject() {
        Case caseObject = new Case();
        caseObjectList.add(caseObject);
        return caseObject;
    }

    public void insertCaseObject(Case caseObject, int position) {
        caseObjectList.add(position, caseObject);
    }

    public void removeCaseObject(int position) {
        caseObjectList.remove(position);
    }

    public Iterable<Case> caseObjects() {
        return caseObjectList;
    }

    public Default defaultObject() {
        return defaultObject;
    }

    public void createDefaultObject() {
        defaultObject = new Default();
    }

    public void removeDefaultObject() {
        defaultObject = null;
    }

    public int position() {
        return position;
    }

    public void position(int position) {
        this.position = position;
    }
}

