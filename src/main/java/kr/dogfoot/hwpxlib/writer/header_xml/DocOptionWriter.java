package kr.dogfoot.hwpxlib.writer.header_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.DocOption;
import kr.dogfoot.hwpxlib.object.content.header_xml.LinkInfo;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class DocOptionWriter extends ElementWriter {
    public DocOptionWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        DocOption docOption = (DocOption) object;
        switchList(docOption.switchList());

        xsb()
                .openElement(ElementNames.hh_docOption)
                .elementWriter(this);

        if (docOption.linkinfo() != null) {
            linkinfo(docOption.linkinfo());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void linkinfo(LinkInfo linkinfo) {
        xsb()
                .openElement(ElementNames.hh_linkinfo)
                .attribute(AttributeNames.path, linkinfo.path())
                .attribute(AttributeNames.pageInherit, linkinfo.pageInherit())
                .attribute(AttributeNames.footnoteInherit, linkinfo.footnoteInherit())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_linkinfo:
                linkinfo((LinkInfo) child);
                break;
        }
    }
}
