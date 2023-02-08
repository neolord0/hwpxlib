package kr.dogfoot.hwpxlib.reader.manifest_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionAlgorithm;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionData;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionKeyDerivation;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionStartKeyGeneration;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class EncryptionDataReader extends ElementReader {
    private EncryptionData encryptionData;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EncryptionData;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.checksum_type:
                encryptionData.checksumType(value);
                break;
            case AttributeNames.checksum:
                encryptionData.checksum(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Algorithm:
                encryptionData.createAlgorithm();
                algorithm(encryptionData.algorithm(), name, attrs);
                break;
            case ElementNames.KeyDerivation:
                encryptionData.createKeyDerivation();
                keyDerivation(encryptionData.keyDerivation(), name, attrs);
                break;
            case ElementNames.StartKeyGeneration:
                encryptionData.createStartKeyGeneration();
                startKeyGeneration(encryptionData.startKeyGeneration(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Algorithm:
                EncryptionAlgorithm algorithm = new EncryptionAlgorithm();
                algorithm(algorithm, name, attrs);
                return algorithm;
            case ElementNames.KeyDerivation:
                EncryptionKeyDerivation keyDerivation = new EncryptionKeyDerivation();
                keyDerivation(keyDerivation, name, attrs);
                return keyDerivation;
            case ElementNames.StartKeyGeneration:
                EncryptionStartKeyGeneration startKeyGeneration = new EncryptionStartKeyGeneration();
                startKeyGeneration(startKeyGeneration, name, attrs);
                return startKeyGeneration;
        }
        return null;
    }

    private void algorithm(EncryptionAlgorithm algorithm, String name, Attributes attrs) {
        ((AlgorithmReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Algorithm))
                .algorithm(algorithm);

        xmlFileReader().startElement(name, attrs);
    }

    private void keyDerivation(EncryptionKeyDerivation keyDerivation, String name, Attributes attrs) {
        ((KeyDerivationReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.KeyDerivation))
                .keyDerivation(keyDerivation);

        xmlFileReader().startElement(name, attrs);
    }

    private void startKeyGeneration(EncryptionStartKeyGeneration startKeyGeneration, String name, Attributes attrs) {
        ((StartKeyGenerationReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.StartKeyGeneration))
                .startKeyGeneration(startKeyGeneration);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return encryptionData;
    }

    public void encryptionData(EncryptionData encryptionData) {
        this.encryptionData = encryptionData;
    }
}
