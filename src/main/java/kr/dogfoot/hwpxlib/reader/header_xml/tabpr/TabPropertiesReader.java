package kr.dogfoot.hwpxlib.reader.header_xml.tabpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.charpr.CharPrReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class TabPropertiesReader extends ElementReader {
    private ObjectList<TabPr> tabProperties;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TabProperties;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.TabPr:
                tabPr(tabProperties.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.TabPr) {
            tabPr((TabPr) child, name, attrs);
        }
    }

    private void tabPr(TabPr tabPr, String name, Attributes attrs) {
        ((TabPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TabPr))
                .tabPr(tabPr);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return tabProperties;
    }

    public void tabProperties(ObjectList<TabPr> tabProperties) {
        this.tabProperties = tabProperties;
    }
}
