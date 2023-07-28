package kr.dogfoot.hwpxlib.writer.header_xml.reflist;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Style;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class StylesWriter extends ElementWriter {
    public StylesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Styles;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<Style> styles = (ObjectList<Style>) object;
        switchList(styles.switchList());
        if (styles.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_styles)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, styles.count());

        for (Style style : styles.items()) {
            style(style);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void style(Style style) {
        xsb()
                .openElement(ElementNames.hh_style)
                .attribute(AttributeNames.id, style.id())
                .attribute(AttributeNames.type, style.type())
                .attribute(AttributeNames.name, style.name())
                .attribute(AttributeNames.engName, style.engName())
                .attribute(AttributeNames.paraPrIDRef, style.paraPrIDRef())
                .attribute(AttributeNames.charPrIDRef, style.charPrIDRef())
                .attribute(AttributeNames.nextStyleIDRef, style.nextStyleIDRef())
                .attribute(AttributeNames.langID, style.langID())
                .attribute(AttributeNames.lockForm, style.lockForm())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_style:
                style((Style) child);
                break;
        }
    }
}
