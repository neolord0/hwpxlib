package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.GradationType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Color;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Gradation;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Ellipse;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleEllipse {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleEllipse.hwpx");
        Ellipse ellipse = (Ellipse) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(ellipse);
        Assert.assertEquals(ellipse.id(), "1143227146");
        Assert.assertEquals(ellipse.zOrder().intValue(), 0);
        Assert.assertEquals(ellipse.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(ellipse.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(ellipse.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(ellipse.lock().booleanValue(), false);
        Assert.assertEquals(ellipse.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(ellipse.href(), "");
        Assert.assertEquals(ellipse.groupLevel().intValue(), 0);
        Assert.assertEquals(ellipse.instid(), "69485323");
        Assert.assertEquals(ellipse.intervalDirty().booleanValue(), false);
        Assert.assertEquals(ellipse.hasArcPr().booleanValue(), false);
        Assert.assertEquals(ellipse.arcType(), ArcType.NORMAL);

        XAndY offset = ellipse.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = ellipse.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 27950);
        Assert.assertEquals(orgSZ.height().intValue(), 15150);

        WidthAndHeight curSz = ellipse.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = ellipse.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = ellipse.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 13975);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 7575);
        Assert.assertEquals(rotationInfo.rotateImage().booleanValue(), true);

        RenderingInfo renderingInfo = ellipse.renderingInfo();
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

        LineShape lineShape = ellipse.lineShape();
        Assert.assertNotNull(lineShape);
        Assert.assertEquals(lineShape.color(), "#BD3D3D");
        Assert.assertEquals(lineShape.width().intValue(), 1133);
        Assert.assertEquals(lineShape.style(), LineType2.DOT);
        Assert.assertEquals(lineShape.endCap(), LineCap.FLAT);
        Assert.assertEquals(lineShape.headStyle(), ArrowType.NORMAL);
        Assert.assertEquals(lineShape.tailStyle(), ArrowType.NORMAL);
        Assert.assertEquals(lineShape.headfill().booleanValue(), true);
        Assert.assertEquals(lineShape.tailfill().booleanValue(), true);
        Assert.assertEquals(lineShape.headSz(), ArrowSize.MEDIUM_MEDIUM);
        Assert.assertEquals(lineShape.tailSz(), ArrowSize.MEDIUM_MEDIUM);
        Assert.assertEquals(lineShape.outlineStyle(), OutlineStyle.NORMAL);
        Assert.assertEquals(lineShape.alpha().floatValue(), 0);

        FillBrush fillBrush = ellipse.fillBrush();
        Assert.assertNotNull(fillBrush);
        Gradation gradation = fillBrush.gradation();
        Assert.assertNotNull(gradation);
        Assert.assertEquals(gradation.type(), GradationType.LINEAR);
        Assert.assertEquals(gradation.angle().intValue(), 0);
        Assert.assertEquals(gradation.centerX().intValue(), 50);
        Assert.assertEquals(gradation.centerY().intValue(), 50);
        Assert.assertEquals(gradation.step().shortValue(), 255);
        Assert.assertEquals(gradation.colorNum(), 2);
        Assert.assertEquals(gradation.stepCenter().shortValue(), 50);
        Assert.assertEquals(gradation.alpha().floatValue(), 0);

        int index = 0;
        for (Color color : gradation.colors()) {
            switch (index) {
                case 0:
                    Assert.assertEquals(color.value(), "#FFFFFF");
                    break;
                case 1:
                    Assert.assertEquals(color.value(), "#4B87CB");
                    break;
                default:
                    Assert.fail();
                    break;
            }
            index++;
        }


        DrawingShadow shadow = ellipse.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.NONE);
        Assert.assertEquals(shadow.color(), "#B2B2B2");
        Assert.assertEquals(shadow.offsetX().intValue(), 0);
        Assert.assertEquals(shadow.offsetY().intValue(), 0);
        Assert.assertEquals(shadow.alpha().floatValue(), 0);

        DrawText drawText = ellipse.drawText();
        Assert.assertNull(drawText);

        Point center = ellipse.center();
        Assert.assertNotNull(center);
        Assert.assertEquals(center.x().intValue(), 13975);
        Assert.assertEquals(center.y().intValue(), 7575);

        Point ax1 = ellipse.ax1();
        Assert.assertNotNull(ax1);
        Assert.assertEquals(ax1.x().intValue(), 27950);
        Assert.assertEquals(ax1.y().intValue(), 7575);

        Point ax2 = ellipse.ax2();
        Assert.assertNotNull(ax2);
        Assert.assertEquals(ax2.x().intValue(), 13975);
        Assert.assertEquals(ax2.y().intValue(), 0);

        Point start1 = ellipse.start1();
        Assert.assertNotNull(start1);
        Assert.assertEquals(start1.x().intValue(), 1106);
        Assert.assertEquals(start1.y().intValue(), 2341);

        Point end1 = ellipse.end1();
        Assert.assertNotNull(end1);
        Assert.assertEquals(end1.x().intValue(), 1113);
        Assert.assertEquals(end1.y().intValue(), 2368);

        Point start2 = ellipse.start2();
        Assert.assertNotNull(start2);
        Assert.assertEquals(start2.x().intValue(), 1119);
        Assert.assertEquals(start2.y().intValue(), 2395);

        Point end2 = ellipse.end2();
        Assert.assertNotNull(end2);
        Assert.assertEquals(end2.x().intValue(), 1124);
        Assert.assertEquals(end2.y().intValue(), 2423);

        ShapeSize sz = ellipse.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 27950);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 15150);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = ellipse.pos();
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
        Assert.assertEquals(pos.vertOffset().intValue(), 12425);
        Assert.assertEquals(pos.horzOffset().intValue(), 17214);

        LeftRightTopBottom outMargin = ellipse.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 283);
        Assert.assertEquals(outMargin.right().intValue(), 566);
        Assert.assertEquals(outMargin.top().intValue(), 850);
        Assert.assertEquals(outMargin.bottom().intValue(), 1133);

        Caption caption = ellipse.caption();
        Assert.assertNull(caption);

        HasOnlyText shapeComment = ellipse.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "타원입니다.");
    }
}
