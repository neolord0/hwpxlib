package kr.dogfoot.hwpxlib.tool.textextractor.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public class CannotStartFromException extends Exception {
    private HWPXObject object;

    public CannotStartFromException(HWPXObject object) {
        this.object = object;
    }

    public HWPXObject object() {
        return object;
    }

    @Override
    public String getMessage() {
        if (object != null) {
            return "Cannot start from " + object._objectType();
        } else {
            return "Cannot start from object";
        }
    }
}
