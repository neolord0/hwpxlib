package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.ColorSchema;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class ColorSchemaReader extends ElementReader {
    private ColorSchema schema;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColorSchema;
    }

    public void schema(ColorSchema schema) {
        this.schema = schema;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.r:
                schema.r(ValueConvertor.toShort(value));
                break;
            case AttributeNames.g:
                schema.g(ValueConvertor.toShort(value));
                break;
            case AttributeNames.b:
                schema.b(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
