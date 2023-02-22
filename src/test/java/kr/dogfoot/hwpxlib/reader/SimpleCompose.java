package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ComposeCircleType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ComposeType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Compose;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose.ComposeCharPr;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleCompose {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/SimpleCompose.hwpx");
        Compose compose1 = (Compose) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        compose1(compose1);

        Compose compose2 = (Compose) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(3);
        compose2(compose2);
    }

    private void compose1(Compose compose) {
        Assert.assertNotNull(compose);
        Assert.assertEquals(compose.circleType(), ComposeCircleType.SHAPE_REVERSAL_TIRANGLE);
        Assert.assertEquals(compose.charSz().shortValue(), -3);
        Assert.assertEquals(compose.composeType(), ComposeType.SPREAD);
        Assert.assertEquals(compose.charPrCnt(), 10);
        Assert.assertEquals(compose.composeText(), "12");

        int index = 0;
        for (ComposeCharPr charPr : compose.charPrs()) {
            switch (index) {
                case 0:
                    Assert.assertEquals(charPr.prIDRef(), "7");
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    Assert.assertEquals(charPr.prIDRef(), "4294967295");
                    break;
                default:
                    Assert.fail();
                    break;
            }
            index++;
        }
    }

    private void compose2(Compose compose) {
        Assert.assertNotNull(compose);
        Assert.assertEquals(compose.circleType(), ComposeCircleType.CHAR);
        Assert.assertEquals(compose.charSz().shortValue(), -3);
        Assert.assertEquals(compose.composeType(), ComposeType.OVERLAP);
        Assert.assertEquals(compose.charPrCnt(), 10);
        Assert.assertEquals(compose.composeText(), "AO");

        int index = 0;
        for (ComposeCharPr charPr : compose.charPrs()) {
            switch (index) {
                case 0:
                    Assert.assertEquals(charPr.prIDRef(), "7");
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    Assert.assertEquals(charPr.prIDRef(), "4294967295");
                    break;
                default:
                    Assert.fail();
                    break;
            }
            index++;
        }
    }
}
