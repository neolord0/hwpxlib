package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

import javax.print.Doc;

/**
 * /content/header_forTestSwitch.xml
 */
public class HeaderXMLFile extends XMLFile {
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
    private TrackChangeConfig trackChangeConfig;

    public HeaderXMLFile() {
    }


    @Override
    public ObjectType objectType() {
        return ObjectType.Headers_XMLFile;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.BeginNum.equalElementName(name)) {
            return new BeginNum();
        } else if (ObjectType.RefList.equalElementName(name)) {
            return new RefList();
        } else if (ObjectType.ForbiddenWordList.equalElementName(name)) {
            return new ObjectList<ForbiddenWord>(ObjectType.ForbiddenWordList, ForbiddenWord.class);
        } else if (ObjectType.CompatibleDocument.equalElementName(name)) {
            return new CompatibleDocument();
        } else if (ObjectType.DocOption.equalElementName(name)) {
            return new DocOption();
        } else if (ObjectType.TrackChangeConfig.equalElementName(name)) {
            return new TrackChangeConfig();
        }
        return null;
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
        forbiddenWordList = new ObjectList<ForbiddenWord>(ObjectType.ForbiddenWordList, ForbiddenWord.class);
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

    public TrackChangeConfig trackChangeConfig() {
        return trackChangeConfig;
    }

    public void createTrackChangeConfig() {
        trackChangeConfig = new TrackChangeConfig();
    }

    public void removeTrackChangeConfig() {
        trackChangeConfig = new TrackChangeConfig();
    }

}
