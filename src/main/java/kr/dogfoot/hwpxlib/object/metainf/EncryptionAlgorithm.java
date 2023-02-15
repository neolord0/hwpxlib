package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class EncryptionAlgorithm extends HWPXObject {
    private String algorithmName;
    private String initialisationVector;

    public EncryptionAlgorithm() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_algorithm;
    }

    public String algorithmName() {
        return algorithmName;
    }

    public void algorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public EncryptionAlgorithm algorithmNameAnd(String algorithmName) {
        this.algorithmName = algorithmName;
        return this;
    }

    public String initialisationVector() {
        return initialisationVector;
    }

    public void initialisationVector(String initialisationVector) {
        this.initialisationVector = initialisationVector;
    }

    public EncryptionAlgorithm initialisationVectorAnd(String initialisationVector) {
        this.initialisationVector = initialisationVector;
        return this;
    }
}
