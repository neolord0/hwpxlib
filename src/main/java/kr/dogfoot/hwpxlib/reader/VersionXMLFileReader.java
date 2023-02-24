package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.commonstirngs.ZipEntryName;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import kr.dogfoot.hwpxlib.reader.version_xml.VersionReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.zip.ZipFile;

public class VersionXMLFileReader extends XMLFileReader {
    private VersionXMLFile versionXMLFile;

    public VersionXMLFileReader(ElementReaderManager entryReaderManager) {
        super(entryReaderManager);
        versionXMLFile = null;
    }

    public void read(VersionXMLFile versionXMLFile, ZipFile zipFile) throws ParserConfigurationException, IOException, SAXException {
        ((VersionReader) setCurrentEntryReader(ElementReaderSort.Version))
                .versionXMLFile(versionXMLFile);

        read(zipFile, ZipEntryName.Version);
    }
}
