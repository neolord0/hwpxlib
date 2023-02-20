package kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.WidthAndHeightReader;
import kr.dogfoot.hwpxlib.reader.common.baseobject.XAndYReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
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
                offset(shapeComponent().offset(), name, attrs);
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
                Offset offset = new Offset();
                offset(offset, name, attrs);
                return offset;
            case ElementNames.hp_orgSz:
                OriginalSize orgSz = new OriginalSize();
                widthAndHeight(orgSz, name, attrs);
                return orgSz;
            case ElementNames.hp_curSz:
                CurrentSize curSz = new CurrentSize();
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

    private void offset(Offset offset, String name, Attributes attrs) {
        ((XAndYReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.XAndY))
                .xAndY(offset);

        xmlFileReader().startElement(name, attrs);
    }

    private void widthAndHeight(WidthAndHeight widthAndHeight, String name, Attributes attrs) {
        ((WidthAndHeightReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.WidthAndHeight))
                .widthAndHeight(widthAndHeight);

        xmlFileReader().startElement(name, attrs);
    }

    private void flip(Flip flip, String name, Attributes attrs) {
        ((FlipReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Flip))
                .flip(flip);

        xmlFileReader().startElement(name, attrs);
    }


    private void rotationInfo(RotationInfo rotationInfo, String name, Attributes attrs) {
        ((RotationInfoReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.RotationInfo))
                .rotationInfo(rotationInfo);

        xmlFileReader().startElement(name, attrs);
    }

    private void renderingInfo(RenderingInfo renderingInfo, String name, Attributes attrs) {
        ((RenderingInfoReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.RenderingInfo))
                .renderingInfo(renderingInfo);

        xmlFileReader().startElement(name, attrs);

    }
}
