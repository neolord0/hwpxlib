package kr.dogfoot.hwpxlib.writer.section;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicParagraph {
    @Test
    public void ChangeTrack() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/ChangeTrack.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void MultiColumn() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/MultiColumn.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void HeaderFooter() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/HeaderFooter.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void PageSize_Margin() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/PageSize_Margin.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void PageFunctions() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/PageFunctions.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }
}
