package kr.dogfoot.hwpxlib.writer.manifest_xml;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.commonstirngs.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.metainf.FileEntry;
import kr.dogfoot.hwpxlib.object.metainf.ManifestXMLFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ManifestWriter extends ElementWriter {
    public ManifestWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Manifest;
    }

    @Override
    public void write(HWPXObject object) {
        ManifestXMLFile manifestXMLFile = (ManifestXMLFile) object;
        switchObject(manifestXMLFile.switchObject());

        xsb()
                .clear()
                .openElement(ElementNames.odf_manifest)
                .elementWriter(this)
                .namespace(Namespaces.odf);

        for (FileEntry fileEntry : manifestXMLFile.fileEntries()) {
            writeChild(ElementWriterSort.FileEntry, fileEntry);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case odf_file_entry:
                writeChild(ElementWriterSort.FileEntry, child);
                break;
        }
    }
}
