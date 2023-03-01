package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.SpineItemRef;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class SpineItemRefReader extends ElementReader {
    private SpineItemRef itemRef;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.SpineItemRef;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.idref:
                itemRef.idref(value);
                break;
            case AttributeNames.linear:
                itemRef.linear(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void itemRef(SpineItemRef itemRef) {
        this.itemRef = itemRef;
    }
}
