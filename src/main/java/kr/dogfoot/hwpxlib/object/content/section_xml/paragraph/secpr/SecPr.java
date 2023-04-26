package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.EndNotePr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.FootNotePr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PagePr;

import java.util.ArrayList;

/**
 * 섹션 정의
 */
public class SecPr extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 글자 진행방향
     */
    private TextDirection textDirection;
    /**
     * 다단 나누기 등으로 나뉜 다단 사이에 간격
     */
    private Integer spaceColumns;
    /**
     * tabStopVal * 2
     */
    private Integer tabStop;
    /**
     * 기본 탭 간격
     */
    private Integer tabStopVal;
    /**
     * 기본 탭 간격 단위
     */
    private ValueUnit1 tabStopUnit;
    /**
     * 개요 번호 모양 아이디 참조 값
     */
    private String outlineShapeIDRef;
    /**
     * 메모 모양 아이디 참조 값
     */
    private String memoShapeIDRef;
    /**
     * 머리말/꼬리말 세로 쓰기 여부
     */
    private Boolean textVerticalWidthHead;
    /**
     * 줄맞춤 정보
     */
    private Grid grid;
    /**
     * 객체들의 시작 번호
     */
    private StartNum startNum;
    /**
     * 감추기/보여주기 정보
     */
    private Visibility visibility;
    /**
     * 줄 번호 정보
     */
    private LineNumberShape lineNumberShape;
    /**
     * 용지 설정
     */
    private PagePr pagePr;
    /**
     * 각주 정보
     */
    private FootNotePr footNotePr;
    /**
     * 미주 정보
     */
    private EndNotePr endNotePr;
    /**
     * 쪽 테두리/배경 정보
     */
    private final ArrayList<PageBorderFill> pageBorderFillList;
    /**
     * 바탕쪽 정보
     */
    private final ArrayList<MasterPage> masterPageList;
    /**
     * 프레젠테이션 정보
     */
    private Presentation presentation;

    public SecPr() {
        pageBorderFillList = new ArrayList<PageBorderFill>();
        masterPageList = new ArrayList<MasterPage>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_secPr;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public SecPr idAnd(String id) {
        this.id = id;
        return this;
    }

    public TextDirection textDirection() {
        return textDirection;
    }

    public void textDirection(TextDirection textDirection) {
        this.textDirection = textDirection;
    }

    public SecPr textDirectionAnd(TextDirection textDirection) {
        this.textDirection = textDirection;
        return this;
    }

    public Integer spaceColumns() {
        return spaceColumns;
    }

    public void spaceColumns(Integer spaceColumns) {
        this.spaceColumns = spaceColumns;
    }

    public SecPr spaceColumnsAnd(Integer spaceColumns) {
        this.spaceColumns = spaceColumns;
        return this;
    }

    public Integer tabStop() {
        return tabStop;
    }

    public void tabStop(Integer tabStop) {
        this.tabStop = tabStop;
    }

    public SecPr tabStopAnd(Integer tabStop) {
        this.tabStop = tabStop;
        return this;
    }

    public Integer tabStopVal() {
        return tabStopVal;
    }

    public void tabStopVal(Integer tabStopVal) {
        this.tabStopVal = tabStopVal;
    }

    public SecPr tabStopValAnd(Integer tabStopVal) {
        this.tabStopVal = tabStopVal;
        return this;
    }

    public ValueUnit1 tabStopUnit() {
        return tabStopUnit;
    }

    public void tabStopUnit(ValueUnit1 tabStopUnit) {
        this.tabStopUnit = tabStopUnit;
    }

    public SecPr tabStopUnitAnd(ValueUnit1 tabStopUnit) {
        this.tabStopUnit = tabStopUnit;
        return this;
    }

    public String outlineShapeIDRef() {
        return outlineShapeIDRef;
    }

    public void outlineShapeIDRef(String outlineShapeIDRef) {
        this.outlineShapeIDRef = outlineShapeIDRef;
    }

    public SecPr outlineShapeIDRefAnd(String outlineShapeIDRef) {
        this.outlineShapeIDRef = outlineShapeIDRef;
        return this;
    }

    public String memoShapeIDRef() {
        return memoShapeIDRef;
    }

    public void memoShapeIDRef(String memoShapeIDRef) {
        this.memoShapeIDRef = memoShapeIDRef;
    }

    public SecPr memoShapeIDRefAnd(String memoShapeIDRef) {
        this.memoShapeIDRef = memoShapeIDRef;
        return this;
    }

    public Boolean textVerticalWidthHead() {
        return textVerticalWidthHead;
    }

    public void textVerticalWidthHead(Boolean textVerticalWidthHead) {
        this.textVerticalWidthHead = textVerticalWidthHead;
    }

    public SecPr textVerticalWidthHeadAnd(Boolean textVerticalWidthHead) {
        this.textVerticalWidthHead = textVerticalWidthHead;
        return this;
    }

    /**
     * 구역 내에서 정의된 바탕쪽 수을 반환한다.
     *
     * @return 구역 내에서 정의된 바탕쪽 수
     */
    public int masterPageCnt() {
        if (masterPageList == null) {
            return 0;
        }
        return masterPageList.size();
    }

    public Grid grid() {
        return grid;
    }

    public void createGrid() {
        grid = new Grid();
    }

    public void removeGrid() {
        grid = null;
    }

    public StartNum startNum() {
        return startNum;
    }

    public void createStartNum() {
        startNum = new StartNum();
    }

    public void removeStartNum() {
        startNum = null;
    }

    public Visibility visibility() {
        return visibility;
    }

    public void createVisibility() {
        visibility = new Visibility();
    }

    public void removeVisibility() {
        visibility = null;
    }

    public LineNumberShape lineNumberShape() {
        return lineNumberShape;
    }

    public void createLineNumberShape() {
        lineNumberShape = new LineNumberShape();
    }

    public void removeLineNumberShape() {
        lineNumberShape = null;
    }

    public PagePr pagePr() {
        return pagePr;
    }

    public void createPagePr() {
        pagePr = new PagePr();
    }

    public void removePagePr() {
        pagePr = null;
    }

    public FootNotePr footNotePr() {
        return footNotePr;
    }

    public void createFootNotePr() {
        footNotePr = new FootNotePr();
    }

    public void removeFootNotePr() {
        footNotePr = null;
    }

    public EndNotePr endNotePr() {
        return endNotePr;
    }

    public void createEndNotePr() {
        endNotePr = new EndNotePr();
    }

    public void removeEndNotePr() {
        endNotePr = null;
    }

    public int countOfPageBorderFill() {
        return pageBorderFillList.size();
    }

    public PageBorderFill getPageBorderFill(int index) {
        return pageBorderFillList.get(index);
    }

    public int getPageBorderFillIndex(PageBorderFill pageBorderFill) {
        int count = pageBorderFillList.size();
        for (int index = 0; index < count; index++) {
            if (pageBorderFillList.get(index) == pageBorderFill) {
                return index;
            }
        }
        return -1;
    }

    public void addPageBorderFill(PageBorderFill pageBorderFill) {
        pageBorderFillList.add(pageBorderFill);
    }

    public PageBorderFill addNewPageBorderFill() {
        PageBorderFill pageBorderFill = new PageBorderFill();
        pageBorderFillList.add(pageBorderFill);
        return pageBorderFill;
    }

    public void insertPageBorderFill(PageBorderFill pageBorderFill, int position) {
        pageBorderFillList.add(position, pageBorderFill);
    }

    public void removePageBorderFill(int position) {
        pageBorderFillList.remove(position);
    }

    public Iterable<PageBorderFill> pageBorderFills() {
        return pageBorderFillList;
    }

    public int countOfMasterPage() {
        return masterPageList.size();
    }

    public MasterPage getMasterPage(int index) {
        return masterPageList.get(index);
    }

    public int getMasterPageIndex(MasterPage masterPage) {
        int count = masterPageList.size();
        for (int index = 0; index < count; index++) {
            if (masterPageList.get(index) == masterPage) {
                return index;
            }
        }
        return -1;
   }

    public void addMasterPage(MasterPage masterPage) {
        masterPageList.add(masterPage);
    }

    public MasterPage addNewMasterPage() {
        MasterPage masterPage = new MasterPage();
        masterPageList.add(masterPage);
        return masterPage;
    }

    public void insertMasterPage(MasterPage masterPage, int position) {
        masterPageList.add(position, masterPage);
    }

    public void removeMasterPage(int position) {
        masterPageList.remove(position);
    }

    public Iterable<MasterPage> masterPages() {
        return masterPageList;
    }

    public Presentation presentation() {
        return presentation;
    }

    public void createPresentation() {
        presentation = new Presentation();
    }

    public void removePresentation() {
        presentation = null;
    }
}
