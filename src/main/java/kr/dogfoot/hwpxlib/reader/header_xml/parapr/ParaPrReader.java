package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.ParaHeadReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ParaPrReader extends ElementReader {
    private ParaPr paraPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ParaPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                paraPr.id(value);
                break;
            case AttributeNames.tabPrIDRef:
                paraPr.tabPrIDRef(value);
                break;
            case AttributeNames.condense:
                paraPr.condense(ValueConvertor.toByte(value));
                break;
            case AttributeNames.fontLineHeight:
                paraPr.fontLineHeight(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.snapToGrid:
                paraPr.snapToGrid(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.suppressLineNumbers:
                paraPr.suppressLineNumbers(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.checked:
                paraPr.checked(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Align:
                paraPr.createAlign();
                align(paraPr.align(), name, attrs);
                break;
            case ElementNames.Heading:
                paraPr.createHeading();
                heading(paraPr.heading(), name, attrs);
                break;
            case ElementNames.BreakSetting:
                paraPr.createBreakSetting();
                breakSetting(paraPr.breakSetting(), name, attrs);
                break;
            case ElementNames.ParaMargin:
                paraPr.createMargin();
                margin(paraPr.margin(), name, attrs);
                break;
            case ElementNames.LineSpacing:
                paraPr.createLineSpacing();
                lineSpacing(paraPr.lineSpacing(), name, attrs);
                break;
            case ElementNames.ParaBorder:
                paraPr.createBorder();
                border(paraPr.border(), name, attrs);
                break;
            case ElementNames.AutoSpacing:
                paraPr.createAutoSpacing();
                autoSpacing(paraPr.autoSpacing(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.Align) {
            align((Align) child, name, attrs);
        } else if (child.objectType() == ObjectType.Heading) {
            heading((Heading) child, name, attrs);
        } else if (child.objectType() == ObjectType.BreakSetting) {
            breakSetting((BreakSetting) child, name, attrs);
        } else if (child.objectType() == ObjectType.ParaMargin) {
            margin((ParaMargin) child, name, attrs);
        } else if (child.objectType() == ObjectType.LineSpacing) {
            lineSpacing((LineSpacing) child, name, attrs);
        } else if (child.objectType() == ObjectType.ParaBorder) {
            border((ParaBorder) child, name, attrs);
        } else if (child.objectType() == ObjectType.AutoSpacing) {
            autoSpacing((AutoSpacing) child, name, attrs);
        }
    }

    private void align(Align align, String name, Attributes attrs) {
        ((AlignReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Align))
                .align(align);

        xmlFileReader().startElement(name, attrs);
    }

    private void heading(Heading heading, String name, Attributes attrs) {
        ((HeadingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Heading))
                .heading(heading);

        xmlFileReader().startElement(name, attrs);
    }

    private void breakSetting(BreakSetting breakSetting, String name, Attributes attrs) {
        ((BreakSettingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.BreakSetting))
                .breakSetting(breakSetting);

        xmlFileReader().startElement(name, attrs);
    }

    private void margin(ParaMargin margin, String name, Attributes attrs) {
        ((ParaMarginReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParaMargin))
                .margin(margin);

        xmlFileReader().startElement(name, attrs);
    }

    private void lineSpacing(LineSpacing lineSpacing, String name, Attributes attrs) {
        ((LineSpacingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.LineSpacing))
                .lineSpacing(lineSpacing);

        xmlFileReader().startElement(name, attrs);
    }

    private void border(ParaBorder border, String name, Attributes attrs) {
        ((ParaBorderReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParaBorder))
                .border(border);

        xmlFileReader().startElement(name, attrs);
    }

    private void autoSpacing(AutoSpacing autoSpacing, String name, Attributes attrs) {
        ((AutoSpacingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.AutoSpacing))
                .autoSpacing(autoSpacing);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return paraPr;
    }

    public void paraPr(ParaPr paraPr) {
        this.paraPr = paraPr;
    }
}
