package kr.dogfoot.hwpxlib.tool;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.tool.blankfilemaker.BlankFileMaker;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Assert;
import org.junit.Test;

public class TestBlankFileMaker {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = BlankFileMaker.make();
        HWPXWriter.toFilepath(hwpxFile, "testFile/tool/blank.hwpx");

        TestUtil.Result result = TestUtil.headerXML("testFile/tool/blank.hwpx", hwpxFile);
        Assert.assertEquals(result.actual(), result.expected());

        TestUtil.Result result2 = TestUtil.sectionXML("testFile/tool/blank.hwpx", hwpxFile);
        Assert.assertEquals(result2.actual(), result2.expected());
    }
}
