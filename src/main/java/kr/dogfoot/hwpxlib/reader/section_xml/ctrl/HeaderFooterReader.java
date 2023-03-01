package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ApplyPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.HeaderFooterType;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import org.xml.sax.Attributes;

public class HeaderFooterReader extends ElementReader {
    private HeaderFooterType headerFooter;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.HeaderFooter;
    }

    public void headerFooter(HeaderFooterType headerFooter) {
        this.headerFooter = headerFooter;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                headerFooter.id(value);
                break;
            case AttributeNames.applyPageType:
                headerFooter.applyPageType(ApplyPageType.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_subList:
                headerFooter.createSubList();
                subList(headerFooter.subList(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_subList:
                SubList subList = new SubList();
                subList(subList, name, attrs);
                return subList;
        }
        return null;
    }

    private void subList(SubList subList, String name, Attributes attrs) {
        ((SubListReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.SubList))
                .subList(subList);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return headerFooter;
    }
}
