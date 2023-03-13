package kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class RotationInfoReader extends ElementReader {
    private RotationInfo rotationInfo;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.RotationInfo;
    }

    public void rotationInfo(RotationInfo rotationInfo) {
        this.rotationInfo = rotationInfo;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.angle:
                rotationInfo.angle(ValueConvertor.toShort(value));
                break;
            case AttributeNames.centerX:
                rotationInfo.centerX(ValueConvertor.toLong(value));
                break;
            case AttributeNames.centerY:
                rotationInfo.centerY(ValueConvertor.toLong(value));
                break;
            case AttributeNames.rotateimage:
                rotationInfo.rotateimage(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
