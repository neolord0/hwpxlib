package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VisibilityOption;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.Visibility;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class VisibilityReader extends ElementReader {
    private Visibility visibility;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Visibility;
    }

    public void visibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.hideFirstHeader:
                visibility.hideFirstHeader(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideFirstFooter:
                visibility.hideFirstFooter(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideFirstMasterPage:
                visibility.hideFirstMasterPage(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.border:
                visibility.border(VisibilityOption.fromString(value));
                break;
            case AttributeNames.fill:
                visibility.fill(VisibilityOption.fromString(value));
                break;
            case AttributeNames.hideFirstPageNum:
                visibility.hideFirstPageNum(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hideFirstEmptyLine:
                visibility.hideFirstEmptyLine(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.showLineNumber:
                visibility.showLineNumber(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
