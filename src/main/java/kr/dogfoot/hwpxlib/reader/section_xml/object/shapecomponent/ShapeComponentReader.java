package kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RenderingInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.RotationInfo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public abstract class ShapeComponentReader extends ShapeObjectReader {
    public abstract ShapeComponent shapeComponent();

    @Override
    public ShapeObject shapeObject() {
        return shapeComponent();
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.href:
                shapeComponent().href(value);
                break;
            case AttributeNames.groupLevel:
                shapeComponent().groupLevel(ValueConvertor.toShort(value));
                break;
            case AttributeNames.instid:
                shapeComponent().instid(value);
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_offset:
                shapeComponent().createOffset();
                xAndY(shapeComponent().offset(), name, attrs);
                break;
            case ElementNames.hp_orgSz:
                shapeComponent().createOrgSz();
                widthAndHeight(shapeComponent().orgSz(), name, attrs);
                break;
            case ElementNames.hp_curSz:
                shapeComponent().createCurSz();
                widthAndHeight(shapeComponent().curSz(), name, attrs);
                break;
            case ElementNames.hp_flip:
                shapeComponent().createFlip();
                flip(shapeComponent().flip(), name, attrs);
                break;
            case ElementNames.hp_rotationInfo:
                shapeComponent().createRotationInfo();
                rotationInfo(shapeComponent().rotationInfo(), name, attrs);
                break;
            case ElementNames.hp_renderingInfo:
                shapeComponent().createRenderingInfo();
                renderingInfo(shapeComponent().renderingInfo(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }


    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_offset:
                XAndY offset = new XAndY(ObjectType.hp_offset_for_shapeComponent);
                xAndY(offset, name, attrs);
                return offset;
            case ElementNames.hp_orgSz:
                WidthAndHeight orgSz = new WidthAndHeight(ObjectType.hp_orgSz);
                widthAndHeight(orgSz, name, attrs);
                return orgSz;
            case ElementNames.hp_curSz:
                WidthAndHeight curSz = new WidthAndHeight(ObjectType.hp_curSz);
                widthAndHeight(curSz, name, attrs);
                return curSz;
            case ElementNames.hp_flip:
                Flip flip = new Flip();
                flip(flip, name, attrs);
                return flip;
            case ElementNames.hp_rotationInfo:
                RotationInfo rotationInfo = new RotationInfo();
                rotationInfo(rotationInfo, name, attrs);
                return rotationInfo;
            case ElementNames.hp_renderingInfo:
                RenderingInfo renderingInfo = new RenderingInfo();
                renderingInfo(renderingInfo, name, attrs);
                return renderingInfo;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void flip(Flip flip, String name, Attributes attrs) {
        ((FlipReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Flip))
                .flip(flip);

        xmlFileReader().startElement(name, attrs);
    }


    private void rotationInfo(RotationInfo rotationInfo, String name, Attributes attrs) {
        ((RotationInfoReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.RotationInfo))
                .rotationInfo(rotationInfo);

        xmlFileReader().startElement(name, attrs);
    }

    private void renderingInfo(RenderingInfo renderingInfo, String name, Attributes attrs) {
        ((RenderingInfoReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.RenderingInfo))
                .renderingInfo(renderingInfo);

        xmlFileReader().startElement(name, attrs);

    }
}
