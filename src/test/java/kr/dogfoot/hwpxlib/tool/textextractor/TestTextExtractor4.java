package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class TestTextExtractor4 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/Table.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.AppendControlTextAfterParagraphText,
                false,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .paraSeparatorAnd("\n")
                        .fieldStartAnd("<필드>")
                        .fieldEndAnd("</필드>")
                        .rectangleStartAnd("<사각형>")
                        .rectangleEndAnd("</사각형>")
                        .tableStartAnd("<표>\n")
                        .tableEndAnd("\n</표>")
                        .tableRowSeparatorAnd("\n")
                        .tableCellSeparatorAnd("; "));

        String expected = "<사각형><필드>C반 기말고사</필드></사각형>\n" +
                "\n" +
                "\n" +
                "<필드>날짜</필드>\n" +
                "\n" +
                "<표>\n" +
                "이름; 국어; 영어; 수학\n" +
                "개똥이; 89; 65; 78\n" +
                "칠득이; 77; 77; 77\n" +
                "팔푼이; 88; 88; 88\n" +
                "육손이; 66; 66; 66\n" +
                "합계; ; ; \n" +
                "</표>\n" +
                "\n";

        Assert.assertEquals(expected, result);
    }
}
