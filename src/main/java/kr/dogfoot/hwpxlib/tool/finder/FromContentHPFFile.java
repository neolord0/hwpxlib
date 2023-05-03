package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ContentHPFFile;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.content.context_hpf.SpineItemRef;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromContentHPFFile extends FinderBase {
    public FromContentHPFFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_package;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ContentHPFFile contentHPFFile = (ContentHPFFile) from;
        pushPath(contentHPFFile);

        for (ManifestItem manifest : contentHPFFile.manifest().items()) {
            check(manifest);
        }

        for (SpineItemRef spine : contentHPFFile.spine().items()) {
            check(spine);
        }

        checkSwitchObject(contentHPFFile.switchObject());
        popPath();
    }
}
