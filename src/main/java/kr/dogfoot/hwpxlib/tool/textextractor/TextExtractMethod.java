package kr.dogfoot.hwpxlib.tool.textextractor;

public enum TextExtractMethod {
    /**
     * 컨트롤의 텍스트를 문단 텍스트 사이에 삽입하여 추출함
     */
    InsertControlTextBetweenParagraphText,
    /**
     * 컨트롤의 텍스트를 문단 텍스트 뒤에 추가하여 추출함
     */
    AppendControlTextAfterParagraphText
}
