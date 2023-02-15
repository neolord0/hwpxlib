package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetApplicationSort;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.zip.ZipFile;

public class VersionXMLFileReader extends XMLFileReader {
    public static final String Filepath = "version.xml";

    private VersionXMLFile versionXMLFile;

    public VersionXMLFileReader(ElementReaderManager entryReaderManager) {
        super(entryReaderManager);
        versionXMLFile = null;
    }

    public void read(VersionXMLFile versionXMLFile, ZipFile zipFile) throws ParserConfigurationException, IOException, SAXException {
        this.versionXMLFile = versionXMLFile;
        read(zipFile, Filepath);
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attrs) {
        if (ElementNames.hv_HCFVersion.equals(name)) {
            int count = attrs.getLength();
            for (int index = 0; index < count; index++) {
                setAttribute(
                        attrs.getLocalName(index),
                        attrs.getValue(index));
            }
        }
    }

    private void setAttribute(String name, String value) {
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

    public void endElement(String uri, String localName, String name) {
        // nothing
    }

    public void characters(char[] ch, int start, int length) {
        // nothing
    }
}
