package kr.dogfoot.hwpxlib.writer.section_xml;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeCore;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TWriter extends ElementWriter {
    public TWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.T;
    }

    @Override
    public void write(HWPXObject object) {
        T t = (T) object;
        switchObject(t.switchObject());

        xsb()
                .openElement(ElementNames.hp_t)
                .elementWriter(this)
                .attribute(AttributeNames.charPrIDRef, t.charPrIDRef());

        if (!t.isEmpty()) {
            if (t.isOnlyText()) {
                xsb().text(t.onlyText());
            } else {
                for (TItem item : t.items()) {
                    item(item);
                }
            }
        }

        xsb().closeElement();
        releaseMe();
    }

    private void item(TItem item) {
        switch (item._objectType()) {
            case NormalText:
                normalText((NormalText) item);
                break;
            case hp_markpenBegin:
                markpenBegin((MarkpenBegin) item);
                break;
            case hp_markpenEnd:
                noAttributeChildElement(ElementNames.hp_markpenEnd);
                break;
            case hp_titleMark:
                titleMark((TitleMark) item);
                break;
            case hp_tab:
                tab((Tab) item);
                break;
            case hp_lineBreak:
                noAttributeChildElement(ElementNames.hp_lineBreak);
                break;
            case hp_hyphen:
                noAttributeChildElement(ElementNames.hp_hyphen);
                break;
            case hp_nbSpace:
                noAttributeChildElement(ElementNames.hp_nbSpace);
                break;
            case hp_fwSpace:
                noAttributeChildElement(ElementNames.hp_fwSpace);
                break;
            case hp_insertBegin:
                trackChange(ElementNames.hp_insertBegin, (TrackChangeCore) item);
                break;
            case hp_insertEnd:
                trackChange(ElementNames.hp_insertEnd, (TrackChangeCore) item);
                break;
            case hp_deleteBegin:
                trackChange(ElementNames.hp_deleteBegin, (TrackChangeCore) item);
                break;
            case hp_deleteEnd:
                trackChange(ElementNames.hp_deleteEnd, (TrackChangeCore) item);
                break;

        }
    }

    private void normalText(NormalText normalText) {
        xsb().text(normalText.text());
    }

    private void markpenBegin(MarkpenBegin markpenBegin) {
        xsb()
                .openElement(ElementNames.hp_markpenBegin)
                .attribute(AttributeNames.beginColor, markpenBegin.beginColor())
                .closeElement();
    }

    private void titleMark(TitleMark titleMark) {
        xsb()
                .openElement(ElementNames.hp_titleMark)
                .attribute(AttributeNames.ignore, titleMark.ignore())
                .closeElement();
    }

    private void tab(Tab tab) {
        xsb()
                .openElement(ElementNames.hp_tab)
                .attribute(AttributeNames.width, tab.width())
                .attributeIndex(AttributeNames.leader, tab.leader())
                .attributeIndex(AttributeNames.type, tab.type())
                .closeElement();
    }

    private void trackChange(String name, TrackChangeCore trackChange) {
        xsb()
                .openElement(name)
                .attribute(AttributeNames.Id, trackChange.Id())
                .attribute(AttributeNames.TcId, trackChange.TcId())
                .attribute(AttributeNames.paraend, trackChange.paraend())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        if (child instanceof TItem) {
            item((TItem) child);
        }
    }
}
