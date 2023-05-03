package kr.dogfoot.hwpxlib.tool.blankfilemaker.header;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.StyleType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Style;

public class ForStyles {
    public static void make(ObjectList<Style> styles) {
        styles.addNew()
                .idAnd("0")
                .typeAnd(StyleType.PARA)
                .nameAnd("바탕글")
                .engNameAnd("Normal")
                .paraPrIDRefAnd("3")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("0")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("1")
                .typeAnd(StyleType.PARA)
                .nameAnd("본문")
                .engNameAnd("Body")
                .paraPrIDRefAnd("11")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("1")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("2")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 1")
                .engNameAnd("Outline 1")
                .paraPrIDRefAnd("10")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("2")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("3")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 2")
                .engNameAnd("Outline 2")
                .paraPrIDRefAnd("9")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("3")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("4")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 3")
                .engNameAnd("Outline 3")
                .paraPrIDRefAnd("8")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("4")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("5")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 4")
                .engNameAnd("Outline 4")
                .paraPrIDRefAnd("7")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("5")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("6")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 5")
                .engNameAnd("Outline 5")
                .paraPrIDRefAnd("6")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("6")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("7")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 6")
                .engNameAnd("Outline 6")
                .paraPrIDRefAnd("5")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("7")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("8")
                .typeAnd(StyleType.PARA)
                .nameAnd("개요 7")
                .engNameAnd("Outline 7")
                .paraPrIDRefAnd("4")
                .charPrIDRefAnd("0")
                .nextStyleIDRefAnd("8")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("9")
                .typeAnd(StyleType.CHAR)
                .nameAnd("쪽 번호")
                .engNameAnd("Page Number")
                .paraPrIDRefAnd("6750318")
                .charPrIDRefAnd("1")
                .nextStyleIDRefAnd("0")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("10")
                .typeAnd(StyleType.PARA)
                .nameAnd("머리말")
                .engNameAnd("Header")
                .paraPrIDRefAnd("2")
                .charPrIDRefAnd("2")
                .nextStyleIDRefAnd("10")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("11")
                .typeAnd(StyleType.PARA)
                .nameAnd("각주")
                .engNameAnd("Footnote")
                .paraPrIDRefAnd("1")
                .charPrIDRefAnd("3")
                .nextStyleIDRefAnd("11")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("12")
                .typeAnd(StyleType.PARA)
                .nameAnd("미주")
                .engNameAnd("Endnote")
                .paraPrIDRefAnd("1")
                .charPrIDRefAnd("3")
                .nextStyleIDRefAnd("12")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("13")
                .typeAnd(StyleType.PARA)
                .nameAnd("메모")
                .engNameAnd("Memo")
                .paraPrIDRefAnd("0")
                .charPrIDRefAnd("4")
                .nextStyleIDRefAnd("13")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("14")
                .typeAnd(StyleType.PARA)
                .nameAnd("차례 제목")
                .engNameAnd("TOC Heading")
                .paraPrIDRefAnd("12")
                .charPrIDRefAnd("5")
                .nextStyleIDRefAnd("14")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("15")
                .typeAnd(StyleType.PARA)
                .nameAnd("차례 1")
                .engNameAnd("TOC 1")
                .paraPrIDRefAnd("13")
                .charPrIDRefAnd("6")
                .nextStyleIDRefAnd("15")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("16")
                .typeAnd(StyleType.PARA)
                .nameAnd("차례 2")
                .engNameAnd("TOC 2")
                .paraPrIDRefAnd("14")
                .charPrIDRefAnd("6")
                .nextStyleIDRefAnd("16")
                .langIDAnd("1042")
                .lockForm(false);

        styles.addNew()
                .idAnd("17")
                .typeAnd(StyleType.PARA)
                .nameAnd("차례 3")
                .engNameAnd("TOC 3")
                .paraPrIDRefAnd("15")
                .charPrIDRefAnd("6")
                .nextStyleIDRefAnd("17")
                .langIDAnd("1042")
                .lockForm(false);
    }
}
