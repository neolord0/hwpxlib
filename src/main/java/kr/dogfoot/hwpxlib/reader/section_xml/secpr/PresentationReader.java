package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PresentationEffect;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.Presentation;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.borderfill.FillBrushReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class PresentationReader extends ElementReader {
    private Presentation presentation;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Presentation;
    }

    public void presentation(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.effect:
                presentation.effect(PresentationEffect.fromString(value));
                break;
            case AttributeNames.soundIDRef:
                presentation.soundIDRef(value);
                break;
            case AttributeNames.inventText:
                presentation.inventText(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.autoshow:
                presentation.autoshow(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.showtime:
                presentation.showtime(ValueConvertor.toLong(value));
                break;
            case AttributeNames.applyto:
                presentation.applyto(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_fillBrush:
                presentation.createFillBrush();
                fillBrush(presentation.fillBrush(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_fillBrush:
                FillBrush fillBrush = new FillBrush();
                fillBrush(fillBrush, name, attrs);
                return fillBrush;
        }
        return null;
    }

    private void fillBrush(FillBrush fillBrush, String name, Attributes attrs) {
        ((FillBrushReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.FillBrush))
                .fillBrush(fillBrush);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return presentation;
    }
}
