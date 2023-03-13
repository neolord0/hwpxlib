package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Container;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent.ShapeComponentWriter;

public class ContainerControlWriter extends ShapeComponentWriter {
    public ContainerControlWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ContainerControl;
    }

    @Override
    public void write(HWPXObject object) {
        Container container = (Container) object;
        switchObject(container.switchObject());

        xsb()
                .openElement(ElementNames.hp_container)
                .elementWriter(this);
        writeAttributeForShapeComponent(container);

        writeChildrenForShapeComponent(container);

        for (ShapeComponent child : container.children()) {
            child(child);
        }

        writeChildrenForShapeObject(container);

        xsb().closeElement();
        releaseMe();
    }

    private boolean child(ShapeComponent child) {
        switch (child._objectType()) {
            case hp_pic:
                writeChild(ElementWriterSort.Picture, child);
                return true;
            case hp_ole:
                writeChild(ElementWriterSort.OLE, child);
                return true;
            case hp_container:
                writeChild(ElementWriterSort.ContainerControl, child);
                return true;
            case hp_line:
                writeChild(ElementWriterSort.Line, child);
                return true;
            case hp_rect:
                writeChild(ElementWriterSort.Rectangle, child);
                return true;
            case hp_ellipse:
                writeChild(ElementWriterSort.Ellipse, child);
                return true;
            case hp_arc:
                writeChild(ElementWriterSort.Arc, child);
                return true;
            case hp_polygon:
                writeChild(ElementWriterSort.Polygon, child);
                return true;
            case hp_curve:
                writeChild(ElementWriterSort.Curve, child);
                return true;
            case hp_connectLine:
                writeChild(ElementWriterSort.ConnectLine, child);
                return true;
            case hp_textart:
                writeChild(ElementWriterSort.TextArt, child);
                return true;
        }
        return false;
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        boolean wrote = false;
        if (child instanceof ShapeComponent) {
            wrote = child((ShapeComponent) child);
        }

        if (!wrote) {
            super.childInSwitch(child);
        }
    }
}
