package kr.dogfoot.hwpxlib.writer.util;

public enum NamespaceSort {
    hv("http://www.hancom.co.kr/hwpml/2011/version"),
    odf("urn:oasis:names:tc:opendocument:xmlns:manifest:1.0"),
    ocf("urn:oasis:names:tc:opendocument:xmlns:container"),
    hpf("http://www.hancom.co.kr/schema/2011/hpf"),
    ha("http://www.hancom.co.kr/hwpml/2011/app"),
    hp("http://www.hancom.co.kr/hwpml/2011/paragraph"),
    hp10("http://www.hancom.co.kr/hwpml/2016/paragraph"),
    hs("http://www.hancom.co.kr/hwpml/2011/section"),
    hc("http://www.hancom.co.kr/hwpml/2011/core"),
    hh("http://www.hancom.co.kr/hwpml/2011/head"),
    hhs("http://www.hancom.co.kr/hwpml/2011/history"),
    hm("http://www.hancom.co.kr/hwpml/2011/master-page"),
    dc("http://purl.org/dc/elements/1.1/"),
    opf("http://www.idpf.org/2007/opf/"),
    ooxmlchart("http://www.hancom.co.kr/hwpml/2016/ooxmlchart"),
    hwpunitchar("http://www.hancom.co.kr/hwpml/2016/HwpUnitChar"),
    epub("http://www.idpf.org/2007/ops"),
    config("urn:oasis:names:tc:opendocument:xmlns:config:1.0"),


    ;



    private String value;

    NamespaceSort(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
