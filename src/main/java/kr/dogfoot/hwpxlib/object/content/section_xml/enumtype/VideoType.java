package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum VideoType implements EnumGetStr {
    /**
     * 컴퓨터의 동영상
     */
    LOCAL("Local"),
    /**
     * 인터넷 동영상
     */
    WEB("Web");

    private String str;

    VideoType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static VideoType fromString(String str) {
        if (str != null) {
             for (VideoType item : values()) {
                if (item.str.equals(str)) {
                    return item;
                }
            }
        }
        return null;
    }
}
