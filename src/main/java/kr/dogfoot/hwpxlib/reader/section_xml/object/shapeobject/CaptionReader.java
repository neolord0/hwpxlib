package kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.CaptionSide;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class CaptionReader extends ElementReader {
    private Caption caption;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Caption;
    }

    public void caption(Caption caption) {
        this.caption = caption;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.side:
                caption.side(CaptionSide.fromString(value));
                break;
            case AttributeNames.fullSz:
                caption.fullSz(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.width:
                caption.width(ValueConvertor.toLong(value));
                break;
            case AttributeNames.gap:
                caption.gap(ValueConvertor.toLong(value));
                break;
            case AttributeNames.lastWidth:
                caption.lastWidth(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_subList:
                caption.createSubList();
                subList(caption.subList(), name, attrs);
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
        return caption;
    }
}
