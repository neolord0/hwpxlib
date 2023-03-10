package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DropCapStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextFlowSide;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextWrapMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Container;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleContainer {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleContainer.hwpx");
        Container container = (Container) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(container);
        Assert.assertEquals(container.id(), "1138906163");
        Assert.assertEquals(container.zOrder().intValue(), 4);
        Assert.assertEquals(container.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(container.textWrap(), TextWrapMethod.IN_FRONT_OF_TEXT);
        Assert.assertEquals(container.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(container.lock().booleanValue(), false);
        Assert.assertEquals(container.dropcapstyle(), DropCapStyle.None);
        Assert.assertEquals(container.href(), "");
        Assert.assertEquals(container.groupLevel().shortValue(), 0);
        Assert.assertEquals(container.instid(), "65164340");

        XAndY offset = container.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSZ = container.orgSz();
        Assert.assertNotNull(orgSZ);
        Assert.assertEquals(orgSZ.width().intValue(), 17372);
        Assert.assertEquals(orgSZ.height().intValue(), 3250);

        WidthAndHeight curSz = container.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 0);
        Assert.assertEquals(curSz.height().intValue(), 0);

        Flip flip = container.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = container.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 8686);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 1625);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = container.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.getMatrix(0).e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.getMatrix(0).e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.getMatrix(0).e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.getMatrix(1).e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.getMatrix(1).e6().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e1().floatValue(), 1);
        Assert.assertEquals(renderingInfo.getMatrix(2).e2().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e3().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e4().floatValue(), 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e5().floatValue(), 1);
        Assert.assertEquals(renderingInfo.getMatrix(2).e6().floatValue(), 0);

        Assert.assertEquals(container.countOfChild(), 3);
        Assert.assertEquals(container.getChild(0)._objectType(), ObjectType.hp_pic);
        Assert.assertEquals(container.getChild(1)._objectType(), ObjectType.hp_pic);
        Assert.assertEquals(container.getChild(2)._objectType(), ObjectType.hp_line);
    }
}
