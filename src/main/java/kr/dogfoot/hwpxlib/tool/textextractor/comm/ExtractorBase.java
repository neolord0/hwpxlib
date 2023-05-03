package kr.dogfoot.hwpxlib.tool.textextractor.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.paraHead.ParaHeadMaker;

public abstract class ExtractorBase {
    protected final ExtractorManager extractorManager;
    protected final Parameter parameter;

    public ExtractorBase(ExtractorManager extractorManager, Parameter parameter) {
        this.extractorManager = extractorManager;
        this.parameter = parameter;
    }

    public abstract ObjectType _objectType();

    public abstract void extract(HWPXObject from) throws Exception;

    public void extractChild(HWPXObject child) throws Exception {
        ExtractorBase extractor = extractorManager.get(child._objectType());
        extractor.extract(child);

        extractorManager.release(extractor);
    }

    protected ParaHeadMaker paraHeadMaker() {
        return parameter.paraHeadMaker();
    }

    protected TextBuilder textBuilder() {
        return parameter.textBuilder();
    }
}
