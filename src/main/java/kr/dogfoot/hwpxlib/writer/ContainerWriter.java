package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.writer.util.NamespaceSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class ContainerWriter {
    public static void write(ContainerXMLFile containerXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.ocf_container)
                .namespace(NamespaceSort.ocf)
                .namespace(NamespaceSort.hpf);

        if (!containerXMLFile.rootFiles().empty()) {
            xsb.openElement(ElementNames.ocf_rootfiles);
            for (RootFile rootFile : containerXMLFile.rootFiles().items()) {
                rootFile(rootFile, xsb);
            }
            xsb.closeElement();
        }

        xsb.closeElement();
    }

    private static void rootFile(RootFile rootFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.ocf_rootfile)
                .attribute(AttributeNames.full_path, rootFile.fullPath())
                .attribute(AttributeNames.media_type, rootFile.mediaType())
                .closeElement();
    }

}
