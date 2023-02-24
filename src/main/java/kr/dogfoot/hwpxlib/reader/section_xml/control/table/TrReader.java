package kr.dogfoot.hwpxlib.reader.section_xml.control.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class TrReader extends ElementReader {
    private Tr tr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Tr;
    }

    public void tr(Tr tr) {
        this.tr = tr;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_tc:
                tc(tr.addNewTc(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_tc:
                Tc tc = new Tc();
                tc(tc, name, attrs);
                return tc;
        }
        return null;
    }

    private void tc(Tc tc, String name, Attributes attrs) {
        ((TcReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Tc))
                .tc(tc);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return tr;
    }
}
