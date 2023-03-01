package kr.dogfoot.hwpxlib.reader.section_xml.control.etc;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FontType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextArtAlign;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextArtShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.textart.TextArtPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingShadowReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class TextArtPrReader extends ElementReader {
    private TextArtPr textArtPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TextArtPr;
    }

    public void textArtPr(TextArtPr textArtPr) {
        this.textArtPr = textArtPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.fontName:
                textArtPr.fontName(value);
                break;
            case AttributeNames.fontStyle:
                textArtPr.fontStyle(value);
                break;
            case AttributeNames.fontType:
                textArtPr.fontType(FontType2.fromString(value));
                break;
            case AttributeNames.textShape:
                textArtPr.textShape(TextArtShape.fromString(value));
                break;
            case AttributeNames.lineSpacing:
                textArtPr.lineSpacing(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.charSpacing:
                textArtPr.charSpacing(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.align:
                textArtPr.align(TextArtAlign.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_shadow:
                textArtPr.createShadow();
                shadow(textArtPr.shadow(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_shadow:
                DrawingShadow shadow = new DrawingShadow();
                shadow(shadow, name, attrs);
                return shadow;
        }

        return null;
    }

    private void shadow(DrawingShadow shadow, String name, Attributes attrs) {
        ((DrawingShadowReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.DrawingShadow))
                .shadow(shadow);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
