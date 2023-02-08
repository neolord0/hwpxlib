package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Gradation;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.ImgBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.WinBrush;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class FillBrushReader extends ElementReader {
    private FillBrush fillBrush;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FillBrush;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.WinBrush:
                fillBrush.createWinBrush();
                winBrush(fillBrush.winBrush(), name, attrs);
                break;
            case ElementNames.Gradation:
                fillBrush.createGradation();
                gradation(fillBrush.gradation(), name, attrs);
                break;
            case ElementNames.ImgBrush:
                fillBrush.createImgBrush();
                imageBrush(fillBrush.imgBrush(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.WinBrush) {
            winBrush((WinBrush) child, name, attrs);
        } else if (child.objectType() == ObjectType.Gradation) {
            gradation((Gradation) child, name, attrs);
        } else if (child.objectType() == ObjectType.ImgBrush) {
            imageBrush((ImgBrush) child, name, attrs);
        }
    }

    private void winBrush(WinBrush winBrush, String name, Attributes attrs) {
        ((WinBrushReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.WinBrush))
                .winBrush(winBrush);

        xmlFileReader().startElement(name, attrs);
    }

    private void gradation(Gradation gradation, String name, Attributes attrs) {
        ((GradationReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Gradation))
                .gradation(gradation);

        xmlFileReader().startElement(name, attrs);
    }

    private void imageBrush(ImgBrush imgBrush, String name, Attributes attrs) {
        ((ImageBrushReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ImageBrush))
                .imgBrush(imgBrush);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return fillBrush;
    }

    public void fillBrush(FillBrush fillBrush) {
        this.fillBrush = fillBrush;
    }
}

