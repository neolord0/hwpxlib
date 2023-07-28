package kr.dogfoot.hwpxlib.writer.manifest_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionAlgorithm;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionData;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionKeyDerivation;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionStartKeyGeneration;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EncryptionDataWriter extends ElementWriter {
    public EncryptionDataWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.EncryptionData;
    }

    @Override
    public void write(HWPXObject object) {
        EncryptionData encryptionData = (EncryptionData) object;
        switchList(encryptionData.switchList());

        xsb()
                .openElement(ElementNames.odf_encryption_data)
                .elementWriter(this)
                .attribute(AttributeNames.checksum_type, encryptionData.checksumType())
                .attribute(AttributeNames.checksum, encryptionData.checksum());

        if (encryptionData.algorithm() != null) {
            algorithm(encryptionData.algorithm());
        }

        if (encryptionData.keyDerivation() != null) {
            keyDerivation(encryptionData.keyDerivation());
        }

        if (encryptionData.startKeyGeneration() != null) {
            startKeyGeneration(encryptionData.startKeyGeneration());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void algorithm(EncryptionAlgorithm algorithm) {
        xsb()
                .openElement(ElementNames.odf_algorithm)
                .attribute(AttributeNames.algorithm_name, algorithm.algorithmName())
                .attribute(AttributeNames.initialisation_vector, algorithm.initialisationVector())
                .closeElement();
    }

    private void keyDerivation(EncryptionKeyDerivation keyDerivation) {
        xsb()
                .openElement(ElementNames.odf_key_derivation)
                .attribute(AttributeNames.key_derivation_name, keyDerivation.keyDerivationName())
                .attribute(AttributeNames.key_size, keyDerivation.keySize())
                .attribute(AttributeNames.iteration_count, keyDerivation.iterationCount())
                .attribute(AttributeNames.salt, keyDerivation.salt())
                .closeElement();
    }


    private void startKeyGeneration(EncryptionStartKeyGeneration startKeyGeneration) {
        xsb()
                .openElement(ElementNames.odf_start_key_generation)
                .attribute(AttributeNames.start_key_generation_name, startKeyGeneration.startKeyGenerationName())
                .attribute(AttributeNames.key_size, startKeyGeneration.keySize())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case odf_algorithm:
                algorithm((EncryptionAlgorithm) child);
                break;
            case odf_key_derivation:
                keyDerivation((EncryptionKeyDerivation) child);
                break;
            case odf_start_key_generation:
                startKeyGeneration((EncryptionStartKeyGeneration) child);
                break;
        }
    }
}
