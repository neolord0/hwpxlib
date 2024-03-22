package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

public class Tr extends SwitchableObject {
    private final ArrayList<Tc> tcList;

    public Tr() {
        tcList = new ArrayList<Tc>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tr;
    }

    public int countOfTc() {
        return tcList.size();
    }

    public Tc getTc(int index) {
        return tcList.get(index);
    }

    public int getTcIndex(Tc tc) {
        int count = tcList.size();
        for (int index = 0; index < count; index++) {
            if (tcList.get(index) == tc) {
                return index;
            }
        }
        return -1;
    }

    public void addTc(Tc tc) {
        tcList.add(tc);
    }

    public Tc addNewTc() {
        Tc tc = new Tc();
        tcList.add(tc);
        return tc;
    }

    public void insertTc(Tc tc, int position) {
        tcList.add(position, tc);
    }

    public void removeTc(int position) {
        tcList.remove(position);
    }

    public void removeTc(Tc tc) {
        tcList.remove(tc);
    }

    public void removeAllTcs() {
        tcList.clear();
    }

    public Iterable<Tc> tcs() {
        return tcList;
    }

    @Override
    public Tr clone() {
        Tr cloned = new Tr();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Tr from) {
        for (Tc tc : from.tcList) {
            tcList.add(tc.clone());
        }

        super.copyFrom(from);
    }
}
