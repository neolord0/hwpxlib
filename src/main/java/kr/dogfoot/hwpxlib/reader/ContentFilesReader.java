package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Chart;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import kr.dogfoot.hwpxlib.reader.header_xml.HeadReader;
import kr.dogfoot.hwpxlib.reader.masterpage_xml.MasterPageReader;
import kr.dogfoot.hwpxlib.reader.section_xml.SecReader;
import kr.dogfoot.hwpxlib.reader.settings_xml.SettingsReader;
import kr.dogfoot.hwpxlib.reader.versionlog_xml.HistoryReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.ZipFile;

public class ContentFilesReader extends XMLFileReader {
    private final ArrayList<Chart> chartList;
    private HWPXFile hwpxFile;

    public ContentFilesReader(ElementReaderManager entryReaderManager) {
        super(entryReaderManager);

        chartList = new ArrayList<>();
    }

    public void read(HWPXFile hwpxFile, InputStream io) throws ParserConfigurationException, IOException, SAXException {
        this.hwpxFile = hwpxFile;
        currentElementReader = null;
        read(io);
    }

    public void read(HWPXFile hwpxFile, String filepath, ZipFile zipFile) throws ParserConfigurationException, IOException, SAXException {
        this.hwpxFile = hwpxFile;
        currentElementReader = null;
        read(zipFile, filepath);
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attrs) {
        if (currentElementReader == null) {
            switch (name) {
                case ElementNames.hh_head:
                    ((HeadReader) setCurrentElementReader(ElementReaderSort.Head))
                            .headerXMLFile(hwpxFile.headerXMLFile());
                    super.startElement(uri, localName, name, attrs);
                    break;
                case ElementNames.hs_sec:
                    ((SecReader) setCurrentElementReader(ElementReaderSort.Sec))
                            .sectionXMLFile(hwpxFile.sectionXMLFileList().addNew());
                    super.startElement(uri, localName, name, attrs);
                    break;
                case ElementNames.masterPage:
                    ((MasterPageReader) setCurrentElementReader(ElementReaderSort.MasterPage))
                            .masterPageXMLFile(hwpxFile.masterPageXMLFileList().addNew());

                    super.startElement(uri, localName, name, attrs);
                    break;
                case ElementNames.ha_HWPApplicationSetting:
                    ((SettingsReader) setCurrentElementReader(ElementReaderSort.Settings))
                            .settingsXMLFile(hwpxFile.settingsXMLFile());

                    super.startElement(uri, localName, name, attrs);
                    break;
                case ElementNames.hhs_history:
                    ((HistoryReader) setCurrentElementReader(ElementReaderSort.History))
                            .historyXMLFile(hwpxFile.historyXMLFileList().addNew());

                    super.startElement(uri, localName, name, attrs);
                    break;
                case ElementNames.b_Sources:
                    stopParsing();
                    break;
                default:
                    setCurrentElementReader(ElementReaderSort.Unreadable);

                    super.startElement(uri, localName, name, attrs);
                    break;
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

    public void addChart(Chart chart) {
        chartList.add(chart);
    }

    public Chart[] charts() {
        return chartList.toArray(new Chart[0]);
    }

}
