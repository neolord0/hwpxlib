package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.tabpr.TabItem;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class Error_20230728 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20230728/test.hwpx");
        TabPr tabPr = hwpxFile.headerXMLFile().refList().tabProperties().get(1);
        Assert.assertEquals(31, tabPr.switchList().size());

        int[] pos = new int[31];
        pos[0] = 4000;
        pos[1] = 8000;
        pos[2] = 12000;
        pos[3] = 16000;
        pos[4] = 20000;
        pos[5] = 24000;
        pos[6] = 28000;
        pos[7] = 32000;
        pos[8] = 36000;
        pos[9] = 40000;
        pos[10] = 44000;
        pos[11] = 47984;
        pos[12] = 52000;
        pos[13] = 56000;
        pos[14] = 60000;
        pos[15] = 64000;
        pos[16] = 68000;
        pos[17] = 72000;
        pos[18] = 76000;
        pos[19] = 80000;
        pos[20] = 84000;
        pos[21] = 88000;
        pos[22] = 92000;
        pos[23] = 96000;
        pos[24] = 100000;
        pos[25] = 104000;
        pos[26] = 108000;
        pos[27] = 112000;
        pos[28] = 116000;
        pos[29] = 120000;
        pos[30] = 124000;

        for (int index = 0;  index < 31; index++) {
            Switch sw = tabPr.switchList().get(index);
            Assert.assertEquals(index, sw.position() - 1);
            TabItem tabItem = (TabItem) sw.getCaseObject(0).getChild(0);
            Assert.assertEquals(pos[index], tabItem.pos().intValue());
        }

        HWPXWriter.toFilepath(hwpxFile, "testFile/error/20230728/test_.hwpx");
        Assert.assertEquals(
                TestUtil.zipFileString("testFile/error/20230728/test.hwpx", "Contents/header.xml", StandardCharsets.UTF_8),
                TestUtil.zipFileString("testFile/error/20230728/test_.hwpx", "Contents/header.xml", StandardCharsets.UTF_8));
    }
}
