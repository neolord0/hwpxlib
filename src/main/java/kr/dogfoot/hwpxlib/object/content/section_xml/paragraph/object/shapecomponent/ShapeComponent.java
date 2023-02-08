package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.OLE;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;

/**
 * Shape Component
 */
public abstract class ShapeComponent<ChildType> extends ShapeObject<ChildType> {
    /**
     * 하이퍼링크 속성
     */
    private String href;
    /**
     * 그릅핑 횟수
     */
    private Short groupLevel;
    /**
     * 개체 아이디
     */
    private Integer instid;
    /**
     * 그룹 개체 안에 개별 개체의 위치
     */
    private Offset offset;
    /**
     * 생성시 크기
     */
    private OriginalSize orgSz;
    /**
     * 현재 크기
     */
    private CurrentSize curSz;
    /**
     * 뒤집힌 상태
     */
    private Flip flip;
    /**
     * 회전 정보
     */
    private RotationInfo rotationInfo;
    /**
     * 변환 정보
     */
    private RenderingInfo renderingInfo;

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Offset.equalElementName(name)) {
            return new Offset();
        } else if (ObjectType.OrgSz.equalElementName(name)){
            return new OriginalSize();
        } else if (ObjectType.CurSz.equalElementName(name)) {
            return new CurrentSize();
        } else if (ObjectType.Flip.equalElementName(name)) {
            return new Flip();
        } else if (ObjectType.RotationInfo.equalElementName(name)) {
            return new RotationInfo();
        } else if (ObjectType.RenderingInfo.equalElementName(name)) {
            return new RenderingInfo();
        }
        return super.createChildWithElementName(name);
    }

    public String href() {
        return href;
    }

    public void href(String href) {
        this.href = href;
    }

    public ShapeComponent hrefAnd(String href) {
        this.href = href;
        return this;
    }

    public Short groupLevel() {
        return groupLevel;
    }

    public void groupLevel(Short groupLevel) {
        this.groupLevel = groupLevel;
    }

    public ShapeComponent groupLevelAnd(Short groupLevel) {
        this.groupLevel = groupLevel;
        return this;
    }

    public Integer instid() {
        return instid;
    }

    public void instid(Integer instid) {
        this.instid = instid;
    }

    public ShapeComponent instidAnd(Integer instid) {
        this.instid = instid;
        return this;
    }

    public Offset offset() {
        return offset;
    }

    public void createOffset() {
        offset = new Offset();
    }

    public void removeOffset() {
        offset = null;
    }

    public OriginalSize orgSz() {
        return orgSz;
    }

    public void createOrgSz() {
        orgSz = new OriginalSize();
    }

    public void removeOrgSz() {
        orgSz = null;
    }

    public CurrentSize curSz() {
        return curSz;
    }

    public void createCurSz() {
        curSz = new CurrentSize();
    }

    public void removeCurSz() {
        curSz = null;
    }

    public Flip flip() {
        return flip;
    }

    public void createFlip() {
        flip = new Flip();
    }

    public void removeFlip() {
        flip = null;
    }

    public RotationInfo rotationInfo() {
        return rotationInfo;
    }

    public void createRotationInfo() {
        rotationInfo = new RotationInfo();
    }

    public void removeRotationInfo() {
        rotationInfo = null;
    }

    public RenderingInfo renderingInfo() {
        return renderingInfo;
    }

    public void createRenderingInfo() {
        renderingInfo = new RenderingInfo();
    }

    public void removeRenderingInfo() {
        renderingInfo = null;
    }
}
