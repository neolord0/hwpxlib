package kr.dogfoot.hwpxlib.tool.textextractor.paraHead;


import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Bullet;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Style;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.Heading;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.util.StringUtil;

public class ParaHeadMaker {
    private static final String OutlineStyleEngNamePrefix = "Outline ";
    private HWPXFile hwpxFile;
    private ParaNumber paraNumberForNumbering;
    private ParaNumber paraNumberForOutline;

    public ParaHeadMaker(HWPXFile hwpxFile) {
        this.hwpxFile = hwpxFile;
    }

    public void startSection() {
        paraNumberForOutline = new ParaNumber();
        paraNumberForNumbering = new ParaNumber();
    }

    public void endSection() {
        paraNumberForOutline = null;
        paraNumberForNumbering = null;
    }

    public String make(Para para) {
        ParaPr paraPr = getParaPr(para.paraPrIDRef());
        if (paraPr == null || paraPr.heading() == null) {
            return null;
        }

        return paraHead(paraPr.heading());
    }

    private String paraHead(Heading heading) {
        switch (heading.type()) {
            case NONE:
                return "";
            case OUTLINE:
                return outline(heading.level());
            case NUMBER:
                return numbering(heading.idRef(),
                        heading.level());
            case BULLET:
                return bullet(heading.idRef(),
                        heading.level());
        }
        return null;
    }

    private ParaPr getParaPr(String idRef) {
        for (ParaPr paraPr : hwpxFile.headerXMLFile().refList().paraProperties().items()) {
            if (idRef.equals(paraPr.id())) {
                return paraPr;
            }
        }
        return null;
    }

    private String outline(byte paraLevel) {
        Style style = getStyle(paraLevel);
        if (style == null) {
            return null;
        }

        ParaPr outlineParaPr = getParaPr(style.paraPrIDRef());
        ParaHead paraHead = getParaHead(Integer.parseInt(outlineParaPr.heading().idRef()) + 1, paraLevel);
        if (paraHead != null) {
            if (paraNumberForOutline.changedParaHead(outlineParaPr.heading().idRef())) {
                paraNumberForOutline.reset(outlineParaPr.heading().idRef(), paraLevel, paraHead.start());
            } else {
                paraNumberForOutline.increase(paraLevel);
            }

            return numberText(paraHead, paraNumberForOutline, paraLevel);
        } else {
            return null;
        }
    }

    private Style getStyle(Byte paraLevel) {
        String styleEnglishName = OutlineStyleEngNamePrefix + (paraLevel + 1);
        for (Style style : hwpxFile.headerXMLFile().refList().styles().items()) {
            if (styleEnglishName.equals(style.engName())) {
                return style;
            }
        }
        return null;
    }


    private ParaHead getParaHead(int numberingIDRef, byte paraLevel) {
        Numbering numbering = getNumbering(numberingIDRef);
        if (numbering != null) {
            for (ParaHead paraHead : numbering.paraHeads()) {
                if (paraHead.level() == paraLevel + 1) {
                    return paraHead;
                }
            }
        }
        return null;
    }

    private Numbering getNumbering(int idRef) {
        String numberID = String.valueOf(idRef);
        for (Numbering numbering : hwpxFile.headerXMLFile().refList().numberings().items()) {
            if (numberID.equals(numbering.id())) {
                return numbering;
            }
        }
        return null;
    }

    private String numbering(String paraHeadIDRef, byte paraLevel) {
        ParaHead paraHead = getParaHead(Integer.parseInt(paraHeadIDRef), paraLevel);

        if (paraHead != null) {
            if (paraNumberForNumbering.changedParaHead(paraHeadIDRef)) {
                paraNumberForNumbering.reset(paraHeadIDRef, paraLevel, paraHead.start());
            } else {
                paraNumberForNumbering.increase(paraLevel);
            }
            return numberText(paraHead, paraNumberForNumbering, paraLevel);
        } else {
            return null;
        }
    }

    private String numberText(ParaHead paraHead, ParaNumber paraNumber, int paraLevel) {
        String format = paraHead.text();
        String[] tokens = new String[10];
        String[] values = new String[10];
        for (int level = 0; level <= paraLevel; level++) {
            tokens[level] = "^" + (level + 1);
            values[level] = ParaHeadNumber.toString(paraNumber.value(level), paraHead.numFormat());
        }
        return StringUtil.replaceEach(format, tokens, values);
    }

    private String bullet(String paraHeadId, byte paraLevel) {
        Bullet bullet = getBullet(paraHeadId);
        if (bullet != null) {
            return bullet._char();
        } else {
            return "";
        }
    }

    private Bullet getBullet(String idRef) {
        String bulletID = String.valueOf(Integer.parseInt(idRef));

        for (Bullet bullet : hwpxFile.headerXMLFile().refList().bullets().items()) {
            if (bulletID.equals(bullet.id())){
                return bullet;
            }
        }
        return null;
    }
}
