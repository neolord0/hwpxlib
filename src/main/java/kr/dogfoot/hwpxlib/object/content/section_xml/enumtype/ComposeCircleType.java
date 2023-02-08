package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 글자 겹칩 테두리 종류
 */
public enum ComposeCircleType {
    CHAR("CHAR"),
    SHAPE_CIRCLE("SHAPE_CIRCLE"),
    SHAPE_REVERSAL_CIRCLE("SHAPE_REVERSAL_CIRCLE"),
    SHAPE_RECTANGLE("SHAPE_RECTANGLE"),
    SHAPE_REVERSAL_RECTANGLE("SHAPE_REVERSAL_RECTANGLE"),
    SHAPE_TRIANGLE("SHAPE_TRIANGLE"),
    SHAPE_REVERSAL_TIRANGLE("SHAPE_REVERSAL_TIRANGLE"),
    SHAPE_LIGHT("SHAPE_LIGHT"),
    SHAPE_RHOMBUS("SHAPE_RHOMBUS"),
    SHAPE_REVERSAL_RHOMBUS("SHAPE_REVERSAL_RHOMBUS"),
    SHAPE_ROUNDED_RECTANGLE("SHAPE_ROUNDED_RECTANGLE"),
    SHAPE_EMPTY_CIRCULATE_TRIANGLE("SHAPE_EMPTY_CIRCULATE_TRIANGLE"),
    SHAPE_THIN_CIRCULATE_TRIANGLE("SHAPE_THIN_CIRCULATE_TRIANGLE"),
    SHAPE_THICK_CIRCULATE_TRIANGLE("SHAPE_THICK_CIRCULATE_TRIANGLE");

    private String str;

    ComposeCircleType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ComposeCircleType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ComposeCircleType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
