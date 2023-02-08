package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.textart;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FontType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextArtAlign;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextArtShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;

/**
 * 글맵시 모양
 */
public class TextArtPr extends SwitchableObject {
    /**
     * 글꼴 이름
     */
    private String fontName;
    /**
     * 글꼴 스타일
     */
    private String fontStyle;
    /**
     * 글꼴 타입
     */
    private FontType2 fontType;
    /**
     * 글맵시 모양
     */
    private TextArtShape textShape;
    /**
     * 줄간격
     */
    private Integer lineSpacing;
    /**
     * 글자 간격
     */
    private Integer charSpacing;
    /**
     * 정렬 방식
     */
    private TextArtAlign align;
    /**
     * 그림자
     */
    private DrawingShadow shadow;

    public TextArtPr() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.TextArtPr;
    }

    public String fontName() {
        return fontName;
    }

    public void fontName(String fontName) {
        this.fontName = fontName;
    }

    public TextArtPr fontNameAnd(String fontName) {
        this.fontName = fontName;
        return this;
    }

    public String fontStyle() {
        return fontStyle;
    }

    public void fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public TextArtPr fontStyleAnd(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    public FontType2 fontType() {
        return fontType;
    }

    public void fontType(FontType2 fontType) {
        this.fontType = fontType;
    }

    public TextArtPr fontTypeAnd(FontType2 fontType) {
        this.fontType = fontType;
        return this;
    }

    public TextArtShape textShape() {
        return textShape;
    }

    public void textShape(TextArtShape textShape) {
        this.textShape = textShape;
    }

    public TextArtPr textShapeAnd(TextArtShape textShape) {
        this.textShape = textShape;
        return this;
    }

    public Integer lineSpacing() {
        return lineSpacing;
    }

    public void lineSpacing(Integer lineSpacing) {
        this.lineSpacing = lineSpacing;
    }

    public TextArtPr lineSpacingAnd(Integer lineSpacing) {
        this.lineSpacing = lineSpacing;
        return this;
    }

    public Integer charSpacing() {
        return charSpacing;
    }

    public void charSpacing(Integer charSpacing) {
        this.charSpacing = charSpacing;
    }

    public TextArtPr charSpacingAnd(Integer charSpacing) {
        this.charSpacing = charSpacing;
        return this;
    }

    public TextArtAlign align() {
        return align;
    }

    public void align(TextArtAlign align) {
        this.align = align;
    }

    public TextArtPr alignAnd(TextArtAlign align) {
        this.align = align;
        return this;
    }

    public DrawingShadow shadow() {
        return shadow;
    }

    public void createShadow() {
        shadow = new DrawingShadow();
    }

    public void removeShadow() {
        shadow = null;
    }
}
