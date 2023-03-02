package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Indexmark;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
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
                hasOnlyText(indexmark.firstKey(), name, attrs);
                break;
            case ElementNames.hp_secondKey:
                indexmark.createSecondKey();
                hasOnlyText(indexmark.secondKey(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_firstKey:
                HasOnlyText firstKey = new HasOnlyText(ObjectType.hp_firstKey);
                hasOnlyText(firstKey, name, attrs);
                return firstKey;
            case ElementNames.hp_secondKey:
                HasOnlyText secondKey = new HasOnlyText(ObjectType.hp_secondKey);
                hasOnlyText(secondKey, name, attrs);
                return secondKey;
        }
        return null;
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
