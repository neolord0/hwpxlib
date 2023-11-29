package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

/**
 * 문단
 */
public class Para extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 문단모양 아이디 참조값
     */
    private String paraPrIDRef;
    /**
     * 스타일 아이디 참조값
     */
    private String styleIDRef;
    /**
     * 쪽 나눔 여부
     */
    private Boolean pageBreak;
    /**
     * 단 나눔 여부
     */
    private Boolean columnBreak;
    /**
     * 병합된 문단인지 여부
     */
    private Boolean merged;
    /**
     * 문단 번호 변경 추적 아이디
     */
    private String paraTcId;
    /**
     * char-run 리스트
     */
    private final ArrayList<Run> runList;
    private ObjectList<LineSeg> lineSegArray;

    public Para() {
        runList = new ArrayList<Run>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_p;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public Para idAnd(String id) {
        this.id = id;
        return this;
    }

    public String paraPrIDRef() {
        return paraPrIDRef;
    }

    public void paraPrIDRef(String paraPrIDRef) {
        this.paraPrIDRef = paraPrIDRef;
    }

    public Para paraPrIDRefAnd(String paraPrIDRef) {
        this.paraPrIDRef = paraPrIDRef;
        return this;
    }

    public String styleIDRef() {
        return styleIDRef;
    }

    public void styleIDRef(String styleIDRef) {
        this.styleIDRef = styleIDRef;
    }

    public Para styleIDRefAnd(String styleIDRef) {
        this.styleIDRef = styleIDRef;
        return this;
    }

    public Boolean pageBreak() {
        return pageBreak;
    }

    public void pageBreak(Boolean pageBreak) {
        this.pageBreak = pageBreak;
    }

    public Para pageBreakAnd(Boolean pageBreak) {
        this.pageBreak = pageBreak;
        return this;
    }

    public Boolean columnBreak() {
        return columnBreak;
    }

    public void columnBreak(Boolean columnBreak) {
        this.columnBreak = columnBreak;
    }

    public Para columnBreakAnd(Boolean columnBreak) {
        this.columnBreak = columnBreak;
        return this;
    }

    public Boolean merged() {
        return merged;
    }

    public void merged(Boolean merged) {
        this.merged = merged;
    }

    public Para mergedAnd(Boolean merged) {
        this.merged = merged;
        return this;
    }

    public String paraTcId() {
        return paraTcId;
    }

    public void paraTcId(String paraTcId) {
        this.paraTcId = paraTcId;
    }

    public Para paraTcIdAnd(String paraTcId) {
        this.paraTcId = paraTcId;
        return this;
    }

    public int countOfRun() {
        return runList.size();
    }

    public Run getRun(int index) {
        return runList.get(index);
    }

    public int getRunIndex(Run run) {
        int count = runList.size();
        for (int index = 0; index < count; index++) {
            if (runList.get(index) == run) {
                return index;
            }
        }
        return -1;
    }

    public void addRun(Run run) {
        runList.add(run);
    }

    public Run addNewRun() {
        Run run = new Run();
        runList.add(run);
        return run;
    }

    public void insertRun(Run run, int position) {
        runList.add(position, run);
    }

    public void removeRun(int position) {
        runList.remove(position);
    }

    public Iterable<Run> runs() {
        return runList;
    }

    public ObjectList<LineSeg> lineSegArray() {
        return lineSegArray;
    }

    public void createLineSegArray() {
        lineSegArray = new ObjectList<LineSeg>(ObjectType.hp_linesegarray, LineSeg.class);
    }

    public void removeLineSegArray() {
        lineSegArray = null;
    }

    @Override
    public Para clone() {
        Para cloned = new Para();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Para from) {
        this.id = from.id;
        this.paraPrIDRef = from.paraPrIDRef;
        this.styleIDRef = from.styleIDRef;
        this.pageBreak = from.pageBreak;
        this.columnBreak = from.columnBreak;
        this.merged = from.merged;
        this.paraTcId = from.paraTcId;

        for (Run run : from.runList) {
            runList.add(run.clone());
        }

        if (from.lineSegArray != null) {
            createLineSegArray();;
            for (LineSeg lineSeg : from.lineSegArray.items()) {
                lineSegArray.add(lineSeg.clone());
            }
        } else {
            removeLineSegArray();
        }

        super.copyFrom(from);
    }

}
