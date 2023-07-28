package kr.dogfoot.hwpxlib.tool.finder.manifest;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionData;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEncryptionData extends FinderBase {

    public FromEncryptionData(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_encryption_data;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        EncryptionData encryptionData = (EncryptionData) from;
        pushPath(encryptionData);

        check(encryptionData.algorithm());
        check(encryptionData.keyDerivation());
        check(encryptionData.startKeyGeneration());

        checkSwitchList(encryptionData.switchList());
        popPath();
    }
}
