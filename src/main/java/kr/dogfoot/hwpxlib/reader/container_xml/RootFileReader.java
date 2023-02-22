package kr.dogfoot.hwpxlib.reader.container_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class RootFileReader extends ElementReader {
    private RootFile rootFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.RootFile;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.full_path:
                rootFile.fullPath(value);
                break;
            case AttributeNames.media_type:
                rootFile.mediaType(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void rootFile(RootFile rootFile) {
        this.rootFile = rootFile;
    }
}
