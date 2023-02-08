package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TrackChangeType;

/**
 * 변경추적
 */
public class TrackChange extends HWPXObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 변경추적 종류
     */
    private TrackChangeType type;
    /**
     * 변경 추적 시각 (yyyy-mm-ddThh:mm:ssZ, 예 2022-09-20T06:08:00Z)
     */
    private String date;
    /**
     * 저자 아이디
     */
    private String authorID;
    /**
     * 화면에서 감추기 여부
     */
    private Boolean hide;
    /**
     * type = "CharShape" 일떄 변경한 글자모양 아이디
     */
    private String charshapeID;
    /**
     * type = "ParaShape" 일떄 변경한 문단모양 아이디
     */
    private String parashapeID;

    public TrackChange() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.TrackChange;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public TrackChange idAnd(String id) {
        this.id = id;
        return this;
    }

    public TrackChangeType type() {
        return type;
    }

    public void type(TrackChangeType type) {
        this.type = type;
    }

    public TrackChange typeAnd(TrackChangeType type) {
        this.type = type;
        return this;
    }

    public String date() {
        return date;
    }

    public void date(String date) {
        this.date = date;
    }

    public TrackChange dateAnd(String date) {
        this.date = date;
        return this;
    }

    public String authorID() {
        return authorID;
    }

    public void authorID(String authorID) {
        this.authorID = authorID;
    }

    public TrackChange authorIDAnd(String authorID) {
        this.authorID = authorID;
        return this;
    }

    public Boolean hide() {
        return hide;
    }

    public void hide(Boolean hide) {
        this.hide = hide;
    }

    public TrackChange hideAnd(Boolean hide) {
        this.hide = hide;
        return this;
    }

    public String charshapeID() {
        return charshapeID;
    }

    public void charshapeID(String charshapeID) {
        this.charshapeID = charshapeID;
    }

    public TrackChange charshapeIDAnd(String charshapeID) {
        this.charshapeID = charshapeID;
        return this;
    }

    public String parashapeID() {
        return parashapeID;
    }

    public void parashapeID(String parashapeID) {
        this.parashapeID = parashapeID;
    }

    public TrackChange parashapeIDAnd(String parashapeID) {
        this.parashapeID = parashapeID;
        return this;
    }
}
