package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Video;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent.ShapeComponentWriter;

public class VideoWriter extends ShapeComponentWriter {
    public VideoWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Version;
    }

    @Override
    public void write(HWPXObject object) {
        Video video = (Video) object;
        switchObject(video.switchObject());

        xsb()
                .openElement(ElementNames.hp_video)
                .elementWriter(this);
        writeAttributeForShapeComponent(video);
        xsb()
                .attribute(AttributeNames.videotype, video.videotype())
                .attribute(AttributeNames.fileIDRef, video.fileIDRef())
                .attribute(AttributeNames.imageIDRef, video.imageIDRef())
                .attribute(AttributeNames.tag, video.tag());

        writeChildrenForShapeComponent(video);

        writeChildrenForShapeObject(video);

        xsb().closeElement();
        releaseMe();
    }
}
