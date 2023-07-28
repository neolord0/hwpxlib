package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Video;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeComponent;

public class FromVideo extends FromShapeComponent {
    public FromVideo(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_video;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Video video = (Video) from;
        pushPath(video);

        checkFromShapeComponent(video);

        checkSwitchList(video.switchList());
        popPath();
    }
}
