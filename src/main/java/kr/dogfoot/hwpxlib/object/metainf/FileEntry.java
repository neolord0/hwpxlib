package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class FileEntry extends SwitchableObject {
    /**
     * 패키지 내부에 경로
     */
    private String fullPath;
    /**
     * 파일의 mime 타입
     */
    private String mediaType;
    /**
     * 원본 파일의 크기
     */
    private Long size;
    /**
     * 암호화 정보
     */
    private EncryptionData encryptionData;

    public FileEntry() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.odf_file_entry;
    }

    public String fullPath() {
        return fullPath;
    }

    public void fullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public FileEntry fullPathAnd(String fullPath) {
        this.fullPath = fullPath;
        return this;
    }

    public String mediaType() {
        return mediaType;
    }

    public FileEntry mediaTypeAnd(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public void mediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Long size() {
        return size;
    }

    public void size(Long size) {
        this.size = size;
    }

    public FileEntry sizeAnd(Long size) {
        this.size = size;
        return this;
    }


    public EncryptionData encryptionData() {
        return encryptionData;
    }

    public void createEncryptionData() {
        encryptionData = new EncryptionData();
    }

    public void removeEncryptionData() {
        encryptionData = null;
    }

    @Override
    public FileEntry clone() {
        FileEntry cloned = new FileEntry();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FileEntry from) {
        this.fullPath = from.fullPath;
        this.mediaType = from.mediaType;
        this.size = from.size;

        if (from.encryptionData != null) {
            encryptionData = from.encryptionData.clone();
        } else {
            encryptionData = null;
        }
    }
}
