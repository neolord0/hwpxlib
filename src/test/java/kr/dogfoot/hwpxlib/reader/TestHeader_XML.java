package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Default;
import kr.dogfoot.hwpxlib.object.content.header_xml.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.TypeInfo;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

public class TestHeader_XML {
    @Test
    void read() throws IOException, ParserConfigurationException, SAXException {
        ElementReaderManager manager = new ElementReaderManager();
        HWPXFile hwpxFile = new HWPXFile();
        ContentFilesReader contentFilesReader = new ContentFilesReader(manager);
        contentFilesReader.read(hwpxFile, new FileInputStream("testFile/header.xml"));
        HeaderXMLFile header = hwpxFile.headerXMLFile();
        Assert.assertEquals(1 ,header.secCnt().shortValue());
        beginNum(header.beginNum());
        refList(header.refList());
        compatibleDocument(header.compatibleDocument());
        docOption(header.docOption());
        trackChangeConfig(header.trackChangeConfig());
    }

    private void beginNum(BeginNum beginNum) {
        Assert.assertEquals(1, beginNum.page().intValue());
        Assert.assertEquals(2, beginNum.footnote().intValue());
        Assert.assertEquals(3, beginNum.endnote().intValue());
        Assert.assertEquals(4, beginNum.pic().intValue());
        Assert.assertEquals(5, beginNum.tbl().intValue());
        Assert.assertEquals(6, beginNum.equation().intValue());
    }

    private void refList(RefList refList) {
        fontfaces(refList.fontfaces());
        borderFills(refList.borderFills());
        charProperties(refList.charProperties());
        tabProperties(refList.tabProperties());
        numberings(refList.numberings());
        paraProperties(refList.paraProperties());
        styles(refList.styles());
        trackChanges(refList.trackChanges());
        trackChangeAuthors(refList.trackChangeAuthors());
    }


    private void fontfaces(Fontfaces fontfaces) {
        Assert.assertEquals(7, fontfaces.countOfFontface());
        {
            Fontface fontface = fontfaces.getFontface(0);
            Assert.assertEquals(LanguageType.HANGUL, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
            font(fontface.getFont(0));
        }
        {
            Fontface fontface = fontfaces.getFontface(1);
            Assert.assertEquals(LanguageType.LATIN, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
        }
        {
            Fontface fontface = fontfaces.getFontface(2);
            Assert.assertEquals(LanguageType.HANJA, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
        }
        {
            Fontface fontface = fontfaces.getFontface(3);
            Assert.assertEquals(LanguageType.JAPANESE, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
        }
        {
            Fontface fontface = fontfaces.getFontface(4);
            Assert.assertEquals(LanguageType.OTHER, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
        }
        {
            Fontface fontface = fontfaces.getFontface(5);
            Assert.assertEquals(LanguageType.SYMBOL, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
        }
        {
            Fontface fontface = fontfaces.getFontface(6);
            Assert.assertEquals(LanguageType.USER, fontface.lang());
            Assert.assertEquals(2, fontface.countOfFont());
        }
    }

    private void font(Font font) {
        Assert.assertEquals("0", font.id());
        Assert.assertEquals("함초롬돋움", font.face());
        Assert.assertEquals(FontType.TTF, font.type());
        Assert.assertEquals(false, font.isEmbedded().booleanValue());
        Assert.assertNotNull(font.typeInfo());
        TypeInfo typeInfo = font.typeInfo();
        Assert.assertEquals(FontFamilyType.FCAT_GOTHIC, typeInfo.familyType());
        Assert.assertEquals(8, typeInfo.weight().intValue());
        Assert.assertEquals(4, typeInfo.proportion().intValue());
        Assert.assertEquals(0, typeInfo.contrast().intValue());
        Assert.assertEquals(1, typeInfo.strokeVariation().intValue());
        Assert.assertEquals(true, typeInfo.armStyle().booleanValue());
        Assert.assertEquals(true, typeInfo.letterform().booleanValue());
        Assert.assertEquals(true, typeInfo.midline().booleanValue());
        Assert.assertEquals(1, typeInfo.xHeight().intValue());
        Assert.assertNull(font.substFont());
    }


    private void borderFills(ObjectList<BorderFill> borderFills) {
        Assert.assertEquals(2, borderFills.count());
        {
            BorderFill borderFill = borderFills.get(1);
            Assert.assertEquals("2", borderFill.id());
            Assert.assertEquals(false, borderFill.threeD().booleanValue());
            Assert.assertEquals(false, borderFill.shadow().booleanValue());
            Assert.assertEquals(CenterLineSort.NONE, borderFill.centerLine());
            Assert.assertEquals(false, borderFill.breakCellSeparateLine().booleanValue());

            Slash slash = borderFill.slash();
            Assert.assertEquals(SlashType.NONE, slash.type());
            Assert.assertEquals(false, slash.Crooked().booleanValue());
            Assert.assertEquals(false, slash.isCounter().booleanValue());

            BackSlash backSlash = borderFill.backSlash();
            Assert.assertEquals(SlashType.NONE, backSlash.type());
            Assert.assertEquals(false, backSlash.Crooked().booleanValue());
            Assert.assertEquals(false, backSlash.isCounter().booleanValue());

            LeftBorder left  = borderFill.leftBorder();
            Assert.assertEquals(LineType2.NONE, left.type());
            Assert.assertEquals(LineWidth.MM_0_1, left.width());
            Assert.assertEquals("#000000", left.color());

            RightBorder right  = borderFill.rightBorder();
            Assert.assertEquals(LineType2.NONE, right.type());
            Assert.assertEquals(LineWidth.MM_0_1, right.width());
            Assert.assertEquals("#000000", right.color());

            DiagonalBorder diagonal = borderFill.diagonal();
            Assert.assertEquals(LineType2.SOLID, diagonal.type());
            Assert.assertEquals(LineWidth.MM_0_1, diagonal.width());
            Assert.assertEquals("#000000", diagonal.color());

            FillBrush fillBrush = borderFill.fillBrush();
            Assert.assertNotNull(fillBrush);
            Assert.assertNotNull(fillBrush.winBrush());
            Assert.assertNull(fillBrush.gradation());
            Assert.assertNull(fillBrush.imgBrush());

            Assert.assertEquals("none", fillBrush.winBrush().faceColor());
            Assert.assertEquals("#FF000000", fillBrush.winBrush().hatchColor());
            Assert.assertEquals(0, fillBrush.winBrush().alpha().intValue());
        }
    }

    private void charProperties(ObjectList<CharPr> charProperties) {
        Assert.assertEquals(7, charProperties.count());

        CharPr charPr = charProperties.get(0);
        Assert.assertEquals("0", charPr.id());
        Assert.assertEquals(1000, charPr.height().intValue());
        Assert.assertEquals("#000000", charPr.textColor());
        Assert.assertEquals("none", charPr.shadeColor());
        Assert.assertEquals(false, charPr.useFontSpace().booleanValue());
        Assert.assertEquals(false, charPr.useKerning().booleanValue());
        Assert.assertEquals(SymMarkSort.NONE, charPr.symMark());
        Assert.assertEquals("2", charPr.borderFillIDRef());

        Assert.assertEquals("1", charPr.fontRef().hangul());
        Assert.assertEquals("1", charPr.fontRef().latin());
        Assert.assertEquals("1", charPr.fontRef().hanja());
        Assert.assertEquals("1", charPr.fontRef().japanese());
        Assert.assertEquals("1", charPr.fontRef().other());
        Assert.assertEquals("1", charPr.fontRef().symbol());
        Assert.assertEquals("1", charPr.fontRef().user());

        Assert.assertEquals(100, charPr.ratio().hangul().shortValue());
        Assert.assertEquals(100, charPr.ratio().latin().shortValue());
        Assert.assertEquals(100, charPr.ratio().hanja().shortValue());
        Assert.assertEquals(100, charPr.ratio().japanese().shortValue());
        Assert.assertEquals(100, charPr.ratio().other().shortValue());
        Assert.assertEquals(100, charPr.ratio().symbol().shortValue());
        Assert.assertEquals(100, charPr.ratio().user().shortValue());

        Assert.assertEquals(0, charPr.spacing().hangul().shortValue());
        Assert.assertEquals(0, charPr.spacing().latin().shortValue());
        Assert.assertEquals(0, charPr.spacing().hanja().shortValue());
        Assert.assertEquals(0, charPr.spacing().japanese().shortValue());
        Assert.assertEquals(0, charPr.spacing().other().shortValue());
        Assert.assertEquals(0, charPr.spacing().symbol().shortValue());
        Assert.assertEquals(0, charPr.spacing().user().shortValue());

        Assert.assertEquals(100, charPr.relSz().hangul().shortValue());
        Assert.assertEquals(100, charPr.relSz().latin().shortValue());
        Assert.assertEquals(100, charPr.relSz().hanja().shortValue());
        Assert.assertEquals(100, charPr.relSz().japanese().shortValue());
        Assert.assertEquals(100, charPr.relSz().other().shortValue());
        Assert.assertEquals(100, charPr.relSz().symbol().shortValue());
        Assert.assertEquals(100, charPr.relSz().user().shortValue());

        Assert.assertEquals(0, charPr.offset().hangul().shortValue());
        Assert.assertEquals(0, charPr.offset().latin().shortValue());
        Assert.assertEquals(0, charPr.offset().hanja().shortValue());
        Assert.assertEquals(0, charPr.offset().japanese().shortValue());
        Assert.assertEquals(0, charPr.offset().other().shortValue());
        Assert.assertEquals(0, charPr.offset().symbol().shortValue());
        Assert.assertEquals(0, charPr.offset().user().shortValue());

        Assert.assertEquals(UnderlineType.NONE, charPr.underline().type());
        Assert.assertEquals(LineType3.SOLID, charPr.underline().shape());
        Assert.assertEquals("#000000", charPr.underline().color());

        Assert.assertEquals(LineType2.NONE, charPr.strikeout().shape());
        Assert.assertEquals("#000000", charPr.strikeout().color());

        Assert.assertEquals(LineType1.NONE, charPr.outline().type());

        Assert.assertEquals(CharShadowType.NONE, charPr.shadow().type());
    }

    private void tabProperties(ObjectList<TabPr> tabProperties) {
        Assert.assertEquals(2,  tabProperties.count());

        TabPr tabPr = tabProperties.get(1);
        Assert.assertEquals("1", tabPr.id());
        Assert.assertEquals(true, tabPr.autoTabLeft().booleanValue());
        Assert.assertEquals(false, tabPr.autoTabRight().booleanValue());
    }

    private void numberings(ObjectList<Numbering> numberings) {
        Assert.assertEquals(1, numberings.count());

        Numbering numbering = numberings.get(0);
        Assert.assertEquals("1", numbering.id());
        Assert.assertEquals(0, numbering.start().intValue());

        {
            ParaHead paraHead = numbering.getParaHead(0);
            Assert.assertEquals(1, paraHead.start().intValue());
            Assert.assertEquals(1, paraHead.level().intValue());
            Assert.assertEquals(HorizontalAlign1.LEFT, paraHead.align());
            Assert.assertEquals(true, paraHead.useInstWidth().booleanValue());
            Assert.assertEquals(true, paraHead.autoIndent().booleanValue());
            Assert.assertEquals(0, paraHead.widthAdjust().intValue());
            Assert.assertEquals(ValueUnit1.PERCENT, paraHead.textOffsetType());
            Assert.assertEquals(50, paraHead.textOffset().intValue());
            Assert.assertEquals(NumberType1.DIGIT, paraHead.numFormat());
            Assert.assertEquals("4294967295", paraHead.charPrIDRef());
            Assert.assertEquals(false, paraHead.checkable().booleanValue());
            Assert.assertEquals("^1.", paraHead.text());
        }

        {
            ParaHead paraHead = numbering.getParaHead(1);
            Assert.assertEquals(1, paraHead.start().intValue());
            Assert.assertEquals(2, paraHead.level().intValue());
            Assert.assertEquals(HorizontalAlign1.LEFT, paraHead.align());
            Assert.assertEquals(true, paraHead.useInstWidth().booleanValue());
            Assert.assertEquals(true, paraHead.autoIndent().booleanValue());
            Assert.assertEquals(0, paraHead.widthAdjust().intValue());
            Assert.assertEquals(ValueUnit1.PERCENT, paraHead.textOffsetType());
            Assert.assertEquals(50, paraHead.textOffset().intValue());
            Assert.assertEquals(NumberType1.HANGUL_SYLLABLE, paraHead.numFormat());
            Assert.assertEquals("4294967295", paraHead.charPrIDRef());
            Assert.assertEquals(false, paraHead.checkable().booleanValue());
            Assert.assertEquals("^2.", paraHead.text());
        }

        {
            ParaHead paraHead = numbering.getParaHead(6);
            Assert.assertEquals(1, paraHead.start().intValue());
            Assert.assertEquals(7, paraHead.level().intValue());
            Assert.assertEquals(HorizontalAlign1.LEFT, paraHead.align());
            Assert.assertEquals(true, paraHead.useInstWidth().booleanValue());
            Assert.assertEquals(true, paraHead.autoIndent().booleanValue());
            Assert.assertEquals(0, paraHead.widthAdjust().intValue());
            Assert.assertEquals(ValueUnit1.PERCENT, paraHead.textOffsetType());
            Assert.assertEquals(50, paraHead.textOffset().intValue());
            Assert.assertEquals(NumberType1.CIRCLED_DIGIT, paraHead.numFormat());
            Assert.assertEquals("4294967295", paraHead.charPrIDRef());
            Assert.assertEquals(true, paraHead.checkable().booleanValue());
            Assert.assertEquals("^7", paraHead.text());
        }
    }
    private void paraProperties(ObjectList<ParaPr> paraProperties) {
        Assert.assertEquals(16, paraProperties.count());

        paraPr0(paraProperties.get(0));
        paraPr16(paraProperties.get(15));
    }

    private static void paraPr0(ParaPr paraPr) {
        Assert.assertEquals("0", paraPr.id());
        Assert.assertEquals("0", paraPr.tabPrIDRef());
        Assert.assertEquals(0, paraPr.condense().intValue());
        Assert.assertEquals(false, paraPr.fontLineHeight().booleanValue());
        Assert.assertEquals(true, paraPr.snapToGrid().booleanValue());
        Assert.assertEquals(false, paraPr.suppressLineNumbers().booleanValue());
        Assert.assertEquals(false, paraPr.checked().booleanValue());

        Align align = paraPr.align();
        Assert.assertEquals(HorizontalAlign2.LEFT, align.horizontal());
        Assert.assertEquals(VerticalAlign1.BASELINE, align.vertical());

        Heading heading = paraPr.heading();
        Assert.assertEquals(ParaHeadingType.NONE, heading.type());
        Assert.assertEquals("0", heading.idRef());
        Assert.assertEquals(0, heading.level().intValue());

        BreakSetting breakSetting = paraPr.breakSetting();
        Assert.assertEquals(LineBreakForLatin.KEEP_WORD, breakSetting.breakLatinWord());
        Assert.assertEquals(LineBreakForNonLatin.BREAK_WORD, breakSetting.breakNonLatinWord());
        Assert.assertEquals(false, breakSetting.widowOrphan().booleanValue());
        Assert.assertEquals(false, breakSetting.keepWithNext().booleanValue());
        Assert.assertEquals(false, breakSetting.keepLines().booleanValue());
        Assert.assertEquals(false, breakSetting.pageBreakBefore().booleanValue());
        Assert.assertEquals(LineWrap.BREAK, breakSetting.lineWrap());

        AutoSpacing autoSpacing = paraPr.autoSpacing();
        Assert.assertEquals(false, autoSpacing.eAsianEng().booleanValue());
        Assert.assertEquals(false, autoSpacing.eAsianNum().booleanValue());

        ParaBorder border = paraPr.border();
        Assert.assertEquals("2", border.borderFillIDRef());
        Assert.assertEquals(0, border.offsetLeft().intValue());
        Assert.assertEquals(0, border.offsetRight().intValue());
        Assert.assertEquals(0, border.offsetTop().intValue());
        Assert.assertEquals(0, border.offsetBottom().intValue());
        Assert.assertEquals(false, border.connect().booleanValue());
        Assert.assertEquals(false, border.ignoreMargin().booleanValue());

        Assert.assertEquals(1, paraPr.switchObject().countOfCaseObject());
        {
            Case caseObject = paraPr.switchObject().getCaseObject(0);
            Assert.assertEquals("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar", caseObject.requiredNamespace());
            Assert.assertEquals(2, caseObject.countOfChild());
            Assert.assertEquals(ObjectType.ParaMargin, caseObject.getChild(0).objectType());
            ParaMargin margin = (ParaMargin) caseObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(0, margin.intent().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.intent().unit());
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(0, margin.left().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.left().unit());
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(0, margin.right().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.right().unit());
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(0, margin.prev().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.prev().unit());
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(0, margin.next().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.next().unit());
            Assert.assertEquals(ObjectType.LineSpacing, caseObject.getChild(1).objectType());
            LineSpacing lineSpacing = (LineSpacing) caseObject.getChild(1);
            Assert.assertEquals(LineSpacingType.PERCENT, lineSpacing.type());
            Assert.assertEquals(130, lineSpacing.value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, lineSpacing.unit());
        }

        {
            Default defaultObject = paraPr.switchObject().defaultObject();
            Assert.assertEquals(2, defaultObject.countOfChild());
            Assert.assertEquals(ObjectType.ParaMargin, defaultObject.getChild(0).objectType());
            ParaMargin margin = (ParaMargin) defaultObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(0, margin.intent().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.intent().unit());
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(0, margin.left().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.left().unit());
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(0, margin.right().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.right().unit());
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(0, margin.prev().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.prev().unit());
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(0, margin.next().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.next().unit());
            Assert.assertEquals(ObjectType.LineSpacing, defaultObject.getChild(1).objectType());
            LineSpacing lineSpacing = (LineSpacing) defaultObject.getChild(1);
            Assert.assertEquals(LineSpacingType.PERCENT, lineSpacing.type());
            Assert.assertEquals(130, lineSpacing.value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, lineSpacing.unit());
        }
    }

    private static void paraPr16(ParaPr paraPr) {
        Assert.assertEquals("15", paraPr.id());
        Assert.assertEquals("0", paraPr.tabPrIDRef());
        Assert.assertEquals(0, paraPr.condense().intValue());
        Assert.assertEquals(false, paraPr.fontLineHeight().booleanValue());
        Assert.assertEquals(true, paraPr.snapToGrid().booleanValue());
        Assert.assertEquals(false, paraPr.suppressLineNumbers().booleanValue());
        Assert.assertEquals(false, paraPr.checked().booleanValue());

        Align align = paraPr.align();
        Assert.assertEquals(HorizontalAlign2.LEFT, align.horizontal());
        Assert.assertEquals(VerticalAlign1.BASELINE, align.vertical());

        Heading heading = paraPr.heading();
        Assert.assertEquals(ParaHeadingType.NONE, heading.type());
        Assert.assertEquals("0", heading.idRef());
        Assert.assertEquals(0, heading.level().intValue());

        BreakSetting breakSetting = paraPr.breakSetting();
        Assert.assertEquals(LineBreakForLatin.KEEP_WORD, breakSetting.breakLatinWord());
        Assert.assertEquals(LineBreakForNonLatin.BREAK_WORD, breakSetting.breakNonLatinWord());
        Assert.assertEquals(true, breakSetting.widowOrphan().booleanValue());
        Assert.assertEquals(false, breakSetting.keepWithNext().booleanValue());
        Assert.assertEquals(false, breakSetting.keepLines().booleanValue());
        Assert.assertEquals(false, breakSetting.pageBreakBefore().booleanValue());
        Assert.assertEquals(LineWrap.BREAK, breakSetting.lineWrap());

        AutoSpacing autoSpacing = paraPr.autoSpacing();
        Assert.assertEquals(true, autoSpacing.eAsianEng().booleanValue());
        Assert.assertEquals(true, autoSpacing.eAsianNum().booleanValue());

        ParaBorder border = paraPr.border();
        Assert.assertEquals("2", border.borderFillIDRef());
        Assert.assertEquals(0, border.offsetLeft().intValue());
        Assert.assertEquals(0, border.offsetRight().intValue());
        Assert.assertEquals(0, border.offsetTop().intValue());
        Assert.assertEquals(0, border.offsetBottom().intValue());
        Assert.assertEquals(false, border.connect().booleanValue());
        Assert.assertEquals(false, border.ignoreMargin().booleanValue());

        Assert.assertEquals(1, paraPr.switchObject().countOfCaseObject());
        {
            Case caseObject = paraPr.switchObject().getCaseObject(0);
            Assert.assertEquals("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar", caseObject.requiredNamespace());
            Assert.assertEquals(2, caseObject.countOfChild());
            Assert.assertEquals(ObjectType.ParaMargin, caseObject.getChild(0).objectType());
            ParaMargin margin = (ParaMargin) caseObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(0, margin.intent().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.intent().unit());
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(2200, margin.left().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.left().unit());
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(0, margin.right().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.right().unit());
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(0, margin.prev().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.prev().unit());
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(700, margin.next().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.next().unit());
            Assert.assertEquals(ObjectType.LineSpacing, caseObject.getChild(1).objectType());
            LineSpacing lineSpacing = (LineSpacing) caseObject.getChild(1);
            Assert.assertEquals(LineSpacingType.PERCENT, lineSpacing.type());
            Assert.assertEquals(160, lineSpacing.value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, lineSpacing.unit());
        }

        {
            Default defaultObject = paraPr.switchObject().defaultObject();
            Assert.assertEquals(2, defaultObject.countOfChild());
            Assert.assertEquals(ObjectType.ParaMargin, defaultObject.getChild(0).objectType());
            ParaMargin margin = (ParaMargin) defaultObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(0, margin.intent().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.intent().unit());
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(4400, margin.left().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.left().unit());
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(0, margin.right().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.right().unit());
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(0, margin.prev().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.prev().unit());
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(1400, margin.next().value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, margin.next().unit());
            Assert.assertEquals(ObjectType.LineSpacing, defaultObject.getChild(1).objectType());
            LineSpacing lineSpacing = (LineSpacing) defaultObject.getChild(1);
            Assert.assertEquals(LineSpacingType.PERCENT, lineSpacing.type());
            Assert.assertEquals(160, lineSpacing.value().intValue());
            Assert.assertEquals(ValueUnit2.HWPUNIT, lineSpacing.unit());
        }
    }

    private void styles(ObjectList<Style> styles) {
        Assert.assertEquals(18, styles.count());
        {
            Style style = styles.get(2);
            Assert.assertEquals("2", style.id());
            Assert.assertEquals(StyleType.PARA, style.type());
            Assert.assertEquals("개요 1", style.name());
            Assert.assertEquals("Outline 1", style.engName());
            Assert.assertEquals("10", style.paraPrIDRef());
            Assert.assertEquals("0", style.charPrIDRef());
            Assert.assertEquals("2", style.nextStyleIDRef());
            Assert.assertEquals("1042", style.langID());
            Assert.assertEquals(false, style.lockForm().booleanValue());
        }
        {
            Style style = styles.get(9);
            Assert.assertEquals("9", style.id());
            Assert.assertEquals(StyleType.CHAR, style.type());
            Assert.assertEquals("쪽 번호", style.name());
            Assert.assertEquals("Page Number", style.engName());
            Assert.assertEquals("0", style.paraPrIDRef());
            Assert.assertEquals("1", style.charPrIDRef());
            Assert.assertEquals("0", style.nextStyleIDRef());
            Assert.assertEquals("1042", style.langID());
            Assert.assertEquals(false, style.lockForm().booleanValue());
        }
    }

    private void trackChanges(ObjectList<TrackChange> trackChanges) {
        Assert.assertEquals(2, trackChanges.count());
        TrackChange trackChange = trackChanges.get(0);
        Assert.assertEquals("1", trackChange.id());
        Assert.assertEquals(TrackChangeType.Insert, trackChange.type());
        Assert.assertEquals("2022-11-22T07:02:00Z", trackChange.date());
        Assert.assertEquals("1", trackChange.authorID());
        Assert.assertEquals(false, trackChange.hide().booleanValue());
    }

    private void trackChangeAuthors(ObjectList<TrackChangeAuthor> trackChangeAuthors) {
        Assert.assertEquals(1, trackChangeAuthors.count());
        TrackChangeAuthor trackChangeAuthor = trackChangeAuthors.get(0);
        Assert.assertEquals("fff", trackChangeAuthor.name());
        Assert.assertEquals(true, trackChangeAuthor.mark().booleanValue());
        Assert.assertEquals("0", trackChangeAuthor.id());
    }

    private void compatibleDocument(CompatibleDocument compatibleDocument) {
        Assert.assertEquals(TargetProgramSort.HWP201X, compatibleDocument.targetProgram());
        Assert.assertNotNull(compatibleDocument.layoutCompatibility());
        Assert.assertEquals(0, compatibleDocument.layoutCompatibility().count());
    }

    private void docOption(DocOption docOption) {
        Assert.assertNotNull(docOption.linkInfo());
        LinkInfo linkInfo = docOption.linkInfo();
        Assert.assertEquals("", linkInfo.path());
        Assert.assertEquals(false, linkInfo.pageInherit().booleanValue());
        Assert.assertEquals(false, linkInfo.footnoteInherit().booleanValue());
    }

    private void trackChangeConfig(TrackChangeConfig trackChangeConfig) {
        Assert.assertEquals(57, trackChangeConfig.flags().intValue());
    }
}
