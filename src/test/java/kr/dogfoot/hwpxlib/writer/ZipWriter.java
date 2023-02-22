package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.testng.annotations.Test;

import java.io.IOException;

public class ZipWriter {
    @Test
    public void test1() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/SimpleArc.hwpx");
        hwpxFile.settingsXMLFile().caretPosition().pos(500);
        HWPXWriter.toFilePath(hwpxFile, "test.zip");
    }
}
