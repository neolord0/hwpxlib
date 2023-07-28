package kr.dogfoot.hwpxlib.writer.section_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class SubListWriter extends ElementWriter {
    public SubListWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.SubList;
    }

    @Override
    public void write(HWPXObject object) {
        SubList subList = (SubList) object;
        switchList(subList.switchList());

        xsb()
                .openElement(ElementNames.hp_subList)
                .elementWriter(this)
                .attribute(AttributeNames.id, subList.id())
                .attribute(AttributeNames.textDirection, subList.textDirection())
                .attribute(AttributeNames.lineWrap, subList.lineWrap())
                .attribute(AttributeNames.vertAlign, subList.vertAlign())
                .attribute(AttributeNames.linkListIDRef, subList.linkListIDRef())
                .attribute(AttributeNames.linkListNextIDRef, subList.linkListNextIDRef())
                .attribute(AttributeNames.textWidth, subList.textWidth())
                .attribute(AttributeNames.textHeight, subList.textHeight())
                .attribute(AttributeNames.hasTextRef, subList.hasTextRef())
                .attribute(AttributeNames.hasNumRef, subList.hasNumRef());

        for (Para para : subList.paras()) {
            writeChild(ElementWriterSort.Para, para);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_p:
                writeChild(ElementWriterSort.Para, child);
                break;
        }
    }
}
