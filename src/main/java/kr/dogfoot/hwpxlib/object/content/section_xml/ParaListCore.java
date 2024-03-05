package kr.dogfoot.hwpxlib.object.content.section_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;

import java.util.ArrayList;

public abstract class ParaListCore extends SwitchableObject {
    private final ArrayList<Para> paraList;

    public ParaListCore() {
        paraList = new ArrayList<Para>();
    }

    public int countOfPara() {
        return paraList.size();
    }

    public Para getPara(int index) {
        return paraList.get(index);
    }

    public int getParaIndex(Para para) {
        int count = paraList.size();
        for (int index = 0; index < count; index++) {
            if (paraList.get(index) == para) {
                return index;
            }
        }
        return -1;
    }

    public void addPara(Para para) {
        paraList.add(para);
    }

    public Para addNewPara() {
        Para para = new Para();
        paraList.add(para);
        return para;
    }

    public void insertPara(Para para, int position) {
        paraList.add(position, para);
    }

    public void removePara(int position) {
        paraList.remove(position);
    }

    public void removePara(Para para) {
        paraList.remove(para);
    }

    public void removeAllParas() {
        paraList.clear();
    }

    public Iterable<Para> paras() {
        return paraList;
    }

    protected void copyFrom(ParaListCore from) {
        for (Para para : from.paraList) {
            paraList.add(para.clone());
        }

        super.copyFrom(from);
    }
}
