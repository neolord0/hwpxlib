package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

public class ContentHPFFile extends XMLFile {
    private String version;
    private String uniqueIdentifier;
    private String id;
    private MetaData metaData;
    private ObjectList<ManifestItem> manifest;
    private ObjectList<SpineItemRef> spine;

    public ContentHPFFile() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Content_HPFFile;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.MetaData.equalElementName(name)) {
            return new MetaData();
        } else if (ObjectType.Manifest.equalElementName(name)) {
            return new ObjectList<ManifestItem>(ObjectType.Manifest, ManifestItem.class);
        } else if (ObjectType.Spine.equalElementName(name)) {
            return new ObjectList<SpineItemRef>(ObjectType.Spine, SpineItemRef.class);
        }
        return null;
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
        manifest = new ObjectList<ManifestItem>(ObjectType.Manifest, ManifestItem.class);
    }

    public void removeManifest() {
        manifest = null;
    }

    public ObjectList<SpineItemRef> spine() {
        return spine;
    }

    public void createSpine() {
        spine = new ObjectList<SpineItemRef>(ObjectType.Spine, SpineItemRef.class);
    }

    public void removeSpine() {
        spine = null;
    }

}
