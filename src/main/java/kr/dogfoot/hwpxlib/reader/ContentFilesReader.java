package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import kr.dogfoot.hwpxlib.reader.header_xml.HeadReader;
import kr.dogfoot.hwpxlib.reader.masterpage_xml.MasterPageReader;
import kr.dogfoot.hwpxlib.reader.section_xml.SecReader;
import kr.dogfoot.hwpxlib.reader.settings_xml.SettingsReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

public class ContentFilesReader extends XMLFileReader {
    private HWPXFile hwpxFile;
    private String topEntryName;

    public ContentFilesReader(ElementReaderManager entryReaderManager) {
        super(entryReaderManager);
    }

    public void read(HWPXFile hwpxFile, InputStream io) throws ParserConfigurationException, IOException, SAXException {
        this.hwpxFile = hwpxFile;
        currentEntryReader = null;

        read(io);
    }

    public void read(HWPXFile hwpxFile, String filepath, ZipFile zipFile) throws ParserConfigurationException, IOException, SAXException {
        this.hwpxFile = hwpxFile;
        currentEntryReader = null;

        read(zipFile, filepath);
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attrs) {
        if (currentEntryReader == null) {
            topEntryName = name;

            if (ObjectType.Headers_XMLFile.equalElementName(name)) {
                ((HeadReader) setCurrentEntryReader(ElementReaderSort.Head))
                        .headerXMLFile(hwpxFile.headerXMLFile());

                super.startElement(uri, localName, name, attrs);
            } else if (ObjectType.Section_XMLFile.equalElementName(name)) {
                ((SecReader) setCurrentEntryReader(ElementReaderSort.Sec))
                        .sectionXMLFile(hwpxFile.sectionXMLFileList().addNew());

                super.startElement(uri, localName, name, attrs);
            } else if (ObjectType.MasterPage_XMLFile.equalElementName(name)) {
                ((MasterPageReader) setCurrentEntryReader(ElementReaderSort.MasterPage))
                        .masterPageXMLFile(hwpxFile.masterPageXMLFileList().addNew());

                super.startElement(uri, localName, name, attrs);
            } else if (ObjectType.Settings_XMLFile.equalElementName(name)) {
                ((SettingsReader) setCurrentEntryReader(ElementReaderSort.Settings))
                        .settingsXMLFile(hwpxFile.settingsXMLFile());

                super.startElement(uri, localName, name, attrs);
            }
        } else {
            super.startElement(uri, localName, name, attrs);
        }
    }

    // test
    @Override
    public void endElement(String uri, String localName, String name) {
        super.endElement(uri, localName, name);
    }

}
