package kr.dogfoot.hwpxlib.reader.content_hpf;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ManifestItemReader extends ElementReader {
    private ManifestItem item;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ManifestItem;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                item.id(value);
                break;
            case AttributeNames.href:
                item.href(value);
                break;
            case AttributeNames.media_type:
                item.mediaType(value);
                break;
            case AttributeNames.fallback:
                item.fallback(value);
                break;
            case AttributeNames.fallback_style:
                item.fallbackStyle(value);
                break;
            case AttributeNames.required_namespace:
                item.requiredNamespace(value);
                break;
            case AttributeNames.required_modules:
                item.requiredModules(value);
                break;
            case AttributeNames.encryption:
                item.encryption(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.file_size:
                item.fileSize(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.isEmbedded:
                item.embedded(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.sub_path:
                item.subPath(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void item(ManifestItem item) {
        this.item = item;
    }
}

