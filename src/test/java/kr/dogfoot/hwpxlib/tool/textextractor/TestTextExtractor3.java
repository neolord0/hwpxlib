package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class TestTextExtractor3 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/RectInRect.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.AppendControlTextAfterParagraphText,
                null,
                false,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .paraSeparatorAnd("\n")
                        .rectangleStartAnd("\n<사각형>\n")
                        .rectangleEndAnd("\n</사각형>"));

        String expected = "\n" +
                "<사각형>\n" +
                "사각형 안에 텍스트입니다.\n" +
                "<사각형>\n" +
                "사각형 안에 사각형의 텍스트입니다.\n" +
                "</사각형>\n" +
                "</사각형>";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void test2() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/RectInRect.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.InsertControlTextBetweenParagraphText,
                null,
                false,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .rectangleStartAnd("<사각형>")
                        .rectangleEndAnd("</사각형>"));
        String expected = "<사각형>사각형 안에<사각형>사각형 안에 사각형의 텍스트입니다.</사각형> 텍스트입니다.</사각형>";

        Assert.assertEquals(expected, result);
    }
}
