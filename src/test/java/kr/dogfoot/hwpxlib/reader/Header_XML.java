package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.compatibility.Case;
import kr.dogfoot.hwpxlib.object.common.compatibility.Default;
import kr.dogfoot.hwpxlib.object.common.compatibility.Switch;
import kr.dogfoot.hwpxlib.object.content.header_xml.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Border;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.SlashCore;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.TypeInfo;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;

public class Header_XML {
    @Test
    public void read() throws IOException, ParserConfigurationException, SAXException {
        ElementReaderManager manager = new ElementReaderManager();
        HWPXFile hwpxFile = new HWPXFile();
        ContentFilesReader contentFilesReader = new ContentFilesReader(manager);
        contentFilesReader.read(hwpxFile, new FileInputStream("testFile/reader_writer/header.xml"), true);
        HeaderXMLFile header = hwpxFile.headerXMLFile();
        Assert.assertEquals(header.secCnt().shortValue() ,1);
        beginNum(header.beginNum());
        refList(header.refList());
        compatibleDocument(header.compatibleDocument());
        docOption(header.docOption());
        trackChangeConfig(header.trackChangeConfig());
    }

    private void beginNum(BeginNum beginNum) {
        Assert.assertEquals(beginNum.page().intValue(), 1);
        Assert.assertEquals(beginNum.footnote().intValue(), 2);
        Assert.assertEquals(beginNum.endnote().intValue(), 3);
        Assert.assertEquals(beginNum.pic().intValue(), 4);
        Assert.assertEquals(beginNum.tbl().intValue(), 5);
        Assert.assertEquals(beginNum.equation().intValue(), 6);
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
            Assert.assertEquals(fontface.lang(), LanguageType.HANGUL);
            Assert.assertEquals(fontface.countOfFont(), 2);
            font(fontface.getFont(0));
        }
        {
            Fontface fontface = fontfaces.getFontface(1);
            Assert.assertEquals(fontface.lang(), LanguageType.LATIN);
            Assert.assertEquals(fontface.countOfFont(), 2);
        }
        {
            Fontface fontface = fontfaces.getFontface(2);
            Assert.assertEquals(fontface.lang(), LanguageType.HANJA);
            Assert.assertEquals(fontface.countOfFont(), 2);
        }
        {
            Fontface fontface = fontfaces.getFontface(3);
            Assert.assertEquals(fontface.lang(), LanguageType.JAPANESE);
            Assert.assertEquals(fontface.countOfFont(), 2);
        }
        {
            Fontface fontface = fontfaces.getFontface(4);
            Assert.assertEquals(fontface.lang(), LanguageType.OTHER);
            Assert.assertEquals(fontface.countOfFont(), 2);
        }
        {
            Fontface fontface = fontfaces.getFontface(5);
            Assert.assertEquals(fontface.lang(), LanguageType.SYMBOL);
            Assert.assertEquals(fontface.countOfFont(), 2);
        }
        {
            Fontface fontface = fontfaces.getFontface(6);
            Assert.assertEquals(fontface.lang(), LanguageType.USER);
            Assert.assertEquals(fontface.countOfFont(), 2);
        }
    }

    private void font(Font font) {
        Assert.assertEquals(font.id(), "0");
        Assert.assertEquals(font.face(), "함초롬돋움");
        Assert.assertEquals(font.type(), FontType.TTF);
        Assert.assertEquals(font.isEmbedded().booleanValue(), false);
        Assert.assertNotNull(font.typeInfo());
        TypeInfo typeInfo = font.typeInfo();
        Assert.assertEquals(typeInfo.familyType(), FontFamilyType.FCAT_GOTHIC);
        Assert.assertEquals(typeInfo.weight().intValue(), 8);
        Assert.assertEquals(typeInfo.proportion().intValue(), 4);
        Assert.assertEquals(typeInfo.contrast().intValue(), 0);
        Assert.assertEquals(typeInfo.strokeVariation().intValue(), 1);
        Assert.assertEquals(typeInfo.armStyle().booleanValue(), true);
        Assert.assertEquals(typeInfo.letterform().booleanValue(), true);
        Assert.assertEquals(typeInfo.midline().intValue(), 1);
        Assert.assertEquals(typeInfo.xHeight().intValue(), 1);
        Assert.assertNull(font.substFont());
    }


    private void borderFills(ObjectList<BorderFill> borderFills) {
        Assert.assertEquals(2, borderFills.count());
        {
            BorderFill borderFill = borderFills.get(1);
            Assert.assertEquals(borderFill.id(), "2");
            Assert.assertEquals(borderFill.threeD().booleanValue(), false);
            Assert.assertEquals(borderFill.shadow().booleanValue(), false);
            Assert.assertEquals(borderFill.centerLine(), CenterLineSort.NONE);
            Assert.assertEquals(borderFill.breakCellSeparateLine().booleanValue(), false);

            SlashCore slash = borderFill.slash();
            Assert.assertEquals(slash.type(), SlashType.NONE);
            Assert.assertEquals(slash.Crooked().booleanValue(), false);
            Assert.assertEquals(slash.isCounter().booleanValue(), false);

            SlashCore backSlash = borderFill.backSlash();
            Assert.assertEquals(backSlash.type(), SlashType.NONE);
            Assert.assertEquals(backSlash.Crooked().booleanValue(), false);
            Assert.assertEquals(backSlash.isCounter().booleanValue(), false);

            Border left = borderFill.leftBorder();
            Assert.assertEquals(left.type(), LineType2.NONE);
            Assert.assertEquals(left.width(), LineWidth.MM_0_1);
            Assert.assertEquals(left.color(), "#000000");

            Border right = borderFill.rightBorder();
            Assert.assertEquals(right.type(), LineType2.NONE);
            Assert.assertEquals(right.width(), LineWidth.MM_0_1);
            Assert.assertEquals(right.color(), "#000000");

            Border diagonal = borderFill.diagonal();
            Assert.assertEquals(diagonal.type(), LineType2.SOLID);
            Assert.assertEquals(diagonal.width(), LineWidth.MM_0_1);
            Assert.assertEquals(diagonal.color(), "#000000");

            FillBrush fillBrush = borderFill.fillBrush();
            Assert.assertNotNull(fillBrush);
            Assert.assertNotNull(fillBrush.winBrush());
            Assert.assertNull(fillBrush.gradation());
            Assert.assertNull(fillBrush.imgBrush());

            Assert.assertEquals(fillBrush.winBrush().faceColor(), "none");
            Assert.assertEquals(fillBrush.winBrush().hatchColor(), "#FF000000");
            Assert.assertEquals(fillBrush.winBrush().alpha().intValue(), 0);
        }
    }

    private void charProperties(ObjectList<CharPr> charProperties) {
        Assert.assertEquals(7, charProperties.count());

        CharPr charPr = charProperties.get(0);
        Assert.assertEquals(charPr.id(), "0");
        Assert.assertEquals(charPr.height().intValue(), 1000);
        Assert.assertEquals(charPr.textColor(), "#000000");
        Assert.assertEquals(charPr.shadeColor(), "none");
        Assert.assertEquals(charPr.useFontSpace().booleanValue(), false);
        Assert.assertEquals(charPr.useKerning().booleanValue(), false);
        Assert.assertEquals(charPr.symMark(), SymMarkSort.NONE);
        Assert.assertEquals(charPr.borderFillIDRef(), "2");

        Assert.assertEquals(charPr.fontRef().hangul(), "1");
        Assert.assertEquals(charPr.fontRef().latin(), "1");
        Assert.assertEquals(charPr.fontRef().hanja(), "1");
        Assert.assertEquals(charPr.fontRef().japanese(), "1");
        Assert.assertEquals(charPr.fontRef().other(), "1");
        Assert.assertEquals(charPr.fontRef().symbol(), "1");
        Assert.assertEquals(charPr.fontRef().user(), "1");

        Assert.assertEquals(charPr.ratio().hangul().shortValue(), 100);
        Assert.assertEquals(charPr.ratio().latin().shortValue(), 100);
        Assert.assertEquals(charPr.ratio().hanja().shortValue(), 100);
        Assert.assertEquals(charPr.ratio().japanese().shortValue(), 100);
        Assert.assertEquals(charPr.ratio().other().shortValue(), 100);
        Assert.assertEquals(charPr.ratio().symbol().shortValue(), 100);
        Assert.assertEquals(charPr.ratio().user().shortValue(), 100);

        Assert.assertEquals(charPr.spacing().hangul().shortValue(), 0);
        Assert.assertEquals(charPr.spacing().latin().shortValue(), 0);
        Assert.assertEquals(charPr.spacing().hanja().shortValue(), 0);
        Assert.assertEquals(charPr.spacing().japanese().shortValue(), 0);
        Assert.assertEquals(charPr.spacing().other().shortValue(), 0);
        Assert.assertEquals(charPr.spacing().symbol().shortValue(), 0);
        Assert.assertEquals(charPr.spacing().user().shortValue(), 0);

        Assert.assertEquals(charPr.relSz().hangul().shortValue(), 100);
        Assert.assertEquals(charPr.relSz().latin().shortValue(), 100);
        Assert.assertEquals(charPr.relSz().hanja().shortValue(), 100);
        Assert.assertEquals(charPr.relSz().japanese().shortValue(), 100);
        Assert.assertEquals(charPr.relSz().other().shortValue(), 100);
        Assert.assertEquals(charPr.relSz().symbol().shortValue(), 100);
        Assert.assertEquals(charPr.relSz().user().shortValue(), 100);

        Assert.assertEquals(charPr.offset().hangul().shortValue(), 0);
        Assert.assertEquals(charPr.offset().latin().shortValue(), 0);
        Assert.assertEquals(charPr.offset().hanja().shortValue(), 0);
        Assert.assertEquals(charPr.offset().japanese().shortValue(), 0);
        Assert.assertEquals(charPr.offset().other().shortValue(), 0);
        Assert.assertEquals(charPr.offset().symbol().shortValue(), 0);
        Assert.assertEquals(charPr.offset().user().shortValue(), 0);

        Assert.assertEquals(charPr.underline().type(), UnderlineType.NONE);
        Assert.assertEquals(charPr.underline().shape(), LineType3.SOLID);
        Assert.assertEquals(charPr.underline().color(), "#000000");

        Assert.assertEquals(charPr.strikeout().shape(), LineType2.NONE);
        Assert.assertEquals(charPr.strikeout().color(), "#000000");

        Assert.assertEquals(charPr.outline().type(), LineType1.NONE);

        Assert.assertEquals(charPr.shadow().type(), CharShadowType.NONE);
    }

    private void tabProperties(ObjectList<TabPr> tabProperties) {
        Assert.assertEquals(tabProperties.count(),  2);

        TabPr tabPr = tabProperties.get(1);
        Assert.assertEquals(tabPr.id(), "1");
        Assert.assertEquals(tabPr.autoTabLeft().booleanValue(), true);
        Assert.assertEquals(tabPr.autoTabRight().booleanValue(), false);
    }

    private void numberings(ObjectList<Numbering> numberings) {
        Assert.assertEquals(numberings.count(), 1);

        Numbering numbering = numberings.get(0);
        Assert.assertEquals(numbering.id(), "1");
        Assert.assertEquals(numbering.start().intValue(), 0);

        {
            ParaHead paraHead = numbering.getParaHead(0);
            Assert.assertEquals(paraHead.start().intValue(), 1);
            Assert.assertEquals(paraHead.level().intValue(), 1);
            Assert.assertEquals(paraHead.align(), HorizontalAlign1.LEFT);
            Assert.assertEquals(paraHead.useInstWidth().booleanValue(), true);
            Assert.assertEquals(paraHead.autoIndent().booleanValue(), true);
            Assert.assertEquals(paraHead.widthAdjust().intValue(), 0);
            Assert.assertEquals(paraHead.textOffsetType(), ValueUnit1.PERCENT);
            Assert.assertEquals(paraHead.textOffset().intValue(), 50);
            Assert.assertEquals(paraHead.numFormat(), NumberType1.DIGIT);
            Assert.assertEquals(paraHead.charPrIDRef(), "4294967295");
            Assert.assertEquals(paraHead.checkable().booleanValue(), false);
            Assert.assertEquals(paraHead.text(), "^1.");
        }

        {
            ParaHead paraHead = numbering.getParaHead(1);
            Assert.assertEquals(paraHead.start().intValue(), 1);
            Assert.assertEquals(paraHead.level().intValue(), 2);
            Assert.assertEquals(paraHead.align(), HorizontalAlign1.LEFT);
            Assert.assertEquals(paraHead.useInstWidth().booleanValue(), true);
            Assert.assertEquals(paraHead.autoIndent().booleanValue(), true);
            Assert.assertEquals(paraHead.widthAdjust().intValue(), 0);
            Assert.assertEquals(paraHead.textOffsetType(), ValueUnit1.PERCENT);
            Assert.assertEquals(paraHead.textOffset().intValue(), 50);
            Assert.assertEquals(paraHead.numFormat(), NumberType1.HANGUL_SYLLABLE);
            Assert.assertEquals(paraHead.charPrIDRef(), "4294967295");
            Assert.assertEquals(paraHead.checkable().booleanValue(), false);
            Assert.assertEquals(paraHead.text(), "^2.");
        }

        {
            ParaHead paraHead = numbering.getParaHead(6);
            Assert.assertEquals(paraHead.start().intValue(), 1);
            Assert.assertEquals(paraHead.level().intValue(), 7);
            Assert.assertEquals(paraHead.align(), HorizontalAlign1.LEFT);
            Assert.assertEquals(paraHead.useInstWidth().booleanValue(), true);
            Assert.assertEquals(paraHead.autoIndent().booleanValue(), true);
            Assert.assertEquals(paraHead.widthAdjust().intValue(), 0);
            Assert.assertEquals(paraHead.textOffsetType(), ValueUnit1.PERCENT);
            Assert.assertEquals(paraHead.textOffset().intValue(), 50);
            Assert.assertEquals(paraHead.numFormat(), NumberType1.CIRCLED_DIGIT);
            Assert.assertEquals(paraHead.charPrIDRef(), "4294967295");
            Assert.assertEquals(paraHead.checkable().booleanValue(), true);
            Assert.assertEquals(paraHead.text(), "^7");
        }
    }
    private void paraProperties(ObjectList<ParaPr> paraProperties) {
        Assert.assertEquals(paraProperties.count(), 16);

        paraPr0(paraProperties.get(0));
        paraPr16(paraProperties.get(15));
    }

    private static void paraPr0(ParaPr paraPr) {
        Assert.assertEquals(paraPr.id(), "0");
        Assert.assertEquals(paraPr.tabPrIDRef(), "0");
        Assert.assertEquals(paraPr.condense().intValue(), 0);
        Assert.assertEquals(paraPr.fontLineHeight().booleanValue(), false);
        Assert.assertEquals(paraPr.snapToGrid().booleanValue(), true);
        Assert.assertEquals(paraPr.suppressLineNumbers().booleanValue(), false);
        Assert.assertEquals(paraPr.checked().booleanValue(), false);

        Align align = paraPr.align();
        Assert.assertEquals(align.horizontal(), HorizontalAlign2.LEFT);
        Assert.assertEquals(align.vertical(), VerticalAlign1.BASELINE);

        Heading heading = paraPr.heading();
        Assert.assertEquals(heading.type(), ParaHeadingType.NONE);
        Assert.assertEquals(heading.idRef(), "0");
        Assert.assertEquals(heading.level().intValue(), 0);

        BreakSetting breakSetting = paraPr.breakSetting();
        Assert.assertEquals(breakSetting.breakLatinWord(), LineBreakForLatin.KEEP_WORD);
        Assert.assertEquals(breakSetting.breakNonLatinWord(), LineBreakForNonLatin.BREAK_WORD);
        Assert.assertEquals(breakSetting.widowOrphan().booleanValue(), false);
        Assert.assertEquals(breakSetting.keepWithNext().booleanValue(), false);
        Assert.assertEquals(breakSetting.keepLines().booleanValue(), false);
        Assert.assertEquals(breakSetting.pageBreakBefore().booleanValue(), false);
        Assert.assertEquals(breakSetting.lineWrap(), LineWrap.BREAK);

        AutoSpacing autoSpacing = paraPr.autoSpacing();
        Assert.assertEquals(autoSpacing.eAsianEng().booleanValue(), false);
        Assert.assertEquals(autoSpacing.eAsianNum().booleanValue(), false);

        ParaBorder border = paraPr.border();
        Assert.assertEquals(border.borderFillIDRef(), "2");
        Assert.assertEquals(border.offsetLeft().intValue(), 0);
        Assert.assertEquals(border.offsetRight().intValue(), 0);
        Assert.assertEquals(border.offsetTop().intValue(), 0);
        Assert.assertEquals(border.offsetBottom().intValue(), 0);
        Assert.assertEquals(border.connect().booleanValue(), false);
        Assert.assertEquals(border.ignoreMargin().booleanValue(), false);

        Switch switchObject = paraPr.switchList().get(0);
        Assert.assertEquals(1, switchObject.countOfCaseObject());
        {
            Case caseObject = switchObject.getCaseObject(0);
            Assert.assertEquals(caseObject.requiredNamespace(), "http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
            Assert.assertEquals(caseObject.countOfChild(), 2);
            Assert.assertEquals(caseObject.getChild(0)._objectType(), ObjectType.hh_margin);
            ParaMargin margin = (ParaMargin) caseObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(margin.intent().value().intValue(), 0);
            Assert.assertEquals(margin.intent().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(margin.left().value().intValue(), 0);
            Assert.assertEquals(margin.left().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(margin.right().value().intValue(), 0);
            Assert.assertEquals(margin.right().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(margin.prev().value().intValue(), 0);
            Assert.assertEquals(margin.prev().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(margin.next().value().intValue(), 0);
            Assert.assertEquals(margin.next().unit(), ValueUnit2.HWPUNIT);
            Assert.assertEquals(caseObject.getChild(1)._objectType(), ObjectType.hh_lineSpacing);
            LineSpacing lineSpacing = (LineSpacing) caseObject.getChild(1);
            Assert.assertEquals(lineSpacing.type(), LineSpacingType.PERCENT);
            Assert.assertEquals(lineSpacing.value().intValue(), 130);
            Assert.assertEquals(lineSpacing.unit(), ValueUnit2.HWPUNIT);
        }

        {
            Default defaultObject = switchObject.defaultObject();
            Assert.assertEquals(defaultObject.countOfChild(), 2);
            Assert.assertEquals(defaultObject.getChild(0)._objectType(), ObjectType.hh_margin);
            ParaMargin margin = (ParaMargin) defaultObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(margin.intent().value().intValue(), 0);
            Assert.assertEquals(margin.intent().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(margin.left().value().intValue(), 0);
            Assert.assertEquals(margin.left().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(margin.right().value().intValue(), 0);
            Assert.assertEquals(margin.right().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(margin.prev().value().intValue(), 0);
            Assert.assertEquals(margin.prev().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(margin.next().value().intValue(), 0);
            Assert.assertEquals(margin.next().unit(), ValueUnit2.HWPUNIT);
            Assert.assertEquals(defaultObject.getChild(1)._objectType(), ObjectType.hh_lineSpacing);
            LineSpacing lineSpacing = (LineSpacing) defaultObject.getChild(1);
            Assert.assertEquals(lineSpacing.type(), LineSpacingType.PERCENT);
            Assert.assertEquals(lineSpacing.value().intValue(), 130);
            Assert.assertEquals(lineSpacing.unit(), ValueUnit2.HWPUNIT);
        }
    }

    private static void paraPr16(ParaPr paraPr) {
        Assert.assertEquals(paraPr.id(), "15");
        Assert.assertEquals(paraPr.tabPrIDRef(), "0");
        Assert.assertEquals(paraPr.condense().intValue(), 0);
        Assert.assertEquals(paraPr.fontLineHeight().booleanValue(), false);
        Assert.assertEquals(paraPr.snapToGrid().booleanValue(), true);
        Assert.assertEquals(paraPr.suppressLineNumbers().booleanValue(), false);
        Assert.assertEquals(paraPr.checked().booleanValue(), false);

        Align align = paraPr.align();
        Assert.assertEquals(align.horizontal(), HorizontalAlign2.LEFT);
        Assert.assertEquals(align.vertical(), VerticalAlign1.BASELINE);

        Heading heading = paraPr.heading();
        Assert.assertEquals(heading.type(), ParaHeadingType.NONE);
        Assert.assertEquals("0", heading.idRef());
        Assert.assertEquals(0, heading.level().intValue());

        BreakSetting breakSetting = paraPr.breakSetting();
        Assert.assertEquals(LineBreakForLatin.KEEP_WORD, breakSetting.breakLatinWord());
        Assert.assertEquals(LineBreakForNonLatin.BREAK_WORD, breakSetting.breakNonLatinWord());
        Assert.assertEquals(breakSetting.widowOrphan().booleanValue(), true);
        Assert.assertEquals(breakSetting.keepWithNext().booleanValue(), false);
        Assert.assertEquals(breakSetting.keepLines().booleanValue(), false);
        Assert.assertEquals(breakSetting.pageBreakBefore().booleanValue(), false);
        Assert.assertEquals(breakSetting.lineWrap(), LineWrap.BREAK);

        AutoSpacing autoSpacing = paraPr.autoSpacing();
        Assert.assertEquals(autoSpacing.eAsianEng().booleanValue(), true);
        Assert.assertEquals(autoSpacing.eAsianNum().booleanValue(), true);

        ParaBorder border = paraPr.border();
        Assert.assertEquals(border.borderFillIDRef(), "2");
        Assert.assertEquals(border.offsetLeft().intValue(), 0);
        Assert.assertEquals(border.offsetRight().intValue(), 0);
        Assert.assertEquals(border.offsetTop().intValue(), 0);
        Assert.assertEquals(border.offsetBottom().intValue(), 0);
        Assert.assertEquals(border.connect().booleanValue(), false);
        Assert.assertEquals(border.ignoreMargin().booleanValue(), false);

        Switch switchObject = paraPr.switchList().get(0);
        Assert.assertEquals(1, switchObject.countOfCaseObject());
        {
            Case caseObject = switchObject.getCaseObject(0);
            Assert.assertEquals(caseObject.requiredNamespace(), "http://www.hancom.co.kr/hwpml/2016/HwpUnitChar");
            Assert.assertEquals(caseObject.countOfChild(), 2);
            Assert.assertEquals(caseObject.getChild(0)._objectType(), ObjectType.hh_margin);
            ParaMargin margin = (ParaMargin) caseObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(margin.intent().value().intValue(), 0);
            Assert.assertEquals(margin.intent().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(margin.left().value().intValue(), 2200);
            Assert.assertEquals(margin.left().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(margin.right().value().intValue(), 0);
            Assert.assertEquals(margin.right().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(margin.prev().value().intValue(), 0);
            Assert.assertEquals(margin.prev().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(margin.next().value().intValue(), 700);
            Assert.assertEquals(margin.next().unit(), ValueUnit2.HWPUNIT);
            Assert.assertEquals(caseObject.getChild(1)._objectType(), ObjectType.hh_lineSpacing);
            LineSpacing lineSpacing = (LineSpacing) caseObject.getChild(1);
            Assert.assertEquals(lineSpacing.type(), LineSpacingType.PERCENT);
            Assert.assertEquals(lineSpacing.value().intValue(), 160);
            Assert.assertEquals(lineSpacing.unit(), ValueUnit2.HWPUNIT);
        }

        {
            Default defaultObject = switchObject.defaultObject();
            Assert.assertEquals(defaultObject.countOfChild(), 2);
            Assert.assertEquals(defaultObject.getChild(0)._objectType(), ObjectType.hh_margin);
            ParaMargin margin = (ParaMargin) defaultObject.getChild(0);
            Assert.assertNotNull(margin.intent());
            Assert.assertEquals(margin.intent().value().intValue(), 0);
            Assert.assertEquals(margin.intent().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.left());
            Assert.assertEquals(margin.left().value().intValue(), 4400);
            Assert.assertEquals(margin.left().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.right());
            Assert.assertEquals(margin.right().value().intValue(), 0);
            Assert.assertEquals(margin.right().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.prev());
            Assert.assertEquals(margin.prev().value().intValue(), 0);
            Assert.assertEquals(margin.prev().unit(), ValueUnit2.HWPUNIT);
            Assert.assertNotNull(margin.next());
            Assert.assertEquals(margin.next().value().intValue(), 1400);
            Assert.assertEquals(margin.next().unit(), ValueUnit2.HWPUNIT);
            Assert.assertEquals(defaultObject.getChild(1)._objectType(), ObjectType.hh_lineSpacing);
            LineSpacing lineSpacing = (LineSpacing) defaultObject.getChild(1);
            Assert.assertEquals(lineSpacing.type(), LineSpacingType.PERCENT);
            Assert.assertEquals(lineSpacing.value().intValue(), 160);
            Assert.assertEquals(lineSpacing.unit(), ValueUnit2.HWPUNIT);
        }
    }

    private void styles(ObjectList<Style> styles) {
        Assert.assertEquals(styles.count(), 18);
        {
            Style style = styles.get(2);
            Assert.assertEquals(style.id(), "2");
            Assert.assertEquals(style.type(), StyleType.PARA);
            Assert.assertEquals(style.name(), "개요 1");
            Assert.assertEquals(style.engName(), "Outline 1");
            Assert.assertEquals(style.paraPrIDRef(), "10");
            Assert.assertEquals(style.charPrIDRef(), "0");
            Assert.assertEquals(style.nextStyleIDRef(), "2");
            Assert.assertEquals(style.langID(), "1042");
            Assert.assertEquals(style.lockForm().booleanValue(), false);
        }
        {
            Style style = styles.get(9);
            Assert.assertEquals(style.id(), "9");
            Assert.assertEquals(style.type(), StyleType.CHAR);
            Assert.assertEquals(style.name(), "쪽 번호");
            Assert.assertEquals(style.engName(), "Page Number");
            Assert.assertEquals(style.paraPrIDRef(), "0");
            Assert.assertEquals(style.charPrIDRef(), "1");
            Assert.assertEquals(style.nextStyleIDRef(), "0");
            Assert.assertEquals(style.langID(), "1042");
            Assert.assertEquals(style.lockForm().booleanValue(), false);
        }
    }

    private void trackChanges(ObjectList<TrackChange> trackChanges) {
        Assert.assertEquals(trackChanges.count(), 2);
        TrackChange trackChange = trackChanges.get(0);
        Assert.assertEquals(trackChange.id(), "1");
        Assert.assertEquals(trackChange.type(), TrackChangeType.Insert);
        Assert.assertEquals(trackChange.date(), "2022-11-22T07:02:00Z");
        Assert.assertEquals(trackChange.authorID(), "1");
        Assert.assertEquals(trackChange.hide().booleanValue(), false);
    }

    private void trackChangeAuthors(ObjectList<TrackChangeAuthor> trackChangeAuthors) {
        Assert.assertEquals(trackChangeAuthors.count(), 1);
        TrackChangeAuthor trackChangeAuthor = trackChangeAuthors.get(0);
        Assert.assertEquals(trackChangeAuthor.name(), "fff");
        Assert.assertEquals(trackChangeAuthor.mark().booleanValue(), true);
        Assert.assertEquals(trackChangeAuthor.id(), "0");
    }

    private void compatibleDocument(CompatibleDocument compatibleDocument) {
        Assert.assertEquals(compatibleDocument.targetProgram(), TargetProgramSort.HWP201X);
        Assert.assertNotNull(compatibleDocument.layoutCompatibility());
        Assert.assertEquals(compatibleDocument.layoutCompatibility().count(), 0);
    }

    private void docOption(DocOption docOption) {
        Assert.assertNotNull(docOption.linkinfo());
        LinkInfo linkInfo = docOption.linkinfo();
        Assert.assertEquals(linkInfo.path(), "");
        Assert.assertEquals(linkInfo.pageInherit().booleanValue(), false);
        Assert.assertEquals(linkInfo.footnoteInherit().booleanValue(), false);
    }

    private void trackChangeConfig(TrackChangeConfig trackChangeConfig) {
        Assert.assertEquals(trackChangeConfig.flags().intValue(), 57);
    }
}
