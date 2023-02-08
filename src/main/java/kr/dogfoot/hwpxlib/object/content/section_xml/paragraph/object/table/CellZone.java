package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 셀 테두리/배경 - "하나의 셀처럼 적용"시 사용
 */
public class CellZone extends HWPXObject {
    /**
     * 셀 영역의 시작 행 주소
     */
    private Short startRowAddr;
    /**
     * 셀 영역의 시작 열 주소
     */
    private Short startColAddr;
    /**
     * 셀 영역의 끝 행 주소
     */
    private Short endRowAddr;
    /**
     * 셀 영역의 끝 열 주소
     */
    private Short endColAddr;
    /**
     * 테두리/배경 아이디 참조
     */
    private String borderFillIDRef;

    public CellZone() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CellZone;
    }

    public Short startRowAddr() {
        return startRowAddr;
    }

    public void startRowAddr(Short startRowAddr) {
        this.startRowAddr = startRowAddr;
    }

    public CellZone startRowAddrAnd(Short startRowAddr) {
        this.startRowAddr = startRowAddr;
        return this;
    }

    public Short startColAddr() {
        return startColAddr;
    }

    public void startColAddr(Short startColAddr) {
        this.startColAddr = startColAddr;
    }

    public CellZone startColAddrAnd(Short startColAddr) {
        this.startColAddr = startColAddr;
        return this;
    }

    public Short endRowAddr() {
        return endRowAddr;
    }

    public void endRowAddr(Short endRowAddr) {
        this.endRowAddr = endRowAddr;
    }

    public CellZone endRowAddrAnd(Short endRowAddr) {
        this.endRowAddr = endRowAddr;
        return this;
    }

    public Short endColAddr() {
        return endColAddr;
    }

    public void endColAddr(Short endColAddr) {
        this.endColAddr = endColAddr;
    }

    public CellZone endColAddrAnd(Short endColAddr) {
        this.endColAddr = endColAddr;
        return this;
    }

    public String borderFillIDRef() {
        return borderFillIDRef;
    }

    public void borderFillIDRef(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
    }

    public CellZone borderFillIDRefAnd(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
        return this;
    }
}
