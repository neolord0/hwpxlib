package kr.dogfoot.hwpxlib.tool.blankfilemaker.header;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.CenterLineSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SlashType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;

public class ForBorderFills {
    public static void make(ObjectList<BorderFill> borderFills) {
        borderFill1(borderFills.addNew());
        borderFill2(borderFills.addNew());
    }

    private static void borderFill1(BorderFill bf) {
        bf
                .idAnd("1")
                .threeDAnd(false)
                .shadowAnd(false)
                .centerLineAnd(CenterLineSort.NONE)
                .breakCellSeparateLine(false);

        bf.createSlash();
        bf.slash()
                .typeAnd(SlashType.NONE)
                .CrookedAnd(false)
                .isCounter(false);

        bf.createBackSlash();
        bf.backSlash()
                .typeAnd(SlashType.NONE)
                .CrookedAnd(false)
                .isCounter(false);

        bf.createLeftBorder();
        bf.leftBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createRightBorder();
        bf.rightBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createTopBorder();
        bf.topBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createBottomBorder();
        bf.bottomBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createDiagonal();
        bf.diagonal()
                .typeAnd(LineType2.SOLID)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");
    }

    private static void borderFill2(BorderFill bf) {
        bf
                .idAnd("2")
                .threeDAnd(false)
                .shadowAnd(false)
                .centerLineAnd(CenterLineSort.NONE)
                .breakCellSeparateLine(false);

        bf.createSlash();
        bf.slash()
                .typeAnd(SlashType.NONE)
                .CrookedAnd(false)
                .isCounter(false);

        bf.createBackSlash();
        bf.backSlash()
                .typeAnd(SlashType.NONE)
                .CrookedAnd(false)
                .isCounter(false);

        bf.createLeftBorder();
        bf.leftBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createRightBorder();
        bf.rightBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createTopBorder();
        bf.topBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createBottomBorder();
        bf.bottomBorder()
                .typeAnd(LineType2.NONE)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createDiagonal();
        bf.diagonal()
                .typeAnd(LineType2.SOLID)
                .widthAnd(LineWidth.MM_0_1)
                .color("#000000");

        bf.createFillBrush();
        FillBrush fillBrush = bf.fillBrush();

        fillBrush.createWinBrush();
        fillBrush.winBrush()
                .faceColorAnd("none")
                .hatchColorAnd("#FF000000")
                .alpha(0f);
    }
}
