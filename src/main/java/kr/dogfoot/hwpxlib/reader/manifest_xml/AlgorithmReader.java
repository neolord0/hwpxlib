package kr.dogfoot.hwpxlib.reader.manifest_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.EncryptionAlgorithm;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class AlgorithmReader extends ElementReader {
    private EncryptionAlgorithm algorithm;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Algorithm;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.algorithm_name:
                algorithm.algorithmName(value);
                break;
            case AttributeNames.initialisation_vector:
                algorithm.initialisationVector(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void algorithm(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
