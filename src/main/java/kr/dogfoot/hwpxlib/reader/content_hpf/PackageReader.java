package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ContentHPFFile;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.content.context_hpf.MetaData;
import kr.dogfoot.hwpxlib.object.content.context_hpf.SpineItemRef;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class PackageReader extends ElementReader {
    private ContentHPFFile contentHPFFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Package;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.version:
                contentHPFFile.version(value);
                break;
            case AttributeNames.unique_identifier:
                contentHPFFile.uniqueIdentifier(value);
                break;
            case AttributeNames.id:
                contentHPFFile.id(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.MetaData:
                contentHPFFile.createMetaData();
                metadata(contentHPFFile.metaData(), name, attrs);
                break;
            case ElementNames.Manifest:
                contentHPFFile.createManifest();
                manifest(contentHPFFile.manifest(), name, attrs);
                break;
            case ElementNames.Spine:
                contentHPFFile.createSpine();
                spine(contentHPFFile.spine(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.MetaData) {
            metadata((MetaData) child, name, attrs);
        } else if (child.objectType() == ObjectType.Manifest) {
            manifest((ObjectList<ManifestItem>) child, name, attrs);
        } else if (child.objectType() == ObjectType.Spine) {
            spine((ObjectList<SpineItemRef>) child, name, attrs);
        }
    }

    private void metadata(MetaData metaData, String name, Attributes attrs) {
        ((MetadataReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Metadata))
                .metaData(metaData);

        xmlFileReader().startElement(name, attrs);
    }

    private void manifest(ObjectList<ManifestItem> manifest, String name, Attributes attrs) {
        ((PackageManifestReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.PackageManifest))
                .manifest(manifest);

        xmlFileReader().startElement(name, attrs);
    }

    private void spine(ObjectList<SpineItemRef> spine, String name, Attributes attrs) {
        ((SpineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Spine))
                .spine(spine);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return contentHPFFile;
    }

    public void contentHPFFile(ContentHPFFile contentHPFFile) {
        this.contentHPFFile = contentHPFFile;
    }
}
