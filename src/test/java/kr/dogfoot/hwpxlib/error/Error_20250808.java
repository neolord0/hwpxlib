package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.TrackChangeConfig;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.MasterPageXMLFile;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.enumtype.MasterPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Assert;
import org.junit.Test;

public class Error_20250808 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20250808/2015년_12월_재난안전종합상황_분석_및_전망.hwpx");
        check(hwpxFile);

        HWPXWriter.toFilepath(hwpxFile, "testFile/error/20250808/2015년_12월_재난안전종합상황_분석_및_전망.hwpx");
        HWPXFile hwpxFile2 = HWPXReader.fromFilepath("testFile/error/20250808/2015년_12월_재난안전종합상황_분석_및_전망.hwpx");
        // check(hwpxFile2);
    }


    private void check(HWPXFile hwpxFile) {
        Assert.assertEquals(1, hwpxFile.masterPageXMLFileList().count());
        MasterPageXMLFile masterPageXMLFile = hwpxFile.masterPageXMLFileList().get(0);
        Assert.assertEquals("masterpage0", masterPageXMLFile.id());
        Assert.assertEquals(MasterPageType.OPTIONAL_PAGE, masterPageXMLFile.type());
        Assert.assertEquals(1, masterPageXMLFile.pageNumber().intValue());
        Assert.assertFalse(masterPageXMLFile.pageDuplicate());
        Assert.assertFalse(masterPageXMLFile.pageFront());
        Assert.assertEquals(1, masterPageXMLFile.subList().countOfPara());
    }
}
