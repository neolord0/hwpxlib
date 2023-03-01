package kr.dogfoot.hwpxlib.writer.header_xml.reflist.fontface;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontfaces;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FontFacesWriter extends ElementWriter {
    private static final int FontFaceCount = 7;
    public FontFacesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FontFaces;
    }

    @Override
    public void write(HWPXObject object) {
        Fontfaces fontfaces = (Fontfaces) object;
        storeSwitchObject(fontfaces.switchObject());

        xsb()
                .openElement(ElementNames.hh_fontfaces)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, FontFaceCount);

        for (Fontface fontface : fontfaces.fontfaces()) {
            writeChild(ElementWriterSort.FontFace, fontface);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_fontface:
                writeChild(ElementWriterSort.FontFace, child);
                break;
        }
    }
}
