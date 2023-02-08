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
    public ObjectType objectType() {
        return ObjectType.Tr;
    }

    public int countOfTc() {
        return tcList.size();
    }

    public Tc getTc(int index) {
        return tcList.get(index);
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

    public Iterable<Tc> tcs() {
        return tcList;
    }
}
