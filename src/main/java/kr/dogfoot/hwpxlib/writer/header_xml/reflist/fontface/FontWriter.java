package kr.dogfoot.hwpxlib.writer.header_xml.reflist.fontface;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.SubstFont;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.TypeInfo;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FontWriter extends ElementWriter {
    public FontWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Font;
    }

    @Override
    public void write(HWPXObject object) {
        Font font = (Font) object;
        switchObject(font.switchObject());

        xsb()
                .openElement(ElementNames.hh_font)
                .elementWriter(this)
                .attribute(AttributeNames.id, font.id())
                .attribute(AttributeNames.face, font.face())
                .attribute(AttributeNames.type, font.type())
                .attribute(AttributeNames.isEmbedded, font.isEmbedded())
                .attribute(AttributeNames.binaryItemIDRef, font.binaryItemIDRef());

        if (font.substFont() != null) {
            substFont(font.substFont());
        }

        if (font.typeInfo() != null) {
            typeInfo(font.typeInfo());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void substFont(SubstFont substFont) {
        xsb()
                .openElement(ElementNames.hh_substFont)
                .attribute(AttributeNames.face, substFont.face())
                .attribute(AttributeNames.type, substFont.type())
                .attribute(AttributeNames.isEmbedded, substFont.isEmbedded())
                .attribute(AttributeNames.binaryItemIDRef, substFont.binaryItemIDRef())
                .closeElement();
    }

    private void typeInfo(TypeInfo typeInfo) {
        xsb()
                .openElement(ElementNames.hh_typeInfo)
                .attribute(AttributeNames.familyType, typeInfo.familyType())
                .attribute(AttributeNames.serifStyle, typeInfo.serifStyle())
                .attribute(AttributeNames.weight, typeInfo.weight())
                .attribute(AttributeNames.proportion, typeInfo.proportion())
                .attribute(AttributeNames.contrast, typeInfo.contrast())
                .attribute(AttributeNames.strokeVariation, typeInfo.strokeVariation())
                .attribute(AttributeNames.armStyle, typeInfo.armStyle())
                .attribute(AttributeNames.letterform, typeInfo.letterform())
                .attribute(AttributeNames.midline, typeInfo.midline())
                .attribute(AttributeNames.xHeight, typeInfo.xHeight())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_substFont:
                substFont((SubstFont) child);
                break;
            case hh_typeInfo:
                typeInfo((TypeInfo) child);
                break;
        }
    }
}
