package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class TestFieldFinder {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");
        FieldFinder.Result[] results = FieldFinder.find(hwpxFile, "필드A", false);
        Assert.assertEquals(results.length, 2);

        {
            FieldFinder.Result result = results[0];
            Assert.assertEquals(result.beginField().name(), "필드A");
            Assert.assertEquals(result.beginField().id(), result.endField().beginIDRef());
        }

        {
            FieldFinder.Result result = results[1];
            Assert.assertEquals(result.beginField().name(), "필드A");
            Assert.assertEquals(result.beginField().id(), result.endField().beginIDRef());
        }
    }
}