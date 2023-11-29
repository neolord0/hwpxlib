package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VideoType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;

/**
 * 비디오
 */
public class Video extends ShapeComponent<Video> {
    /**
     * 비디오 타입
     */
    private VideoType videotype;
    /**
     * 로컬 비디오 바이너리 데이타에 대한 아이디 참조값
     */
    private String fileIDRef;
    /**
     * 비디오 폴백의 이미지에 대한 아이디 참조값
     */
    private String imageIDRef;
    /**
     * 웹 동영상의 주소
     */
    private String tag;

    public Video() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_video;
    }

    public VideoType videotype() {
        return videotype;
    }

    public void videotype(VideoType videotype) {
        this.videotype = videotype;
    }

    public Video videotypeAnd(VideoType videotype) {
        this.videotype = videotype;
        return this;
    }

    public String fileIDRef() {
        return fileIDRef;
    }

    public void fileIDRef(String fileIDRef) {
        this.fileIDRef = fileIDRef;
    }

    public Video fileIDRefAnd(String fileIDRef) {
        this.fileIDRef = fileIDRef;
        return this;
    }

    public String imageIDRef() {
        return imageIDRef;
    }

    public void imageIDRef(String imageIDRef) {
        this.imageIDRef = imageIDRef;
    }

    public Video imageIDRefAnd(String imageIDRef) {
        this.imageIDRef = imageIDRef;
        return this;
    }

    public String tag() {
        return tag;
    }

    public void tag(String tag) {
        this.tag = tag;
    }

    public Video tagAnd(String tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public Video clone() {
        Video cloned = new Video();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Video from) {
        this.videotype = from.videotype;
        this.fileIDRef = from.fileIDRef;
        this.imageIDRef = from.imageIDRef;
        this.tag = from.tag;

        super.copyFrom(from);
    }
}
