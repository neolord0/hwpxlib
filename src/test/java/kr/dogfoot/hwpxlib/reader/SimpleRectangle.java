package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Rectangle;
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

public class SimpleRectangle {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleRectangle.hwpx");
        Rectangle rectangle = (Rectangle) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(rectangle);
        Assert.assertEquals(rectangle.id(), "1143196392");
        Assert.assertEquals(rectangle.zOrder().intValue(), 0);
        Assert.assertEquals(rectangle.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(rectangle.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(rectangle.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(rectangle.lock().booleanValue(), false);
        Assert.assertEquals(rectangle.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(rectangle.href(), "");
        Assert.assertEquals(rectangle.groupLevel().intValue(), 0);
        Assert.assertEquals(rectangle.instid(), "69454569");
        Assert.assertEquals(rectangle.ratio().shortValue(), 0);

        XAndY offset = rectangle.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = rectangle.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 20925);
        Assert.assertEquals(orgSZ.height().intValue(), 14175);

        WidthAndHeight curSz = rectangle.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = rectangle.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = rectangle.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 10462);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 7087);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = rectangle.renderingInfo();
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

        LineShape lineShape = rectangle.lineShape();
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

        FillBrush fillBrush = rectangle.fillBrush();
        Assert.assertNotNull(fillBrush);
        WinBrush winBrush = fillBrush.winBrush();
        Assert.assertNotNull(winBrush);
        Assert.assertEquals(winBrush.faceColor(), "#86AFDC");
        Assert.assertEquals(winBrush.hatchColor(), "#D8D8D8");
        Assert.assertEquals(winBrush.alpha().floatValue(), 0);

        DrawingShadow shadow = rectangle.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.NONE);
        Assert.assertEquals(shadow.color(), "#B2B2B2");
        Assert.assertEquals(shadow.offsetX().intValue(), 0);
        Assert.assertEquals(shadow.offsetY().intValue(), 0);
        Assert.assertEquals(shadow.alpha().floatValue(), 0);

        DrawText drawText = rectangle.drawText();
        Assert.assertNotNull(drawText);
        Assert.assertEquals(drawText.lastWidth().intValue(), 20925);
        Assert.assertEquals(drawText.name(), "");
        Assert.assertEquals(drawText.editable().booleanValue(), false);
        Assert.assertNotNull(drawText.subList());

        Point pt0 = rectangle.pt0();
        Assert.assertNotNull(pt0);
        Assert.assertEquals(pt0.x().intValue(), 0);
        Assert.assertEquals(pt0.y().intValue(), 0);

        Point pt1 = rectangle.pt1();
        Assert.assertNotNull(pt1);
        Assert.assertEquals(pt1.x().intValue(), 20925);
        Assert.assertEquals(pt1.y().intValue(), 0);

        Point pt2 = rectangle.pt2();
        Assert.assertNotNull(pt2);
        Assert.assertEquals(pt2.x().intValue(), 20925);
        Assert.assertEquals(pt2.y().intValue(), 14175);

        Point pt3 = rectangle.pt3();
        Assert.assertNotNull(pt3);
        Assert.assertEquals(pt3.x().intValue(), 0);
        Assert.assertEquals(pt3.y().intValue(), 14175);

        ShapeSize sz = rectangle.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 20925);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 14175);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = rectangle.pos();
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
        Assert.assertEquals(pos.vertOffset().intValue(), 13075);
        Assert.assertEquals(pos.horzOffset().intValue(), 16664);

        LeftRightTopBottom outMargin = rectangle.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        Caption caption = rectangle.caption();
        Assert.assertNotNull(caption);
        Assert.assertEquals(caption.side(), CaptionSide.BOTTOM);
        Assert.assertEquals(caption.fullSz().booleanValue(), false);
        Assert.assertEquals(caption.width().intValue(), 8504);
        Assert.assertEquals(caption.gap().intValue(), 850);
        Assert.assertEquals(caption.lastWidth().intValue(), 20925);
        Assert.assertNotNull(caption.subList());

        HasOnlyText shapeComment = rectangle.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "사각형입니다.");
    }
}
