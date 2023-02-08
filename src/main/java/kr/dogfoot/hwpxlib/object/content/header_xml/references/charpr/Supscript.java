package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;


import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;

/**
 * 위첨자
 */
public class Supscript extends NoAttributeNoChild<Supscript> {
    public Supscript() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Supscript;
    }
}
