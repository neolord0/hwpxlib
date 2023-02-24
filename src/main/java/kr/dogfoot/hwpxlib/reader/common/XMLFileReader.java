package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.commonstirngs.ErrorMessage;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.reader.common.compatibility.SwitchReader;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public abstract class XMLFileReader extends DefaultHandler {
    protected ElementReaderManager entryReaderManager;
    protected ElementReader currentEntryReader;
    private boolean isSwitchableObjectReader;

    protected XMLFileReader(ElementReaderManager entryReaderManager) {
        this.entryReaderManager = entryReaderManager;
        currentEntryReader = null;
    }

    protected void read(InputStream io) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(io, this);
    }

    protected void read(ZipFile zipFile, String zipEntryName) throws ParserConfigurationException, SAXException, IOException {
        ZipEntry zipEntry = zipFile.getEntry(zipEntryName);
        if (zipEntry != null) {
            read(zipFile.getInputStream(zipEntry));
        } else {
            throw new IOException(ErrorMessage.Not_HWPX_File);
        }
    }

    public ElementReader setCurrentEntryReader(ElementReaderSort sort) {
        ElementReader nextEntryReader = entryReaderManager.get(sort)
                .xmlFileReaderAnd(this)
                .previousReaderAnd(currentEntryReader)
                .startedAnd(false)
                .switchableObjectReaderAnd(false);
        currentEntryReader = nextEntryReader;
        return currentEntryReader;
    }

    public ElementReader setCurrentEntryReaderInSwitch(ElementReaderSort sort) {
        ElementReader nextEntryReader = entryReaderManager.get(sort)
                .xmlFileReaderAnd(this)
                .previousReaderAnd(currentEntryReader)
                .startedAnd(true)
                .switchableObjectReaderAnd(true);
        currentEntryReader = nextEntryReader;
        return currentEntryReader;
    }

    public void startElement(String name, Attributes attrs) {
        startElement(null, null, name, attrs);
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attrs) {
        if (!currentEntryReader.started()) {
            currentEntryReader.started(true);
            currentEntryReader.startElement(attrs);
        } else {
            if (ElementNames.hp_switch.equals(name)) {
                if (currentEntryReader.switchableObject() != null) {
                    SwitchableObject switchableObject = currentEntryReader.switchableObject();

                    switchableObject.createSwitchObject();
                    ((SwitchReader) setCurrentEntryReader(ElementReaderSort.Switch))
                            .switchableObject(switchableObject);

                    startElement(name, attrs);
                }
            } else {
                currentEntryReader.childElement(name, attrs);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) {
        currentEntryReader.started(false);
        currentEntryReader.endElement();
        entryReaderManager.release(currentEntryReader);

        if (currentEntryReader.previousReader() == null) {
            currentEntryReader = null;
        } else {
            currentEntryReader = currentEntryReader.previousReader().switchableObjectReader() ? currentEntryReader.previousReader().previousReader() : currentEntryReader.previousReader();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentEntryReader != null) {
            currentEntryReader.text(new String(ch, start, length));
        }
    }

    public void setCurrentEntryReaderForEmpty(String name, Attributes attrs) {
        setCurrentEntryReader(ElementReaderSort.Empty);
        startElement(name, attrs);
    }
}
