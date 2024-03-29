package kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.LayoutCompatibilityItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class LayoutCompatibilityReader extends ElementReader {
    private ObjectList<LayoutCompatibilityItem> layoutCompatibility;

    @Override
    public ElementReaderSort sort() {
        return null;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        layoutCompatibilityItem(layoutCompatibility.addNew(), name, attrs);
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        LayoutCompatibilityItem item = new LayoutCompatibilityItem();
        layoutCompatibilityItem(item, name, attrs);
        return item;
    }

    private void layoutCompatibilityItem(LayoutCompatibilityItem item, String name, Attributes attrs) {
        ((LayoutCompatibilityItemReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LayoutCompatibilityItem))
                .layoutCompatibilityItem(item.nameAnd(name));

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return layoutCompatibility;
    }

    public void layoutCompatibility(ObjectList<LayoutCompatibilityItem> layoutCompatibility) {
        this.layoutCompatibility = layoutCompatibility;
    }
}
