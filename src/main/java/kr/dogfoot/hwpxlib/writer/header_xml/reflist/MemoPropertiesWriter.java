package kr.dogfoot.hwpxlib.writer.header_xml.reflist;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.MemoPr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class MemoPropertiesWriter extends ElementWriter {
    public MemoPropertiesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<MemoPr> memoProperties = (ObjectList<MemoPr>) object;
        switchList(memoProperties.switchList());
        if (memoProperties.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_memoProperties)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, memoProperties.count());

        for (MemoPr memoPr : memoProperties.items()) {
            memoPr(memoPr);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void memoPr(MemoPr memoPr) {
        xsb()
                .openElement(ElementNames.hh_memoPr)
                .attribute(AttributeNames.id, memoPr.id())
                .attribute(AttributeNames.width, memoPr.width())
                .attribute(AttributeNames.lineType, memoPr.lineType())
                .attributeIndex(AttributeNames.lineWidth, memoPr.lineWidth())
                .attribute(AttributeNames.lineColor, memoPr.lineColor())
                .attribute(AttributeNames.fillColor, memoPr.fillColor())
                .attribute(AttributeNames.activeColor, memoPr.activeColor())
                .attribute(AttributeNames.memoType, memoPr.memoType())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_memoPr:
                memoPr((MemoPr) child);
                break;
        }
    }
}
