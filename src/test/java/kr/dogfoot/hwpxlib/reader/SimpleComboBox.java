package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ComboBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormCharPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class SimpleComboBox {
    private HWPXFile file;

    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimpleComboBox.hwpx");
        ComboBox comboBox = (ComboBox) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(comboBox);
        Assert.assertEquals(comboBox.listBoxRows().intValue(), 10);
        Assert.assertEquals(comboBox.listBoxWidth().intValue(), 0);
        Assert.assertEquals(comboBox.editEnable().booleanValue(), true);
        Assert.assertEquals(comboBox.selectedValue(), "");
        Assert.assertEquals(comboBox.name(), "ComboBox1");
        Assert.assertEquals(comboBox.foreColor(), "#000000");
        Assert.assertEquals(comboBox.backColor(), "#F0F0F0");
        Assert.assertEquals(comboBox.groupName(), "");
        Assert.assertEquals(comboBox.tabStop().booleanValue(), true);
        Assert.assertEquals(comboBox.editable().booleanValue(), true);
        Assert.assertEquals(comboBox.borderTypeIDRef(), "5");
        Assert.assertEquals(comboBox.drawFrame().booleanValue(), true);
        Assert.assertEquals(comboBox.printable().booleanValue(), true);
        Assert.assertEquals(comboBox.command(), "");

        FormCharPr formCharPr = comboBox.formCharPr();
        Assert.assertNotNull(formCharPr);
        Assert.assertEquals(formCharPr.charPrIDRef(), "0");
        Assert.assertEquals(formCharPr.followContext().booleanValue(), false);
        Assert.assertEquals(formCharPr.autoSz().booleanValue(), false);
        Assert.assertEquals(formCharPr.wordWrap().booleanValue(), false);

        Assert.assertEquals(comboBox.countOfListItem(), 1);
        ListItem listItem = comboBox.getListItem(0);
        Assert.assertNotNull(listItem);
        Assert.assertEquals(listItem.displayText(), "");
        Assert.assertEquals(listItem.value(), "");

        ShapeSize sz = comboBox.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().longValue(), 9921);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().longValue(), 1984);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = comboBox.pos();
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

        LeftRightTopBottom outMargin = comboBox.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().longValue(), 0);
        Assert.assertEquals(outMargin.right().longValue(), 0);
        Assert.assertEquals(outMargin.top().longValue(), 0);
        Assert.assertEquals(outMargin.bottom().longValue(), 0);

        HasOnlyText shapeComment = comboBox.shapeComment();
        Assert.assertNull(shapeComment);

        int index = 0;
        for (ManifestItem item : file.contentHPFFile().manifest().items()) {
            switch (index) {
                case 0:
                    Assert.assertNull(item.attachedFile());
                    break;
                case 1:
                    Assert.assertNull(item.attachedFile());
                    break;
                case 2:
                    Assert.assertNotNull(item.attachedFile());
                    Assert.assertEquals(item.href(), "Scripts/headerScripts.js");
                    Assert.assertEquals(new String(item.attachedFile().data(), StandardCharsets.UTF_16LE), "var Documents = XHwpDocuments;\r\n" +
                            "var Document = Documents.Active_XHwpDocument;\r\n" +
                            "var ComboBox1 = Document.XHwpFormComboBoxs.ItemFromName(\"ComboBox1\");\r\n");
                    break;
                case 3:
                    Assert.assertNotNull(item.attachedFile());
                    Assert.assertEquals(item.href(), "Scripts/sourceScripts.js");
                    Assert.assertEquals(new String(item.attachedFile().data(), StandardCharsets.UTF_16LE), "\r\n" +
                            "function OnDocument_Open()\r\n" +
                            "{\r\n" +
                            "\tComboBox1.InsertString(\"봄\", 0);\r\n" +
                            "\tComboBox1.InsertString(\"여름\", 1);\r\n" +
                            "\tComboBox1.InsertString(\"가을\", 2);\r\n" +
                            "\tComboBox1.InsertString(\"겨울\", 3);\r\n" +
                            "}\r\n" +
                            "function OnDocument_New()\r\n" +
                            "{\r\n" +
                            "\t//todo : \r\n" +
                            "}\r\n");
                    break;
                case 4:
                    Assert.assertNull(item.attachedFile());
                    break;
                default:
                    Assert.fail();
                    break;
            }

            index++;
       }
    }
}
