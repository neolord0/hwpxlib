package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellAddr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellSpan;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTable {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleTable.hwpx");
        Table table = (Table) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertEquals(table.id(), "1137126797");
        Assert.assertEquals(table.zOrder().intValue(), 0);
        Assert.assertEquals(table.numberingType(), NumberingType.TABLE);
        Assert.assertEquals(table.textWrap(), TextWrapMethod.TOP_AND_BOTTOM);
        Assert.assertEquals(table.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(table.lock().booleanValue(), false);
        Assert.assertEquals(table.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(table.pageBreak(), TablePageBreak.CELL);
        Assert.assertEquals(table.repeatHeader().booleanValue(), true);
        Assert.assertEquals(table.rowCnt().shortValue(), 3);
        Assert.assertEquals(table.colCnt().shortValue(), 3);
        Assert.assertEquals(table.cellSpacing().intValue(), 0);
        Assert.assertEquals(table.borderFillIDRef(), "3");
        Assert.assertEquals(table.noAdjust().booleanValue(), false);

        ShapeSize sz = table.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 19029);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 8657);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = table.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), false);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), false);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.COLUMN);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().intValue(), 0);
        Assert.assertEquals(pos.horzOffset().intValue(), 0);

        LeftRightTopBottom outMargin = table.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 283);
        Assert.assertEquals(outMargin.right().intValue(), 283);
        Assert.assertEquals(outMargin.top().intValue(), 283);
        Assert.assertEquals(outMargin.bottom().intValue(), 283);

        LeftRightTopBottom inMargin = table.inMargin();
        Assert.assertNotNull(inMargin);
        Assert.assertEquals(inMargin.left().intValue(), 510);
        Assert.assertEquals(inMargin.right().intValue(), 510);
        Assert.assertEquals(inMargin.top().intValue(), 141);
        Assert.assertEquals(inMargin.bottom().intValue(), 141);

        Assert.assertEquals(3, table.countOfTr());
        {
            Tr tr = table.getTr(0);
            Assert.assertEquals(tr.countOfTc(), 2);
            {
                Tc tc = tr.getTc(0);
                Assert.assertEquals(tc.name(), "");
                Assert.assertEquals(tc.header().booleanValue(), false);
                Assert.assertEquals(tc.hasMargin().booleanValue(), false);
                Assert.assertEquals(tc.protect().booleanValue(), false);
                Assert.assertEquals(tc.editable().booleanValue(), false);
                Assert.assertEquals(tc.dirty().booleanValue(), false);
                Assert.assertEquals(tc.borderFillIDRef(), "3");

                SubList subList = tc.subList();
                Assert.assertNotNull(subList);
                Assert.assertEquals(subList.id(), "");
                Assert.assertEquals(subList.textDirection(), TextDirection.HORIZONTAL);
                Assert.assertEquals(subList.lineWrap(), LineWrapMethod.BREAK);
                Assert.assertEquals(subList.vertAlign(), VerticalAlign2.CENTER);
                Assert.assertEquals(subList.linkListIDRef(), "0");
                Assert.assertEquals(subList.linkListNextIDRef(), "0");
                Assert.assertEquals(subList.textWidth().intValue(), 0);
                Assert.assertEquals(subList.textHeight().intValue(), 0);
                Assert.assertEquals(subList.hasTextRef().booleanValue(), false);
                Assert.assertEquals(subList.hasNumRef().booleanValue(), false);
                Assert.assertEquals(subList.countOfPara(), 1);

                CellAddr cellAddr = tc.cellAddr();
                Assert.assertNotNull(cellAddr);
                Assert.assertEquals(cellAddr.colAddr().shortValue(), 0);
                Assert.assertEquals(cellAddr.rowAddr().shortValue(), 0);

                CellSpan cellSpan = tc.cellSpan();
                Assert.assertNotNull(cellSpan);
                Assert.assertEquals(cellSpan.colSpan().shortValue(), 2);
                Assert.assertEquals(cellSpan.rowSpan().shortValue(), 2);

                WidthAndHeight cellSz = tc.cellSz();
                Assert.assertNotNull(cellSz);
                Assert.assertEquals(cellSz.width().intValue(), 12688);
                Assert.assertEquals(cellSz.height().intValue(), 5772);

                LeftRightTopBottom cellMargin = tc.cellMargin();
                Assert.assertNotNull(cellMargin);
                Assert.assertEquals(cellMargin.left().intValue(), 510);
                Assert.assertEquals(cellMargin.right().intValue(), 510);
                Assert.assertEquals(cellMargin.top().intValue(), 141);
                Assert.assertEquals(cellMargin.bottom().intValue(), 141);
            }
            {
                Tc tc = tr.getTc(1);
                Assert.assertEquals(tc.name(), "");
                Assert.assertEquals(tc.header().booleanValue(), false);
                Assert.assertEquals(tc.hasMargin().booleanValue(), false);
                Assert.assertEquals(tc.protect().booleanValue(), false);
                Assert.assertEquals(tc.editable().booleanValue(), false);
                Assert.assertEquals(tc.dirty().booleanValue(), false);
                Assert.assertEquals(tc.borderFillIDRef(), "3");

                SubList subList = tc.subList();
                Assert.assertNotNull(subList);
                Assert.assertEquals(subList.id(), "");
                Assert.assertEquals(subList.textDirection(), TextDirection.HORIZONTAL);
                Assert.assertEquals(subList.lineWrap(), LineWrapMethod.BREAK);
                Assert.assertEquals(subList.vertAlign(), VerticalAlign2.CENTER);
                Assert.assertEquals(subList.linkListIDRef(), "0");
                Assert.assertEquals(subList.linkListNextIDRef(), "0");
                Assert.assertEquals(subList.textWidth().intValue(), 0);
                Assert.assertEquals(subList.textHeight().intValue(), 0);
                Assert.assertEquals(subList.hasTextRef().booleanValue(), false);
                Assert.assertEquals(subList.hasNumRef().booleanValue(), false);
                Assert.assertEquals(subList.countOfPara(), 1);

                CellAddr cellAddr = tc.cellAddr();
                Assert.assertNotNull(cellAddr);
                Assert.assertEquals(cellAddr.colAddr().shortValue(), 2);
                Assert.assertEquals(cellAddr.rowAddr().shortValue(), 0);

                CellSpan cellSpan = tc.cellSpan();
                Assert.assertNotNull(cellSpan);
                Assert.assertEquals(cellSpan.colSpan().shortValue(), 1);
                Assert.assertEquals(cellSpan.rowSpan().shortValue(), 1);

                WidthAndHeight cellSz = tc.cellSz();
                Assert.assertNotNull(cellSz);
                Assert.assertEquals(cellSz.width().intValue(), 6341);
                Assert.assertEquals(cellSz.height().intValue(), 2886);

                LeftRightTopBottom cellMargin = tc.cellMargin();
                Assert.assertNotNull(cellMargin);
                Assert.assertEquals(cellMargin.left().intValue(), 510);
                Assert.assertEquals(cellMargin.right().intValue(), 510);
                Assert.assertEquals(cellMargin.top().intValue(), 141);
                Assert.assertEquals(cellMargin.bottom().intValue(), 141);
            }
        }

        {
            Tr tr = table.getTr(1);
            Assert.assertEquals(1, tr.countOfTc());
            {
                Tc tc = tr.getTc(0);
                Assert.assertEquals(tc.name(), "");
                Assert.assertEquals(tc.header().booleanValue(), false);
                Assert.assertEquals(tc.hasMargin().booleanValue(), false);
                Assert.assertEquals(tc.protect().booleanValue(), false);
                Assert.assertEquals(tc.editable().booleanValue(), false);
                Assert.assertEquals(tc.dirty().booleanValue(), false);
                Assert.assertEquals(tc.borderFillIDRef(), "3");

                SubList subList = tc.subList();
                Assert.assertNotNull(subList);
                Assert.assertEquals(subList.id(), "");
                Assert.assertEquals(subList.textDirection(), TextDirection.HORIZONTAL);
                Assert.assertEquals(subList.lineWrap(), LineWrapMethod.BREAK);
                Assert.assertEquals(subList.vertAlign(), VerticalAlign2.CENTER);
                Assert.assertEquals(subList.linkListIDRef(), "0");
                Assert.assertEquals(subList.linkListNextIDRef(), "0");
                Assert.assertEquals(subList.textWidth().intValue(), 0);
                Assert.assertEquals(subList.textHeight().intValue(), 0);
                Assert.assertEquals(subList.hasTextRef().booleanValue(), false);
                Assert.assertEquals(subList.hasNumRef().booleanValue(), false);
                Assert.assertEquals(subList.countOfPara(), 1);

                CellAddr cellAddr = tc.cellAddr();
                Assert.assertNotNull(cellAddr);
                Assert.assertEquals(cellAddr.colAddr().shortValue(), 2);
                Assert.assertEquals(cellAddr.rowAddr().shortValue(), 1);

                CellSpan cellSpan = tc.cellSpan();
                Assert.assertNotNull(cellSpan);
                Assert.assertEquals(cellSpan.colSpan().shortValue(), 1);
                Assert.assertEquals(cellSpan.rowSpan().shortValue(), 1);

                WidthAndHeight cellSz = tc.cellSz();
                Assert.assertNotNull(cellSz);
                Assert.assertEquals(cellSz.width().intValue(), 6341);
                Assert.assertEquals(cellSz.height().intValue(), 2886);

                LeftRightTopBottom cellMargin = tc.cellMargin();
                Assert.assertNotNull(cellMargin);
                Assert.assertEquals(cellMargin.left().intValue(), 510);
                Assert.assertEquals(cellMargin.right().intValue(), 510);
                Assert.assertEquals(cellMargin.top().intValue(), 141);
                Assert.assertEquals(cellMargin.bottom().intValue(), 141);
            }
        }

        {
            Tr tr = table.getTr(2);
            Assert.assertEquals(2, tr.countOfTc());
            {
                Tc tc = tr.getTc(0);
                Assert.assertEquals(tc.name(), "");
                Assert.assertEquals(tc.header().booleanValue(), false);
                Assert.assertEquals(tc.hasMargin().booleanValue(), false);
                Assert.assertEquals(tc.protect().booleanValue(), false);
                Assert.assertEquals(tc.editable().booleanValue(), false);
                Assert.assertEquals(tc.dirty().booleanValue(), false);
                Assert.assertEquals(tc.borderFillIDRef(), "3");

                SubList subList = tc.subList();
                Assert.assertNotNull(subList);
                Assert.assertEquals(subList.id(), "");
                Assert.assertEquals(subList.textDirection(), TextDirection.HORIZONTAL);
                Assert.assertEquals(subList.lineWrap(), LineWrapMethod.BREAK);
                Assert.assertEquals(subList.vertAlign(), VerticalAlign2.CENTER);
                Assert.assertEquals(subList.linkListIDRef(), "0");
                Assert.assertEquals(subList.linkListNextIDRef(), "0");
                Assert.assertEquals(subList.textWidth().intValue(), 0);
                Assert.assertEquals(subList.textHeight().intValue(), 0);
                Assert.assertEquals(subList.hasTextRef().booleanValue(), false);
                Assert.assertEquals(subList.hasNumRef().booleanValue(), false);
                Assert.assertEquals(subList.countOfPara(), 1);

                CellAddr cellAddr = tc.cellAddr();
                Assert.assertNotNull(cellAddr);
                Assert.assertEquals(cellAddr.colAddr().shortValue(), 0);
                Assert.assertEquals(cellAddr.rowAddr().shortValue(), 2);

                CellSpan cellSpan = tc.cellSpan();
                Assert.assertNotNull(cellSpan);
                Assert.assertEquals(cellSpan.colSpan().shortValue(), 1);
                Assert.assertEquals(cellSpan.rowSpan().shortValue(), 1);

                WidthAndHeight cellSz = tc.cellSz();
                Assert.assertNotNull(cellSz);
                Assert.assertEquals(cellSz.width().intValue(), 6344);
                Assert.assertEquals(cellSz.height().intValue(), 2885);

                LeftRightTopBottom cellMargin = tc.cellMargin();
                Assert.assertNotNull(cellMargin);
                Assert.assertEquals(cellMargin.left().intValue(), 510);
                Assert.assertEquals(cellMargin.right().intValue(), 510);
                Assert.assertEquals(cellMargin.top().intValue(), 141);
                Assert.assertEquals(cellMargin.bottom().intValue(), 141);
            }
            {
                Tc tc = tr.getTc(1);
                Assert.assertEquals("", tc.name());
                Assert.assertEquals(tc.header().booleanValue(), false);
                Assert.assertEquals(tc.hasMargin().booleanValue(), false);
                Assert.assertEquals(tc.protect().booleanValue(), false);
                Assert.assertEquals(tc.editable().booleanValue(), false);
                Assert.assertEquals(tc.dirty().booleanValue(), false);
                Assert.assertEquals(tc.borderFillIDRef(), "3");

                SubList subList = tc.subList();
                Assert.assertNotNull(subList);
                Assert.assertEquals(subList.id(), "");
                Assert.assertEquals(subList.textDirection(), TextDirection.HORIZONTAL);
                Assert.assertEquals(subList.lineWrap(), LineWrapMethod.BREAK);
                Assert.assertEquals(subList.vertAlign(), VerticalAlign2.CENTER);
                Assert.assertEquals(subList.linkListIDRef(), "0");
                Assert.assertEquals(subList.linkListNextIDRef(), "0");
                Assert.assertEquals(subList.textWidth().intValue(), 0);
                Assert.assertEquals(subList.textHeight().intValue(), 0);
                Assert.assertEquals(subList.hasTextRef().booleanValue(), false);
                Assert.assertEquals(subList.hasNumRef().booleanValue(), false);
                Assert.assertEquals(subList.countOfPara(), 1);

                CellAddr cellAddr = tc.cellAddr();
                Assert.assertNotNull(cellAddr);
                Assert.assertEquals(cellAddr.colAddr().shortValue(), 1);
                Assert.assertEquals(cellAddr.rowAddr().shortValue(), 2);

                CellSpan cellSpan = tc.cellSpan();
                Assert.assertNotNull(cellSpan);
                Assert.assertEquals(cellSpan.colSpan().shortValue(), 2);
                Assert.assertEquals(cellSpan.rowSpan().shortValue(), 1);

                WidthAndHeight cellSz = tc.cellSz();
                Assert.assertNotNull(cellSz);
                Assert.assertEquals(cellSz.width().intValue(), 12685);
                Assert.assertEquals(cellSz.height().intValue(), 2885);

                LeftRightTopBottom cellMargin = tc.cellMargin();
                Assert.assertNotNull(cellMargin);
                Assert.assertEquals(cellMargin.left().intValue(), 510);
                Assert.assertEquals(cellMargin.right().intValue(), 510);
                Assert.assertEquals(cellMargin.top().intValue(), 141);
                Assert.assertEquals(cellMargin.bottom().intValue(), 141);
            }
        }
    }
}
