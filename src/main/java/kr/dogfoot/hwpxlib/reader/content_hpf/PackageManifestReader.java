package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class PackageManifestReader extends ElementReader {
    private ObjectList<ManifestItem> manifest;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PackageManifest;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.opf_item:
                item(manifest.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.opf_item:
                ManifestItem item = new ManifestItem();
                item(item, name, attrs);
                return item;
        }
        return null;
    }


    private void item(ManifestItem manifestItem, String name, Attributes attrs) {
        ((ManifestItemReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ManifestItem))
                .item(manifestItem);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return manifest;
    }

    public void manifest(ObjectList<ManifestItem> manifest) {
        this.manifest = manifest;
    }
}
