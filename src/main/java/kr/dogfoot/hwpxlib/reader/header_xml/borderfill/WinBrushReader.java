package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HatchStyle;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class WinBrushReader extends ElementReader {
    private WinBrush winBrush;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.WinBrush;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.faceColor:
                winBrush.faceColor(value);
                break;
            case AttributeNames.hatchColor:
                winBrush.hatchColor(value);
                break;
            case AttributeNames.hatchStyle:
                winBrush.hatchStyle(HatchStyle.fromString(value));
                break;
            case AttributeNames.alpha:
                winBrush.alpha(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void winBrush(WinBrush winBrush) {
        this.winBrush = winBrush;
    }
}
