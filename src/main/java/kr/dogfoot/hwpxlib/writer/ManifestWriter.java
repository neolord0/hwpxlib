package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.object.metainf.*;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.writer.util.NamespaceSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class ManifestWriter {
    public static void write(ManifestXMLFile manifestXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.odf_manifest)
                .namespace(NamespaceSort.odf);

        for (FileEntry fileEntry : manifestXMLFile.fileEntries()) {
            fileEntry(fileEntry, xsb);
        }

        xsb.closeElement();
    }

    private static void fileEntry(FileEntry fileEntry, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.odf_file_entry)
                .attribute(AttributeNames.full_path, fileEntry.fullPath())
                .attribute(AttributeNames.media_type, fileEntry.mediaType())
                .attribute(AttributeNames.size, fileEntry.size());

        if (fileEntry.encryptionData() != null) {
            encryptionData(fileEntry.encryptionData(), xsb);
        }

        xsb.closeElement();
    }

    private static void encryptionData(EncryptionData encryptionData, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.odf_encryption_data)
                .attribute(AttributeNames.checksum_type, encryptionData.checksumType())
                .attribute(AttributeNames.checksum, encryptionData.checksum());

        if (encryptionData.algorithm() != null) {
            EncryptionAlgorithm algorithm = encryptionData.algorithm();
            xsb
                    .openElement(ElementNames.odf_algorithm)
                    .attribute(AttributeNames.algorithm_name, algorithm.algorithmName())
                    .attribute(AttributeNames.initialisation_vector, algorithm.initialisationVector())
                    .closeElement();
        }

        if (encryptionData.keyDerivation() != null) {
            EncryptionKeyDerivation keyDerivation = encryptionData.keyDerivation();
            xsb
                    .openElement(ElementNames.odf_key_derivation)
                    .attribute(AttributeNames.key_derivation_name, keyDerivation.keyDerivationName())
                    .attribute(AttributeNames.key_size, keyDerivation.keySize())
                    .attribute(AttributeNames.iteration_count, keyDerivation.iterationCount())
                    .attribute(AttributeNames.salt, keyDerivation.salt())
                    .closeElement();
        }

        if (encryptionData.startKeyGeneration() != null) {
            EncryptionStartKeyGeneration startKeyGeneration = encryptionData.startKeyGeneration();
            xsb
                    .openElement(ElementNames.odf_start_key_generation)
                    .attribute(AttributeNames.start_key_generation_name, startKeyGeneration.startKeyGenerationName())
                    .attribute(AttributeNames.key_size, startKeyGeneration.keySize())
                    .closeElement();
        }

        xsb.closeElement();
    }
}
