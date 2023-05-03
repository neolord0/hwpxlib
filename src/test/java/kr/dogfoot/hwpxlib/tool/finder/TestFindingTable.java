package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Table;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.tool.finder.comm.ObjectFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestFindingTable {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {
            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_tbl) {
                    Table table = (Table) thisObject;
                    Tc firstCell = table.getTr(0).getTc(0);

                    if ("표2_2".equals(firstCell.name())) {
                        return true;
                    }
                }
                return false;
            }
        }

        ObjectFinder.Result[] results = ObjectFinder.find(hwpxFile, new MyFilter(), false);
        Assert.assertEquals(results.length, 1);


        {
            ObjectFinder.Result result = results[0];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_tbl);

            Assert.assertEquals(result.parentsPath().size(), 4);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 12);

            Table table = (Table) result.thisObject();
            Assert.assertEquals(table.rowCnt().intValue(), 2);
            Assert.assertEquals(table.colCnt().intValue(), 2);
        }

    }

    @Test
    public void test2() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {
            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_tbl) {
                    Table table = (Table) thisObject;
                    Tc firstCell = table.getTr(0).getTc(0);

                    if ("표4_4".equals(firstCell.name())) {
                        return true;
                    }
                }
                return false;
            }
        }

        ObjectFinder.Result[] results = ObjectFinder.find(hwpxFile, new MyFilter(), false);
        Assert.assertEquals(results.length, 1);


        {
            ObjectFinder.Result result = results[0];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_tbl);

            Assert.assertEquals(result.parentsPath().size(), 4);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 14);

            Table table = (Table) result.thisObject();
            Assert.assertEquals(table.rowCnt().intValue(), 4);
            Assert.assertEquals(table.colCnt().intValue(), 4);
        }
    }

    @Test
    public void test3() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {
            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_tbl) {
                    Table table = (Table) thisObject;
                    Tc firstCell = table.getTr(0).getTc(0);

                    if ("표0_0".equals(firstCell.name())) {
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
