package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class ContentHPFFile extends SwitchableObject {
    private String version;
    private String uniqueIdentifier;
    private String id;
    private MetaData metaData;
    private ObjectList<ManifestItem> manifest;
    private ObjectList<SpineItemRef> spine;

    public ContentHPFFile() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_package;
    }


    public String version() {
        return version;
    }

    public void version(String version) {
        this.version = version;
    }

    public ContentHPFFile versionAnd(String version) {
        this.version = version;
        return this;
    }

    public String uniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void uniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public ContentHPFFile uniqueIdentifierAnd(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public ContentHPFFile idAnd(String id) {
        this.id = id;
        return this;
    }

    public MetaData metaData() {
        return metaData;
    }

    public void createMetaData() {
        metaData = new MetaData();
    }

    public void removeMetaData() {
        metaData = null;
    }

    public ObjectList<ManifestItem> manifest() {
        return manifest;
    }

    public void createManifest() {
        manifest = new ObjectList<ManifestItem>(ObjectType.opf_manifest, ManifestItem.class);
    }

    public void removeManifest() {
        manifest = null;
    }

    public ManifestItem getManifestItemById(String id) {
        for (ManifestItem item : manifest.items()) {
            if (item.id().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public ObjectList<SpineItemRef> spine() {
        return spine;
    }

    public void createSpine() {
        spine = new ObjectList<SpineItemRef>(ObjectType.opf_spine, SpineItemRef.class);
    }

    public void removeSpine() {
        spine = null;
    }

    @Override
    public ContentHPFFile clone() {
        ContentHPFFile cloned = new ContentHPFFile();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ContentHPFFile from) {
        this.version = from.version;
        this.uniqueIdentifier = from.uniqueIdentifier;
        this.id = from.id;

        if (from.metaData != null) {
            this.metaData = from.metaData.clone();
        } else {
            this.metaData = null;
        }

        if (from.manifest != null) {
            createManifest();
            for (ManifestItem manifestItem : from.manifest.items()) {
                manifest.add(manifestItem.clone());
            }
        } else {
            removeManifest();
        }

        if (from.spine != null) {
            createSpine();
            for (SpineItemRef spineItemRef : from.spine.items()) {
                spine.add(spineItemRef.clone());
            }
        } else {
            removeSpine();
        }

        super.copyFrom(from);
    }
}
