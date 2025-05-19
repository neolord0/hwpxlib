package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class Error_20240416 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20240416/presentation오류.hwpx");
        SectionXMLFile seciton = hwpxFile.sectionXMLFileList().get(0);
        Run firstRun = seciton.getPara(0).getRun(0);

        Assert.assertEquals(4294967295L, firstRun.secPr().presentation().showtime().longValue());
    }
}
