package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.OLE;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ole.Extent;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.OutMargin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeComment;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleOLE {

    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleOLE.hwpx");
        OLE ole = (OLE) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(ole);
        Assert.assertEquals(ole.id(), "1138838690");
        Assert.assertEquals(ole.zOrder().intValue(), 0);
        Assert.assertEquals(ole.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(ole.textWrap(), TextWrapMethod.SQUARE);
        Assert.assertEquals(ole.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(ole.lock().booleanValue(), false);
        Assert.assertEquals(ole.dropcapstyle(), DropCapStyle.NONE);
        Assert.assertEquals(ole.href(), "");
        Assert.assertEquals(ole.groupLevel().shortValue(), 0);
        Assert.assertEquals(ole.instid(), "65096867");
        Assert.assertEquals(ole.objectType(), OLEObjectType.EMBEDDED);
        Assert.assertEquals(ole.binaryItemIDRef(), "ole1");
        Assert.assertEquals(ole.hasMoniker().booleanValue(), false);
        Assert.assertEquals(ole.drawAspect(), OLEDrawAspect.CONTENT);
        Assert.assertEquals(ole.eqBaseLine().intValue(), 0);

        Offset offset = ole.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        OriginalSize orgSZ = ole.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 14176);
        Assert.assertEquals(orgSZ.height().intValue(), 14176);

        CurrentSize curSz = ole.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = ole.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = ole.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 7088);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 7088);
        Assert.assertEquals(rotationInfo.rotateImage().booleanValue(), true);

        RenderingInfo renderingInfo = ole.renderingInfo();
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

        Extent extent = ole.extent();
        Assert.assertNotNull(extent);
        Assert.assertEquals(extent.x().intValue(), 14176);
        Assert.assertEquals(extent.y().intValue(), 14176);

        LineShape lineShape = ole.lineShape();
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
        Assert.assertEquals(lineShape.outlineStyle(), OutlineStyle.OUTER);
        Assert.assertEquals(lineShape.alpha().floatValue(), 0);

        ShapeSize sz = ole.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 14176);;
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 14176);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = ole.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), false);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), false);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PARA);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.PARA);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().intValue(), 8475);
        Assert.assertEquals(pos.horzOffset().intValue(), 9100);

        OutMargin outMargin = ole.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        ShapeComment shapeComment = ole.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(),
                "OLE 개체입니다.\n" +
                "개체 형식은 Bitmap Image입니다.");
    }
}
