package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.ErrorMessage;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
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
    private boolean stoppedParsing;
    private StringBuilder textBuffer;

    private static boolean namespaceAware = false;

    static {
        // XML parser 가 class com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl 면 namespace aware 를 false로 설정해도 attribute 의 localName 이 제대로 나온다.
        // 하지만
        // XML parser 가 class org.apache.xerces.jaxp.SAXParserImpl 이면, namespace aware 를 true 로 설정해야 attribute 의 localName 이 제대로 나온다.
        // 그러므로 parser 에 따라서 외부에서 값을 조정할 수 있도록 하자.
        // 초기 값은 -D 옵션에서 받아 오도록 한다.
        namespaceAware = Boolean.parseBoolean(System.getProperty("kr.dogfoot.hwpxlib.reader.xml.namespace-aware", "false"));
    }

    protected XMLFileReader(ElementReaderManager entryReaderManager) {
        this.elementReaderManager = entryReaderManager;
        currentElementReader = null;

        textBuffer = new StringBuilder();
    }

    protected void read(InputStream io) throws ParserConfigurationException, SAXException, IOException {
        stoppedParsing = false;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(namespaceAware);
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
        if (stoppedParsing) {
            return;
        }

        if (!currentElementReader.started()) {
            currentElementReader.started(true);
            currentElementReader.startElement(attrs);
        } else {
            if (textBuffer.length() > 0) {
                currentElementReader.text(textBuffer.toString());
                textBuffer.setLength(0);
            }

            currentElementReader.increaseChildIndex();

            if (ElementNames.hp_switch.equals(name)) {
                if (currentElementReader.switchableObject() != null) {
                    SwitchableObject switchableObject = currentElementReader.switchableObject();

                    Switch switchObject = switchableObject.addNewSwitch();
                    switchObject.position(currentElementReader.childIndex());
                    ((SwitchReader) setCurrentElementReader(ElementReaderSort.Switch))
                            .switchObject(switchObject);

                    startElement(name, attrs);
                }
            } else {
                currentElementReader.childElement(name, attrs);
            }
        }

        textBuffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String name) {
        if (stoppedParsing) {
            return;
        }

        if (currentElementReader != null) {
            if (textBuffer.length() > 0) {
                currentElementReader.text(textBuffer.toString());
                textBuffer.setLength(0);
            }
        }

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
        if (stoppedParsing) {
            return;
        }

        if (currentElementReader != null) {
            textBuffer.append(ch, start, length);
        }
    }

    public void setCurrentElementReaderForEmpty(String name, Attributes attrs) {

        setCurrentElementReader(ElementReaderSort.Empty);
        startElement(name, attrs);
    }

    protected void stopParsing() {
        stoppedParsing = true;
    }

    public boolean stoppedParsing() {
        return stoppedParsing;
    }

    // -D 옵션을 사용하지 않는곳에서도 runtime 으로 바꿀 수 있도록 허용 한다.
    public static void setNamespaceAware(boolean namespaceAware) {
        XMLFileReader.namespaceAware = namespaceAware;
    }
}
