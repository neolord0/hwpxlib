package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class EncryptionKeyDerivation extends HWPXObject {
    private String keyDerivationName;
    private Integer keySize;
    private Integer iterationCount;
    private String salt;

    public EncryptionKeyDerivation() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_key_derivation;
    }

    public String keyDerivationName() {
        return keyDerivationName;
    }

    public void keyDerivationName(String keyDerivationName) {
        this.keyDerivationName = keyDerivationName;
    }

    public EncryptionKeyDerivation keyDerivationNameAnd(String keyDerivationName) {
        this.keyDerivationName = keyDerivationName;
        return this;
    }

    public Integer keySize() {
        return keySize;
    }

    public void keySize(Integer keySize) {
        this.keySize = keySize;
    }

    public EncryptionKeyDerivation keySizeAnd(Integer keySize) {
        this.keySize = keySize;
        return this;
    }

    public Integer iterationCount() {
        return iterationCount;
    }

    public void iterationCount(Integer iterationCount) {
        this.iterationCount = iterationCount;
    }

    public EncryptionKeyDerivation iterationCountAnd(Integer iterationCount) {
        this.iterationCount = iterationCount;
        return this;
    }

    public String salt() {
        return salt;
    }

    public void salt(String salt) {
        this.salt = salt;
    }

    public EncryptionKeyDerivation saltAnd(String salt) {
        this.salt = salt;
        return this;
    }
}
