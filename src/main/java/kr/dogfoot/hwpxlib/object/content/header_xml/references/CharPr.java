package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SymMarkSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.*;

/**
 * 글자 모양
 */
public class CharPr extends SwitchableObject {
    /**
     * 글자모양 아이디
     */
    private String id;
    /**
     * 글자 크기, 단위 hwpunit
     */
    private Integer height;
    /**
     * 글자색
     */
    private String textColor;
    /**
     * 음영색
     */
    private String shadeColor;
    /**
     * 글꼴에 어울리는 빈칸 사용 여부
     */
    private Boolean useFontSpace;
    /**
     * 커닝 사용 여부
     */
    private Boolean useKerning;
    /**
     * 강조점 종류
     */
    private SymMarkSort symMark;
    /**
     * 글자테두리를 위한 BorderFill 아이디 참조
     */
    private String borderFillIDRef;
    /**
     * 언어별 글꼴(Font) 아이디 참조
     */
    private ValuesByLanguage<String> fontRef;
    /**
     * 언어별 장평, 단위 %
     */
    private ValuesByLanguage<Short> ratio;
    /**
     * 언어별 자간, 단위 %
     */
    private ValuesByLanguage<Short> spacing;
    /**
     * 언어별 상대크기, 단위 %
     */
    private ValuesByLanguage<Short> relSz;
    /**
     * 언어별 오프셋, 단위 %
     */
    private ValuesByLanguage<Short> offset;
    /**
     * 글자 기울임
     */
    private NoAttributeNoChild italic;
    /**
     * 글자 굵게
     */
    private NoAttributeNoChild bold;
    /**
     * 글자 밑줄
     */
    private Underline underline;
    /**
     * 글자 취소선
     */
    private Strikeout strikeout;
    /**
     * 글자 외곽선
     */
    private Outline outline;
    /**
     * 글자 그림자
     */
    private CharShadow shadow;
    /**
     * 양각 문자
     */
    private NoAttributeNoChild emboss;
    /**
     * 음각 문자
     */
    private NoAttributeNoChild engrave;
    /**
     * 위첨자
     */
    private NoAttributeNoChild supscript;
    /**
     * 아래첨자
     */
    private NoAttributeNoChild subscript;


    public CharPr() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_charPr;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public CharPr idAnd(String id) {
        this.id = id;
        return this;
    }

    public Integer height() {
        return height;
    }

    public void height(Integer height) {
        this.height = height;
    }

    public CharPr heightAnd(Integer height) {
        this.height = height;
        return this;
    }

    public String textColor() {
        return textColor;
    }

    public void textColor(String textColor) {
        this.textColor = textColor;
    }

    public CharPr textColorAnd(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public String shadeColor() {
        return shadeColor;
    }

    public void shadeColor(String shadeColor) {
        this.shadeColor = shadeColor;
    }

    public CharPr shadeColorAnd(String shadeColor) {
        this.shadeColor = shadeColor;
        return this;
    }

    public Boolean useFontSpace() {
        return useFontSpace;
    }

    public void useFontSpace(Boolean useFontSpace) {
        this.useFontSpace = useFontSpace;
    }

    public CharPr useFontSpaceAnd(Boolean useFontSpace) {
        this.useFontSpace = useFontSpace;
        return this;
    }

    public Boolean useKerning() {
        return useKerning;
    }

    public void useKerning(Boolean useKerning) {
        this.useKerning = useKerning;
    }

    public CharPr useKerningAnd(Boolean useKerning) {
        this.useKerning = useKerning;
        return this;
    }

    public SymMarkSort symMark() {
        return symMark;
    }

    public void symMark(SymMarkSort symMark) {
        this.symMark = symMark;
    }

    public CharPr symMarkAnd(SymMarkSort symMark) {
        this.symMark = symMark;
        return this;
    }

    public String borderFillIDRef() {
        return borderFillIDRef;
    }

    public void borderFillIDRef(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
    }

    public CharPr borderFillIDRefAnd(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
        return this;
    }

    public ValuesByLanguage<String> fontRef() {
        return fontRef;
    }

    public void createFontRef() {
        fontRef = new ValuesByLanguage<String>(ObjectType.hh_fontRef);
    }

    public void removeFontRef() {
        fontRef = null;
    }

    public ValuesByLanguage<Short> ratio() {
        return ratio;
    }

    public void createRatio() {
        ratio = new ValuesByLanguage<Short>(ObjectType.hh_ratio);
    }

    public void removeRatio() {
        ratio = null;
    }

    public ValuesByLanguage<Short> spacing() {
        return spacing;
    }

    public void createSpacing() {
        spacing = new ValuesByLanguage<Short>(ObjectType.hh_spacing);
    }

    public void removeSpacing() {
        spacing = null;
    }

    public ValuesByLanguage<Short> relSz() {
        return relSz;
    }

    public void createRelSz() {
        relSz = new ValuesByLanguage<Short>(ObjectType.hh_relSz);
    }

    public void removeRelSz() {
        relSz = null;
    }

    public ValuesByLanguage<Short> offset() {
        return offset;
    }

    public void createOffset() {
        offset = new ValuesByLanguage<Short>(ObjectType.hh_offset);
    }

    public void removeOffset() {
        offset = null;
    }

    public NoAttributeNoChild italic() {
        return italic;
    }

    public void createItalic() {
        italic = new NoAttributeNoChild(ObjectType.hh_italic);
    }

    public void removeItalic() {
        italic = null;
    }

    public NoAttributeNoChild bold() {
        return bold;
    }

    public void createBold() {
        bold = new NoAttributeNoChild(ObjectType.hh_bold);
    }

    public void removeBold() {
        bold = null;
    }

    public Underline underline() {
        return underline;
    }

    public void createUnderline() {
        underline = new Underline();
    }

    public void removeUnderline() {
        underline = null;
    }

    public Strikeout strikeout() {
        return strikeout;
    }

    public void createStrikeout() {
        strikeout = new Strikeout();
    }

    public void removeStrikeout() {
        strikeout = null;
    }

    public Outline outline() {
        return outline;
    }

    public void createOutline() {
        outline = new Outline();
    }

    public void removeOutline() {
        outline = null;
    }

    public CharShadow shadow() {
        return shadow;
    }

    public void createShadow() {
        shadow = new CharShadow();
    }

    public void removeShadow() {
        shadow = null;
    }

    public NoAttributeNoChild emboss() {
        return emboss;
    }

    public void createEmboss() {
        emboss = new NoAttributeNoChild(ObjectType.hh_emboss);
    }

    public void removeEmboss() {
        emboss = null;
    }

    public NoAttributeNoChild engrave() {
        return engrave;
    }

    public void createEngrave() {
        engrave = new NoAttributeNoChild(ObjectType.hh_engrave);
    }

    public void removeEngrave() {
        engrave = null;
    }

    public NoAttributeNoChild supscript() {
        return supscript;
    }

    public void createSupscript() {
        supscript = new NoAttributeNoChild(ObjectType.hh_supscript);
    }

    public void removeSupscript() {
        supscript = null;
    }

    public NoAttributeNoChild subscript() {
        return subscript;
    }

    public void createSubscript() {
        subscript = new NoAttributeNoChild(ObjectType.hh_subscript);
    }

    public void removeSubscript() {
        subscript = null;
    }
}
