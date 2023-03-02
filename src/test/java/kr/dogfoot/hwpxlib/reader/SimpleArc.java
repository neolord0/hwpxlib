package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Arc;
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

public class SimpleArc {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleArc.hwpx");
        Arc arc = (Arc) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(2);

        Assert.assertNotNull(arc);
        Assert.assertEquals(arc.id(), "1143253037");
        Assert.assertEquals(arc.zOrder().intValue(), 0);
        Assert.assertEquals(arc.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(arc.textWrap(), TextWrapMethod.TOP_AND_BOTTOM);
        Assert.assertEquals(arc.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(arc.lock().booleanValue(), false);
        Assert.assertEquals(arc.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(arc.href(), "");
        Assert.assertEquals(arc.groupLevel().intValue(), 0);
        Assert.assertEquals(arc.instid(), "69511214");
        Assert.assertEquals(arc.type(), ArcType.PIE);


        XAndY offset = arc.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = arc.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 12450);
        Assert.assertEquals(orgSZ.height().intValue(), 11225);

        WidthAndHeight curSz = arc.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = arc.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = arc.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 6225);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 5612);
        Assert.assertEquals(rotationInfo.rotateImage().booleanValue(), true);

        RenderingInfo renderingInfo = arc.renderingInfo();
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

        LineShape lineShape = arc.lineShape();
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


        FillBrush fillBrush = arc.fillBrush();
        Assert.assertNotNull(fillBrush);
        WinBrush winBrush = fillBrush.winBrush();
        Assert.assertNotNull(winBrush);
        Assert.assertEquals(winBrush.faceColor(), "#F1CB7E");
        Assert.assertEquals(winBrush.hatchColor(), "#000000");
        Assert.assertEquals(winBrush.alpha().floatValue(), 0);

        DrawingShadow shadow = arc.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.PARELLEL_LEFTTOP);
        Assert.assertEquals(shadow.color(), "#C1D6ED");
        Assert.assertEquals(shadow.offsetX().intValue(), 0);
        Assert.assertEquals(shadow.offsetY().intValue(), 0);
        Assert.assertEquals(shadow.alpha().floatValue(), 0);


        Point center = arc.center();
        Assert.assertNotNull(center);
        Assert.assertEquals(center.x().intValue(), 0);
        Assert.assertEquals(center.y().intValue(), 0);

        Point ax1 = arc.ax1();
        Assert.assertNotNull(ax1);
        Assert.assertEquals(ax1.x().intValue(), 0);
        Assert.assertEquals(ax1.y().intValue(), 11225);

        Point ax2 = arc.ax2();
        Assert.assertNotNull(ax2);
        Assert.assertEquals(ax2.x().intValue(), 12450);
        Assert.assertEquals(ax2.y().intValue(), 0);

        ShapeSize sz = arc.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 12450);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 11225);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = arc.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), true);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), false);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.PARA);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().intValue(), 0);
        Assert.assertEquals(pos.horzOffset().intValue(), 0);

        LeftRightTopBottom outMargin = arc.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        Caption caption = arc.caption();
        Assert.assertNull(caption);

        HasOnlyText shapeComment = arc.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "호입니다.");
    }
}
