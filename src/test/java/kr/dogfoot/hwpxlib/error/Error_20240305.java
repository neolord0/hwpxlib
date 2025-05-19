package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Assert;
import org.junit.Test;

public class Error_20240305 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20240305/2022.hwpx");
        Assert.assertEquals(1, hwpxFile.unparsedXMLFiles().length);
        Assert.assertEquals("Custom/bibliography.xml", hwpxFile.unparsedXMLFiles()[0].href());
        HWPXWriter.toFilepath(hwpxFile, "testFile/error/20240305/2022_.hwpx");

        HWPXFile hwpxFile2 = HWPXReader.fromFilepath("testFile/error/20240305/2022_.hwpx");
        Assert.assertEquals(1, hwpxFile2.unparsedXMLFiles().length);
        Assert.assertEquals("Custom/bibliography.xml", hwpxFile2.unparsedXMLFiles()[0].href());
    }
}
