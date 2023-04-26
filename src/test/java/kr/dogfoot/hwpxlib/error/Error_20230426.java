package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipFile;

public class Error_20230426 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/20230426/HwpxTest1.hwpx");
        HWPXWriter.toFilepath(hwpxFile, "testFile/20230426/HwpxTest1_.hwpx");

        Assert.assertEquals(
                TestUtil.zipFileString("testFile/20230426/HwpxTest1.hwpx", "Contents/section0.xml", StandardCharsets.UTF_8),
                TestUtil.zipFileString("testFile/20230426/HwpxTest1_.hwpx", "Contents/section0.xml", StandardCharsets.UTF_8));
        Assert.assertEquals(
                TestUtil.zipFileString("testFile/20230426/HwpxTest1.hwpx", "Chart/chart1.xml", StandardCharsets.UTF_8),
                TestUtil.zipFileString("testFile/20230426/HwpxTest1_.hwpx", "Chart/chart1.xml", StandardCharsets.UTF_8));
    }
}
