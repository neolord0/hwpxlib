package kr.dogfoot.hwpxlib.writer.header_xml;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.header_xml.ForbiddenWord;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ForbiddenWordListWriter extends ElementWriter {
    public ForbiddenWordListWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<ForbiddenWord> forbiddenWordList = (ObjectList<ForbiddenWord>) object;
        storeSwitchObject(forbiddenWordList.switchObject());
        if (forbiddenWordList.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_forbiddenWordList)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, forbiddenWordList.count());

        for (ForbiddenWord forbiddenWord : forbiddenWordList.items()) {
            hasOnlyTextElement(ElementNames.hh_forbiddenWord, forbiddenWord);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_forbiddenWord:
                hasOnlyTextElement(ElementNames.hh_forbiddenWord, (HasOnlyText) child);
                break;
        }
    }
}
