package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class Error_20260806 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20260806/표전체 형광색인 경우 오류.hwpx");
        HWPXWriter.toFilepath(hwpxFile, "testFile/error/20260806/표전체 형광색인 경우 오류_re.hwpx");

        String originXML = TestUtil.zipFileString("testFile/error/20260806/표전체 형광색인 경우 오류.hwpx",
                "Contents/section0.xml",
                StandardCharsets.UTF_8);

        String wroteXML = TestUtil.zipFileString("testFile/error/20260806/표전체 형광색인 경우 오류_re.hwpx",
                "Contents/section0.xml",
                StandardCharsets.UTF_8);

        Assert.assertEquals(originXML, wroteXML);
    }
}
