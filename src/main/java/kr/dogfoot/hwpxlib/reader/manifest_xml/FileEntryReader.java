package kr.dogfoot.hwpxlib.reader.manifest_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionData;
import kr.dogfoot.hwpxlib.object.metainf.FileEntry;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class FileEntryReader extends ElementReader {
    private FileEntry fileEntry;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FileEntry;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.full_path:
                fileEntry.fullPath(value);
                break;
            case AttributeNames.media_type:
                fileEntry.mediaType(value);
                break;
            case AttributeNames.size:
                fileEntry.size(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.odf_encryption_data:
                fileEntry.createEncryptionData();
                encryptionData(fileEntry.encryptionData(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.odf_encryption_data:
                EncryptionData encryptionData = new EncryptionData();
                encryptionData(encryptionData, name, attrs);
                return encryptionData;
        }
        return null;
    }

    private void encryptionData(EncryptionData encryptionData, String name, Attributes attrs) {
        ((EncryptionDataReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.EncryptionData))
                .encryptionData(encryptionData);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return fileEntry;
    }

    public void fileEntry(FileEntry fileEntry) {
        this.fileEntry = fileEntry;
    }
}
