package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VideoType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Video;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent.ShapeComponentReader;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class VideoReader extends ShapeComponentReader {
    private Video video;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Video;
    }

    @Override
    public ShapeComponent shapeComponent() {
        return video;
    }

    public void video(Video video) {
        this.video = video;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.videotype:
                video.videotype(VideoType.fromString(value));
                break;
            case AttributeNames.fileIDRef:
                video.fileIDRef(value);
                break;
            case AttributeNames.imageIDRef:
                video.imageIDRef(value);
                break;
            case AttributeNames.tag:
                video.tag(value);
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return video;
    }
}
