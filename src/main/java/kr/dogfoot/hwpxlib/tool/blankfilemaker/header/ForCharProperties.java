package kr.dogfoot.hwpxlib.tool.blankfilemaker.header;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;

public class ForCharProperties {
    public static void make(ObjectList<CharPr> charProperties) {
        charPr1(charProperties.addNew());
        charPr2(charProperties.addNew());
        charPr3(charProperties.addNew());
        charPr4(charProperties.addNew());
        charPr5(charProperties.addNew());
        charPr6(charProperties.addNew());
        charPr7(charProperties.addNew());
    }

    private static void charPr1(CharPr cp) {
        cp
                .idAnd("0")
                .heightAnd(1000)
                .textColorAnd("#000000")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("1", "1", "1", "1", "1", "1", "1");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }

    private static void charPr2(CharPr cp) {
        cp
                .idAnd("1")
                .heightAnd(1000)
                .textColorAnd("#000000")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("0", "0", "0", "0", "0", "0", "0");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }

    private static void charPr3(CharPr cp) {
        cp
                .idAnd("2")
                .heightAnd(900)
                .textColorAnd("#000000")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("0", "0", "0", "0", "0", "0", "0");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }

    private static void charPr4(CharPr cp) {
        cp
                .idAnd("3")
                .heightAnd(900)
                .textColorAnd("#000000")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("1", "1", "1", "1", "1", "1", "1");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }

    private static void charPr5(CharPr cp) {
        cp
                .idAnd("4")
                .heightAnd(900)
                .textColorAnd("#000000")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("0", "0", "0", "0", "0", "0", "0");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) -5, (short) -5, (short) -5, (short) -5, (short) -5, (short) -5, (short) -5);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }

    private static void charPr6(CharPr cp) {
        cp
                .idAnd("5")
                .heightAnd(1600)
                .textColorAnd("#2E74B5")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("0", "0", "0", "0", "0", "0", "0");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }

    private static void charPr7(CharPr cp) {
        cp
                .idAnd("6")
                .heightAnd(1100)
                .textColorAnd("#000000")
                .shadeColorAnd("none")
                .useFontSpaceAnd(false)
                .useKerningAnd(false)
                .symMarkAnd(SymMarkSort.NONE)
                .borderFillIDRef("2");

        cp.createFontRef();
        cp.fontRef().set("0", "0", "0", "0", "0", "0", "0");

        cp.createRatio();
        cp.ratio().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createSpacing();
        cp.spacing().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createRelSz();
        cp.relSz().set((short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100, (short) 100);

        cp.createOffset();
        cp.offset().set((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        cp.createUnderline();
        cp.underline()
                .typeAnd(UnderlineType.NONE)
                .shapeAnd(LineType3.SOLID)
                .color("#000000");

        cp.createStrikeout();
        cp.strikeout()
                .shapeAnd(LineType2.NONE)
                .color("#000000");

        cp.createOutline();
        cp.outline().type(LineType1.NONE);

        cp.createShadow();
        cp.shadow()
                .typeAnd(CharShadowType.NONE)
                .colorAnd("#B2B2B2")
                .offsetXAnd((short) 10)
                .offsetY((short) 10);
    }
}
