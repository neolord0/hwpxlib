package kr.dogfoot.hwpxlib.object.common;

import java.util.ArrayList;

public class ObjectList<ItemType> extends SwitchableObject {
    private final ObjectType _objectType;
    private final ArrayList<ItemType> list;
    private final Class<ItemType> clazz;

    public ObjectList(Class<ItemType> clazz) {
        this(null, clazz);
    }

    public ObjectList(ObjectType objectType, Class<ItemType> clazz) {
        this._objectType = objectType;
        list = new ArrayList<ItemType>();
        this.clazz = clazz;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public int count() {
        return list.size();
    }

    public ItemType get(int index) {
        return list.get(index);
    }

    public int getIndex(ItemType item) {
        int count = list.size();
        for (int index = 0; index < count; index++) {
            if (list.get(index) == item) {
                return index;
            }
        }
        return -1;
    }

    public void add(ItemType item) {
        list.add(item);
    }

    public ItemType addNew() {
        ItemType instance;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            instance = null;
        } catch (IllegalAccessException e) {
            instance = null;
        }
        if (instance != null) {
            list.add(instance);
        }
        return instance;
    }

    public void insert(ItemType item, int position) {
        list.add(position, item);
    }

    public void remove(int position) {
        list.remove(position);
    }

    public void removeAll() {
        this.list.clear();
    }

    public Iterable<ItemType> items() {
        return list;
    }

    public boolean empty() {
        return list.size() == 0;
    }

    @Override
    public ObjectList clone() {
        // not supported
        return null;
    }
}
