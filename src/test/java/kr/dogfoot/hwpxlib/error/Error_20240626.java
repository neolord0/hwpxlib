package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class Error_20240626 {

    @Test
    public void test() throws Exception {
        HWPXFile hwpFile = HWPXReader.fromFile(new java.io.File("testFile/error/20240626/no_manifest.hwpx"));
        Assert.assertNotNull(hwpFile);
    }
}
