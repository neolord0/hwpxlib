package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineBreakForLatin;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineBreakForNonLatin;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWrap;

/**
 * 줄나눔 설정
 */
public class BreakSetting extends HWPXObject {
    /**
     * 줄 나눔 기준 영어
     */
    private LineBreakForLatin breakLatinWord;
    /**
     * 줄 나눔 기준 비-영어
     */
    private LineBreakForNonLatin breakNonLatinWord;
    /**
     * 외툴이줄 보호 여부
     */
    private Boolean widowOrphan;
    /**
     * 다음 문단과 함꼐 여부
     */
    private Boolean keepWithNext;
    /**
     * 문단 보호 여부
     */
    private Boolean keepLines;
    /**
     * 문단 앞에서 항상 쪽 나눔 여부
     */
    private Boolean pageBreakBefore;
    /**
     * '한 줄로 입력' 사용시 형식
     */
    private LineWrap lineWrap;

    public BreakSetting() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.BreakSetting;
    }

    public LineBreakForLatin breakLatinWord() {
        return breakLatinWord;
    }

    public void breakLatinWord(LineBreakForLatin breakLatinWord) {
        this.breakLatinWord = breakLatinWord;
    }

    public BreakSetting breakLatinWordAnd(LineBreakForLatin breakLatinWord) {
        this.breakLatinWord = breakLatinWord;
        return this;
    }

    public LineBreakForNonLatin breakNonLatinWord() {
        return breakNonLatinWord;
    }

    public void breakNonLatinWord(LineBreakForNonLatin breakNonLatinWord) {
        this.breakNonLatinWord = breakNonLatinWord;
    }

    public BreakSetting breakNonLatinWordAnd(LineBreakForNonLatin breakNonLatinWord) {
        this.breakNonLatinWord = breakNonLatinWord;
        return this;
    }

    public Boolean widowOrphan() {
        return widowOrphan;
    }

    public void widowOrphan(Boolean widowOrphan) {
        this.widowOrphan = widowOrphan;
    }

    public BreakSetting widowOrphanAnd(Boolean widowOrphan) {
        this.widowOrphan = widowOrphan;
        return this;
    }

    public Boolean keepWithNext() {
        return keepWithNext;
    }

    public void keepWithNext(Boolean keepWithNext) {
        this.keepWithNext = keepWithNext;
    }

    public BreakSetting keepWithNextAnd(Boolean keepWithNext) {
        this.keepWithNext = keepWithNext;
        return this;
    }

    public Boolean keepLines() {
        return keepLines;
    }

    public void keepLines(Boolean keepLines) {
        this.keepLines = keepLines;
    }

    public BreakSetting keepLinesAnd(Boolean keepLines) {
        this.keepLines = keepLines;
        return this;
    }

    public Boolean pageBreakBefore() {
        return pageBreakBefore;
    }

    public void pageBreakBefore(Boolean pageBreakBefore) {
        this.pageBreakBefore = pageBreakBefore;
    }

    public BreakSetting pageBreakBeforeAnd(Boolean pageBreakBefore) {
        this.pageBreakBefore = pageBreakBefore;
        return this;
    }

    public LineWrap lineWrap() {
        return lineWrap;
    }

    public void lineWrap(LineWrap lineWrap) {
        this.lineWrap = lineWrap;
    }

    public BreakSetting lineWrapAnd(LineWrap lineWrap) {
        this.lineWrap = lineWrap;
        return this;
    }
}
