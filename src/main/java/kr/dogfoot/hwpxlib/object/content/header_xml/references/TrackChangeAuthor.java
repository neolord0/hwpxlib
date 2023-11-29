package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 변경추적 사용자
 */
public class TrackChangeAuthor extends HWPXObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 이름
     */
    private String name;
    /**
     * 변경 검토 여부
     */
    private Boolean mark;
    /**
     * UI에서 변경추적 사용자를 구별하는 색
     */
    private String color;

    public TrackChangeAuthor() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_trackChangeAuthor;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public TrackChangeAuthor idAnd(String id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public TrackChangeAuthor nameAnd(String name) {
        this.name = name;
        return this;
    }

    public Boolean mark() {
        return mark;
    }

    public void mark(Boolean mark) {
        this.mark = mark;
    }

    public TrackChangeAuthor markAnd(Boolean mark) {
        this.mark = mark;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public TrackChangeAuthor colorAnd(String color) {
        this.color = color;
        return this;
    }

    @Override
    public TrackChangeAuthor clone() {
        TrackChangeAuthor cloned = new TrackChangeAuthor();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(TrackChangeAuthor from) {
        this.id = from.id;
        this.name = from.name;
        this.mark = from.mark;
        this.color = from.color;
    }
}
