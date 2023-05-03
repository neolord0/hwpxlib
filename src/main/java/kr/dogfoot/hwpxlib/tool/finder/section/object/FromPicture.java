package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Picture;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromShapeComponent;

public class FromPicture extends FromShapeComponent {
    public FromPicture(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_pic;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Picture picture = (Picture) from;
        pushPath(picture);

        checkFromShapeComponent(picture);

        check(picture.lineShape());
        check(picture.imgRect());
        check(picture.imgClip());
        check(picture.inMargin());
        check(picture.imgDim());
        check(picture.img());
        checkWithChildren(picture.effects());

        checkSwitchObject(picture.switchObject());
        popPath();
    }
}
