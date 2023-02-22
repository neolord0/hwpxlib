package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Indexmark;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.FirstKey;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.SecondKey;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.HasOnlyTextReader;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class IndexmarkReader extends ElementReader {
    private Indexmark indexmark;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Indexmark;
    }

    public void indexmark(Indexmark indexmark) {
        this.indexmark = indexmark;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_firstKey:
                indexmark.createFirstKey();
                firstKeySecondKey(indexmark.firstKey(), name, attrs);
                break;
            case ElementNames.hp_secondKey:
                indexmark.createSecondKey();
                firstKeySecondKey(indexmark.secondKey(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_firstKey:
                FirstKey firstKey = new FirstKey();
                firstKeySecondKey(firstKey, name, attrs);
                return firstKey;
            case ElementNames.hp_secondKey:
                SecondKey secondKey = new SecondKey();
                firstKeySecondKey(secondKey, name, attrs);
                return secondKey;
        }
        return null;
    }

    private void firstKeySecondKey(HasOnlyText firstKeySecondKey, String name, Attributes attrs) {
        ((HasOnlyTextReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.HasOnlyText))
                .hasOnlyText(firstKeySecondKey);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
