package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Line;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleLine {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleLine.hwpx");
        Line line = (Line) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(line);
        Assert.assertEquals(line.id(), "2141030297");
        Assert.assertEquals(line.zOrder().intValue(), 0);
        Assert.assertEquals(line.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(line.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(line.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(line.lock().booleanValue(), false);
        Assert.assertEquals(line.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(line.href(), "");
        Assert.assertEquals(line.groupLevel().shortValue(), 0);
        Assert.assertEquals(line.instid(), "1067288474");
        Assert.assertEquals(line.isReverseHV().booleanValue(), false);

        XAndY offset = line.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = line.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 22478);
        Assert.assertEquals(orgSZ.height().intValue(), 8447);

        WidthAndHeight curSz = line.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 16208);
        Assert.assertEquals(curSz.height().intValue(), 20754);

        Flip flip = line.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = line.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 8104);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 10377);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = line.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.transMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.transMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.transMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.transMatrix().e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e1().floatValue(), 0.721061f);
        Assert.assertEquals(renderingInfo.scaMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.scaMatrix().e5().floatValue(), 2.456967f);
        Assert.assertEquals(renderingInfo.scaMatrix().e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.rotMatrix().e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.rotMatrix().e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.rotMatrix().e6().floatValue(), 0);

        LineShape lineShape = line.lineShape();
        Assert.assertNotNull(lineShape);
        Assert.assertEquals(lineShape.color(), "#000000");
        Assert.assertEquals(lineShape.width().intValue(), 33);
        Assert.assertEquals(lineShape.style(), LineType2.SOLID);
        Assert.assertEquals(lineShape.endCap(), LineCap.FLAT);
        Assert.assertEquals(lineShape.headStyle(), ArrowType.EMPTY_BOX);
        Assert.assertEquals(lineShape.tailStyle(), ArrowType.EMPTY_BOX);
        Assert.assertEquals(lineShape.headfill().booleanValue(), true);
        Assert.assertEquals(lineShape.tailfill().booleanValue(), false);
        Assert.assertEquals(lineShape.headSz(), ArrowSize.MEDIUM_MEDIUM);
        Assert.assertEquals(lineShape.tailSz(), ArrowSize.MEDIUM_MEDIUM);
        Assert.assertEquals(lineShape.outlineStyle(), OutlineStyle.NORMAL);
        Assert.assertEquals(lineShape.alpha().floatValue(), 0f);

        DrawingShadow shadow = line.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.type(), DrawingShadowType.PARELLEL_RIGHTTOP);
        Assert.assertEquals(shadow.color(), "#B2B2B2");
        Assert.assertEquals(shadow.offsetX().intValue(), 0);
        Assert.assertEquals(shadow.offsetY().intValue(), 0);
        Assert.assertEquals(shadow.alpha().floatValue(), 0f);

        Point startPt = line.startPt();
        Assert.assertNotNull(startPt);
        Assert.assertEquals(startPt.x().intValue(), 0);
        Assert.assertEquals(startPt.y().intValue(), 0);

        Point endPt = line.endPt();
        Assert.assertNotNull(endPt);
        Assert.assertEquals(endPt.x().intValue(), 22478);
        Assert.assertEquals(endPt.y().intValue(), 8447);

        ShapeSize sz = line.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 16208);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 20754);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = line.pos();
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
        Assert.assertEquals(pos.vertOffset().intValue(), 11446);
        Assert.assertEquals(pos.horzOffset().intValue(), 15631);

        LeftRightTopBottom outMargin = line.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        HasOnlyText shapeComment = line.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "선입니다.");

    }
}
