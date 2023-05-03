package kr.dogfoot.hwpxlib.writer.header;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.junit.Assert;
import org.junit.Test;

public class TestHeaderXML {
    @Test
    public void sample1() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/sample1.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleArc() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleArc.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleButtons() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleButtons.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleCompose() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleCompose.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleConnectLine() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleConnectLine.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleContainer() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleContainer.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleCurve() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleCurve.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleDutmal() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleDutmal.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEdit() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleEdit.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEllipse() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleEllipse.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEquation() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleEquation.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleLine() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleLine.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleOLE() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleOLE.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimplePicture() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimplePicture.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimplePolygon() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimplePolygon.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleRectangle() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleRectangle.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleTable() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleTable.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleTextArt() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleTextArt.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleVideo() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/reader_writer/SimpleVideo.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }
}
