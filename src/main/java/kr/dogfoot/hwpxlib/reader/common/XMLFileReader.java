package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.commonstirngs.ErrorMessage;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.reader.common.compatibility.SwitchReader;
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
    protected ElementReaderManager elementReaderManager;
    protected ElementReader currentElementReader;

    protected XMLFileReader(ElementReaderManager entryReaderManager) {
        this.elementReaderManager = entryReaderManager;
        currentElementReader = null;
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

    public ElementReader setCurrentElementReader(ElementReaderSort sort) {
        ElementReader nextElementReader = elementReaderManager.get(sort)
                .xmlFileReaderAnd(this)
                .previousReaderAnd(currentElementReader)
                .startedAnd(false)
                .switchableObjectReaderAnd(false);
        currentElementReader = nextElementReader;
        return currentElementReader;
    }

    public ElementReader setCurrentElementReaderInSwitch(ElementReaderSort sort) {
        ElementReader nextElementReader = elementReaderManager.get(sort)
                .xmlFileReaderAnd(this)
                .previousReaderAnd(currentElementReader)
                .startedAnd(true)
                .switchableObjectReaderAnd(true);
        currentElementReader = nextElementReader;
        return currentElementReader;
    }

    public void startElement(String name, Attributes attrs) {
        startElement(null, null, name, attrs);
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attrs) {
        if (!currentElementReader.started()) {
            currentElementReader.started(true);
            currentElementReader.startElement(attrs);
        } else {
            if (ElementNames.hp_switch.equals(name)) {
                if (currentElementReader.switchableObject() != null) {
                    SwitchableObject switchableObject = currentElementReader.switchableObject();

                    switchableObject.createSwitchObject();
                    switchableObject.switchObject().position(currentElementReader.childIndex());
                    ((SwitchReader) setCurrentElementReader(ElementReaderSort.Switch))
                            .switchableObject(switchableObject);

                    startElement(name, attrs);
                }
            } else {
                currentElementReader.increaseChildIndex();
                currentElementReader.childElement(name, attrs);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) {
        currentElementReader.started(false);
        currentElementReader.endElement();
        elementReaderManager.release(currentElementReader);

        if (currentElementReader.previousReader() == null) {
            currentElementReader = null;
        } else {
            currentElementReader = currentElementReader.previousReader().switchableObjectReader() ? currentElementReader.previousReader().previousReader() : currentElementReader.previousReader();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElementReader != null) {
            currentElementReader.text(new String(ch, start, length));
        }
    }

    public void setCurrentElementReaderForEmpty(String name, Attributes attrs) {
        setCurrentElementReader(ElementReaderSort.Empty);
        startElement(name, attrs);
    }
}
