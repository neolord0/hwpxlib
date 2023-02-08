package kr.dogfoot.hwpxlib.object.root;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetApplicationSort;

/**
 * /version.xml 파일
 */
public class VersionXMLFile extends XMLFile {
    private TargetApplicationSort targetApplication;
    /**
     * 버전
     */
    private Version version;
    /**
     * 운영체제
     */
    private String os;
    /**
     * 응용프로그램
     */
    private String application;
    /**
     * 응용프로그램 버전
     */
    private String appVersion;

    public VersionXMLFile() {
        targetApplication = TargetApplicationSort.WordProcessor;
        version = new Version();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Version_XMLFile;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        return null;    // no child
    }

    public TargetApplicationSort targetApplication() {
        return targetApplication;
    }

    public void targetApplication(TargetApplicationSort targetApplication) {
        this.targetApplication = targetApplication;
    }

    public VersionXMLFile targetApplicationAnd(TargetApplicationSort targetApplication) {
        this.targetApplication = targetApplication;
        return this;
    }

    public Version version() {
        return version;
    }

    public String os() {
        return os;
    }

    public void os(String os) {
        this.os = os;
    }

    public VersionXMLFile osAnd(String os) {
        this.os = os;
        return this;
    }

    public String application() {
        return application;
    }

    public void application(String application) {
        this.application = application;
    }

    public VersionXMLFile applicationAnd(String application) {
        this.application = application;
        return this;
    }

    public String appVersion() {
        return appVersion;
    }

    public void appVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public VersionXMLFile appVersionAnd(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }
}