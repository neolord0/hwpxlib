package kr.dogfoot.hwpxlib.reader.header_xml.fontface;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontFamilyType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.TypeInfo;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class TypeInfoReader extends ElementReader {
    private TypeInfo typeInfo;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TypeInfo;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.familyType:
                typeInfo.familyType(FontFamilyType.fromString(value));
                break;
            case AttributeNames.serifStyle:
                typeInfo.serifStyle(value);
                break;
            case AttributeNames.weight:
                typeInfo.weight(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.proportion:
                typeInfo.proportion(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.contrast:
                typeInfo.contrast(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.strokeVariation:
                typeInfo.strokeVariation(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.armStyle:
                typeInfo.armStyle(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.letterform:
                typeInfo.letterform(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.midline:
                typeInfo.midline(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.xHeight:
                typeInfo.xHeightAnd(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void typeInfo(TypeInfo typeInfo) {
        this.typeInfo = typeInfo;
    }
}
