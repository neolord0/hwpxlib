package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class XAndYReader extends ElementReader {
    private XAndY xAndY;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.XAndY;
    }

    public void xAndY(XAndY xAndY) {
        this.xAndY = xAndY;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.x:
                xAndY.x(ValueConvertor.toLong(value));
                break;
            case AttributeNames.y:
                xAndY.y(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
