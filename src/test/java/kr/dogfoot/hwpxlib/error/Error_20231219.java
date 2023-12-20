package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Test;

public class Error_20231219 {
    @Test
    public void test() throws Exception {
        HWPXReader.fromFilepath("testFile/error/20231219/test1.hwpx");
    }
}
