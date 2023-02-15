package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument.CompatibleDocumentReader;
import kr.dogfoot.hwpxlib.reader.header_xml.docoption.DocOptionReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class HeadReader extends ElementReader {
    private HeaderXMLFile headerXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Head;
    }

    public void headerXMLFile(HeaderXMLFile headerXMLFile) {
        this.headerXMLFile = headerXMLFile;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.version:
                headerXMLFile.version(value);
                break;
            case AttributeNames.secCnt:
                headerXMLFile.secCnt(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_beginNum:
                headerXMLFile.createBeginNum();
                beginNum(headerXMLFile.beginNum(), name, attrs);
                break;
            case ElementNames.hh_refList:
                headerXMLFile.createRefList();
                refList(headerXMLFile.refList(), name, attrs);
                break;
            case ElementNames.hh_forbiddenWordList:
                headerXMLFile.createForbiddenWordList();
                forbiddenWordList(headerXMLFile.forbiddenWordList(), name, attrs);
                break;
            case ElementNames.hh_compatibleDocument:
                headerXMLFile.createCompatibleDocument();
                compatibleDocument(headerXMLFile.compatibleDocument(), name, attrs);
                break;
            case ElementNames.hh_docOption:
                headerXMLFile.createDocOption();
                docOption(headerXMLFile.docOption(), name, attrs);
                break;
            case ElementNames.hh_trackchageConfig:
                headerXMLFile.createTrackChangeConfig();
                trackChangeConfig(headerXMLFile.trackChangeConfig(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_beginNum:
                BeginNum beginNum = new BeginNum();
                beginNum(beginNum, name, attrs);
                return beginNum;
            case ElementNames.hh_refList:
                RefList refList = new RefList();
                refList(refList, name, attrs);
                return refList;
            case ElementNames.hh_forbiddenWordList:
                ObjectList<ForbiddenWord> forbiddenWordList = new ObjectList<ForbiddenWord>(ObjectType.hh_forbiddenWordList, ForbiddenWord.class);
                forbiddenWordList(forbiddenWordList, name, attrs);
                return forbiddenWordList;
            case ElementNames.hh_compatibleDocument:
                CompatibleDocument compatibleDocument = new CompatibleDocument();
                compatibleDocument(compatibleDocument, name, attrs);
                return compatibleDocument;
            case ElementNames.hh_docOption:
                DocOption docOption = new DocOption();
                docOption(docOption, name, attrs);
                return docOption;
            case ElementNames.hh_trackchageConfig:
                TrackChangeConfig trackChangeConfig = new TrackChangeConfig();
                trackChangeConfig(trackChangeConfig, name, attrs);
                return trackChangeConfig;
        }
        return null;
    }

    private void beginNum(BeginNum beginNum, String name, Attributes attrs) {
        ((BeginNumReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.BeginNum))
                .beginNum(beginNum);

        xmlFileReader().startElement(name, attrs);
    }

    private void refList(RefList refList, String name, Attributes attrs) {
        ((RefListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.RefList))
                .refList(refList);

        xmlFileReader().startElement(name, attrs);
    }

    private void forbiddenWordList(ObjectList<ForbiddenWord> forbiddenWordObjectList, String name, Attributes attrs) {
        ((ForbiddenWordListReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ForbiddenWordList))
                .forbiddenWordList(forbiddenWordObjectList);

        xmlFileReader().startElement(name, attrs);
    }

    private void compatibleDocument(CompatibleDocument compatibleDocument, String name, Attributes attrs) {
        ((CompatibleDocumentReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CompatibleDocument))
                .compatibleDocument(compatibleDocument);

        xmlFileReader().startElement(name, attrs);
    }

    private void docOption(DocOption docOption, String name, Attributes attrs) {
        ((DocOptionReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.DocOption))
                .docOption(docOption);

        xmlFileReader().startElement(name, attrs);
    }

    private void trackChangeConfig(TrackChangeConfig trackChangeConfig, String name, Attributes attrs) {
        ((TrackChangeConfigReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChangeConfig))
                .trackChangeConfig(trackChangeConfig);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return headerXMLFile;
    }
}
