package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;

import java.util.ArrayList;

/**
 * 번호 문단 모양
 */
public class Numbering extends SwitchableObject {
    /**
     * 이이디
     */
    private String id;
    /**
     * 문단 시작 번호
     */
    private Integer start;
    /**
     * 수준별 문단 머리 모양
     */
    private final ArrayList<ParaHead> paraHeadList;

    public Numbering() {
        paraHeadList = new ArrayList<ParaHead>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_numbering;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public Numbering idAnd(String id) {
        this.id = id;
        return this;
    }

    public Integer start() {
        return start;
    }

    public void start(Integer start) {
        this.start = start;
    }

    public Numbering startAnd(Integer start) {
        this.start = start;
        return this;
    }

    public int countOfParaHead() {
        return paraHeadList.size();
    }

    public ParaHead getParaHead(int index) {
        return paraHeadList.get(index);
    }

    public int getParaHeadIndex(ParaHead paraHead) {
        int count = paraHeadList.size();
        for (int index = 0; index < count; index++) {
            if (paraHeadList.get(index) == paraHead) {
                return index;
            }
        }
        return -1;
   }

    public void addParaHead(ParaHead paraHead) {
        paraHeadList.add(paraHead);
    }

    public ParaHead addNewParaHead() {
        ParaHead paraHead = new ParaHead();
        paraHeadList.add(paraHead);
        return paraHead;
    }

    public void insertParaHead(ParaHead paraHead, int position) {
        paraHeadList.add(position, paraHead);
    }

    public void removeParaHead(int position) {
        paraHeadList.remove(position);
    }

    public Iterable<ParaHead> paraHeads() {
        return paraHeadList;
    }
}
