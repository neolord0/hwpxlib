package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class XAndYFloatReader extends ElementReader {
    private XAndYFloat xAndYFloat;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.XAndYFloat;
    }

    public void xAndYFloat(XAndYFloat xAndYFloat) {
        this.xAndYFloat = xAndYFloat;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.x:
                xAndYFloat.x(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.y:
                xAndYFloat.y(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
