package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Video;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class VideoReader extends ElementReader {
    private Video video;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Video;
    }

    public void video(Video video) {
        this.video = video;
    }

    @Override
    public SwitchableObject switchableObject() {
        return video;
    }
}
