package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Error_20230413 {
    @Test
    public void test() throws Exception {
        TestUtil.Result result = TestUtil.settingsXML("testFile/20230413/test.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }
}