package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.reader.common.XMLFileReader;
import org.xml.sax.Attributes;

public class AllElementReader {
    public static HWPXObject read(ObjectType filePartDiffType, String name, Attributes attrs, XMLFileReader xmlFileReader) {
        if (filePartDiffType == ObjectType.hhs_packageDiff) {
            readForPackage(name, attrs, xmlFileReader);
        } else if (filePartDiffType == ObjectType.hhs_headDiff) {
            readForHead(name, attrs, xmlFileReader);
        } else if (filePartDiffType == ObjectType.hhs_bodyDiff) {
            readForBody(name, attrs, xmlFileReader);
        }
        return null;
    }

    private static void readForPackage(String name, Attributes attrs, XMLFileReader xmlFileReader) {
    }

    private static void readForHead(String name, Attributes attrs, XMLFileReader xmlFileReader) {
    }

    private static void readForBody(String name, Attributes attrs, XMLFileReader xmlFileReader) {
    }
}
