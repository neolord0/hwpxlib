package kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FillBrushWriter extends ElementWriter {
    public FillBrushWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FillBrush;
    }

    @Override
    public void write(HWPXObject object) {
        FillBrush fillBrush = (FillBrush) object;
        storeSwitchObject(fillBrush.switchObject());

        xsb()
                .openElement(ElementNames.hc_fillBrush)
                .elementWriter(this);

        if (fillBrush.winBrush() != null) {
            winBrush(fillBrush.winBrush());
        }

        if (fillBrush.gradation() != null) {
            writeChild(ElementWriterSort.Gradation, fillBrush.gradation());
        }

        if (fillBrush.imgBrush() != null) {
            writeChild(ElementWriterSort.ImageBrush, fillBrush.imgBrush());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void winBrush(WinBrush winBrush) {
        xsb()
                .openElement(ElementNames.hc_winBrush)
                .attribute(AttributeNames.faceColor, winBrush.faceColor())
                .attribute(AttributeNames.hatchColor, winBrush.hatchColor());
        if (winBrush.hatchStyle() != null) {
            xsb().attribute(AttributeNames.hatchStyle, winBrush.hatchStyle().str());
        }
        xsb()
                .attribute(AttributeNames.alpha, winBrush.alpha())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_winBrush:
                winBrush((WinBrush) child);
                break;
            case hc_gradation:
                writeChild(ElementWriterSort.Gradation, child);
                break;
            case hc_imgBrush:
                writeChild(ElementWriterSort.ImageBrush, child);
                break;
        }
    }
}
