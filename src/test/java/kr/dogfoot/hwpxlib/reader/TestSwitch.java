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
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Border;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.SlashCore;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

public class TestSwitch {
    @Test
	public void test1() throws IOException, ParserConfigurationException, SAXException {
        ElementReaderManager manager = new ElementReaderManager();
        HWPXFile hwpxFile = new HWPXFile();
        ContentFilesReader contentFilesReader = new ContentFilesReader(manager);
        contentFilesReader.read(hwpxFile, new FileInputStream("testFile/reader_writer/header_forTestSwitch.xml"));
        Assert.assertEquals(hwpxFile.headerXMLFile().refList().borderFills().count(), 2);

        {
            BorderFill borderFill = hwpxFile.headerXMLFile().refList().borderFills().get(0);
            Assert.assertEquals(borderFill.switchObject().countOfCaseObject(), 2);
            {
                Case caseObject = borderFill.switchObject().getCaseObject(0);
				Assert.assertEquals(caseObject.requiredNamespace(), "http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");

				Assert.assertEquals(caseObject.countOfChild(), 2);

				{
					HWPXObject object = caseObject.getChild(0);
					Assert.assertEquals(object._objectType(), ObjectType.hh_backSlash);
					SlashCore backSlash = (SlashCore) object;
					Assert.assertEquals(backSlash.type(), SlashType.NONE);
					Assert.assertEquals(backSlash.Crooked().booleanValue(), false);
					Assert.assertEquals(backSlash.isCounter().booleanValue(), true);
				}

				{
					HWPXObject object = caseObject.getChild(1);
					Assert.assertEquals(object._objectType(), ObjectType.hh_leftBorder);
					Border leftBorder = (Border) object;
					Assert.assertEquals(leftBorder.type(), LineType2.NONE);
					Assert.assertEquals(leftBorder.width(), LineWidth.MM_0_1);
					Assert.assertEquals(leftBorder.color(), "#000001");
				}
			}

			{
				Case caseObject = borderFill.switchObject().getCaseObject(1);
				Assert.assertEquals(caseObject.requiredNamespace(), "http://www.hancom.co.kr/hwpml/2022/HwpUnitChar");

				Assert.assertEquals(caseObject.countOfChild(), 2);

				{
					HWPXObject object = caseObject.getChild(0);
					Assert.assertEquals(object._objectType(), ObjectType.hh_backSlash);
					SlashCore backSlash = (SlashCore) object;
					Assert.assertEquals(backSlash.type(), SlashType.NONE);
					Assert.assertEquals(backSlash.Crooked().booleanValue(), true);
					Assert.assertEquals(backSlash.isCounter().booleanValue(), false);
				}

				{
					HWPXObject object = caseObject.getChild(1);
					Assert.assertEquals(object._objectType(), ObjectType.hh_leftBorder);
					Border leftBorder = (Border) object;
					Assert.assertEquals(leftBorder.type(), LineType2.NONE);
					Assert.assertEquals(leftBorder.width(), LineWidth.MM_0_2);
					Assert.assertEquals(leftBorder.color(), "#000002");
				}
			}

			{
				Default defaultObject = borderFill.switchObject().defaultObject();
				Assert.assertEquals(defaultObject.countOfChild(), 2);

				{
					HWPXObject object = defaultObject.getChild(0);
					Assert.assertEquals(object._objectType(), ObjectType.hh_backSlash);
					SlashCore backSlash = (SlashCore) object;
					Assert.assertEquals(backSlash.type(), SlashType.NONE);
					Assert.assertEquals(backSlash.Crooked().booleanValue(), true);
					Assert.assertEquals(backSlash.isCounter().booleanValue(), true);
				}

				{
					HWPXObject object = defaultObject.getChild(1);
					Assert.assertEquals(object._objectType(), ObjectType.hh_leftBorder);
					Border leftBorder = (Border) object;
					Assert.assertEquals(leftBorder.type(), LineType2.NONE);
					Assert.assertEquals(leftBorder.width(), LineWidth.MM_0_3);
					Assert.assertEquals(leftBorder.color(), "#000003");
				}
			}
        }
    }
}
