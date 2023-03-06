package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 색상 효과
 */
public enum ColorEffectType implements EnumGetStr {
    ALPHA("ALPHA"),
    ALPHA_MOD("ALPHA_MOD"),
    ALPHA_OFF("ALPHA_OFF"),
    RED("RED"),
    RED_MOD("RED_MOD"),
    RED_OFF("RED_OFF"),
    GREEN("GREEN"),
    GREEN_MOD("GREEN_MOD"),
    GREEN_OFF("GREEN_OFF"),
    BLUE("BLUE"),
    BLUE_MOD("BLUE_MOD"),
    BLUE_OFF("BLUE_OFF"),
    HUE("HUE"),
    HUE_MOD("HUE_MOD"),
    HUE_OFF("HUE_OFF"),
    SAT("SAT"),
    SAT_MOD("SAT_MOD"),
    SAT_OFF("SAT_OFF"),
    LUM("LUM"),
    LUM_MOD("LUM_MOD"),
    LUM_OFF("LUM_OFF"),
    SHADE("SHADE"),
    TINT("TINT"),
    GRAY("GRAY"),
    COMP("COMP"),
    GAMMA("GAMMA"),
    INV_GAMMA("INV_GAMMA"),
    INV("INV");

    private String str;

    ColorEffectType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ColorEffectType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ColorEffectType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}

