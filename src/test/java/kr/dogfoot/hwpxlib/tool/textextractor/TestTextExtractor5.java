package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import org.junit.Assert;
import org.junit.Test;

public class TestTextExtractor5 {
    @Test
    public void test() throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath("testFile/tool/textextractor/ParaHead.hwpx");
        String result = TextExtractor.extract(hwpxFile,
                TextExtractMethod.AppendControlTextAfterParagraphText,
                true,
                new TextMarks()
                        .lineBreakAnd("\n")
                        .paraSeparatorAnd("\n"));

        String expected = "\uF06C 글머리1-1\n" +
                "\uF06C 글머리1-2\n" +
                "\n" +
                "\n" +
                "\uF06E 글머리2-1\n" +
                "\uF06E 글머리2-2\n" +
                "1. \n" +
                "1. 번호1\n" +
                "2. 번호2\n" +
                "3. 번호3\n" +
                "3.1. 번호3-1\n" +
                "3.2. 번호3-2\n" +
                "4. 번호4\n" +
                "4.1.1.1. 번호-4-1-1-1\n" +
                "4.1.1.2. 번호-4-1-1-2\n" +
                "4.1.2. 번호-4-1-2\n" +
                "4.1.2.1. 번호-4-1-2-1\n" +
                "\n" +
                "1. 개요1\n" +
                "가. 개요1-1\n" +
                "나. 개요1-2\n" +
                "다. 개요1-3\n" +
                "2. 개요2\n" +
                "가. 개요2-1\n" +
                "1) 개요2-1-1\n";

        Assert.assertEquals(expected, result);
    }
}
