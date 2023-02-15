package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PresentationEffect;

/**
 * 프레젠테이션 정보
 */
public class Presentation extends SwitchableObject {
    /**
     * 넘김 효과
     */
    private PresentationEffect effect;
    /**
     * 소리 파일 아이디 참조
     */
    private String soundIDRef;
    /**
     * 글자 흑/백 전환 여부
     */
    private Boolean inventText;
    /**
     * 자동 시연 여부
     */
    private Boolean autoshow;
    /**
     * 전환 시간
     */
    private Integer showtime;
    /**
     * 적용범뮈
     */
    private String applyto;
    /**
     * 배경화면 채움 정보
     */
    private FillBrush fillBrush;

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_presentation;
    }

    public PresentationEffect effect() {
        return effect;
    }

    public void effect(PresentationEffect effect) {
        this.effect = effect;
    }

    public Presentation effectAnd(PresentationEffect effect) {
        this.effect = effect;
        return this;
    }

    public String soundIDRef() {
        return soundIDRef;
    }

    public void soundIDRef(String soundIDRef) {
        this.soundIDRef = soundIDRef;
    }

    public Presentation soundIDRefAnd(String soundIDRef) {
        this.soundIDRef = soundIDRef;
        return this;
    }

    public Boolean inventText() {
        return inventText;
    }

    public void inventText(Boolean inventText) {
        this.inventText = inventText;
    }

    public Presentation inventTextAnd(Boolean inventText) {
        this.inventText = inventText;
        return this;
    }

    public Boolean autoshow() {
        return autoshow;
    }

    public void autoshow(Boolean autoshow) {
        this.autoshow = autoshow;
    }

    public Presentation autoshowAnd(Boolean autoshow) {
        this.autoshow = autoshow;
        return this;
    }

    public Integer showtime() {
        return showtime;
    }

    public Presentation showtimeAnd(Integer showtime) {
        this.showtime = showtime;
        return this;
    }

    public void showtime(Integer showtime) {
        this.showtime = showtime;
    }

    public String applyto() {
        return applyto;
    }

    public void applyto(String applyto) {
        this.applyto = applyto;
    }

    public Presentation applytoAnd(String applyto) {
        this.applyto = applyto;
        return this;
    }

    public FillBrush fillBrush() {
        return fillBrush;
    }

    public void createFillBrush() {
        fillBrush = new FillBrush();
    }

    public void removeFillBrush() {
        fillBrush = null;
    }
}
