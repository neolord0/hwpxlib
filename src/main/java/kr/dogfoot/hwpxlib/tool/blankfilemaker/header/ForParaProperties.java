package kr.dogfoot.hwpxlib.tool.blankfilemaker.header;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Default;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.LineSpacing;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.ParaMargin;

public class ForParaProperties {
    public static void make(ObjectList<ParaPr> paraProperties) {
        paraPr1(paraProperties.addNew());
        paraPr2(paraProperties.addNew());
        paraPr3(paraProperties.addNew());
        paraPr4(paraProperties.addNew());
        paraPr5(paraProperties.addNew());
        paraPr6(paraProperties.addNew());
        paraPr7(paraProperties.addNew());
        paraPr8(paraProperties.addNew());
        paraPr9(paraProperties.addNew());
        paraPr10(paraProperties.addNew());
        paraPr11(paraProperties.addNew());
        paraPr12(paraProperties.addNew());
        paraPr13(paraProperties.addNew());
        paraPr14(paraProperties.addNew());
        paraPr15(paraProperties.addNew());
        paraPr16(paraProperties.addNew());
    }

    private static void paraPr1(ParaPr pp) {
        pp
                .idAnd("0")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.LEFT, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.BREAK_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);
        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 0, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 130, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 0, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 130, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void align(ParaPr pp, HorizontalAlign2 horizontal, VerticalAlign1 vertical) {
        pp.createAlign();
        pp.align()
                .horizontalAnd(horizontal)
                .vertical(vertical);
    }

    private static void heading(ParaPr pp, ParaHeadingType type, String idRef, byte level) {
        pp.createHeading();
        pp.heading()
                .typeAnd(type)
                .idRefAnd(idRef)
                .level(level);
    }

    private static void breakSetting(ParaPr pp,
                                     LineBreakForLatin breakLatinWord,
                                     LineBreakForNonLatin breakNonLatinWord,
                                     boolean widowOrphan,
                                     boolean keepWithNext,
                                     boolean keepLines,
                                     boolean pageBreakBefore,
                                     LineWrap lineWrap) {
        pp.createBreakSetting();
        pp.breakSetting()
                .breakLatinWordAnd(breakLatinWord)
                .breakNonLatinWordAnd(breakNonLatinWord)
                .widowOrphanAnd(widowOrphan)
                .keepWithNextAnd(keepWithNext)
                .keepLinesAnd(keepLines)
                .pageBreakBeforeAnd(pageBreakBefore)
                .lineWrap(lineWrap);
    }

    private static void autoSpacing(ParaPr pp, boolean eAsianEng, boolean eAsianNum) {
        pp.createAutoSpacing();
        pp.autoSpacing()
                .eAsianEngAnd(eAsianEng)
                .eAsianNum(eAsianNum);
    }

    private static ParaMargin pageMargin(int indent, int left, int right, int prev, int next) {
        ParaMargin margin = new ParaMargin();

        margin.createIntent();
        margin.intent()
                .valueAnd(indent)
                .unit(ValueUnit2.HWPUNIT);

        margin.createLeft();
        margin.left()
                .valueAnd(left)
                .unit(ValueUnit2.HWPUNIT);

        margin.createRight();
        margin.right()
                .valueAnd(right)
                .unit(ValueUnit2.HWPUNIT);

        margin.createPrev();
        margin.prev()
                .valueAnd(prev)
                .unit(ValueUnit2.HWPUNIT);

        margin.createNext();
        margin.next()
                .valueAnd(next)
                .unit(ValueUnit2.HWPUNIT);

        return margin;
    }

    private static LineSpacing lineSpacing(LineSpacingType type, int value, ValueUnit2 unit) {
        LineSpacing lineSpacing = new LineSpacing();
        lineSpacing
                .typeAnd(type)
                .valueAnd(value)
                .unit(unit);
        return lineSpacing;
    }

    private static void border(ParaPr pp,
                               String borderFillIDRef,
                               int offsetLeft,
                               int offsetRight,
                               int offsetTop,
                               int offsetBottom,
                               boolean connect,
                               boolean ignoreMargin) {
        pp.createBorder();
        pp.border()
                .borderFillIDRefAnd(borderFillIDRef)
                .offsetLeftAnd(offsetLeft)
                .offsetRightAnd(offsetRight)
                .offsetTopAnd(offsetTop)
                .offsetBottomAnd(offsetBottom)
                .connectAnd(connect)
                .ignoreMargin(ignoreMargin);
    }

    private static void paraPr2(ParaPr pp) {
        pp
                .idAnd("1")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(-1310, 0, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 130, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(-2620, 0, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 130, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr3(ParaPr pp) {
        pp
                .idAnd("2")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.BREAK_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 0, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 150, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 0, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 150, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr4(ParaPr pp) {
        pp
                .idAnd("3")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 0, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 0, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr5(ParaPr pp) {
        pp
                .idAnd("4")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 6);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 7000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 14000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr6(ParaPr pp) {
        pp
                .idAnd("5")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 5);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 6000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 12000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr7(ParaPr pp) {
        pp
                .idAnd("6")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 4);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 5000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 10000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr8(ParaPr pp) {
        pp
                .idAnd("7")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 3);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 4000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 8000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr9(ParaPr pp) {
        pp
                .idAnd("8")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 2);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 3000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 6000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr10(ParaPr pp) {
        pp
                .idAnd("9")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 1);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 2000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 4000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr11(ParaPr pp) {
        pp
                .idAnd("10")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.OUTLINE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 1000, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 2000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr12(ParaPr pp) {
        pp
                .idAnd("11")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.JUSTIFY, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.KEEP_WORD,
                false,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, false, false);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 1500, 0, 0, 0));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 3000, 0, 0, 0));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr13(ParaPr pp) {
        pp
                .idAnd("12")
                .tabPrIDRefAnd("1")
                .condenseAnd((byte) 20)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.LEFT, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.BREAK_WORD,
                true,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, true, true);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 0, 0, 1200, 300));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 0, 0, 2400, 600));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr14(ParaPr pp) {
        pp
                .idAnd("13")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.LEFT, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.BREAK_WORD,
                true,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, true, true);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 0, 0, 0, 700));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 0, 0, 0, 1400));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr15(ParaPr pp) {
        pp
                .idAnd("14")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.LEFT, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.BREAK_WORD,
                true,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, true, true);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 1100, 0, 0, 700));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 2200, 0, 0, 1400));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }

    private static void paraPr16(ParaPr pp) {
        pp
                .idAnd("15")
                .tabPrIDRefAnd("0")
                .condenseAnd((byte) 0)
                .fontLineHeightAnd(false)
                .snapToGridAnd(true)
                .suppressLineNumbersAnd(false)
                .checked(false);

        align(pp, HorizontalAlign2.LEFT, VerticalAlign1.BASELINE);
        heading(pp, ParaHeadingType.NONE, "0", (byte) 0);
        breakSetting(pp,
                LineBreakForLatin.KEEP_WORD,
                LineBreakForNonLatin.BREAK_WORD,
                true,
                false,
                false,
                false,
                LineWrap.BREAK);
        autoSpacing(pp, true, true);

        Switch switchObject = pp.addNewSwitch();
        switchObject.position(4);

        Case case1 = switchObject.addNewCaseObject();
        case1.requiredNamespace("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
        case1.addChild(pageMargin(0, 2200, 0, 0, 700));
        case1.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        switchObject.createDefaultObject();
        Default defaultObject = switchObject.defaultObject();
        defaultObject.addChild(pageMargin(0, 4400, 0, 0, 1400));
        defaultObject.addChild(lineSpacing(LineSpacingType.PERCENT, 160, ValueUnit2.HWPUNIT));

        border(pp,
                "2",
                0,
                0,
                0,
                0,
                false,
                false);
    }
}
