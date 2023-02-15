package kr.dogfoot.hwpxlib.reader.header_xml.numbering;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
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
            case ElementNames.hh_numbering:
                numbering(numberings.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_numbering:
                Numbering numbering = new Numbering();
                numbering(numbering, name, attrs);
                return numbering;
        }
        return null;
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
