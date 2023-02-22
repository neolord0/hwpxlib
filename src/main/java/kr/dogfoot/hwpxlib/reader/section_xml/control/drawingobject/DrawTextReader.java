package kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.TextMargin;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.LeftRightTopBottomReader;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class DrawTextReader extends ElementReader {
    private DrawText drawText;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.DrawText;
    }

    public void drawText(DrawText drawText) {
        this.drawText = drawText;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.lastWidth:
                drawText.lastWidth(ValueConvertor.toLong(value));
                break;
            case AttributeNames.name:
                drawText.name(value);
                break;
            case AttributeNames.editable:
                drawText.editable(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_textMargin:
                drawText.createTextMargin();
                textMargin(drawText.textMargin(), name, attrs);
                break;
            case ElementNames.hp_subList:
                drawText.createSubList();
                subList(drawText.subList(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_textMargin:
                TextMargin textMargin = new TextMargin();
                textMargin(textMargin, name, attrs);
                return textMargin;
            case ElementNames.hp_subList:
                SubList subList = new SubList();
                subList(subList, name, attrs);
                return subList;
        }
        return null;
    }

    private void textMargin(TextMargin textMargin, String name, Attributes attrs) {
        ((LeftRightTopBottomReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LeftRightTopBottom))
                .leftRightTopBottom(textMargin);

        xmlFileReader().startElement(name, attrs);
    }

    private void subList(SubList subList, String name, Attributes attrs) {
        ((SubListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.SubList))
                .subList(subList);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return drawText;
    }
}
