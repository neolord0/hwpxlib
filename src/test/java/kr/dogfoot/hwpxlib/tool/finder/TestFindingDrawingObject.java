package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Arc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Ellipse;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Rectangle;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.tool.finder.comm.ObjectFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestFindingDrawingObject {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {

            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_rect) {
                    Rectangle rectangle = (Rectangle) thisObject;
                    if (rectangle.drawText() != null &&
                            "사각형2".equals(rectangle.drawText().name())) {
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
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_rect);

            Assert.assertEquals(result.parentsPath().size(), 4);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Rectangle rectangle = (Rectangle) result.thisObject();

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 15);
            Assert.assertEquals(para.getRunIndex(run), 0);
            Assert.assertEquals(run.getRunItemIndex(rectangle), 1);
        }

        {
            ObjectFinder.Result result = results[1];
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_rect);

            Assert.assertEquals(result.parentsPath().size(), 4);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Rectangle rectangle = (Rectangle) result.thisObject();

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 15);
            Assert.assertEquals(para.getRunIndex(run), 0);
            Assert.assertEquals(run.getRunItemIndex(rectangle), 2);
        }
    }

    @Test
    public void test2() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {

            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_ellipse) {
                    Ellipse ellipse = (Ellipse) thisObject;
                    if (ellipse.drawText() != null &&
                            "타원".equals(ellipse.drawText().name())) {
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
            Assert.assertEquals(result.thisObject()._objectType(), ObjectType.hp_ellipse);

            Assert.assertEquals(result.parentsPath().size(), 4);
            Assert.assertEquals(result.parentsPath().get(0)._objectType(), ObjectType.HWPXFile);
            Assert.assertEquals(result.parentsPath().get(1)._objectType(), ObjectType.hs_sec);
            Assert.assertEquals(result.parentsPath().get(2)._objectType(), ObjectType.hp_p);
            Assert.assertEquals(result.parentsPath().get(3)._objectType(), ObjectType.hp_run);

            SectionXMLFile sectionXMLFile = (SectionXMLFile) result.parentsPath().get(1);
            Para para = (Para) result.parentsPath().get(2);
            Run run = (Run) result.parentsPath().get(3);
            Ellipse ellipse = (Ellipse) result.thisObject();

            Assert.assertEquals(sectionXMLFile.getParaIndex(para), 15);
            Assert.assertEquals(para.getRunIndex(run), 0);
            Assert.assertEquals(run.getRunItemIndex(ellipse), 3);
        }
    }

    @Test
    public void test3() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/finder/TestFinder.hwpx");

        class MyFilter implements ObjectFilter {

            @Override
            public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
                if (thisObject._objectType() == ObjectType.hp_arc) {
                    Arc arc = (Arc) thisObject;
                    if (arc.drawText() != null &&
                            "x".equals(arc.drawText().name())) {
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
