package kr.dogfoot.hwpxlib.writer.manifest_xml;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.metainf.FileEntry;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FileEntryWriter extends ElementWriter {
    public FileEntryWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FileEntry;
    }

    @Override
    public void write(HWPXObject object) {
        FileEntry fileEntry = (FileEntry) object;
        storeSwitchObject(fileEntry.switchObject());

        xsb()
                .openElement(ElementNames.odf_file_entry)
                .elementWriter(this)
                .attribute(AttributeNames.full_path, fileEntry.fullPath())
                .attribute(AttributeNames.media_type, fileEntry.mediaType())
                .attribute(AttributeNames.size, fileEntry.size());

        if (fileEntry.encryptionData() != null) {
            writeChild(ElementWriterSort.EncryptionData, fileEntry.encryptionData());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case odf_encryption_data:
                writeChild(ElementWriterSort.EncryptionData, child);
                break;
        }
    }
}
