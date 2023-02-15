package kr.dogfoot.hwpxlib.object.metainf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class RootFile extends HWPXObject {
    /**
     * 패키지 내부에 경로
     */
    private String fullPath;
    /**
     * 파일의 mime 타입
     */
    private String mediaType;

    public RootFile() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.ocf_rootfile;
    }

    public String fullPath() {
        return fullPath;
    }

    public void fullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public RootFile fullPathAnd(String fullPath) {
        this.fullPath = fullPath;
        return this;
    }

    public String mediaType() {
        return mediaType;
    }

    public void mediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public RootFile mediaTypeAnd(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }
}
