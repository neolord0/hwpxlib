package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum DrawingShadowType {
    NONE("NONE"),
    SCALE_NARROW("SCALE_NARROW"),
    SCALE_ENLARGE("SCALE_ENLARGE"),
    PARELLEL_LEFTTOP("PARELLEL_LEFTTOP"),
    PARELLEL_RIGHTTOP("PARELLEL_RIGHTTOP"),
    PARELLEL_LEFTBOTTOM("PARELLEL_LEFTBOTTOM"),
    PARELLEL_RIGHTBOTTOM("PARELLEL_RIGHTBOTTOM"),
    SHEAR_LEFTTOP("SHEAR_LEFTTOP"),
    SHEAR_RIGHTTOP("SHEAR_RIGHTTOP"),
    SHEAR_LEFTBOTTOM("SHEAR_LEFTBOTTOM"),
    SHEAR_RIGHTBOTTOM("SHEAR_RIGHTBOTTOM");

    private String str;

    DrawingShadowType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static DrawingShadowType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (DrawingShadowType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
