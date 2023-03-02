package kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawText;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.SubListReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
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
                leftRightTopBottom(drawText.textMargin(), name, attrs);
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
                LeftRightTopBottom textMargin = new LeftRightTopBottom(ObjectType.hp_textMargin);
                leftRightTopBottom(textMargin, name, attrs);
                return textMargin;
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
        return drawText;
    }
}
