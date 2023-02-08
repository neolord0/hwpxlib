package kr.dogfoot.hwpxlib.reader.header_xml.numbering;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.charpr.CharPrReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class NumberingsReader extends ElementReader {
    private ObjectList<Numbering> numberings;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Numberings;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Numbering:
                numbering(numberings.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.CharPr) {
            numbering((Numbering) child, name, attrs);
        }
    }

    private void numbering(Numbering numbering, String name, Attributes attrs) {
        ((NumberingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Numbering))
                .numbering(numbering);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return numberings;
    }

    public void numberings(ObjectList<Numbering> numberings) {
        this.numberings = numberings;
    }
}
