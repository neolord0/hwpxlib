package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class EncryptionData extends SwitchableObject {
    /**
     * checksum 타입
     */
    private String checksumType;
    /**
     * checksum 값
     */
    private String checksum;
    /**
     * 암호화 알고리즘 정보
     */
    private EncryptionAlgorithm algorithm;
    /**
     * 암호화 키 생성 정보
     */
    private EncryptionKeyDerivation keyDerivation;
    /**
     * 시작 키 정보
     */
    private EncryptionStartKeyGeneration startKeyGeneration;


    public EncryptionData() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.EncryptionData;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Algorithm.equalElementName(name)) {
            return new EncryptionAlgorithm();
        } else if (ObjectType.KeyDerivation.equalElementName(name)) {
            return new EncryptionKeyDerivation();
        } else if (ObjectType.StartKeyGeneration.equalElementName(name)) {
            return new EncryptionStartKeyGeneration();
        }
        return null;
    }

    public String checksumType() {
        return checksumType;
    }

    public void checksumType(String checksumType) {
        this.checksumType = checksumType;
    }

    public EncryptionData checksumTypeAnd(String checksumType) {
        this.checksumType = checksumType;
        return this;
    }

    public String checksum() {
        return checksum;
    }

    public void checksum(String checksum) {
        this.checksum = checksum;
    }

    public EncryptionData checksumAnd(String checksum) {
        this.checksum = checksum;
        return this;
    }

    public EncryptionAlgorithm algorithm() {
        return algorithm;
    }

    public void createAlgorithm() {
        algorithm = new EncryptionAlgorithm();
    }

    public void removeAlgorithm() {
        algorithm = null;
    }

    public EncryptionKeyDerivation keyDerivation() {
        return keyDerivation;
    }

    public void createKeyDerivation() {
        keyDerivation = new EncryptionKeyDerivation();
    }

    public void removeKeyDerivation() {
        keyDerivation = null;
    }

    public EncryptionStartKeyGeneration startKeyGeneration() {
        return startKeyGeneration;
    }

    public void createStartKeyGeneration() {
        startKeyGeneration = new EncryptionStartKeyGeneration();
    }

    public void removeStartKeyGeneration() {
        startKeyGeneration = null;
    }
}
