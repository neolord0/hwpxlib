package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.junit.Assert;
import org.junit.Test;

public class Error_20230413 {
    @Test
    public void test() throws Exception {
        TestUtil.Result result = TestUtil.settingsXML("testFile/error/20230413/test.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }
}