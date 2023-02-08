package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.NumberingReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ParaPropertiesReader extends ElementReader {
    private ObjectList<ParaPr> paraProperties;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ParaProperties;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ParaPr:
                paraPr(paraProperties.addNew(), name, attrs);
                break;
        }

        if (ObjectType.ParaPr.equalElementName(name)) {
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.ParaPr) {
            paraPr((ParaPr) child, name, attrs);
        }
    }

    private void paraPr(ParaPr paraPr, String name, Attributes attrs) {
        ((ParaPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParaPr))
                .paraPr(paraPr);

        xmlFileReader().startElement(name, attrs);

    }

    @Override
    public SwitchableObject switchableObject() {
        return paraProperties;
    }

    public void paraProperties(ObjectList<ParaPr> paraProperties) {
        this.paraProperties = paraProperties;
    }
}
