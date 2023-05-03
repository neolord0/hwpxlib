package kr.dogfoot.hwpxlib.writer.section;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.junit.Assert;
import org.junit.Test;

public class BasicParagraph {
    @Test
    public void ChangeTrack() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/reader_writer/ChangeTrack.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void MultiColumn() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/reader_writer/MultiColumn.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void HeaderFooter() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/reader_writer/HeaderFooter.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void PageSize_Margin() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/reader_writer/PageSize_Margin.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void PageFunctions() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/reader_writer/PageFunctions.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }
}
