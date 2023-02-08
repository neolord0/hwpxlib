package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class EncryptionStartKeyGeneration extends HWPXObject {
    private String startKeyGenerationName;
    private Integer keySize;

    public EncryptionStartKeyGeneration() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.StartKeyGeneration;
    }

    public String startKeyGenerationName() {
        return startKeyGenerationName;
    }

    public void startKeyGenerationName(String startKeyGenerationName) {
        this.startKeyGenerationName = startKeyGenerationName;
    }

    public EncryptionStartKeyGeneration startKeyGenerationNameAnd(String startKeyGenerationName) {
        this.startKeyGenerationName = startKeyGenerationName;
        return this;
    }

    public Integer keySize() {
        return keySize;
    }

    public void keySize(Integer keySize) {
        this.keySize = keySize;
    }

    public EncryptionStartKeyGeneration keySizeAnd(Integer keySize) {
        this.keySize = keySize;
        return this;
    }
}
