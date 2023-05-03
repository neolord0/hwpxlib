package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ConnectLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.ConnectLinePoint;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.junit.Assert;
import org.junit.Test;

public class SimpleConnectLine {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimpleConnectLine.hwpx");
        ConnectLine connectLine = (ConnectLine) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(3);

        Assert.assertNotNull(connectLine);
        Assert.assertEquals(connectLine.id(), "1143370512");
        Assert.assertEquals(connectLine.zOrder().intValue(), 2);
        Assert.assertEquals(connectLine.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(connectLine.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(connectLine.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(connectLine.lock().booleanValue(), false);
        Assert.assertEquals(connectLine.dropcapstyle(), DropCapStyle.None);
        Assert.assertEquals(connectLine.href(), "");
        Assert.assertEquals(connectLine.groupLevel().intValue(), 0);
        Assert.assertEquals(connectLine.instid(), "69628689");
        Assert.assertEquals(connectLine.type(), ConnectLineType.STROKE_NOARROW);

        XAndY offset = connectLine.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().longValue(), 4294966971L);
        Assert.assertEquals(offset.y().longValue(), 4294965647L);
        WidthAndHeight orgSZ = connectLine.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 9000);
        Assert.assertEquals(orgSZ.height().intValue(), 5900);

        WidthAndHeight curSz = connectLine.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 10562);
        Assert.assertEquals(curSz.height().intValue(), 4988);

        Flip flip = connectLine.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = connectLine.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 5281);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 2494);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = connectLine.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.getMatrix(0).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e3().floatValue(), -325, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e6().floatValue(), -1649, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e1().floatValue(), 1.173556f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e3().floatValue(), 325, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e5().floatValue(), 0.845424f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e6().floatValue(), 1649, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e6().floatValue(), 0, 0);


        LineShape lineShape = connectLine.lineShape();
        Assert.assertNotNull(lineShape);
        Assert.assertEquals(lineShape.color(), "#000000");
        Assert.assertEquals(lineShape.width().intValue(), 33);
        Assert.assertEquals(lineShape.style(), LineType2.SOLID);
        Assert.assertEquals(lineShape.endCap(), LineCap.FLAT);
        Assert.assertEquals(lineShape.headStyle(), ArrowType.NORMAL);
        Assert.assertEquals(lineShape.tailStyle(), ArrowType.NORMAL);
        Assert.assertEquals(lineShape.headfill().booleanValue(), true);
        Assert.assertEquals(lineShape.tailfill().booleanValue(), true);
        Assert.assertEquals(lineShape.headSz(), ArrowSize.MEDIUM_MEDIUM);
        Assert.assertEquals(lineShape.tailSz(), ArrowSize.MEDIUM_MEDIUM);
        Assert.assertEquals(lineShape.outlineStyle(), OutlineStyle.NORMAL);
        Assert.assertEquals(lineShape.alpha().floatValue(), 0f, 0);

        FillBrush fillBrush = connectLine.fillBrush();
        Assert.assertNull(fillBrush);

        DrawingShadow shadow = connectLine.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.NONE);
        Assert.assertEquals(shadow.color(), "#B2B2B2");
        Assert.assertEquals(shadow.offsetX().intValue(), 0);
        Assert.assertEquals(shadow.offsetY().intValue(), 0);
        Assert.assertEquals(shadow.alpha().floatValue(), 0f, 0);

        ConnectLinePoint startPt = connectLine.startPt();
        Assert.assertNotNull(startPt);
        Assert.assertEquals(startPt.x().longValue(), 0);
        Assert.assertEquals(startPt.y().longValue(), 5900);
        Assert.assertEquals(startPt.subjectIDRef(), "69628685");
        Assert.assertEquals(startPt.subjectIdx().shortValue(), 1);

        ConnectLinePoint endPt = connectLine.endPt();
        Assert.assertNotNull(endPt);
        Assert.assertEquals(endPt.x().longValue(), 9000);
        Assert.assertEquals(endPt.y().longValue(), 0);
        Assert.assertEquals(endPt.subjectIDRef(), "69628687");
        Assert.assertEquals(endPt.subjectIdx().shortValue(), 2);


        ShapeSize sz = connectLine.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().longValue(), 10562);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().longValue(), 4988);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = connectLine.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), false);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), false);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PAPER);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.PAPER);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().longValue(), 16074);
        Assert.assertEquals(pos.horzOffset().longValue(), 19389);

        LeftRightTopBottom outMargin = connectLine.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().longValue(), 0);
        Assert.assertEquals(outMargin.right().longValue(), 0);
        Assert.assertEquals(outMargin.top().longValue(), 0);
        Assert.assertEquals(outMargin.bottom().longValue(), 0);

        HasOnlyText shapeComment = connectLine.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "개체 연결선입니다.");
    }
}