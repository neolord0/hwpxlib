package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class TestTextExtractor2 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/RectInPara.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.AppendControlTextAfterParagraphText,
                null,
                false,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .paraSeparatorAnd("\n")
                        .rectangleStartAnd("\n<사각형>\n")
                        .rectangleEndAnd("\n</사각형>"));

        String expected = "Start. 이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다. End\n" +
                "<사각형>\n" +
                "사각 시각한 사각형입니다. \n" +
                "오각형이 아니에요\n" +
                "</사각형>\n" +
                "<사각형>\n" +
                "2번째 사각형\n" +
                "</사각형>";

        Assert.assertEquals(expected, result);
    }

    @Test
    public void test2() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/RectInPara.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.InsertControlTextBetweenParagraphText,
                null,
                false,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .rectangleStartAnd("<사각형>")
                        .rectangleEndAnd("</사각형>"));

        String expected =
                "Start. 이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.<사각형>사각 시각한 사각형입니다. 오각형이 아니에요</사각형>이것은 본문 텍스트입니다.이것은 본문 텍스트입니다.<사각형>2번째 사각형</사각형>이것은 본문 텍스트입니다. End";

        Assert.assertEquals(expected, result);
    }
}
