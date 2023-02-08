package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.SpineItemRef;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;


public class SpineReader extends ElementReader {
    private ObjectList<SpineItemRef> spine;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Spine;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.SpineItemRef:
                itemRef(spine.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.SpineItemRef:
                SpineItemRef itemRef = new SpineItemRef();
                itemRef(itemRef, name, attrs);
                return itemRef;
        }
        return null;
    }


    private void itemRef(SpineItemRef spineItemRef, String name, Attributes attrs) {
        ((SpineItemRefReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.SpineItemRef))
                .itemRef(spineItemRef);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return spine;
    }

    public void spine(ObjectList<SpineItemRef> spine) {
        this.spine = spine;
    }
}
