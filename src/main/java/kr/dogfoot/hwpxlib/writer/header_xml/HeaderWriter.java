package kr.dogfoot.hwpxlib.writer.header_xml;

import kr.dogfoot.hwpxlib.commonstirngs.DefaultValues;
import kr.dogfoot.hwpxlib.commonstirngs.MineTypes;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.content.header_xml.HeaderXMLFile;
import kr.dogfoot.hwpxlib.writer.util.NamespaceSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class HeaderWriter {
    public static void write(HeaderXMLFile headerXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hh_head)
                .namespace(NamespaceSort.ha)
                .namespace(NamespaceSort.hp)
                .namespace(NamespaceSort.hp10)
                .namespace(NamespaceSort.hs)
                .namespace(NamespaceSort.hc)
                .namespace(NamespaceSort.hh)
                .namespace(NamespaceSort.hhs)
                .namespace(NamespaceSort.hm)
                .namespace(NamespaceSort.hpf)
                .namespace(NamespaceSort.dc)
                .namespace(NamespaceSort.opf)
                .namespace(NamespaceSort.ooxmlchart)
                .namespace(NamespaceSort.hwpunitchar)
                .namespace(NamespaceSort.epub)
                .namespace(NamespaceSort.config)
                .attribute(AttributeNames.version, DefaultValues.XMLVersion)
                .attribute(AttributeNames.secCnt, headerXMLFile.secCnt());

        xsb.closeElement();
    }
}
