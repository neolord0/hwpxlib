package kr.dogfoot.hwpxlib.reader.header_xml.memopr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.MemoPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.NumberingReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class MemoPropertiesReader extends ElementReader {
    private ObjectList<MemoPr> memoProperties;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.MemoProperties;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.MemoPr:
                memoPr(memoProperties.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.CharPr) {
            memoPr((MemoPr) child, name, attrs);
        }
    }

    private void memoPr(MemoPr memoPr, String name, Attributes attrs) {
        ((MemoPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.MemoPr))
                .memoPr(memoPr);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return memoProperties;
    }

    public void memoProperties(ObjectList<MemoPr> memoProperties) {
        this.memoProperties = memoProperties;
    }
}
