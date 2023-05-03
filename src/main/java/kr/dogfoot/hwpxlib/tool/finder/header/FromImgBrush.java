package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.ImgBrush;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromImgBrush extends FinderBase {
    public FromImgBrush(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_imgBrush;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ImgBrush imgBrush = (ImgBrush) from;
        pushPath(imgBrush);

        check(imgBrush.img());

        checkSwitchObject(imgBrush.switchObject());
        popPath();
    }
}
