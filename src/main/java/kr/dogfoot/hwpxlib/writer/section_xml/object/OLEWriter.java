package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.OLE;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent.ShapeComponentWriter;

public class OLEWriter extends ShapeComponentWriter {
    public OLEWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.OLE;
    }

    @Override
    public void write(HWPXObject object) {
        OLE ole = (OLE) object;
        switchObject(ole.switchObject());

        xsb()
                .openElement(ElementNames.hp_ole)
                .elementWriter(this);
        writeAttributeForShapeComponent(ole);
        xsb()
                .attribute(AttributeNames.objectType, ole.objectType())
                .attribute(AttributeNames.binaryItemIDRef, ole.binaryItemIDRef())
                .attribute(AttributeNames.hasMoniker, ole.hasMoniker())
                .attribute(AttributeNames.drawAspect, ole.drawAspect())
                .attribute(AttributeNames.eqBaseLine, ole.eqBaseLine());

        writeChildrenForShapeComponent(ole);

        if (ole.extent() != null) {
            xAndY(ElementNames.hc_extent, ole.extent());
        }

        if (ole.lineShape() != null) {
            PictureWriter.lineShape(ole.lineShape(), xsb());
        }

        writeChildrenForShapeObject(ole);

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_extent:
                xAndY(ElementNames.hc_extent, (XAndY) child);
                break;
            case hp_lineShape:
                PictureWriter.lineShape((LineShape) child, xsb());
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
