package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

/**
 * /content/header_forTestSwitch.xml
 */
public class HeaderXMLFile extends SwitchableObject {
    /**
     * 버전
     */
    private String version;
    /**
     * 섹션 개수
     */
    private Short secCnt;
    private BeginNum beginNum;
    private RefList refList;
    private ObjectList<ForbiddenWord> forbiddenWordList;
    private CompatibleDocument compatibleDocument;
    private DocOption docOption;
    private HasOnlyText metaTag;
    private TrackChangeConfig trackChangeConfig;

    public HeaderXMLFile() {
    }


    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_head;
    }

    public String version() {
        return version;
    }

    public void version(String version) {
        this.version = version;
    }

    public HeaderXMLFile versionAnd(String version) {
        this.version = version;
        return this;
    }

    public Short secCnt() {
        return secCnt;
    }

    public void secCnt(Short secCnt) {
        this.secCnt = secCnt;
    }

    public HeaderXMLFile secCntAnd(Short secCnt) {
        this.secCnt = secCnt;
        return this;
    }

    public BeginNum beginNum() {
        return beginNum;
    }

    public void createBeginNum() {
        beginNum = new BeginNum();
    }

    public void removeBeginNum() {
        beginNum = null;
    }

    public RefList refList() {
        return refList;
    }

    public void createRefList() {
        refList = new RefList();
    }

    public void removeRefList() {
        refList = null;
    }

    public ObjectList<ForbiddenWord> forbiddenWordList() {
        return forbiddenWordList;
    }

    public void createForbiddenWordList() {
        forbiddenWordList = new ObjectList<ForbiddenWord>(ObjectType.hh_forbiddenWordList, ForbiddenWord.class);
    }

    public void removeForbiddenWordList() {
        forbiddenWordList = null;
    }

    public CompatibleDocument compatibleDocument() {
        return compatibleDocument;
    }

    public void createCompatibleDocument() {
        compatibleDocument = new CompatibleDocument();
    }

    public void removeCompatibleDocument() {
        compatibleDocument = null;
    }

    public DocOption docOption() {
        return docOption;
    }

    public void createDocOption() {
        docOption = new DocOption();
    }

    public void removeDocOption() {
        docOption = null;
    }

    public HasOnlyText metaTag() {
        return metaTag;
    }

    public void createMetaTag() {
        metaTag = new HasOnlyText(ObjectType.hh_metaTag);
    }

    public void removeMetaTag() {
        metaTag = null;
    }

    public TrackChangeConfig trackChangeConfig() {
        return trackChangeConfig;
    }

    public void createTrackChangeConfig() {
        trackChangeConfig = new TrackChangeConfig();
    }

    public void removeTrackChangeConfig() {
        trackChangeConfig = null;
    }

    @Override
    public HeaderXMLFile clone() {
        HeaderXMLFile cloned = new HeaderXMLFile();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(HeaderXMLFile from) {
        this.version = from.version;
        this.secCnt = from.secCnt;

        if (from.beginNum != null) {
            beginNum = from.beginNum.clone();
        } else {
            beginNum = null;
        }

        if (from.refList != null) {
            refList = from.refList.clone();
        } else {
            refList = null;
        }

        if (from.forbiddenWordList != null) {
            createForbiddenWordList();
            for (ForbiddenWord forbiddenWord : from.forbiddenWordList.items()) {
                forbiddenWordList.add(forbiddenWord.clone());
            }
        } else {
            forbiddenWordList = null;
        }

        if (from.compatibleDocument != null) {
            compatibleDocument = from.compatibleDocument.clone();
        } else {
            compatibleDocument = null;
        }

        if (from.docOption != null) {
            docOption = from.docOption.clone();
        } else {
            docOption = null;
        }

        if (from.metaTag != null) {
            metaTag = from.metaTag.clone();
        } else {
            metaTag = null;
        }

        if (from.trackChangeConfig != null) {
            trackChangeConfig = from.trackChangeConfig.clone();
        } else {
            trackChangeConfig = null;
        }
    }
}
