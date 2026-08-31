package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class Error_20260831 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20260831/하이픈_테스트.hwpx");
        HWPXWriter.toFilepath(hwpxFile, "testFile/error/20260831/하이픈_테스트_re.hwpx");

        String originXML = TestUtil.zipFileString("testFile/error/20260831/하이픈_테스트.hwpx",
                "Contents/section0.xml",
                StandardCharsets.UTF_8);

        String wroteXML = TestUtil.zipFileString("testFile/error/20260831/하이픈_테스트_re.hwpx",
                "Contents/section0.xml",
                StandardCharsets.UTF_8);

        Assert.assertEquals(originXML, wroteXML);
    }

}
