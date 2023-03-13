package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
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
            case ElementNames.hh_paraPr:
                paraPr(paraProperties.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_paraPr:
                ParaPr paraPr = new ParaPr();
                paraPr(paraPr, name, attrs);
                return paraPr;
        }
        return null;
    }

    private void paraPr(ParaPr paraPr, String name, Attributes attrs) {
        ((ParaPrReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ParaPr))
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
