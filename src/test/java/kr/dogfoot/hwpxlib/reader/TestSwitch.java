package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Default;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SlashType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.BackSlash;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.LeftBorder;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

public class TestSwitch {
    @Test
    void test1() throws IOException, ParserConfigurationException, SAXException {
        ElementReaderManager manager = new ElementReaderManager();
        HWPXFile hwpxFile = new HWPXFile();
        ContentFilesReader contentFilesReader = new ContentFilesReader(manager);
        contentFilesReader.read(hwpxFile, new FileInputStream("testFile/header_forTestSwitch.xml"));
        Assert.assertEquals(2, hwpxFile.headerXMLFile().refList().borderFills().count());

        {
            BorderFill borderFill = hwpxFile.headerXMLFile().refList().borderFills().get(0);
            Assert.assertEquals(2, borderFill.switchObject().countOfCaseObject());
            {
                Case caseObject = borderFill.switchObject().getCaseObject(0);
				Assert.assertEquals("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar", caseObject.requiredNamespace());

				Assert.assertEquals(2, caseObject.countOfChild());

				{
					HWPXObject object = caseObject.getChild(0);
					Assert.assertEquals(ObjectType.BackSlash, object.objectType());
					BackSlash backSlash = (BackSlash) object;
					Assert.assertEquals(SlashType.NONE, backSlash.type());
					Assert.assertEquals(false, backSlash.Crooked().booleanValue());
					Assert.assertEquals(true, backSlash.isCounter().booleanValue());
				}

				{
					HWPXObject object = caseObject.getChild(1);
					Assert.assertEquals(ObjectType.LeftBorder, object.objectType());
					LeftBorder leftBorder = (LeftBorder) object;
					Assert.assertEquals(LineType2.NONE, leftBorder.type());
					Assert.assertEquals(LineWidth.MM_0_1, leftBorder.width());
					Assert.assertEquals("#000001", leftBorder.color());
				}
			}

			{
				Case caseObject = borderFill.switchObject().getCaseObject(1);
				Assert.assertEquals("http://www.hancom.co.kr/hwpml/2022/HwpUnitChar", caseObject.requiredNamespace());

				Assert.assertEquals(2, caseObject.countOfChild());

				{
					HWPXObject object = caseObject.getChild(0);
					Assert.assertEquals(ObjectType.BackSlash, object.objectType());
					BackSlash backSlash = (BackSlash) object;
					Assert.assertEquals(SlashType.NONE, backSlash.type());
					Assert.assertEquals(true, backSlash.Crooked().booleanValue());
					Assert.assertEquals(false, backSlash.isCounter().booleanValue());
				}

				{
					HWPXObject object = caseObject.getChild(1);
					Assert.assertEquals(ObjectType.LeftBorder, object.objectType());
					LeftBorder leftBorder = (LeftBorder) object;
					Assert.assertEquals(LineType2.NONE, leftBorder.type());
					Assert.assertEquals(LineWidth.MM_0_2, leftBorder.width());
					Assert.assertEquals("#000002", leftBorder.color());
				}
			}

			{
				Default defaultObject = borderFill.switchObject().defaultObject();
				Assert.assertEquals(2, defaultObject.countOfChild());

				{
					HWPXObject object = defaultObject.getChild(0);
					Assert.assertEquals(ObjectType.BackSlash, object.objectType());
					BackSlash backSlash = (BackSlash) object;
					Assert.assertEquals(SlashType.NONE, backSlash.type());
					Assert.assertEquals(true, backSlash.Crooked().booleanValue());
					Assert.assertEquals(true, backSlash.isCounter().booleanValue());
				}

				{
					HWPXObject object = defaultObject.getChild(1);
					Assert.assertEquals(ObjectType.LeftBorder, object.objectType());
					LeftBorder leftBorder = (LeftBorder) object;
					Assert.assertEquals(LineType2.NONE, leftBorder.type());
					Assert.assertEquals(LineWidth.MM_0_3, leftBorder.width());
					Assert.assertEquals("#000003", leftBorder.color());
				}
			}
        }
    }
}
