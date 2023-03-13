package kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.CompatibleDocument;
import kr.dogfoot.hwpxlib.object.content.header_xml.LayoutCompatibilityItem;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetProgramSort;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class CompatibleDocumentReader extends ElementReader {
    private CompatibleDocument compatibleDocument;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CompatibleDocument;
    }


    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.targetProgram:
                compatibleDocument.targetProgram(TargetProgramSort.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_layoutCompatibility:
                compatibleDocument.createLayoutCompatibility();
                layoutCompatibility(compatibleDocument.layoutCompatibility(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_layoutCompatibility:
                ObjectList<LayoutCompatibilityItem> layoutCompatibility = new ObjectList<LayoutCompatibilityItem>(ObjectType.hh_layoutCompatibility, LayoutCompatibilityItem.class);
                layoutCompatibility(layoutCompatibility, name, attrs);
                return layoutCompatibility;
        }
        return null;
    }

    private void layoutCompatibility(ObjectList<LayoutCompatibilityItem> layoutCompatibility, String name, Attributes attrs) {
        ((LayoutCompatibilityReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LayoutCompatibility))
                .layoutCompatibility(layoutCompatibility);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return compatibleDocument;
    }

    public void compatibleDocument(CompatibleDocument compatibleDocument) {
        this.compatibleDocument = compatibleDocument;
    }
}
