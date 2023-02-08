package kr.dogfoot.hwpxlib.reader.manifest_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionStartKeyGeneration;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class StartKeyGenerationReader extends ElementReader {
    private EncryptionStartKeyGeneration startKeyGeneration;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.StartKeyGeneration;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.start_key_generation_name:
                startKeyGeneration.startKeyGenerationName(value);
                break;
            case AttributeNames.key_size:
                startKeyGeneration.keySize(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void startKeyGeneration(EncryptionStartKeyGeneration startKeyGeneration) {
        this.startKeyGeneration = startKeyGeneration;
    }
}
