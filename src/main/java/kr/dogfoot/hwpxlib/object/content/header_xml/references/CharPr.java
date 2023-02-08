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
    private FontRef fontRef;
    /**
     * 언어별 장평, 단위 %
     */
    private Ratio ratio;
    /**
     * 언어별 자간, 단위 %
     */
    private Spacing spacing;
    /**
     * 언어별 상대크기, 단위 %
     */
    private RelSz relSz;
    /**
     * 언어별 오프셋, 단위 %
     */
    private CharOffset offset;
    /**
     * 글자 기울임
     */
    private Italic italic;
    /**
     * 글자 굵게
     */
    private Bold bold;
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
    private Emboss emboss;
    /**
     * 음각 문자
     */
    private Engrave engrave;
    /**
     * 위첨자
     */
    private Supscript supscript;
    /**
     * 아래첨자
     */
    private Subscript subscript;


    public CharPr() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CharPr;
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

    public FontRef fontRef() {
        return fontRef;
    }

    public void createFontRef() {
        fontRef = new FontRef();
    }

    public void removeFontRef() {
        fontRef = null;
    }

    public Ratio ratio() {
        return ratio;
    }

    public void createRatio() {
        ratio = new Ratio();
    }

    public void removeRatio() {
        ratio = null;
    }

    public Spacing spacing() {
        return spacing;
    }

    public void createSpacing() {
        spacing = new Spacing();
    }

    public void removeSpacing() {
        spacing = null;
    }

    public RelSz relSz() {
        return relSz;
    }

    public void createRelSz() {
        relSz = new RelSz();
    }

    public void removeRelSz() {
        relSz = null;
    }

    public CharOffset offset() {
        return offset;
    }

    public void createOffset() {
        offset = new CharOffset();
    }

    public void removeOffset() {
        offset = null;
    }

    public NoAttributeNoChild italic() {
        return italic;
    }

    public void createItalic() {
        italic = new Italic();
    }

    public void removeItalic() {
        italic = null;
    }

    public NoAttributeNoChild bold() {
        return bold;
    }

    public void createBold() {
        bold = new Bold();
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
        emboss = new Emboss();
    }

    public void removeEmboss() {
        emboss = null;
    }

    public NoAttributeNoChild engrave() {
        return engrave;
    }

    public void createEngrave() {
        engrave = new Engrave();
    }

    public void removeEngrave() {
        engrave = null;
    }

    public NoAttributeNoChild supscript() {
        return supscript;
    }

    public void createSupscript() {
        supscript = new Supscript();
    }

    public void removeSupscript() {
        supscript = null;
    }

    public NoAttributeNoChild subscript() {
        return subscript;
    }

    public void createSubscript() {
        subscript = new Subscript();
    }

    public void removeSubscript() {
        subscript = null;
    }
}
