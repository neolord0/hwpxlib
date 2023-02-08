package kr.dogfoot.hwpxlib.reader.header_xml.docoption;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.DocOption;
import kr.dogfoot.hwpxlib.object.content.header_xml.LinkInfo;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChangeAuthor;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchange.TrackChangeReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class DocOptionReader extends ElementReader {
    private DocOption docOption;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.DocOption;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.LinkInfo:
                docOption.createLinkInfo();
                linkInfo(docOption.linkInfo(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.TrackChangeAuthor) {
            linkInfo((LinkInfo) child, name, attrs);
        }
    }

    private void linkInfo(LinkInfo linkInfo, String name, Attributes attrs) {
        ((LinkInfoReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LinkInfo))
                .linkInfo(linkInfo);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return docOption;
    }

    public void docOption(DocOption docOption) {
        this.docOption = docOption;
    }
}