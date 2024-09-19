package kr.dogfoot.hwpxlib.error;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.parameter.Param;
import kr.dogfoot.hwpxlib.object.common.parameter.StringParam;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.RunItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

public class Error_20240919 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/error/20240919/테스트문서.hwpx");
        SectionXMLFile sectionXMLFile0 = hwpxFile.sectionXMLFileList().get(0);
        Assert.assertEquals(12, sectionXMLFile0.countOfPara());
        Para para10 = sectionXMLFile0.getPara(10);
        Assert.assertEquals(3, para10.countOfRun());
        Run run0 = para10.getRun(0);
        Assert.assertEquals(2, run0.countOfRunItem());
        Ctrl ctrl1 = (Ctrl) run0.getRunItem(1);
        Assert.assertEquals(ObjectType.hp_fieldBegin, ctrl1.getCtrlItem(0)._objectType());
        FieldBegin fieldBegin = (FieldBegin) ctrl1.getCtrlItem(0);
        Assert.assertEquals(ObjectType.hp_stringParam, fieldBegin.parameters().getParam(1)._objectType());
        StringParam param = (StringParam) fieldBegin.parameters().getParam(1);
        Assert.assertEquals("Command", param.name());
        Assert.assertEquals("http\\:///BizRunner/Common/FileDownloadAllPage.bzr\\?spaceID=0&cabinetID=1165&oid=1240814103339101467&fieldID=zzzuser014;1;0;1;", param.value());
    }
}
