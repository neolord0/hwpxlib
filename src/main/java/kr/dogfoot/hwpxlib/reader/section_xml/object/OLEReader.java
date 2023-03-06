package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.OLEDrawAspect;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.OLEObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.OLE;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.picture.LineShapeReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent.ShapeComponentReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class OLEReader extends ShapeComponentReader {
    private OLE ole;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.OLE;
    }

    @Override
    public ShapeComponent shapeComponent() {
        return ole;
    }

    public void ole(OLE ole) {
        this.ole = ole;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.objectType:
                ole.objectType(OLEObjectType.fromString(value));
                break;
            case AttributeNames.binaryItemIDRef:
                ole.binaryItemIDRef(value);
                break;
            case AttributeNames.hasMoniker:
                ole.hasMoniker(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.drawAspect:
                ole.drawAspect(OLEDrawAspect.fromString(value));
                break;
            case AttributeNames.eqBaseLine:
                ole.eqBaseLine(ValueConvertor.toInteger(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_extent:
                ole.createExtent();
                xAndY(ole.extent(), name, attrs);
                break;
            case ElementNames.hp_lineShape:
                ole.createLineShape();
                lineShape(ole.lineShape(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_extent:
                XAndY extent = new XAndY(ObjectType.hc_extent);
                xAndY(extent, name, attrs);
                return extent;
            case ElementNames.hp_lineShape:
                LineShape lineShape = new LineShape();
                lineShape(lineShape, name, attrs);
                return lineShape;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void lineShape(LineShape lineShape, String name, Attributes attrs) {
        ((LineShapeReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LineShape))
                .lineShape(lineShape);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return ole;
    }
}
