package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

import java.util.ArrayList;


public class MetaData extends SwitchableObject {
    private HasOnlyText title;
    private HasOnlyText language;
    private final ArrayList<Meta> metaList;

    public MetaData() {
        metaList = new ArrayList<Meta>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_metadata;
    }

    public HasOnlyText title() {
        return title;
    }

    public void createTitle() {
        title = new HasOnlyText(ObjectType.opf_title);
    }

    public void removeTitle() {
        title = null;
    }

    public HasOnlyText language() {
        return language;
    }

    public void createLanguage() {
        language = new HasOnlyText(ObjectType.opf_language);
    }

    public void removeLanguage() {
        language = null;
    }

    public int countOfMeta() {
        return metaList.size();
    }

    public Meta getMeta(int index) {
        return metaList.get(index);
    }

    public int getMetaIndex(Meta meta) {
        int count = metaList.size();
        for (int index = 0; index < count; index++) {
            if (metaList.get(index) == meta) {
                return index;
            }
        }
        return -1;
    }

    public void addMeta(Meta meta) {
        metaList.add(meta);
    }

    public Meta addNewMeta() {
        Meta meta = new Meta();
        metaList.add(meta);
        return meta;
    }

    public void insertMeta(Meta meta, int position) {
        metaList.add(position, meta);
    }

    public void removeMeta(int position) {
        metaList.remove(position);
    }

    public void removeMeta(Meta meta) {
        metaList.remove(meta);
    }

    public Iterable<Meta> metas() {
        return metaList;
    }

    @Override
    public MetaData clone() {
        MetaData cloned = new MetaData();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(MetaData from) {
        if (from.title != null) {
            title = from.title.clone();
        } else {
            title = null;
        }

        if (from.language != null) {
            language = from.language.clone();
        } else {
            language = null;
        }

        for (Meta meta : from.metaList) {
            metaList.add(meta.clone());
        }

        super.copyFrom(from);
    }
}
