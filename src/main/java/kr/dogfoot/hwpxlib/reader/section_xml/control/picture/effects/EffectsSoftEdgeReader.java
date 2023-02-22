package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsSoftEdge;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class EffectsSoftEdgeReader extends ElementReader {
    private EffectsSoftEdge softEdge;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EffectsSoftEdge;
    }

    public void softEdge(EffectsSoftEdge softEdge) {
        this.softEdge = softEdge;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.radius:
                softEdge.radius(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
