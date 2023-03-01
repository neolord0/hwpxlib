package kr.dogfoot.hwpxlib.reader.header_xml.style;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Style;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class StylesReader extends ElementReader {
    private ObjectList<Style> styles;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Styles;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_style:
                style(styles.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_style:
                Style style = new Style();
                style(style, name, attrs);
                return style;
        }
        return null;
    }

    private void style(Style style, String name, Attributes attrs) {
        ((StyleReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Style))
                .style(style);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return styles;
    }

    public void styles(ObjectList<Style> styles) {
        this.styles = styles;
    }
}
