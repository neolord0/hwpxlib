package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.DefaultValues;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.commonstirngs.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class VersionWriter extends ElementWriter {
    public VersionWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Version;
    }

    @Override
    public void write(HWPXObject object) {
        VersionXMLFile versionXMLFile = (VersionXMLFile) object;
        xsb()
                .clear()
                .openElement(ElementNames.hv_HCFVersion)
                .namespace(Namespaces.hv);
        if (versionXMLFile.targetApplication() != null) {
            xsb().attribute(AttributeNames.tagetApplication, versionXMLFile.targetApplication().str());
        }
        xsb()
                .attribute(AttributeNames.major, versionXMLFile.version().major())
                .attribute(AttributeNames.minor, versionXMLFile.version().minor())
                .attribute(AttributeNames.micro, versionXMLFile.version().micro())
                .attribute(AttributeNames.buildNumber, versionXMLFile.version().buildNumber())
                .attribute(AttributeNames.os, versionXMLFile.os())
                .attribute(AttributeNames.xmlVersion, DefaultValues.XMLVersion)
                .attribute(AttributeNames.application, versionXMLFile.application())
                .attribute(AttributeNames.appVersion, versionXMLFile.appVersion())
                .closeElement();

        releaseMe();
    }
}
