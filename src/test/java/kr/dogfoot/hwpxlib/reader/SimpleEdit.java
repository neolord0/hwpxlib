package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign1;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Edit;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormCharPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.junit.Assert;
import org.junit.Test;

public class SimpleEdit {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimpleEdit.hwpx");
        Edit edit = (Edit) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(edit);
        Assert.assertEquals(edit.multiLine().booleanValue(), false);
        Assert.assertEquals(edit.passwordChar(), "X");
        Assert.assertEquals(edit.maxLength().intValue(), 2147483647L);
        Assert.assertEquals(edit.scrollBars(), DisplayScrollBar.NONE);
        Assert.assertEquals(edit.tabKeyBehavior(), TabKeyBehavior.NEXT_OBJECT);
        Assert.assertEquals(edit.numOnly().booleanValue(), true);
        Assert.assertEquals(edit.readOnly().booleanValue(), false);
        Assert.assertEquals(edit.alignText(), HorizontalAlign1.LEFT);
        Assert.assertEquals(edit.name(), "Edit1");
        Assert.assertEquals(edit.foreColor(), "#F3EFE4");
        Assert.assertEquals(edit.backColor(), "#719FD1");
        Assert.assertEquals(edit.groupName(), "");
        Assert.assertEquals(edit.tabStop().booleanValue(), true);
        Assert.assertEquals(edit.editable().booleanValue(), true);
        Assert.assertEquals(edit.tabOrder().intValue(), 1);
        Assert.assertEquals(edit.enabled().booleanValue(), true);
        Assert.assertEquals(edit.borderTypeIDRef(), "5");
        Assert.assertEquals(edit.drawFrame().booleanValue(), true);
        Assert.assertEquals(edit.printable().booleanValue(), true);
        Assert.assertEquals(edit.command(), "");

        FormCharPr formCharPr = edit.formCharPr();
        Assert.assertNotNull(formCharPr);
        Assert.assertEquals(formCharPr.charPrIDRef(), "7");
        Assert.assertEquals(formCharPr.followContext().booleanValue(), false);
        Assert.assertEquals(formCharPr.autoSz().booleanValue(), false);
        Assert.assertEquals(formCharPr.wordWrap().booleanValue(), false);

        HasOnlyText text = edit.text();
        Assert.assertNotNull(text);
        Assert.assertEquals(text.text(), "1234");

        ShapeSize sz = edit.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().longValue(), 7087);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().longValue(), 1984);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), true);

        ShapePosition pos = edit.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), true);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.PARA);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().longValue(), 0);
        Assert.assertEquals(pos.horzOffset().longValue(), 0);

        LeftRightTopBottom outMargin = edit.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().longValue(), 0);
        Assert.assertEquals(outMargin.right().longValue(), 0);
        Assert.assertEquals(outMargin.top().longValue(), 0);
        Assert.assertEquals(outMargin.bottom().longValue(), 0);

        HasOnlyText shapeComment = edit.shapeComment();
        Assert.assertNull(shapeComment);
    }
}
