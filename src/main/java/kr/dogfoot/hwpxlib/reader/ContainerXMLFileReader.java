package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.commonstrings.ZipEntryName;
import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import kr.dogfoot.hwpxlib.reader.container_xml.ContainerReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.zip.ZipFile;

public class ContainerXMLFileReader extends XMLFileReader {
    public ContainerXMLFileReader(ElementReaderManager entryReaderManager) {
        super(entryReaderManager);
    }

    public void read(ContainerXMLFile containerXMLFile, ZipFile zipFile) throws ParserConfigurationException, IOException, SAXException {
        ((ContainerReader) setCurrentElementReader(ElementReaderSort.Container))
                .containerXMLFile(containerXMLFile);

        read(zipFile, ZipEntryName.Container);
    }
}
