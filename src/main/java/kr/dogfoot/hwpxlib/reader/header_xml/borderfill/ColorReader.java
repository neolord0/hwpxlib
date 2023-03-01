package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Color;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ColorReader extends ElementReader {
    private Color color;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Color;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.value:
                color.value(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void color(Color color) {
        this.color = color;
    }
}
