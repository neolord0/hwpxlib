package kr.dogfoot.hwpxlib.writer.header_xml.reflist.fontface;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FontFaceWriter extends ElementWriter {
    public FontFaceWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FontFace;
    }

    @Override
    public void write(HWPXObject object) {
        Fontface fontface = (Fontface) object;
        switchObject(fontface.switchObject());

        xsb()
                .openElement(ElementNames.hh_fontface)
                .elementWriter(this)
                .attribute(AttributeNames.lang, fontface.lang())
                .attribute(AttributeNames.fontCnt, fontface.countOfFont());

        for (Font font : fontface.fonts()) {
            writeChild(ElementWriterSort.Font, font);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_font:
                writeChild(ElementWriterSort.Font, child);
                break;
        }
    }
}
