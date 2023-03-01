package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.content.context_hpf.ContentHPFFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import kr.dogfoot.hwpxlib.reader.content_hpf.PackageReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.zip.ZipFile;

public class ContentHPFFileReader extends XMLFileReader {
    public ContentHPFFileReader(ElementReaderManager entryReaderManager) {
        super(entryReaderManager);
    }

    public void read(ContentHPFFile contentHPFFile, ZipFile zipFile, String filepath) throws ParserConfigurationException, IOException, SAXException {
        ((PackageReader) setCurrentElementReader(ElementReaderSort.Package))
                .contentHPFFile(contentHPFFile);

        read(zipFile, filepath);
    }
}
