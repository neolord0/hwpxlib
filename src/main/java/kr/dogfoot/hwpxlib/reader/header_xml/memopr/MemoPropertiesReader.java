package kr.dogfoot.hwpxlib.reader.header_xml.memopr;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.MemoPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
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
            case ElementNames.hh_memoPr:
                memoPr(memoProperties.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_memoPr:
                MemoPr memoPr = new MemoPr();
                memoPr(memoPr, name, attrs);
                return memoPr;
        }
        return null;
    }

    private void memoPr(MemoPr memoPr, String name, Attributes attrs) {
        ((MemoPrReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.MemoPr))
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
