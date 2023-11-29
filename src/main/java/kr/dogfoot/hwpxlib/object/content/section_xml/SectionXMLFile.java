package kr.dogfoot.hwpxlib.object.content.section_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * Section.xml 파일
 */
public class SectionXMLFile extends ParaListCore {
    public SectionXMLFile() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hs_sec;
    }

    public SectionXMLFile clone() {
        SectionXMLFile cloned = new SectionXMLFile();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(SectionXMLFile from) {
        super.copyFrom(from);
    }
}
