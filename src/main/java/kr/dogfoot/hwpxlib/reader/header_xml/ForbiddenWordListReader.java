package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.ForbiddenWord;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.HasOnlyTextReader;
import org.xml.sax.Attributes;

public class ForbiddenWordListReader extends ElementReader {
    private ObjectList<ForbiddenWord> forbiddenWordList;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ForbiddenWordList;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_forbiddenWord:
                forbiddenWord(forbiddenWordList.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_forbiddenWord:
                ForbiddenWord forbiddenWord = new ForbiddenWord();
                forbiddenWord(forbiddenWord, name, attrs);
                return forbiddenWord;
        }
        return null;
    }

    private void forbiddenWord(ForbiddenWord forbiddenWord, String name, Attributes attrs) {
        ((HasOnlyTextReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.HasOnlyText))
                .hasOnlyText(forbiddenWord);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return forbiddenWordList;
    }

    public void forbiddenWordList(ObjectList<ForbiddenWord> forbiddenWordList) {
        this.forbiddenWordList = forbiddenWordList;
    }
}
