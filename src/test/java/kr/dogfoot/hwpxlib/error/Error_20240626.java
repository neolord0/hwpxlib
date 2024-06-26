package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;

public class Error_20240626 {
    public static void main(String[] args) throws Exception {
        HWPXFile hwpFile = HWPXReader.fromFile(new java.io.File("testFile/error/20240626/no_manifest.hwpx"));
    }
}
