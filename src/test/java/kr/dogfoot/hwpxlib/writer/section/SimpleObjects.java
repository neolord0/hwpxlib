package kr.dogfoot.hwpxlib.writer.section;

import kr.dogfoot.hwpxlib.writer.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleObjects {
    @Test
    public void SimpleArc() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleArc.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleButtons() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleButtons.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleComboBox() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleComboBox.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleCompose() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleCompose.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleConnectLine() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleConnectLine.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleContainer() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleContainer.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleCurve() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleCurve.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleDutmal() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleDutmal.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEdit() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleEdit.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEllipse() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleEllipse.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleEquation() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleEquation.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleLine() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleLine.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleOLE() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleOLE.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimplePicture() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimplePicture.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimplePolygon() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimplePolygon.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleRectangle() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleRectangle.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleTable() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleTable.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleTextArt() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleTextArt.hwpx");
        Assert.assertEquals(result.actual(), result.expected());
    }

    @Test
    public void SimpleVideo() throws Exception {
        TestUtil.Result result = TestUtil.sectionXML("testFile/SimpleVideo.hwpx");
        System.out.println(result.actual());
        Assert.assertEquals(result.actual(), result.expected());
    }
}

