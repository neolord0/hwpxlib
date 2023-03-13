package kr.dogfoot.hwpxlib.writer.section_xml.object.textart;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingShadow;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.textart.TextArtPr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class TextArtPrWriter extends ElementWriter {
    public TextArtPrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TextArtPr;
    }

    @Override
    public void write(HWPXObject object) {
        TextArtPr textArtPr = (TextArtPr) object;
        switchObject(textArtPr.switchObject());

        xsb()
                .openElement(ElementNames.hp_textartPr)
                .elementWriter(this)
                .attribute(AttributeNames.fontName, textArtPr.fontName())
                .attribute(AttributeNames.fontStyle, textArtPr.fontStyle())
                .attribute(AttributeNames.fontType, textArtPr.fontType())
                .attribute(AttributeNames.textShape, textArtPr.textShape())
                .attribute(AttributeNames.lineSpacing, textArtPr.lineSpacing())
                .attribute(AttributeNames.charSpacing, textArtPr.charSpacing())
                .attribute(AttributeNames.align, textArtPr.align());

        if (textArtPr.shadow() != null) {
            DrawingObjectWriter.shadow(textArtPr.shadow(), xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_shadow_for_drawingObject:
                DrawingObjectWriter.shadow((DrawingShadow) child, xsb());
                break;
        }
    }
}
