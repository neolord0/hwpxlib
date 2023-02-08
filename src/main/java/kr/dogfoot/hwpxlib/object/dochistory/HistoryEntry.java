package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class HistoryEntry extends SwitchableObject {
    /**
     * 리비전 번호
     */
    private Integer revisionNumber;
    /**
     * 리비전 날짜
     */
    private String revisionDate;
    /**
     * 리비전 저자
     */
    private String revisionAuthor;
    /**
     * 리비전 설명
     */
    private String revisionDesc;
    /**
     * 잠금 여부
     */
    private Boolean revisionLock;
    /**
     * 자동 저장 여부
     */
    private Boolean autoSave;
    /**
     * 패키지의 변경 이력 정보
     */
    private PackageDiff packageDiff;
    /**
     * 헤더의 변경 이력 정보
     */
    private HeadDiff headDiff;
    /**
     * 본문의 변경 이력 정보
     */
    private BodyDiff bodyDiff;

    public HistoryEntry() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.HistoryEntry;
    }

    public Integer revisionNumber() {
        return revisionNumber;
    }

    public void revisionNumber(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public HistoryEntry revisionNumberAnd(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
        return this;
    }

    public String revisionDate() {
        return revisionDate;
    }

    public void revisionDate(String revisionDate) {
        this.revisionDate = revisionDate;
    }

    public HistoryEntry revisionDateAnd(String revisionDate) {
        this.revisionDate = revisionDate;
        return this;
    }

    public String revisionAuthor() {
        return revisionAuthor;
    }

    public void revisionAuthor(String revisionAuthor) {
        this.revisionAuthor = revisionAuthor;
    }

    public HistoryEntry revisionAuthorAnd(String revisionAuthor) {
        this.revisionAuthor = revisionAuthor;
        return this;
    }

    public String revisionDesc() {
        return revisionDesc;
    }

    public void revisionDesc(String revisionDesc) {
        this.revisionDesc = revisionDesc;
    }

    public HistoryEntry revisionDescAnd(String revisionDesc) {
        this.revisionDesc = revisionDesc;
        return this;
    }

    public Boolean revisionLock() {
        return revisionLock;
    }

    public void revisionLock(Boolean revisionLock) {
        this.revisionLock = revisionLock;
    }

    public HistoryEntry revisionLockAnd(Boolean revisionLock) {
        this.revisionLock = revisionLock;
        return this;
    }

    public Boolean autoSave() {
        return autoSave;
    }

    public void autoSave(Boolean autoSave) {
        this.autoSave = autoSave;
    }

    public HistoryEntry autoSaveAnd(Boolean autoSave) {
        this.autoSave = autoSave;
        return this;
    }

    public PackageDiff packageDiff() {
        return packageDiff;
    }

    public void createPackageDiff() {
        packageDiff = new PackageDiff();
    }

    public void removePackageDiff() {
        packageDiff = null;
    }

    public HeadDiff headDiff() {
        return headDiff;
    }

    public void createHeadDiff() {
        headDiff = new HeadDiff();
    }

    public void removeHeadDiff() {
        headDiff = null;
    }

    public BodyDiff bodyDiff() {
        return bodyDiff;
    }

    public void createBodyDiff() {
        bodyDiff = new BodyDiff();
    }

    public void removeBodyDiff() {
        bodyDiff = null;
    }
}
