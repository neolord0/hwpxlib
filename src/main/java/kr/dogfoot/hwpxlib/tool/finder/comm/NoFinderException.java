package kr.dogfoot.hwpxlib.tool.finder.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public class NoFinderException extends Exception {
    private HWPXObject object;

    public NoFinderException(HWPXObject object) {
        this.object = object;
    }

    public HWPXObject object() {
        return object;
    }
}
