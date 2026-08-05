package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Test;

public class Error_20260805 {
    @Test
    public void test() throws Exception {
        HWPXFile targetFile = new HWPXFile();
        HWPXFile srcFile = HWPXReader.fromFilepath("testFile/error/20260805/고정폭빈칸_문서.hwpx");

        targetFile.copyFrom(srcFile);

        HWPXWriter.toFilepath(targetFile, "testFile/error/20260805/고정폭빈칸_문서_re.hwpx");
    }
}
