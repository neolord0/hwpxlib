package kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawText;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class DrawTextWriter extends ElementWriter {
    public DrawTextWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.DrawText;
    }

    @Override
    public void write(HWPXObject object) {
        DrawText drawText = (DrawText) object;
        switchObject(drawText.switchObject());

        xsb()
                .openElement(ElementNames.hp_drawText)
                .elementWriter(this)
                .attribute(AttributeNames.lastWidth, drawText.lastWidth())
                .attribute(AttributeNames.name, drawText.name())
                .attribute(AttributeNames.editable, drawText.editable());

        if (drawText.textMargin() != null) {
            leftRightTopBottom(ElementNames.hp_textMargin, drawText.textMargin());
        }

        if (drawText.subList() != null) {
            writeChild(ElementWriterSort.SubList, drawText.subList());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_textMargin:
                leftRightTopBottom(ElementNames.hp_textMargin, (LeftRightTopBottom) child);
                break;
            case hp_subList:
                writeChild(ElementWriterSort.SubList, child);
                break;
        }
    }
}
