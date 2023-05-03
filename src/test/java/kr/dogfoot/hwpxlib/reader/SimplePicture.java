package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.*;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageEffect;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Picture;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageDim;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeSize;
import org.junit.Assert;
import org.junit.Test;

public class SimplePicture {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimplePicture.hwpx");
        Picture picture = (Picture) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(picture);
        Assert.assertEquals(picture.id(), "1137988260");
        Assert.assertEquals(picture.zOrder().intValue(), 1);
        Assert.assertEquals(picture.numberingType(), NumberingType.PICTURE);
        Assert.assertEquals(picture.textWrap(), TextWrapMethod.SQUARE);
        Assert.assertEquals(picture.textFlow(), TextFlowSide.BOTH_SIDES);
        Assert.assertEquals(picture.lock().booleanValue(), false);
        Assert.assertEquals(picture.dropcapstyle(), DropCapStyle.None);
        Assert.assertEquals(picture.href(), "");
        Assert.assertEquals(picture.groupLevel().shortValue(), 0);
        Assert.assertEquals(picture.instid(), "64246437");
        Assert.assertEquals(picture.reverse().booleanValue(), false);

        XAndY offset = picture.offset();
        Assert.assertNotNull(offset);
        Assert.assertEquals(offset.x().intValue(), 0);
        Assert.assertEquals(offset.y().intValue(), 0);

        WidthAndHeight orgSz = picture.orgSz();
        Assert.assertNotNull(orgSz);
        Assert.assertEquals(orgSz.width().intValue(), 17664);
        Assert.assertEquals(orgSz.height().intValue(), 5975);

        WidthAndHeight curSz = picture.curSz();
        Assert.assertNotNull(curSz);
        Assert.assertEquals(curSz.width().intValue(), 25942);
        Assert.assertEquals(curSz.height().intValue(), 8775);

        Flip flip = picture.flip();
        Assert.assertNotNull(flip);
        Assert.assertEquals(flip.horizontal().booleanValue(), false);
        Assert.assertEquals(flip.vertical().booleanValue(), false);

        RotationInfo rotationInfo = picture.rotationInfo();
        Assert.assertNotNull(rotationInfo);
        Assert.assertEquals(rotationInfo.angle().shortValue(), 0);
        Assert.assertEquals(rotationInfo.centerX().intValue(), 12971);
        Assert.assertEquals(rotationInfo.centerY().intValue(), 4387);
        Assert.assertEquals(rotationInfo.rotateimage().booleanValue(), true);

        RenderingInfo renderingInfo = picture.renderingInfo();
        Assert.assertNotNull(renderingInfo);
        Assert.assertEquals(renderingInfo.getMatrix(0).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(0).e6().floatValue(), 0, 0);

        Assert.assertEquals(renderingInfo.getMatrix(1).e1().floatValue(), 1.468637f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e5().floatValue(), 1.468619f, 0);
        Assert.assertEquals(renderingInfo.getMatrix(1).e6().floatValue(), 0, 0);

        Assert.assertEquals(renderingInfo.getMatrix(2).e1().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e2().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e3().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e4().floatValue(), 0, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e5().floatValue(), 1, 0);
        Assert.assertEquals(renderingInfo.getMatrix(2).e6().floatValue(), 0, 0);

        ImageRect imgRect = picture.imgRect();
        Assert.assertNotNull(imgRect);
        Assert.assertEquals(imgRect.pt0().x().intValue(), 0);
        Assert.assertEquals(imgRect.pt0().y().intValue(), 0);
        Assert.assertEquals(imgRect.pt1().x().intValue(), 17664);
        Assert.assertEquals(imgRect.pt1().y().intValue(), 0);
        Assert.assertEquals(imgRect.pt2().x().intValue(), 17664);
        Assert.assertEquals(imgRect.pt2().y().intValue(), 5975);
        Assert.assertEquals(imgRect.pt3().x().intValue(), 0);
        Assert.assertEquals(imgRect.pt3().y().intValue(), 5975);

        LeftRightTopBottom imgClip = picture.imgClip();
        Assert.assertNotNull(imgClip);
        Assert.assertEquals(imgClip.left().intValue(), 0);
        Assert.assertEquals(imgClip.right().intValue(), 40800);
        Assert.assertEquals(imgClip.top().intValue(), 0);
        Assert.assertEquals(imgClip.bottom().intValue(), 13800);

        LeftRightTopBottom inMargin = picture.inMargin();
        Assert.assertNotNull(inMargin);
        Assert.assertEquals(inMargin.left().intValue(), 0);
        Assert.assertEquals(inMargin.right().intValue(), 0);
        Assert.assertEquals(inMargin.top().intValue(), 0);
        Assert.assertEquals(inMargin.bottom().intValue(), 0);
        ImageDim imgDim = picture.imgDim();
        Assert.assertNotNull(imgDim);
        Assert.assertEquals(imgDim.dimwidth().intValue(), 40800);
        Assert.assertEquals(imgDim.dimheight().intValue(), 13800);

        Image img = picture.img();
        Assert.assertNotNull(img);
        Assert.assertEquals(img.binaryItemIDRef(), "image1");
        Assert.assertEquals(img.bright().intValue(), 0);
        Assert.assertEquals(img.contrast().intValue(), 0);
        Assert.assertEquals(img.effect(), ImageEffect.REAL_PIC);
        Assert.assertEquals(img.alpha().floatValue(), 0, 0);

        Effects effects = picture.effects();
        Assert.assertNotNull(effects);

        EffectsShadow shadow = effects.shadow();
        Assert.assertNotNull(shadow);
        Assert.assertEquals(shadow.style(), ShadowStyle.OUTSIDE);
        Assert.assertEquals(shadow.alpha().floatValue(), 0.5f, 0);
        Assert.assertEquals(shadow.radius().floatValue(), 600, 0);
        Assert.assertEquals(shadow.direction().shortValue(), 180);
        Assert.assertEquals(shadow.distance().floatValue(), 600, 0);
        Assert.assertEquals(shadow.alignStyle(), AlignStyleType.CENTER);
        Assert.assertEquals(shadow.rotationStyle().booleanValue(), false);
        {
            XAndYFloat skew = shadow.skew();
            Assert.assertNotNull(skew);
            Assert.assertEquals(skew.x().floatValue(), 0, 0);
            Assert.assertEquals(skew.y().floatValue(), 0, 0);

            XAndYFloat scale = shadow.scale();
            Assert.assertNotNull(scale);
            Assert.assertEquals(scale.x().floatValue(), 1, 0);
            Assert.assertEquals(scale.y().floatValue(), 1, 0);

            EffectsColor effectsColor = shadow.effectsColor();
            Assert.assertNotNull(effectsColor);
            Assert.assertEquals(effectsColor.type(), ColorType.RGB);
            Assert.assertEquals(effectsColor.schemeIdx().intValue(), -1);
            Assert.assertEquals(effectsColor.systemIdx().intValue(), -1);
            Assert.assertEquals(effectsColor.presetIdx().intValue(), -1);
            Assert.assertNotNull(effectsColor.rgb());
            Assert.assertEquals(effectsColor.rgb().r().shortValue(), 0);
            Assert.assertEquals(effectsColor.rgb().g().shortValue(), 0);
            Assert.assertEquals(effectsColor.rgb().b().shortValue(), 0);
        }

        EffectsGlow glow = effects.glow();
        Assert.assertNotNull(glow);
        Assert.assertEquals(glow.alpha().floatValue(), 0.5f, 0);
        Assert.assertEquals(glow.radius().floatValue(), 500, 0);

        {
            EffectsColor effectsColor = glow.effectsColor();
            Assert.assertNotNull(effectsColor);
            Assert.assertEquals(effectsColor.type(), ColorType.RGB);
            Assert.assertEquals(effectsColor.schemeIdx().intValue(), -1);
            Assert.assertEquals(effectsColor.systemIdx().intValue(), -1);
            Assert.assertEquals(effectsColor.presetIdx().intValue(), -1);
            Assert.assertNotNull(effectsColor.rgb());
            Assert.assertEquals(effectsColor.rgb().r().shortValue(), 233);
            Assert.assertEquals(effectsColor.rgb().g().shortValue(), 174);
            Assert.assertEquals(effectsColor.rgb().b().shortValue(), 43);
            Assert.assertNotNull(effectsColor.effect());
            Assert.assertEquals(effectsColor.effect().type(), ColorEffectType.SAT_MOD);
            Assert.assertEquals(effectsColor.effect().value(), "1.75");
        }

        EffectsSoftEdge softEdge = effects.softEdge();
        Assert.assertNotNull(softEdge);
        Assert.assertEquals(softEdge.radius().floatValue(), 300, 0);

        EffectsReflection reflection = effects.reflection();
        Assert.assertNotNull(reflection);
        Assert.assertEquals(reflection.alignStyle(), AlignStyleType.BOTTOM_LEFT);
        Assert.assertEquals(reflection.radius().floatValue(), 50, 0);
        Assert.assertEquals(reflection.direction().intValue(), 90);
        Assert.assertEquals(reflection.distance().floatValue(), 0, 0);
        Assert.assertEquals(reflection.rotationStyle().booleanValue(), false);
        Assert.assertEquals(reflection.fadeDirection().intValue(), 90);
        {
            XAndYFloat skew = reflection.skew();
            Assert.assertNotNull(skew);
            Assert.assertEquals(skew.x().floatValue(), 0, 0);
            Assert.assertEquals(skew.y().floatValue(), 0, 0);

            XAndYFloat scale = reflection.scale();
            Assert.assertNotNull(scale);
            Assert.assertEquals(scale.x().floatValue(), 1, 0);
            Assert.assertEquals(scale.y().floatValue(), -1, 0);

            StartAndEndFloat alpha = reflection.alpha();
            Assert.assertNotNull(alpha);
            Assert.assertEquals(alpha.start().floatValue(), 0.5f, 0);
            Assert.assertEquals(alpha.end().floatValue(), 0.997f, 0);

            StartAndEndFloat pos = reflection.pos();
            Assert.assertNotNull(pos);
            Assert.assertEquals(pos.start().floatValue(), 0, 0);
            Assert.assertEquals(pos.end().floatValue(), 0.5, 0);
        }

        ShapeSize sz = picture.sz();
        Assert.assertNotNull(sz);
        Assert.assertEquals(sz.width().intValue(), 25942);
        Assert.assertEquals(sz.widthRelTo(), WidthRelTo.ABSOLUTE);
        Assert.assertEquals(sz.height().intValue(), 8775);
        Assert.assertEquals(sz.heightRelTo(), HeightRelTo.ABSOLUTE);
        Assert.assertEquals(sz.protect().booleanValue(), false);

        ShapePosition pos = picture.pos();
        Assert.assertNotNull(pos);
        Assert.assertEquals(pos.treatAsChar().booleanValue(), false);
        Assert.assertEquals(pos.affectLSpacing().booleanValue(), false);
        Assert.assertEquals(pos.flowWithText().booleanValue(), true);
        Assert.assertEquals(pos.allowOverlap().booleanValue(), true);
        Assert.assertEquals(pos.holdAnchorAndSO().booleanValue(), false);
        Assert.assertEquals(pos.vertRelTo(), VertRelTo.PAPER);
        Assert.assertEquals(pos.horzRelTo(), HorzRelTo.PAPER);
        Assert.assertEquals(pos.vertAlign(), VertAlign.TOP);
        Assert.assertEquals(pos.horzAlign(), HorzAlign.LEFT);
        Assert.assertEquals(pos.vertOffset().intValue(), 11775);
        Assert.assertEquals(pos.horzOffset().intValue(), 8739);

        LeftRightTopBottom outMargin = picture.outMargin();
        Assert.assertNotNull(outMargin);
        Assert.assertEquals(outMargin.left().intValue(), 0);
        Assert.assertEquals(outMargin.right().intValue(), 0);
        Assert.assertEquals(outMargin.top().intValue(), 0);
        Assert.assertEquals(outMargin.bottom().intValue(), 0);

        HasOnlyText shapeComment = picture.shapeComment();
        Assert.assertNotNull(shapeComment);
        Assert.assertEquals(shapeComment.text(),
                "그림입니다.\n" +
                "원본 그림의 이름: google.jpg\n" +
                "원본 그림의 크기: 가로 544pixel, 세로 184pixel");

        int index = 0;
        for (ManifestItem item : file.contentHPFFile().manifest().items()) {
            switch (index) {
                case 0:
                    Assert.assertNull(item.attachedFile());
                    break;
                case 1:
                    Assert.assertNotNull(item.attachedFile());
                    Assert.assertNotNull(item.attachedFile().data());
                    Assert.assertEquals(item.attachedFile().data().length, 23560);
                    break;
                case 2:
                    Assert.assertNull(item.attachedFile());
                    break;
                case 3:
                    Assert.assertNull(item.attachedFile());
                    break;
                default:
                    Assert.fail();
                    break;
            }
            index++;
        }
    }
}







