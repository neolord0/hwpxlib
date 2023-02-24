package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.commonstirngs.DefaultValues;
import kr.dogfoot.hwpxlib.commonstirngs.MineTypes;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.writer.util.NamespaceSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class VersionWriter {
    public static void write(VersionXMLFile versionXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hv_HCFVersion)
                .namespace(NamespaceSort.hv)
                .attribute(AttributeNames.tagetApplication, versionXMLFile.targetApplication().str())
                .attribute(AttributeNames.major, versionXMLFile.version().major())
                .attribute(AttributeNames.minor, versionXMLFile.version().minor())
                .attribute(AttributeNames.micro, versionXMLFile.version().micro())
                .attribute(AttributeNames.buildNumber, versionXMLFile.version().buildNumber())
                .attribute(AttributeNames.os, versionXMLFile.os())
                .attribute(AttributeNames.xmlVersion, DefaultValues.XMLVersion)
                .attribute(AttributeNames.application, versionXMLFile.application())
                .attribute(AttributeNames.appVersion, versionXMLFile.appVersion())
                .closeElement();
    }
}
