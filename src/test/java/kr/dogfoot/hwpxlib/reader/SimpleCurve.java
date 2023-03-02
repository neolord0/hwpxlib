package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Curve;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleCurve {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleCurve.hwpx");
        Curve curve = (Curve) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(curve);
        Assert.assertEquals(curve.id(), "1143293629");
        Assert.assertEquals(curve.zOrder().intValue(), 0);
        Assert.assertEquals(curve.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(curve.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(curve.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(curve.lock().booleanValue(), false);
        Assert.assertEquals(curve.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(curve.href(), "");
        Assert.assertEquals(curve.groupLevel().intValue(), 0);
        Assert.assertEquals(curve.instid(), "69551806");

        XAndY offset = curve.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = curve.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 16636);
        Assert.assertEquals(orgSZ.height().intValue(), 21360);

        WidthAndHeight curSz = curve.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = curve.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = curve.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 8318);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 10680);
        Assert.assertEquals(rotationInfo.rotateImage().booleanValue(), true);

        RenderingInfo renderingInfo = curve.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.transMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.transMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.transMatrix().e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.scaMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.scaMatrix().e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.rotMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.rotMatrix().e6().floatValue(), 0);

        LineShape lineShape = curve.lineShape();
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
        Assert.assertEquals(lineShape.alpha().floatValue(), 0f);

        FillBrush fillBrush = curve.fillBrush();
        Assert.assertNotNull(fillBrush);
        WinBrush winBrush = fillBrush.winBrush();
        Assert.assertNotNull(winBrush);
        Assert.assertEquals(winBrush.faceColor(), "#FFFFFF");
        Assert.assertEquals(winBrush.hatchColor(), "#000000");
        Assert.assertEquals(winBrush.alpha().floatValue(), 0);

        DrawingShadow shadow = curve.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.PARELLEL_RIGHTTOP);
        Assert.assertEquals(shadow.color(), "#A0BEE0");
        Assert.assertEquals(shadow.offsetX().intValue(), 283);
        Assert.assertEquals(shadow.offsetY().intValue(), 283);
        Assert.assertEquals(shadow.alpha().floatValue(), 10);

        int index = 0;
        for (CurveSegment seg : curve.segs()) {
            switch (index) {
                case 0:
                    Assert.assertEquals(seg.type(), CurveSegmentType.CURVE);
                    Assert.assertEquals(seg.x1().intValue(), 450);
                    Assert.assertEquals(seg.y1().intValue(), 6140);
                    Assert.assertEquals(seg.x2().intValue(), 8000);
                    Assert.assertEquals(seg.y2().intValue(), 11215);
                    break;
                case 1:
                    Assert.assertEquals(seg.type(), CurveSegmentType.CURVE);
                    Assert.assertEquals(seg.x1().intValue(), 8000);
                    Assert.assertEquals(seg.y1().intValue(), 11215);
                    Assert.assertEquals(seg.x2().intValue(), 2500);
                    Assert.assertEquals(seg.y2().intValue(), 19340);
                    break;
                case 2:
                    Assert.assertEquals(seg.type(), CurveSegmentType.CURVE);
                    Assert.assertEquals(seg.x1().intValue(), 2500);
                    Assert.assertEquals(seg.y1().intValue(), 19340);
                    Assert.assertEquals(seg.x2().intValue(), 14175);
                    Assert.assertEquals(seg.y2().intValue(), 20515);
                    break;
                case 3:
                    Assert.assertEquals(seg.type(), CurveSegmentType.CURVE);
                    Assert.assertEquals(seg.x1().intValue(), 14175);
                    Assert.assertEquals(seg.y1().intValue(), 20515);
                    Assert.assertEquals(seg.x2().intValue(), 15675);
                    Assert.assertEquals(seg.y2().intValue(), 8440);
                    break;
                case 4:
                    Assert.assertEquals(seg.type(), CurveSegmentType.CURVE);
                    Assert.assertEquals(seg.x1().intValue(), 15675);
                    Assert.assertEquals(seg.y1().intValue(), 8440);
                    Assert.assertEquals(seg.x2().intValue(), 2475);
                    Assert.assertEquals(seg.y2().intValue(), 15);
                    break;
                case 5:
                    Assert.assertEquals(seg.type(), CurveSegmentType.CURVE);
                    Assert.assertEquals(seg.x1().intValue(), 2475);
                    Assert.assertEquals(seg.y1().intValue(), 15);
                    Assert.assertEquals(seg.x2().intValue(), 450);
                    Assert.assertEquals(seg.y2().intValue(), 6140);
                    break;
                default:
                    Assert.fail();
                    break;
            }

            index++;
        }

        ShapeSize sz = curve.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 16636);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 21360);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = curve.pos();
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
        Assert.assertEquals(pos.vertOffset().intValue(), 12660);
        Assert.assertEquals(pos.horzOffset().intValue(), 18564);

        LeftRightTopBottom outMargin = curve.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        HasOnlyText shapeComment = curve.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "곡선입니다.");
    }
}
