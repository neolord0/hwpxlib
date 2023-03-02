package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Button;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.CheckButton;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.RadioButton;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormCharPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleButtons {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleButtons.hwpx");
        Button btn = (Button) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        btn(btn);

        CheckButton checkBtn = (CheckButton) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(2);
        checkBtn(checkBtn);


        RadioButton radioBtn = (RadioButton) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(3);
        radioBtn(radioBtn);
    }


    private void btn(Button btn) {
        Assert.assertNotNull(btn);
        Assert.assertEquals(btn.captionText(), "명령 단추1");
        Assert.assertEquals(btn.value(), ButtonCheckValue.UNCHECKED);
        Assert.assertEquals(btn.radioGroupName(), "");
        Assert.assertEquals(btn.triState().booleanValue(), false);
        Assert.assertEquals(btn.name(), "PushButton1");
        Assert.assertEquals(btn.foreColor(), "#000000");
        Assert.assertEquals(btn.backColor(), "#F0F0F0");
        Assert.assertEquals(btn.groupName(), "");
        Assert.assertEquals(btn.tabStop().booleanValue(), true);
        Assert.assertEquals(btn.editable().booleanValue(), true);
        Assert.assertEquals(btn.tabOrder().intValue(), 1);
        Assert.assertEquals(btn.enabled().booleanValue(), true);
        Assert.assertEquals(btn.borderTypeIDRef(), "4");
        Assert.assertEquals(btn.drawFrame().booleanValue(), true);
        Assert.assertEquals(btn.printable().booleanValue(), true);
        Assert.assertEquals(btn.command(), "");

        FormCharPr formCharPr = btn.formCharPr();
        Assert.assertNotNull(formCharPr);
        Assert.assertEquals(formCharPr.charPrIDRef(), "0");
        Assert.assertEquals(formCharPr.followContext().booleanValue(), false);
        Assert.assertEquals(formCharPr.autoSz().booleanValue(), false);
        Assert.assertEquals(formCharPr.wordWrap().booleanValue(), false);


        ShapeSize sz = btn.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().longValue(), 7087);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().longValue(), 1984);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = btn.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), true);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.COLUMN);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().longValue(), 0);
        Assert.assertEquals(pos.horzOffset().longValue(), 0);

        LeftRightTopBottom outMargin = btn.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().longValue(), 0);
        Assert.assertEquals(outMargin.right().longValue(), 0);
        Assert.assertEquals(outMargin.top().longValue(), 0);
        Assert.assertEquals(outMargin.bottom().longValue(), 0);

        HasOnlyText shapeComment = btn.shapeComment();
        Assert.assertNull(shapeComment);
    }

    private void checkBtn(CheckButton checkBtn) {
        Assert.assertNotNull(checkBtn);
        Assert.assertEquals(checkBtn.captionText(), "선택 상자1");
        Assert.assertEquals(checkBtn.value(), ButtonCheckValue.UNCHECKED);
        Assert.assertEquals(checkBtn.radioGroupName(), "");
        Assert.assertEquals(checkBtn.triState().booleanValue(), false);
        Assert.assertEquals(checkBtn.backStyle(), BackStyle.OPAQUE);
        Assert.assertEquals(checkBtn.name(), "CheckBox1");
        Assert.assertEquals(checkBtn.foreColor(), "#000000");
        Assert.assertEquals(checkBtn.backColor(), "#FFFFFF");
        Assert.assertEquals(checkBtn.groupName(), "");
        Assert.assertEquals(checkBtn.tabStop().booleanValue(), true);
        Assert.assertEquals(checkBtn.editable().booleanValue(), true);
        Assert.assertEquals(checkBtn.tabOrder().intValue(), 2);
        Assert.assertEquals(checkBtn.enabled().booleanValue(), true);
        Assert.assertEquals(checkBtn.borderTypeIDRef(), "0");
        Assert.assertEquals(checkBtn.drawFrame().booleanValue(), true);
        Assert.assertEquals(checkBtn.printable().booleanValue(), true);
        Assert.assertEquals(checkBtn.command(), "");

        FormCharPr formCharPr = checkBtn.formCharPr();
        Assert.assertNotNull(formCharPr);
        Assert.assertEquals(formCharPr.charPrIDRef(), "0");
        Assert.assertEquals(formCharPr.followContext().booleanValue(), false);
        Assert.assertEquals(formCharPr.autoSz().booleanValue(), false);
        Assert.assertEquals(formCharPr.wordWrap().booleanValue(), false);


        ShapeSize sz = checkBtn.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().longValue(), 9921);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().longValue(), 1984);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = checkBtn.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), true);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.COLUMN);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().longValue(), 0);
        Assert.assertEquals(pos.horzOffset().longValue(), 0);

        LeftRightTopBottom outMargin = checkBtn.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().longValue(), 0);
        Assert.assertEquals(outMargin.right().longValue(), 0);
        Assert.assertEquals(outMargin.top().longValue(), 0);
        Assert.assertEquals(outMargin.bottom().longValue(), 0);

        HasOnlyText shapeComment = checkBtn.shapeComment();
        Assert.assertNull(shapeComment);
    }

    private void radioBtn(RadioButton radioBtn) {
        Assert.assertNotNull(radioBtn);
        Assert.assertEquals(radioBtn.captionText(), "라디오 단추1");
        Assert.assertEquals(radioBtn.value(), ButtonCheckValue.UNCHECKED);
        Assert.assertEquals(radioBtn.radioGroupName(), "");
        Assert.assertEquals(radioBtn.triState().booleanValue(), false);
        Assert.assertEquals(radioBtn.backStyle(), BackStyle.OPAQUE);
        Assert.assertEquals(radioBtn.name(), "RadioButton1");
        Assert.assertEquals(radioBtn.foreColor(), "#000000");
        Assert.assertEquals(radioBtn.backColor(), "#FFFFFF");
        Assert.assertEquals(radioBtn.groupName(), "");
        Assert.assertEquals(radioBtn.tabStop().booleanValue(), true);
        Assert.assertEquals(radioBtn.editable().booleanValue(), true);
        Assert.assertEquals(radioBtn.tabOrder().intValue(), 3);
        Assert.assertEquals(radioBtn.enabled().booleanValue(), true);
        Assert.assertEquals(radioBtn.borderTypeIDRef(), "0");
        Assert.assertEquals(radioBtn.drawFrame().booleanValue(), true);
        Assert.assertEquals(radioBtn.printable().booleanValue(), true);
        Assert.assertEquals(radioBtn.command(), "");

        FormCharPr formCharPr = radioBtn.formCharPr();
        Assert.assertNotNull(formCharPr);
        Assert.assertEquals(formCharPr.charPrIDRef(), "0");
        Assert.assertEquals(formCharPr.followContext().booleanValue(), false);
        Assert.assertEquals(formCharPr.autoSz().booleanValue(), false);
        Assert.assertEquals(formCharPr.wordWrap().booleanValue(), false);


        ShapeSize sz = radioBtn.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().longValue(), 8504);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().longValue(), 1984);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = radioBtn.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), true);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.COLUMN);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().longValue(), 0);
        Assert.assertEquals(pos.horzOffset().longValue(), 0);

        LeftRightTopBottom outMargin = radioBtn.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().longValue(), 0);
        Assert.assertEquals(outMargin.right().longValue(), 0);
        Assert.assertEquals(outMargin.top().longValue(), 0);
        Assert.assertEquals(outMargin.bottom().longValue(), 0);

        HasOnlyText shapeComment = radioBtn.shapeComment();
        Assert.assertNull(shapeComment);
    }
}
