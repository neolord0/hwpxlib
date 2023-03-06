package kr.dogfoot.hwpxlib.writer.header;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHeaderXML {
    @Test
    public void sample1() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/sample1.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleArc() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleArc.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleButtons() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleButtons.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleCompose() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleCompose.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleConnectLine() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleConnectLine.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleContainer() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleContainer.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleCurve() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleCurve.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleDutmal() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleDutmal.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEdit() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleEdit.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEllipse() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleEllipse.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEquation() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleEquation.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleLine() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleLine.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleOLE() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleOLE.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimplePicture() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimplePicture.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimplePolygon() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimplePolygon.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleRectangle() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleRectangle.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleTable() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleTable.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleTextArt() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleTextArt.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleVideo() throws Exception {
        TestUtil.Result result = TestUtil.headerXML("testFile/SimpleVideo.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }
}
