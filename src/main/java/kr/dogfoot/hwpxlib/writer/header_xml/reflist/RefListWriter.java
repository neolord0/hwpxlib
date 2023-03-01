package kr.dogfoot.hwpxlib.writer.header_xml.reflist;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.RefList;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class RefListWriter extends ElementWriter {
    public RefListWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.RefList;
    }

    @Override
    public void write(HWPXObject object) {
        RefList refList = (RefList) object;
        storeSwitchObject(refList.switchObject());

        xsb()
                .openElement(ElementNames.hh_refList)
                .elementWriter(this);

        if (refList.fontfaces() != null) {
            writeChild(ElementWriterSort.FontFaces, refList.fontfaces());
        }

        if (refList.borderFills() != null) {
            writeChild(ElementWriterSort.BorderFills, refList.borderFills());
        }

        if (refList.charProperties() != null) {
            writeChild(ElementWriterSort.CharProperties, refList.charProperties());
        }

        if (refList.tabProperties() != null) {
            writeChild(ElementWriterSort.TabProperties, refList.tabProperties());
        }

        if (refList.numberings() != null) {
            writeChild(ElementWriterSort.Numberings, refList.numberings());
        }

        if (refList.bullets() != null) {
            writeChild(ElementWriterSort.Bullets, refList.bullets());
        }

        if (refList.paraProperties() != null) {
            writeChild(ElementWriterSort.ParaProperties, refList.paraProperties());
        }

        if (refList.styles() != null) {
            writeChild(ElementWriterSort.Styles, refList.styles());
        }

        if (refList.memoProperties() != null) {
            writeChild(ElementWriterSort.MemoProperties, refList.memoProperties());
        }

        if (refList.trackChanges() != null) {
            writeChild(ElementWriterSort.TrackChanges, refList.trackChanges());
        }

        if (refList.trackChangeAuthors() != null) {
            writeChild(ElementWriterSort.TrackChangeAuthors, refList.trackChangeAuthors());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_fontfaces:
                writeChild(ElementWriterSort.FontFaces, child);
                break;
            case hh_borderFills:
                writeChild(ElementWriterSort.BorderFills, child);
                break;
            case hh_charProperties:
                writeChild(ElementWriterSort.CharProperties, child);
                break;
            case hh_tabProperties:
                writeChild(ElementWriterSort.TabProperties, child);
                break;
            case hh_numberings:
                writeChild(ElementWriterSort.Numberings, child);
                break;
            case hh_bullets:
                writeChild(ElementWriterSort.Bullets, child);
                break;
            case hh_paraProperties:
                writeChild(ElementWriterSort.ParaProperties, child);
                break;
            case hh_styles:
                writeChild(ElementWriterSort.Styles, child);
                break;
            case hh_memoProperties:
                writeChild(ElementWriterSort.MemoProperties, child);
                break;
            case hh_trackChanges:
                writeChild(ElementWriterSort.TrackChanges, child);
                break;
            case hh_trackChangeAuthors:
                writeChild(ElementWriterSort.TrackChangeAuthors, child);
                break;
        }
    }
}
