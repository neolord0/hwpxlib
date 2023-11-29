package kr.dogfoot.hwpxlib.clone;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Video;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class SimpleVideo {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimpleVideo.hwpx");
        file = file.clone();

        Video video = (Video) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(video);
        Assert.assertEquals(video.id(), "1138073078");
        Assert.assertEquals(video.zOrder().intValue(), 0);
        Assert.assertEquals(video.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(video.textWrap(), TextWrapMethod.SQUARE);
        Assert.assertEquals(video.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(video.lock().booleanValue(), false);
        Assert.assertEquals(video.dropcapstyle(), DropCapStyle.None);
        Assert.assertEquals(video.href(), "");
        Assert.assertEquals(video.groupLevel().shortValue(), 0);
        Assert.assertEquals(video.instid(), "64331255");
        Assert.assertEquals(video.videotype(), VideoType.LOCAL);
        Assert.assertEquals(video.fileIDRef(), "image1");
        Assert.assertEquals(video.imageIDRef(), "image2");
        Assert.assertEquals(video.tag(), "");

        XAndY offset = video.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = video.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 22500);
        Assert.assertEquals(orgSZ.height().intValue(), 15000);

        WidthAndHeight curSz = video.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = video.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = video.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 11250);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 7500);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = video.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.getMatrix(0).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e6().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e6().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e6().floatValue(), 0, 0);

        ShapeSize sz = video.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 22500);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 15000);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = video.pos();
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

        LeftRightTopBottom outMargin = video.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        HasOnlyText shapeComment = video.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(), "동영상입니다.");
    }
}
