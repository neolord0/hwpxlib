package kr.dogfoot.hwpxlib.clone;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageBrushMode;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageEffect;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.ImgBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Polygon;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class SimplePolygon {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimplePolygon.hwpx");
        file = file.clone();

        Polygon polygon = (Polygon) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(polygon);
        Assert.assertEquals(polygon.id(), "1143268355");
        Assert.assertEquals(polygon.zOrder().intValue(), 0);
        Assert.assertEquals(polygon.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(polygon.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(polygon.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(polygon.lock().booleanValue(), false);
        Assert.assertEquals(polygon.dropcapstyle(), DropCapStyle.None);
        Assert.assertEquals(polygon.href(), "");
        Assert.assertEquals(polygon.groupLevel().shortValue(), 0);
        Assert.assertEquals(polygon.instid(), "69526532");

        XAndY offset = polygon.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 2218);
        Assert.assertEquals(offset.y().intValue(), 4191);

        WidthAndHeight orgSZ = polygon.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 17925);
        Assert.assertEquals(orgSZ.height().intValue(), 13425);

        WidthAndHeight curSz = polygon.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 13424);

        Flip flip = polygon.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = polygon.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 40);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 11180);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 10903);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = polygon.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.getMatrix(0).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e3().floatValue(), 2218, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e6().floatValue(), 4191, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e1().floatValue(), 1.000037f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e2().floatValue(), -0.000023f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e3().floatValue(), -0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e4().floatValue(), -0.000023f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e5().floatValue(), 0.999973f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e6().floatValue(), -0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e1().floatValue(), 0.766044f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e2().floatValue(), -0.642788f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e3().floatValue(), 6411.34082f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e4().floatValue(), 0.642788f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e5().floatValue(), 0.766044f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e6().floatValue(), -4190.996094f, 0);

        FillBrush fillBrush = polygon.fillBrush();
        Assert.assertNotNull(fillBrush);
        WinBrush winBrush = fillBrush.winBrush();
        Assert.assertNotNull(winBrush);
        Assert.assertEquals(winBrush.faceColor(), "#A0BEE0");
        Assert.assertEquals(winBrush.hatchColor(), "#000000");
        Assert.assertEquals(winBrush.alpha().floatValue(), 0, 0);
        ImgBrush imgBrush = fillBrush.imgBrush();
        Assert.assertNotNull(imgBrush);
        Assert.assertEquals(imgBrush.mode(), ImageBrushMode.TOTAL);
        Image img = imgBrush.img();
        Assert.assertNotNull(img);
        Assert.assertEquals(img.binaryItemIDRef(), "image1");
        Assert.assertEquals(img.bright().intValue(), 0);
        Assert.assertEquals(img.contrast().intValue(), 0);
        Assert.assertEquals(img.effect(), ImageEffect.REAL_PIC);
        Assert.assertEquals(img.alpha().floatValue(), 0, 0);

        int index = 0;
        for (Point pt : polygon.pts()) {
            switch (index) {
                case 0:
                    Assert.assertEquals(pt.x().intValue(), 1025);
                    Assert.assertEquals(pt.y().intValue(), 10500);
                    break;
                case 1:
                    Assert.assertEquals(pt.x().intValue(), 6825);
                    Assert.assertEquals(pt.y().intValue(), 2475);
                    break;
                case 2:
                    Assert.assertEquals(pt.x().intValue(), 11925);
                    Assert.assertEquals(pt.y().intValue(), 10800);
                    break;
                case 3:
                    Assert.assertEquals(pt.x().intValue(), 13875);
                    Assert.assertEquals(pt.y().intValue(), 1500);
                    break;
                case 4:
                    Assert.assertEquals(pt.x().intValue(), 17925);
                    Assert.assertEquals(pt.y().intValue(), 9525);
                    break;
                case 5:
                    Assert.assertEquals(pt.x().intValue(), 0);
                    Assert.assertEquals(pt.y().intValue(), 4675);
                    break;
                case 6:
                    Assert.assertEquals(pt.x().intValue(), 7225);
                    Assert.assertEquals(pt.y().intValue(), 13425);
                    break;
                case 7:
                    Assert.assertEquals(pt.x().intValue(), 13150);
                    Assert.assertEquals(pt.y().intValue(), 0);
                    break;
                default:
                    Assert.fail();
                    break;
            }

            index++;
        }

        ShapeSize sz = polygon.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 5259);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.COLUMN);
        Assert.assertEquals(sz.height().intValue(), 21806);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = polygon.pos();
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
        Assert.assertEquals(pos.vertOffset().intValue(), 18025);
        Assert.assertEquals(pos.horzOffset().intValue(), 12814);

        LeftRightTopBottom outMargin = polygon.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        Caption caption = polygon.caption();
        Assert.assertNull(caption);

        HasOnlyText shapeComment = polygon.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "다각형입니다.");
    }
}
