package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DutmalPosType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Dutmal;
import org.junit.Assert;
import org.junit.Test;

public class SimpleDutmal {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/SimpleDutmal.hwpx");
        Dutmal dutmal = (Dutmal) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);

        Assert.assertNotNull(dutmal);
        Assert.assertEquals(dutmal.posType(), DutmalPosType.TOP);
        Assert.assertEquals(dutmal.szRatio().intValue(), 0);
        Assert.assertEquals(dutmal.option().intValue(), 0);
        Assert.assertEquals(dutmal.styleIDRef(), "0");
        Assert.assertEquals(dutmal.align(), HorizontalAlign2.CENTER);

        HasOnlyText mainText = dutmal.mainText();
        Assert.assertNotNull(mainText);
        Assert.assertEquals(mainText.text(), "테스트_본말");

        HasOnlyText subText = dutmal.subText();
        Assert.assertNotNull(subText);
        Assert.assertEquals(subText.text(), "테스트_닷말");
    }
}
