package kr.dogfoot.hwpxlib.tool.finder.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

import java.util.ArrayList;

public interface ObjectFilter {
    boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath);
}
