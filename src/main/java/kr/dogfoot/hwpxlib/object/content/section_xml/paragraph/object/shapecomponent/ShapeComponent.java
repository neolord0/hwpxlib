package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
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
    private String instid;
    /**
     * 그룹 개체 안에 개별 개체의 위치
     */
    private XAndY offset;
    /**
     * 생성시 크기
     */
    private WidthAndHeight orgSz;
    /**
     * 현재 크기
     */
    private WidthAndHeight curSz;
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

    public String href() {
        return href;
    }

    public void href(String href) {
        this.href = href;
    }

    public ChildType hrefAnd(String href) {
        this.href = href;
        return (ChildType) this;
    }

    public Short groupLevel() {
        return groupLevel;
    }

    public void groupLevel(Short groupLevel) {
        this.groupLevel = groupLevel;
    }

    public ChildType groupLevelAnd(Short groupLevel) {
        this.groupLevel = groupLevel;
        return (ChildType) this;
    }

    public String instid() {
        return instid;
    }

    public void instid(String instid) {
        this.instid = instid;
    }

    public ChildType instidAnd(String instid) {
        this.instid = instid;
        return (ChildType) this;
    }

    public XAndY offset() {
        return offset;
    }

    public void createOffset() {
        offset = new XAndY(ObjectType.hp_offset_for_shapeComponent);
    }

    public void removeOffset() {
        offset = null;
    }

    public WidthAndHeight orgSz() {
        return orgSz;
    }

    public void createOrgSz() {
        orgSz = new WidthAndHeight(ObjectType.hp_orgSz);
    }

    public void removeOrgSz() {
        orgSz = null;
    }

    public WidthAndHeight curSz() {
        return curSz;
    }

    public void createCurSz() {
        curSz = new WidthAndHeight(ObjectType.hp_curSz);
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

    protected void copyFrom(ShapeComponent from) {
        this.href = from.href;
        this.groupLevel = from.groupLevel;
        this.instid = from.instid;

        if (from.offset != null) {
            offset = from.offset.clone();
        } else {
            offset = null;
        }

        if (from.orgSz != null) {
            orgSz = from.orgSz.clone();
        } else {
            orgSz = null;
        }

        if (from.curSz != null) {
            curSz = from.curSz.clone();
        } else {
            curSz = null;
        }

        if (from.flip != null) {
            flip = from.flip.clone();
        } else {
            flip = null;
        }

        if (from.rotationInfo != null) {
            rotationInfo = from.rotationInfo.clone();
        } else {
            rotationInfo = null;
        }

        if (from.renderingInfo != null) {
            renderingInfo = from.renderingInfo.clone();
        } else {
            renderingInfo = null;
        }

        super.copyFrom(from);
    }
}
