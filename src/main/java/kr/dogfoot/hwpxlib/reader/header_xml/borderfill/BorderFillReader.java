package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.CenterLineSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Border;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.SlashCore;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class BorderFillReader extends ElementReader {
    private BorderFill borderFill;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.BorderFill;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                borderFill.id(value);
                break;
            case AttributeNames.threeD:
                borderFill.threeD(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.shadow:
                borderFill.shadow(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.centerLine:
                borderFill.centerLine(CenterLineSort.fromString(value));
                break;
            case AttributeNames.breakCellSeparateLine:
                borderFill.breakCellSeparateLine(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_slash:
                borderFill.createSlash();
                slashCore(borderFill.slash(), name, attrs);
                break;
            case ElementNames.hh_backSlash:
                borderFill.createBackSlash();
                slashCore(borderFill.backSlash(), name, attrs);
                break;
            case ElementNames.hh_leftBorder:
                borderFill.createLeftBorder();
                border(borderFill.leftBorder(), name, attrs);
                break;
            case ElementNames.hh_rightBorder:
                borderFill.createRightBorder();
                border(borderFill.rightBorder(), name, attrs);
                break;
            case ElementNames.hh_topBorder:
                borderFill.createTopBorder();
                border(borderFill.topBorder(), name, attrs);
                break;
            case ElementNames.hh_bottomBorder:
                borderFill.createBottomBorder();
                border(borderFill.bottomBorder(), name, attrs);
                break;
            case ElementNames.hh_diagonal:
                borderFill.createDiagonal();
                border(borderFill.diagonal(), name, attrs);
                break;
            case ElementNames.hc_fillBrush:
                borderFill.createFillBrush();
                fillBrush(borderFill.fillBrush(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_slash:
                SlashCore slash = new SlashCore(ObjectType.hh_slash);
                slashCore(slash, name, attrs);
                return slash;
            case ElementNames.hh_backSlash:
                SlashCore backSlash = new SlashCore(ObjectType.hh_backSlash);
                slashCore(backSlash, name, attrs);
                return backSlash;
            case ElementNames.hh_leftBorder:
                Border leftBorder = new Border(ObjectType.hh_leftBorder);
                border(leftBorder, name, attrs);
                return leftBorder;
            case ElementNames.hh_rightBorder:
                Border rightBorder = new Border(ObjectType.hh_rightBorder);
                border(rightBorder, name, attrs);
                return rightBorder;
            case ElementNames.hh_topBorder:
                Border topBorder = new Border(ObjectType.hh_topBorder);
                border(topBorder, name, attrs);
                return topBorder;
            case ElementNames.hh_bottomBorder:
                Border bottomBorder = new Border(ObjectType.hh_bottomBorder);
                border(bottomBorder, name, attrs);
                return bottomBorder;
            case ElementNames.hh_diagonal:
                Border diagonal = new Border(ObjectType.hh_diagonal);
                border(diagonal, name, attrs);
                return diagonal;
            case ElementNames.hc_fillBrush:
                FillBrush fillBrush = new FillBrush();
                fillBrush(fillBrush, name, attrs);
                return fillBrush;
        }
        return null;
    }

    private void slashCore(SlashCore slashCore, String name, Attributes attrs) {
        ((SlashCoreReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.SlashCore))
                .slashCore(slashCore);

        xmlFileReader().startElement(name, attrs);
    }

    private void border(Border leftBorder, String name, Attributes attrs) {
        ((BorderReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Border))
                .border(leftBorder);

        xmlFileReader().startElement(name, attrs);
    }

    private void fillBrush(FillBrush fillBrush, String name, Attributes attrs) {
        ((FillBrushReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.FillBrush))
                .fillBrush(fillBrush);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return borderFill;
    }

    public void borderFill(BorderFill borderFill) {
        this.borderFill = borderFill;
    }
}
