package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromCharPr extends FinderBase {
    public FromCharPr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_charPr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        CharPr charPr = (CharPr) from;
        pushPath(charPr);

        check(charPr.fontRef());
        check(charPr.ratio());
        check(charPr.spacing());
        check(charPr.relSz());
        check(charPr.offset());
        check(charPr.italic());
        check(charPr.bold());
        check(charPr.underline());
        check(charPr.strikeout());
        check(charPr.outline());
        check(charPr.shadow());
        check(charPr.emboss());
        check(charPr.engrave());
        check(charPr.supscript());
        check(charPr.subscript());

        checkSwitchList(charPr.switchList());
        popPath();
    }
}
