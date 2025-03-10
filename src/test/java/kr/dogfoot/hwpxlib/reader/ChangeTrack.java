package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TabItemType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.*;
import org.junit.Assert;
import org.junit.Test;

public class ChangeTrack {
    @Test
    public void test() throws Exception {
        HWPXFile file = HWPXReader.fromFilepath("testFile/reader_writer/ChangeTrack.hwpx");
        T t = (T) file.sectionXMLFileList().get(0).getPara(0).getRun(0).getRunItem(1);
        Assert.assertNotNull(t);

        int index = 0;
        for (TItem tItem : t.items()) {
            switch (index) {
                case 0:
                    item0(tItem);
                    break;
                case 1:
                    item1(tItem);
                    break;
                case 2:
                    item2(tItem);
                    break;
                case 3:
                    item3(tItem);
                    break;
                case 4:
                    item4(tItem);
                    break;
                case 5:
                    item5(tItem);
                    break;
                case 6:
                    item6(tItem);
                    break;
                case 7:
                    item7(tItem);
                    break;
                case 8:
                    item8(tItem);
                    break;
                default:
                    Assert.fail();
                    break;
            }
            index++;
        }
    }

    private void item0(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.NormalText);
        NormalText normalText = (NormalText) tItem;
        Assert.assertEquals(normalText.text(), "변경");
    }

    private void item1(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.hp_deleteBegin);
        DeleteBegin deleteBegin = (DeleteBegin) tItem;
        Assert.assertEquals(deleteBegin.Id(), "2");
        Assert.assertEquals(deleteBegin.TcId(), "2");
    }

    private void item2(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.NormalText);
        NormalText normalText = (NormalText) tItem;
        Assert.assertEquals(normalText.text(), " 추적");
    }

    private void item3(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.hp_deleteEnd);
        DeleteEnd deleteEnd = (DeleteEnd) tItem;
        Assert.assertEquals(deleteEnd.Id(), "2");
        Assert.assertEquals(deleteEnd.TcId(), "2");
        Assert.assertEquals(deleteEnd.paraend().booleanValue(), false);
    }

    private void item4(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.NormalText);
        NormalText normalText = (NormalText) tItem;
        Assert.assertEquals(normalText.text(), " ");
    }

    private void item5(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.hp_tab);
        Tab tab = (Tab) tItem;
        Assert.assertEquals(tab.width().intValue(), 3112);
        Assert.assertEquals(tab.leader(), LineType2.NONE);
        Assert.assertEquals(tab.type(), TabItemType.LEFT);
    }

    private void item6(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.hp_insertBegin);
        InsertBegin insertBegin = (InsertBegin) tItem;
        Assert.assertEquals(insertBegin.Id(), "1");
        Assert.assertEquals(insertBegin.TcId(), "1");
    }

    private void item7(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.NormalText);
        NormalText normalText = (NormalText) tItem;
        Assert.assertEquals(normalText.text(), "인간은");
    }

    private void item8(TItem tItem) {
        Assert.assertEquals(tItem._objectType(), ObjectType.hp_insertEnd);
        InsertEnd insertEnd = (InsertEnd) tItem;
        Assert.assertEquals(insertEnd.Id(), "1");
        Assert.assertEquals(insertEnd.TcId(), "1");
        Assert.assertEquals(insertEnd.paraend().booleanValue(), false);
    }
}
