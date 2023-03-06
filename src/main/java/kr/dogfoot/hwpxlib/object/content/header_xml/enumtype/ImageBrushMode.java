package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ImageBrushMode implements EnumGetStr {
    /**
     * 바둑판식으로-모두
     */
    TILE("TILE"),
    /**
     * 바둑판식으로-가로/위
     */
    TILE_HORZ_TOP("TILE_HORZ_TOP"),
    /**
     * 바둑판식으로-가로/아래
     */
    TILE_HORZ_BOTTOM("TILE_HORZ_BOTTOM"),
    /**
     * 바둑판식으로-세로/왼쪽
     */
    TILE_VERT_LEFT("TILE_VERT_LEFT"),
    /**
     * 바둑판식으로-세로/오른쪽
     */
    TILE_VERT_RIGHT("TILE_VERT_RIGHT"),
    /**
     * 크기에 맞추어
     */
    TOTAL("TOTAL"),
    /**
     * 가운데로
     */
    CENTER("CENTER"),
    /**
     * 가운데 위로
     */
    CENTER_TOP("CENTER_TOP"),
    /**
     * 가운데 아래로
     */
    CENTER_BOTTOM("CENTER_BOTTOM"),
    /**
     * 왼쪽 가운데로
     */
    LEFT_CENTER("LEFT_CENTER"),
    /**
     * 왼쪽 위로
     */
    LEFT_TOP("LEFT_TOP"),
    /**
     * 왼쪽 아래로
     */
    LEFT_BOTTOM("LEFT_BOTTOM"),
    /**
     * 오른쪽 가운데로
     */
    RIGHT_CENTER("RIGHT_CENTER"),
    /**
     * 오른쪽 위로
     */
    RIGHT_TOP("RIGHT_TOP"),
    /**
     * 오른쪽 아래로
     */
    RIGHT_BOTTOM("RIGHT_BOTTOM"),
    /**
     * 원래 크기에 비례하여
     */
    ZOOM("ZOOM");

    private String str;

    ImageBrushMode(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ImageBrushMode fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ImageBrushMode item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
