package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldEnd;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.tool.finder.comm.ObjectFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestFindingField {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {
            private String fieldBeginID;

            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_fieldBegin) {
                    FieldBegin fieldBegin = (FieldBegin) thisObject;
                    if (fieldBegin.name().equals("필드A")) {
                        fieldBeginID = fieldBegin.id();
                        return true;
                    }
                }
                if (thisObject._objectType() == ObjectType.hp_fieldEnd) {
                    FieldEnd fieldEnd = (FieldEnd) thisObject;
                    if (fieldEnd.beginIDRef().equals(fieldBeginID)) {
                        return true;
                    }
                }
                return false;
            }
        }

        ObjectFinder.Result[] results = ObjectFinder.find(hwpxFile, new MyFilter(), false);
        Assert.assertEquals(results.length, 4);

        {
            ObjectFinder.Result result = results[0];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_fieldBegin);

            Assert.assertEquals(result.parentsPath().size(), 5);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);
            Assert.assertEquals(result.parentsPath().get(4)._objectType(), ObjectType.hp_ctrl);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ctrl ctrl = (Ctrl) result.parentsPath().get(4);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 5);
            Assert.assertEquals(para.getRunIndex(run), 0);
        }

        {
            ObjectFinder.Result result = results[1];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_fieldEnd);
            Assert.assertEquals(result.parentsPath().size(), 5);

            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);
            Assert.assertEquals(result.parentsPath().get(4)._objectType(), ObjectType.hp_ctrl);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ctrl ctrl = (Ctrl) result.parentsPath().get(4);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 5);
            Assert.assertEquals(para.getRunIndex(run), 2);

            Run fieldTextRun = para.getRun(1);
            Assert.assertEquals(fieldTextRun.getRunItem(0)._objectType(), ObjectType.hp_t);
            T t = (T) fieldTextRun.getRunItem(0);
            Assert.assertEquals(t.onlyText(), "필드A");
        }

        {
            ObjectFinder.Result result = results[2];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_fieldBegin);

            Assert.assertEquals(result.parentsPath().size(), 5);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);
            Assert.assertEquals(result.parentsPath().get(4)._objectType(), ObjectType.hp_ctrl);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ctrl ctrl = (Ctrl) result.parentsPath().get(4);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 8);
            Assert.assertEquals(para.getRunIndex(run), 0);
        }

        {
            ObjectFinder.Result result = results[3];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_fieldEnd);
            Assert.assertEquals(result.parentsPath().size(), 5);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);
            Assert.assertEquals(result.parentsPath().get(4)._objectType(), ObjectType.hp_ctrl);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ctrl ctrl = (Ctrl) result.parentsPath().get(4);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 8);
            Assert.assertEquals(para.getRunIndex(run), 2);

            Run fieldTextRun = para.getRun(1);
            Assert.assertEquals(fieldTextRun.getRunItem(0)._objectType(), ObjectType.hp_t);
            T t = (T) fieldTextRun.getRunItem(0);
            Assert.assertEquals(t.onlyText(), "팔드A2");
        }
    }

    @Test
    public void test2() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {
            private String fieldBeginID;

            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_fieldBegin) {
                    FieldBegin fieldBegin = (FieldBegin) thisObject;
                    if (fieldBegin.name().equals("필드1")) {
                        fieldBeginID = fieldBegin.id();
                        return true;
                    }
                }
                if (thisObject._objectType() == ObjectType.hp_fieldEnd) {
                    FieldEnd fieldEnd = (FieldEnd) thisObject;
                    if (fieldEnd.beginIDRef().equals(fieldBeginID)) {
                        return true;
                    }
                }
                return false;
            }
        }

        ObjectFinder.Result[] results = ObjectFinder.find(hwpxFile, new MyFilter(), false);
        Assert.assertEquals(results.length, 2);

        {
            ObjectFinder.Result result = results[0];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_fieldBegin);

            Assert.assertEquals(result.parentsPath().size(), 5);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);
            Assert.assertEquals(result.parentsPath().get(4)._objectType(), ObjectType.hp_ctrl);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ctrl ctrl = (Ctrl) result.parentsPath().get(4);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 3);
            Assert.assertEquals(para.getRunIndex(run), 0);
        }

        {
            ObjectFinder.Result result = results[1];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_fieldEnd);
            Assert.assertEquals(result.parentsPath().size(), 5);

            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);
            Assert.assertEquals(result.parentsPath().get(4)._objectType(), ObjectType.hp_ctrl);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ctrl ctrl = (Ctrl) result.parentsPath().get(4);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 3);
            Assert.assertEquals(para.getRunIndex(run), 2);

            Run fieldTextRun = para.getRun(1);
            Assert.assertEquals(fieldTextRun.getRunItem(0)._objectType(), ObjectType.hp_t);
            T t = (T) fieldTextRun.getRunItem(0);
            Assert.assertEquals(t.onlyText(), "필드1");
        }
    }


    @Test
    public void test3() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {
            private String fieldBeginID;

            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_fieldBegin) {
                    FieldBegin fieldBegin = (FieldBegin) thisObject;
                    if (fieldBegin.name().equals("필드x")) {
                        fieldBeginID = fieldBegin.id();
                        return true;
                    }
                }
                if (thisObject._objectType() == ObjectType.hp_fieldEnd) {
                    FieldEnd fieldEnd = (FieldEnd) thisObject;
                    if (fieldEnd.beginIDRef().equals(fieldBeginID)) {
                        return true;
                    }
                }
                return false;
            }
        }

        ObjectFinder.Result[] results = ObjectFinder.find(hwpxFile, new MyFilter(), false);
        Assert.assertEquals(results.length, 0);
    }
}
