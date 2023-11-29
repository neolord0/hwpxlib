package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 언어별 값
 *
 * @param <ValueType> 값의 타입
 */
public class ValuesByLanguage<ValueType> extends HWPXObject {
    private final ObjectType _objectType;

    /**
     * 한글을 위한 값
     */
    private ValueType hangul;
    /**
     * 영문자를 위한 값
     */
    private ValueType latin;
    /**
     * 한자를 위한 값
     */
    private ValueType hanja;
    /**
     * 일본어를 위한 값
     */
    private ValueType japanese;
    /**
     * 기타 문자를 위한 값
     */
    private ValueType other;
    /**
     * 특수 문자를 위한 값
     */
    private ValueType symbol;
    /**
     * 사용자 정의 문자를 위한 값
     */
    private ValueType user;

    public ValuesByLanguage(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public ValueType hangul() {
        return hangul;
    }

    public void hangul(ValueType hangul) {
        this.hangul = hangul;
    }

    public ValuesByLanguage<ValueType> hangulAnd(ValueType hangul) {
        this.hangul = hangul;
        return this;
    }

    public ValueType latin() {
        return latin;
    }

    public void latin(ValueType latin) {
        this.latin = latin;
    }

    public ValuesByLanguage<ValueType> latinAnd(ValueType latin) {
        this.latin = latin;
        return this;
    }

    public ValueType hanja() {
        return hanja;
    }

    public void hanja(ValueType hanja) {
        this.hanja = hanja;
    }

    public ValuesByLanguage<ValueType> hanjaAnd(ValueType hanja) {
        this.hanja = hanja;
        return this;
    }

    public ValueType japanese() {
        return japanese;
    }

    public void japanese(ValueType japanese) {
        this.japanese = japanese;
    }

    public ValuesByLanguage<ValueType> japaneseAnd(ValueType japanese) {
        this.japanese = japanese;
        return this;
    }

    public ValueType other() {
        return other;
    }

    public void other(ValueType other) {
        this.other = other;
    }

    public ValuesByLanguage<ValueType> otherAnd(ValueType other) {
        this.other = other;
        return this;
    }

    public ValueType symbol() {
        return symbol;
    }

    public void symbol(ValueType symbol) {
        this.symbol = symbol;
    }

    public ValuesByLanguage<ValueType> symbolAnd(ValueType symbol) {
        this.symbol = symbol;
        return this;
    }

    public ValueType user() {
        return user;
    }

    public void user(ValueType user) {
        this.user = user;
    }

    public ValuesByLanguage<ValueType> userAnd(ValueType user) {
        this.user = user;
        return this;
    }

    public void set(ValueType hangul, ValueType latin, ValueType hanja, ValueType japanese, ValueType other, ValueType symbol, ValueType user) {
        this.hangul = hangul;
        this.latin = latin;
        this.hanja = hanja;
        this.japanese = japanese;
        this.other = other;
        this.symbol = symbol;
        this.user = user;
    }

    @Override
    public ValuesByLanguage<ValueType> clone() {
        ValuesByLanguage<ValueType> cloned = new ValuesByLanguage<ValueType>(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ValuesByLanguage<ValueType> from) {
        this.hangul = from.hangul;
        this.latin = from.latin;
        this.hanja = from.hanja;
        this.japanese = from.japanese;
        this.other = from.other;
        this.symbol = from.symbol;
        this.user = from.user;
    }
}
