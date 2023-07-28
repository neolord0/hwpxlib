package kr.dogfoot.hwpxlib.writer.header_xml.compatibledocument;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.CompatibleDocument;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CompatibleDocumentWriter extends ElementWriter {
    public CompatibleDocumentWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        CompatibleDocument compatibleDocument = (CompatibleDocument) object;
        switchList(compatibleDocument.switchList());

        xsb()
                .openElement(ElementNames.hh_compatibleDocument)
                .elementWriter(this)
                .attribute(AttributeNames.targetProgram, compatibleDocument.targetProgram());

        if (compatibleDocument.layoutCompatibility() != null) {
            writeChild(ElementWriterSort.LayoutCompatibility, compatibleDocument.layoutCompatibility());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_layoutCompatibility:
                writeChild(ElementWriterSort.LayoutCompatibility, child);
                break;
        }
    }
}
