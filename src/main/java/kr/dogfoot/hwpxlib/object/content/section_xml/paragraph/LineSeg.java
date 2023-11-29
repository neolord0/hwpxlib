package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 줄 나눔 정보
 */
public class LineSeg extends HWPXObject {
    private Integer textpos;
    private Integer vertpos;
    private Integer vertsize;
    private Integer textheight;
    private Integer baseline;
    private Integer spacing;
    private Integer horzpos;
    private Integer horzsize;
    private Integer flags;

    public LineSeg() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_lineseg;
    }

    public Integer textpos() {
        return textpos;
    }

    public void textpos(Integer textpos) {
        this.textpos = textpos;
    }

    public LineSeg textposAnd(Integer textpos) {
        this.textpos = textpos;
        return this;
    }

    public Integer vertpos() {
        return vertpos;
    }

    public void vertpos(Integer vertpos) {
        this.vertpos = vertpos;
    }

    public LineSeg vertposAnd(Integer vertpos) {
        this.vertpos = vertpos;
        return this;
    }

    public Integer vertsize() {
        return vertsize;
    }

    public void vertsize(Integer vertsize) {
        this.vertsize = vertsize;
    }

    public LineSeg vertsizeAnd(Integer vertsize) {
        this.vertsize = vertsize;
        return this;
    }

    public Integer textheight() {
        return textheight;
    }

    public void textheight(Integer textheight) {
        this.textheight = textheight;
    }

    public LineSeg textheightAnd(Integer textheight) {
        this.textheight = textheight;
        return this;
    }

    public Integer baseline() {
        return baseline;
    }

    public void baseline(Integer baseline) {
        this.baseline = baseline;
    }

    public LineSeg baselineAnd(Integer baseline) {
        this.baseline = baseline;
        return this;
    }

    public Integer spacing() {
        return spacing;
    }

    public void spacing(Integer spacing) {
        this.spacing = spacing;
    }

    public LineSeg spacingAnd(Integer spacing) {
        this.spacing = spacing;
        return this;
    }

    public Integer horzpos() {
        return horzpos;
    }

    public void horzpos(Integer horzpos) {
        this.horzpos = horzpos;
    }

    public LineSeg horzposAnd(Integer horzpos) {
        this.horzpos = horzpos;
        return this;
    }

    public Integer horzsize() {
        return horzsize;
    }

    public void horzsize(Integer horzsize) {
        this.horzsize = horzsize;
    }

    public LineSeg horzsizeAnd(Integer horzsize) {
        this.horzsize = horzsize;
        return this;
    }

    public Integer flags() {
        return flags;
    }

    public void flags(Integer flags) {
        this.flags = flags;
    }

    public LineSeg flagsAnd(Integer flags) {
        this.flags = flags;
        return this;
    }

    @Override
    public LineSeg clone() {
        LineSeg cloned = new LineSeg();
        cloned.copyFrom(this);
        return cloned;
    }

    private void copyFrom(LineSeg from) {
        this.textpos = from.textpos;
        this.vertpos = from.vertpos;
        this.vertsize = from.vertsize;
        this.textheight = from.textheight;
        this.baseline = from.baseline;
        this.spacing = from.spacing;
        this.horzpos = from.horzpos;
        this.horzsize = from.horzsize;
        this.flags = from.flags;
    }
}
