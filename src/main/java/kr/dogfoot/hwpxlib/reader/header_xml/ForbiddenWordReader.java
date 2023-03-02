package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.ForbiddenWord;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ForbiddenWordReader extends ElementReader {
    private ForbiddenWord forbiddenWord;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ForbiddenWord;
    }

    public void forbiddenWord(ForbiddenWord forbiddenWord) {
        this.forbiddenWord = forbiddenWord;
    }

    @Override
    public void text(String text) {
        forbiddenWord.addText(text);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
