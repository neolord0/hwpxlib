package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
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
            case ElementNames.hh_align:
                paraPr.createAlign();
                align(paraPr.align(), name, attrs);
                break;
            case ElementNames.hh_heading:
                paraPr.createHeading();
                heading(paraPr.heading(), name, attrs);
                break;
            case ElementNames.hh_breakSetting:
                paraPr.createBreakSetting();
                breakSetting(paraPr.breakSetting(), name, attrs);
                break;
            case ElementNames.hh_margin:
                paraPr.createMargin();
                margin(paraPr.margin(), name, attrs);
                break;
            case ElementNames.hh_lineSpacing:
                paraPr.createLineSpacing();
                lineSpacing(paraPr.lineSpacing(), name, attrs);
                break;
            case ElementNames.hh_border:
                paraPr.createBorder();
                border(paraPr.border(), name, attrs);
                break;
            case ElementNames.hh_autoSpacing:
                paraPr.createAutoSpacing();
                autoSpacing(paraPr.autoSpacing(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_align:
                Align align = new Align();
                align(align, name, attrs);
                return align;
            case ElementNames.hh_heading:
                Heading heading = new Heading();
                heading(heading, name, attrs);
                return heading;
            case ElementNames.hh_breakSetting:
                BreakSetting breakSetting = new BreakSetting();
                breakSetting(breakSetting, name, attrs);
                return breakSetting;
            case ElementNames.hh_margin:
                ParaMargin margin = new ParaMargin();
                margin(margin, name, attrs);
                return margin;
            case ElementNames.hh_lineSpacing:
                LineSpacing lineSpacing = new LineSpacing();
                lineSpacing(lineSpacing, name, attrs);
                return lineSpacing;
            case ElementNames.hh_border:
                ParaBorder border = new ParaBorder();
                border(border, name, attrs);
                return border;
            case ElementNames.hh_autoSpacing:
                AutoSpacing autoSpacing = new AutoSpacing();
                autoSpacing(autoSpacing, name, attrs);
                return autoSpacing;
        }
        return null;
    }

    private void align(Align align, String name, Attributes attrs) {
        ((AlignReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Align))
                .align(align);

        xmlFileReader().startElement(name, attrs);
    }

    private void heading(Heading heading, String name, Attributes attrs) {
        ((HeadingReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Heading))
                .heading(heading);

        xmlFileReader().startElement(name, attrs);
    }

    private void breakSetting(BreakSetting breakSetting, String name, Attributes attrs) {
        ((BreakSettingReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.BreakSetting))
                .breakSetting(breakSetting);

        xmlFileReader().startElement(name, attrs);
    }

    private void margin(ParaMargin margin, String name, Attributes attrs) {
        ((ParaMarginReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ParaMargin))
                .margin(margin);

        xmlFileReader().startElement(name, attrs);
    }

    private void lineSpacing(LineSpacing lineSpacing, String name, Attributes attrs) {
        ((LineSpacingReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.LineSpacing))
                .lineSpacing(lineSpacing);

        xmlFileReader().startElement(name, attrs);
    }

    private void border(ParaBorder border, String name, Attributes attrs) {
        ((ParaBorderReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ParaBorder))
                .border(border);

        xmlFileReader().startElement(name, attrs);
    }

    private void autoSpacing(AutoSpacing autoSpacing, String name, Attributes attrs) {
        ((AutoSpacingReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.AutoSpacing))
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
