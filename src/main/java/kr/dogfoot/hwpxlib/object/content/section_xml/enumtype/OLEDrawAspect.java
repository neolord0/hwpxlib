package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum OLEDrawAspect implements EnumGetStr {
    CONTENT("CONTENT"),
    THUMB_NAIL("THUMB_NAIL"),
    ICON("ICON"),
    DOC_PRINT("DOC_PRINT");

    private String str;

    OLEDrawAspect(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static OLEDrawAspect fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (OLEDrawAspect item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
