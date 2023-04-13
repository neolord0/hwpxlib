package kr.dogfoot.hwpxlib;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;

public class Test {
    public static void main(String[] arg) throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/test.hwpx");
    }
}
