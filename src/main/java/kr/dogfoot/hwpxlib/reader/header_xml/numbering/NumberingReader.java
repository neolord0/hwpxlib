package kr.dogfoot.hwpxlib.reader.header_xml.numbering;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SymMarkSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class NumberingReader extends ElementReader {
    private Numbering numbering;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Numbering;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                numbering.id(value);
                break;
            case AttributeNames.start:
                numbering.start(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ParaHead:
                paraHead(numbering.addNewParaHead(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.ParaHead) {
            paraHead((ParaHead) child, name, attrs);
        }
    }

    private void paraHead(ParaHead paraHead, String name, Attributes attrs) {
        ((ParaHeadReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParaHead))
                .paraHead(paraHead);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return numbering;
    }

    public void numbering(Numbering numbering) {
        this.numbering = numbering;
    }
}
