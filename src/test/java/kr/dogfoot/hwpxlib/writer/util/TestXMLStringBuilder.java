package kr.dogfoot.hwpxlib.writer.util;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestXMLStringBuilder {
    @Test
    public void test1() {
        XMLStringBuilder xmlSB = new XMLStringBuilder();
        xmlSB
                .openElement("abc")
                .closeElement();

        Assert.assertEquals(xmlSB.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><abc/>");
    }

    @Test
    public void test2() {
        XMLStringBuilder xsb = new XMLStringBuilder();
        xsb
                .openElement("abc")
                .attribute("A1", "V1")
                .attribute("A2", "V2")
                .attribute("A3", "V3")
                .closeElement();

        Assert.assertEquals(xsb.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><abc A1=\"V1\" A2=\"V2\" A3=\"V3\"/>");
    }

    @Test
    public void test3() {
        XMLStringBuilder xsb = new XMLStringBuilder();
        xsb
                .openElement("abc")
                .openElement("def")
                .closeElement()
                .closeElement();

        Assert.assertEquals(xsb.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><abc><def/></abc>");
    }

    @Test
    public void test4() {
        XMLStringBuilder xsb = new XMLStringBuilder();
        xsb
                .openElement("abc")
                .attribute("A1", "V1")
                .attribute("A2", "V2")
                .openElement("def")
                .attribute("A3", "V3")
                .attribute("A4", "V4")
                .closeElement()
                .closeElement();

        Assert.assertEquals(xsb.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><abc A1=\"V1\" A2=\"V2\"><def A3=\"V3\" A4=\"V4\"/></abc>");
    }

    @Test
    public void test5() {
        XMLStringBuilder xsb = new XMLStringBuilder();
        xsb
                .openElement("e1")
                .openElement("e2")
                .openElement("e3")
                .closeElement()
                .openElement("e4")
                .closeElement()
                .closeElement()
                .openElement("e5")
                .openElement("e6")
                .closeElement()
                .openElement("e7")
                .closeElement()
                .closeElement()
                .closeElement();
        Assert.assertEquals(xsb.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><e1><e2><e3/><e4/></e2><e5><e6/><e7/></e5></e1>");
    }

    @Test
    public void test6() {
        XMLStringBuilder xsb = new XMLStringBuilder();
        xsb
                .openElement("ha:HWPApplicationSetting")
                .attribute("xmlns:ha", "http://www.hancom.co.kr/hwpml/2011/app")
                .attribute("xmlns:config", "urn:oasis:names:tc:opendocument:xmlns:config:1.0")
                .openElement("ha:CaretPosition")
                .attribute("listIDRef", "0")
                .attribute("paraIDRef", "0")
                .attribute("pos", "16")
                .closeElement()
                .closeElement();
        Assert.assertEquals(xsb.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><ha:HWPApplicationSetting xmlns:ha=\"http://www.hancom.co.kr/hwpml/2011/app\" xmlns:config=\"urn:oasis:names:tc:opendocument:xmlns:config:1.0\"><ha:CaretPosition listIDRef=\"0\" paraIDRef=\"0\" pos=\"16\"/></ha:HWPApplicationSetting>");
    }

    @Test
    public void test7() {
        XMLStringBuilder xsb = new XMLStringBuilder();
        xsb
                .openElement("e1")
                .openElement("e2")
                .openElement("e3")
                .closeElement()
                .openElement("e4")
                .text("abc")
                .openElement("tag1")
                .closeElement()
                .text("def")
                .openElement("tag2")
                .closeElement()
                .text("ghi")
                .closeElement()
                .closeElement()
                .openElement("e5")
                .openElement("e6")
                .closeElement()
                .openElement("e7")
                .closeElement()
                .closeElement()
                .closeElement();
        Assert.assertEquals(xsb.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><e1><e2><e3/><e4>abc<tag1/>def<tag2/>ghi</e4></e2><e5><e6/><e7/></e5></e1>");
    }
}
