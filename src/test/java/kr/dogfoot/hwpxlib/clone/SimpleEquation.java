package kr.dogfoot.hwpxlib.clone;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Equation;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class SimpleEquation {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimpleEquation.hwpx");
        file = file.clone();

        Equation equation  = (Equation) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(equation);
        Assert.assertEquals(equation.id(), "1137177714");
        Assert.assertEquals(equation.zOrder().intValue(), 0);
        Assert.assertEquals(equation.numberingType(), NumberingType.EQUATION);
        Assert.assertEquals(equation.textWrap(), TextWrapMethod.TOP_AND_BOTTOM);
        Assert.assertEquals(equation.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(equation.lock().booleanValue(), false);
        Assert.assertEquals(equation.dropcapstyle(), DropCapStyle.None);
        Assert.assertEquals(equation.version(), "Equation Version 60");
        Assert.assertEquals(equation.baseLine().intValue(), 61);
        Assert.assertEquals(equation.textColor(), "#000000");
        Assert.assertEquals(equation.baseUnit().intValue(), 1100);
        Assert.assertEquals(equation.lineMode(), EquationLineMode.CHAR);
        Assert.assertEquals(equation.font(), "HYhwpEQ");

        ShapeSize sz = equation.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 3825);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 3311);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = equation.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), true);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), false);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.PARA);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().intValue(), 0);
        Assert.assertEquals(pos.horzOffset().intValue(), 0);

        LeftRightTopBottom outMargin = equation.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 56);
        Assert.assertEquals(outMargin.right().intValue(), 56);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        HasOnlyText shapeComment = equation.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "수식입니다.");

        HasOnlyText script = equation.script();
        Assert.assertNotNull(script);
        Assert.assertEquals(script.text(), "{\"123\"} over {123 sqrt {3466}} sum _{34} ^{12}");
    }
}
