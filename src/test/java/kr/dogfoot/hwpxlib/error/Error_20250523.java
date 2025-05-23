package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.TrackChangeConfig;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Assert;
import org.junit.Test;

public class Error_20250523 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20250523/프로젝트 계획서.hwpx");
        check(hwpxFile);

        HWPXWriter.toFilepath(hwpxFile, "testFile/error/20250523/프로젝트 계획서_wr.hwpx");
        HWPXFile hwpxFile2 = HWPXReader.fromFilepath("testFile/error/20250523/프로젝트 계획서_wr.hwpx");
        check(hwpxFile2);
    }

    private void check(HWPXFile hwpxFile) {
        TrackChangeConfig tcc = hwpxFile.headerXMLFile().trackChangeConfig();
        Assert.assertNotNull(tcc);
        Assert.assertEquals(56, tcc.flags().intValue());
        Assert.assertNotNull(tcc.configItemSet());
        Assert.assertEquals("TrackChangePasswordInfo", tcc.configItemSet().name());
        Assert.assertEquals(1, tcc.configItemSet().countOfConfigItem());
        ConfigItem ci = tcc.configItemSet().getConfigItem(0);
        Assert.assertNotNull(ci);
        Assert.assertEquals("algorithm-name", ci.name());
        Assert.assertEquals("string", ci.type());
        Assert.assertEquals("SHA1", ci.value());
    }
}
