package kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.CompatibleDocument;
import kr.dogfoot.hwpxlib.object.content.header_xml.ForbiddenWord;
import kr.dogfoot.hwpxlib.object.content.header_xml.LayoutCompatibilityItem;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetProgramSort;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.memopr.MemoPrReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
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
            case ElementNames.LayoutCompatibility:
                compatibleDocument.createLayoutCompatibility();
                layoutCompatibility(compatibleDocument.layoutCompatibility(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.LayoutCompatibility) {
            layoutCompatibility((ObjectList<LayoutCompatibilityItem>) child, name, attrs);
        }
    }

    private void layoutCompatibility(ObjectList<LayoutCompatibilityItem> layoutCompatibility, String name, Attributes attrs) {
        ((LayoutCompatibilityReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LayoutCompatibility))
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
