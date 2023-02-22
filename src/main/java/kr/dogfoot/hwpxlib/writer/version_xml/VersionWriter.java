package kr.dogfoot.hwpxlib.writer.version_xml;

import kr.dogfoot.hwpxlib.CommonString;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class VersionWriter {
    public static void write(VersionXMLFile versionXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hv_HCFVersion)
                .attribute(AttributeNames.xmlns_hv, CommonString.xmlns_hv)
                .attribute(AttributeNames.tagetApplication, versionXMLFile.targetApplication().str())
                .attribute(AttributeNames.major, versionXMLFile.version().major())
                .attribute(AttributeNames.minor, versionXMLFile.version().minor())
                .attribute(AttributeNames.micro, versionXMLFile.version().micro())
                .attribute(AttributeNames.buildNumber, versionXMLFile.version().buildNumber())
                .attribute(AttributeNames.os, versionXMLFile.os())
                .attribute(AttributeNames.xmlVersion, CommonString.XMLVersion)
                .attribute(AttributeNames.application, versionXMLFile.application())
                .attribute(AttributeNames.appVersion, versionXMLFile.appVersion())
                .closeElement();
    }
}
