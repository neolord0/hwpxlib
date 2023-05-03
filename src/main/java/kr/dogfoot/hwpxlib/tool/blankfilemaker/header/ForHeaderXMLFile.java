package kr.dogfoot.hwpxlib.tool.blankfilemaker.header;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.*;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.NumberType1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetProgramSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;

public class ForHeaderXMLFile {
    public static void make(HeaderXMLFile headerXMLFile) {
        headerXMLFile
                .versionAnd("1.4")
                .secCnt((short) 1);

        headerXMLFile.createBeginNum();
        beginNum(headerXMLFile.beginNum());

        headerXMLFile.createRefList();
        refList(headerXMLFile.refList());

        headerXMLFile.createCompatibleDocument();
        compatibleDocument(headerXMLFile.compatibleDocument());

        headerXMLFile.createDocOption();
        docOption(headerXMLFile.docOption());

        headerXMLFile.createTrackChangeConfig();
        trackChangeConfig(headerXMLFile.trackChangeConfig());
    }


    private static void beginNum(BeginNum beginNum) {
        beginNum
                .pageAnd(1)
                .footnoteAnd(1)
                .endnoteAnd(1)
                .picAnd(1)
                .tblAnd(1)
                .equation(1);
    }

    private static void refList(RefList refList) {
        refList.createFontfaces();
        ForFontfaces.make(refList.fontfaces());

        refList.createBorderFills();
        ForBorderFills.make(refList.borderFills());

        refList.createCharProperties();
        ForCharProperties.make(refList.charProperties());

        refList.createTabProperties();
        tabProperties(refList.tabProperties());

        refList.createNumberings();
        numberings(refList.numberings());

        refList.createParaProperties();
        ForParaProperties.make(refList.paraProperties());

        refList.createStyles();
        ForStyles.make(refList.styles());
    }

    private static void tabProperties(ObjectList<TabPr> tabProperties) {
        tabProperties.addNew()
                .idAnd("0")
                .autoTabLeftAnd(false)
                .autoTabRight(false);

        tabProperties.addNew()
                .idAnd("1")
                .autoTabLeftAnd(true)
                .autoTabRight(false);
    }


    private static void numberings(ObjectList<Numbering> numberings) {
        Numbering numbering = numberings.addNew()
                .idAnd("1")
                .startAnd(0);

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 1)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.DIGIT)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(false)
                .text("^1.");

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 2)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.HANGUL_SYLLABLE)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(false)
                .text("^2.");

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 3)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.DIGIT)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(false)
                .text("^3)");

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 4)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.HANGUL_SYLLABLE)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(false)
                .text("^4)");

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 5)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.DIGIT)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(false)
                .text("(^5)");

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 6)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.HANGUL_SYLLABLE)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(false)
                .text("(^6)");

        numbering.addNewParaHead()
                .startAnd(1)
                .levelAnd((byte) 7)
                .alignAnd(HorizontalAlign1.LEFT)
                .useInstWidthAnd(true)
                .autoIndentAnd(true)
                .widthAdjustAnd(0)
                .textOffsetTypeAnd(ValueUnit1.PERCENT)
                .textOffsetAnd(50)
                .numFormatAnd(NumberType1.CIRCLED_DIGIT)
                .charPrIDRefAnd("4294967295")
                .checkableAnd(true)
                .text("^7");
    }

    private static void compatibleDocument(CompatibleDocument compatibleDocument) {
        compatibleDocument.targetProgram(TargetProgramSort.HWP201X);

        compatibleDocument.createLayoutCompatibility();
    }

    private static void docOption(DocOption docOption) {
        docOption.createLinkinfo();
        docOption.linkinfo()
                .pathAnd("")
                .pageInheritAnd(false)
                .footnoteInherit(false);
    }

    private static void trackChangeConfig(TrackChangeConfig trackChangeConfig) {
        trackChangeConfig.flags(56);
    }
}
