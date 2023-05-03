package kr.dogfoot.hwpxlib.tool.textextractor.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;

public class NoWorkingExtractor extends ExtractorBase {
    public NoWorkingExtractor(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.Unknown;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
    }
}
