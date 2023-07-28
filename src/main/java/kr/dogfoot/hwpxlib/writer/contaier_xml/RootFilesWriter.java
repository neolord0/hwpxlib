package kr.dogfoot.hwpxlib.writer.contaier_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class RootFilesWriter extends ElementWriter {
    public RootFilesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.RootFiles;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<RootFile> rootFiles = (ObjectList<RootFile>) object;
        switchList(rootFiles.switchList());

        xsb()
                .openElement(ElementNames.ocf_rootfiles)
                .elementWriter(this);

        for (RootFile rootFile : rootFiles.items()) {
            rootFile(rootFile);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void rootFile(RootFile rootFile) {
        xsb()
                .openElement(ElementNames.ocf_rootfile)
                .attribute(AttributeNames.full_path, rootFile.fullPath())
                .attribute(AttributeNames.media_type, rootFile.mediaType())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case ocf_rootfile:
                rootFile((RootFile) child);
                break;
        }
    }
}
