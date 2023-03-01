package kr.dogfoot.hwpxlib.reader.manifest_xml;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionKeyDerivation;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class KeyDerivationReader extends ElementReader {

    private EncryptionKeyDerivation keyDerivation;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.KeyDerivation;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.key_derivation_name:
                keyDerivation.keyDerivationName(value);
                break;
            case AttributeNames.key_size:
                keyDerivation.keySize(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.iteration_count:
                keyDerivation.iterationCount(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.salt:
                keyDerivation.salt(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void keyDerivation(EncryptionKeyDerivation keyDerivation) {
        this.keyDerivation = keyDerivation;
    }
}
