package kr.dogfoot.hwpxlib.reader.version_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetApplicationSort;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class VersionReader extends ElementReader {
    private VersionXMLFile versionXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Version;
    }

    public void versionXMLFile(VersionXMLFile versionXMLFile) {
        this.versionXMLFile = versionXMLFile;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.tagetApplication:
                versionXMLFile.targetApplication(TargetApplicationSort.fromString(value));
                break;
            case AttributeNames.major:
                versionXMLFile.version().major(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.minor:
                versionXMLFile.version().minor(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.micro:
                versionXMLFile.version().micro(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.buildNumber:
                versionXMLFile.version().buildNumber(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.os:
                versionXMLFile.os(value);
                break;
            case AttributeNames.application:
                versionXMLFile.application(value);
                break;
            case AttributeNames.appVersion:
                versionXMLFile.appVersion(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
