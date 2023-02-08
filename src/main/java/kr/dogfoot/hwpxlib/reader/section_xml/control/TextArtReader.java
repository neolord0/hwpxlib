package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.TextArt;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class TextArtReader extends ElementReader {
    private TextArt textArt;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TextArt;
    }

    public void textArt(TextArt textArt) {
        this.textArt = textArt;
    }

    @Override
    public SwitchableObject switchableObject() {
        return textArt;
    }

}
