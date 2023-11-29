package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.commonstrings.MineTypes;
import kr.dogfoot.hwpxlib.object.common.AttachedFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class ManifestItem extends HWPXObject {
    private String id;
    private String href;
    private String mediaType;
    private String fallback;
    private String fallbackStyle;
    private String requiredNamespace;
    private String requiredModules;
    private Boolean encryption;
    private Integer fileSize;
    private Boolean isEmbedded;
    private String subPath;
    /**
     * mediaType가 application/ole, image/*, application/x-javascript 중 하나일 경우 첨부된 파일을 저장한다.
      */
    private AttachedFile attachedFile;

    public ManifestItem() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_item;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public ManifestItem idAnd(String id) {
        this.id = id;
        return this;
    }

    public String href() {
        return href;
    }

    public void href(String href) {
        this.href = href;
    }

    public ManifestItem hrefAnd(String href) {
        this.href = href;
        return this;
    }

    public String mediaType() {
        return mediaType;
    }

    public void mediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public ManifestItem mediaTypeAnd(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public boolean hasAttachedFile() {
        if (mediaType == null) {
            return false;
        }

        if (mediaType.equals(MineTypes.OLE)
                || mediaType.startsWith(MineTypes.Image_PreFix)
                || mediaType.startsWith(MineTypes.Script_PreFix)) {
            return true;
        }
        return false;
    }

    public String fallback() {
        return fallback;
    }

    public void fallback(String fallback) {
        this.fallback = fallback;
    }

    public ManifestItem fallbackAnd(String fallback) {
        this.fallback = fallback;
        return this;
    }

    public String fallbackStyle() {
        return fallbackStyle;
    }

    public void fallbackStyle(String fallbackStyle) {
        this.fallbackStyle = fallbackStyle;
    }

    public ManifestItem fallbackStyleAnd(String fallbackStyle) {
        this.fallbackStyle = fallbackStyle;
        return this;
    }

    public String requiredNamespace() {
        return requiredNamespace;
    }

    public void requiredNamespace(String requiredNamespace) {
        this.requiredNamespace = requiredNamespace;
    }

    public ManifestItem requiredNamespaceAnd(String requiredNamespace) {
        this.requiredNamespace = requiredNamespace;
        return this;
    }

    public String requiredModules() {
        return requiredModules;
    }

    public void requiredModules(String requiredModules) {
        this.requiredModules = requiredModules;
    }

    public ManifestItem requiredModulesAnd(String requiredModules) {
        this.requiredModules = requiredModules;
        return this;
    }

    public Boolean encryption() {
        return encryption;
    }

    public void encryption(Boolean encryption) {
        this.encryption = encryption;
    }

    public ManifestItem encryptionAnd(Boolean encryption) {
        this.encryption = encryption;
        return this;
    }

    public Integer fileSize() {
        return fileSize;
    }

    public void fileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public ManifestItem fileSizeAnd(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public Boolean isEmbedded() {
        return isEmbedded;
    }

    public void embedded(Boolean embedded) {
        this.isEmbedded = embedded;
    }

    public ManifestItem embeddedAnd(Boolean embedded) {
        this.isEmbedded = embedded;
        return this;
    }

    public String subPath() {
        return subPath;
    }

    public void subPath(String subPath) {
        this.subPath = subPath;
    }

    public ManifestItem subPathAnd(String subPath) {
        this.subPath = subPath;
        return this;
    }

    public AttachedFile attachedFile() {
        return attachedFile;
    }

    public void createAttachedFile() {
        attachedFile = new AttachedFile();
    }

    public void removeAttachedFile() {
        attachedFile = null;
    }

    @Override
    public ManifestItem clone() {
        ManifestItem cloned = new ManifestItem();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ManifestItem from) {
        this.id = from.id;
        this.href = from.href;
        this.mediaType = from.mediaType;
        this.fallback = from.fallback;
        this.fallbackStyle = from.fallbackStyle;
        this.requiredNamespace = from.requiredNamespace;
        this.requiredModules = from.requiredModules;
        this.encryption = from.encryption;
        this.fileSize = from.fileSize;
        this.isEmbedded = from.isEmbedded;
        this.subPath = from.subPath;

        if (from.attachedFile != null) {
            attachedFile = from.attachedFile.clone();
        } else {
            attachedFile = null;
        }
    }
}
