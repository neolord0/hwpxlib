package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.TextArt;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.textart.TextArtPr;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTextArt {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleTextArt.hwpx");
        TextArt textArt = (TextArt) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(textArt);
        Assert.assertEquals(textArt.id(), "1143409969");
        Assert.assertEquals(textArt.zOrder().intValue(), 0);
        Assert.assertEquals(textArt.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(textArt.textWrap(), TextWrapMethod.SQUARE);
        Assert.assertEquals(textArt.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(textArt.lock().booleanValue(), false);
        Assert.assertEquals(textArt.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(textArt.href(), "");
        Assert.assertEquals(textArt.groupLevel().intValue(), 0);
        Assert.assertEquals(textArt.instid(), "69668146");
        Assert.assertEquals(textArt.text(), "hwpx 라이브러리 테스트 입니다.␍␊neolord");

        XAndY offset = textArt.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = textArt.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 14173);
        Assert.assertEquals(orgSZ.height().intValue(), 14173);

        WidthAndHeight curSz = textArt.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 40500);
        Assert.assertEquals(curSz.height().intValue(), 16000);

        Flip flip = textArt.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = textArt.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 20250);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 8000);
        Assert.assertEquals(rotationInfo.rotateImage().booleanValue(), true);

        RenderingInfo renderingInfo = textArt.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.transMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.transMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.transMatrix().e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e1().floatValue(), 2.857546f);
        Assert.assertEquals(renderingInfo.scaMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e5().floatValue(), 1.128907f);
        Assert.assertEquals(renderingInfo.scaMatrix().e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.rotMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.rotMatrix().e6().floatValue(), 0);

        LineShape lineShape = textArt.lineShape();
        Assert.assertNotNull(lineShape);
        Assert.assertEquals(lineShape.color(), "#000000");
        Assert.assertEquals(lineShape.width().intValue(), 0);
        Assert.assertEquals(lineShape.style(), LineType2.NONE);
        Assert.assertEquals(lineShape.endCap(), LineCap.ROUND);
        Assert.assertEquals(lineShape.headStyle(), ArrowType.NORMAL);
        Assert.assertEquals(lineShape.tailStyle(), ArrowType.NORMAL);
        Assert.assertEquals(lineShape.headfill().booleanValue(), false);
        Assert.assertEquals(lineShape.tailfill().booleanValue(), false);
        Assert.assertEquals(lineShape.headSz(), ArrowSize.SMALL_SMALL);
        Assert.assertEquals(lineShape.tailSz(), ArrowSize.SMALL_SMALL);
        Assert.assertEquals(lineShape.outlineStyle(), OutlineStyle.INNER);
        Assert.assertEquals(lineShape.alpha().floatValue(), 0f);

        FillBrush fillBrush = textArt.fillBrush();
        Assert.assertNotNull(fillBrush);
        WinBrush winBrush = fillBrush.winBrush();
        Assert.assertNotNull(winBrush);
        Assert.assertEquals(winBrush.faceColor(), "#0000FF");
        Assert.assertEquals(winBrush.hatchColor(), "#000000");
        Assert.assertEquals(winBrush.alpha().floatValue(), 0);

        DrawingShadow shadow = textArt.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.NONE);
        Assert.assertEquals(shadow.color(), "#B2B2B2");
        Assert.assertEquals(shadow.offsetX().intValue(), 0);
        Assert.assertEquals(shadow.offsetY().intValue(), 0);
        Assert.assertEquals(shadow.alpha().floatValue(), 0);

        Point pt0 = textArt.pt0();
        Assert.assertNotNull(pt0);
        Assert.assertEquals(pt0.x().longValue(), 0);
        Assert.assertEquals(pt0.y().longValue(), 0);

        Point pt1 = textArt.pt1();
        Assert.assertNotNull(pt1);
        Assert.assertEquals(pt1.x().longValue(), 14173);
        Assert.assertEquals(pt1.y().longValue(), 0);

        Point pt2 = textArt.pt2();
        Assert.assertNotNull(pt2);
        Assert.assertEquals(pt2.x().longValue(), 14173);
        Assert.assertEquals(pt2.y().longValue(), 14173);

        Point pt3 = textArt.pt3();
        Assert.assertNotNull(pt3);
        Assert.assertEquals(pt3.x().longValue(), 0);
        Assert.assertEquals(pt3.y().longValue(), 14173);

        TextArtPr textartPr = textArt.textartPr();
        Assert.assertNotNull(textartPr);
        Assert.assertEquals(textartPr.fontName(), "함초롬바탕");
        Assert.assertEquals(textartPr.fontStyle(), "진하게");
        Assert.assertEquals(textartPr.fontType(), FontType2.TTF);
        Assert.assertEquals(textartPr.textShape(), TextArtShape.THIN_CURVE_DOWN1);
        Assert.assertEquals(textartPr.lineSpacing().intValue(), 120);
        Assert.assertEquals(textartPr.charSpacing().intValue(), 100);
        Assert.assertEquals(textartPr.align(), TextArtAlign.LEFT);
        DrawingShadow shadow2 = textartPr.shadow();
        Assert.assertNotNull(shadow2);
        Assert.assertEquals(shadow2.type(), DrawingShadowType.NONE);
        Assert.assertEquals(shadow2.color(), "#63AA0D78");
        Assert.assertEquals(shadow2.offsetX().longValue(), 1668812096L);
        Assert.assertEquals(shadow2.offsetY().longValue(), 191099024L);
        Assert.assertEquals(shadow2.alpha().floatValue(), 0);

        ShapeSize sz = textArt.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 40500);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 16000);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = textArt.pos();
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

        LeftRightTopBottom outMargin = textArt.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 56);
        Assert.assertEquals(outMargin.right().intValue(), 56);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        Caption caption = textArt.caption();
        Assert.assertNull(caption);

        HasOnlyText shapeComment = textArt.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "글맵시입니다.");
    }
}
