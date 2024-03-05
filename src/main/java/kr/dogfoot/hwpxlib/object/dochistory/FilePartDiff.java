package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

public class FilePartDiff<ChildType> extends SwitchableObject {
    private ObjectType _objectType;
    private String href;
    /**
     * 하위 이력 리스트
     */
    private final ArrayList<DiffItem> childDiffList;

    public FilePartDiff(ObjectType _objectType) {
        this._objectType = _objectType;
        childDiffList = new ArrayList<DiffItem>();
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public String href() {
        return href;
    }

    public void href(String href) {
        this.href = href;
    }

    public ChildType hrefAnd(String href) {
        this.href = href;
        return (ChildType) this;
    }

    public int countOfChildDiff() {
        return childDiffList.size();
    }

    public DiffItem getChildDiff(int index) {
        return childDiffList.get(index);
    }

    public int getChildDiffIndex(DiffItem childDiff) {
        int count = childDiffList.size();
        for (int index = 0; index < count; index++) {
            if (childDiffList.get(index) == childDiff) {
                return index;
            }
        }
        return -1;
    }

    public void addChildDiff(DiffItem childDiff) {
        childDiffList.add(childDiff);
    }

    public InsertDiff addNewInsertDiff() {
        InsertDiff insertDiff = new InsertDiff()
                .filePartDiffTypeAnd(_objectType());
        childDiffList.add(insertDiff);
        return insertDiff;
    }

    public UpdateDiff addNewUpdateDiff() {
        UpdateDiff updateDiff = new UpdateDiff()
                .filePartDiffTypeAnd(_objectType());
        childDiffList.add(updateDiff);
        return updateDiff;
    }

    public DeleteDiff addNewDeleteDiff() {
        DeleteDiff deleteDiff = new DeleteDiff()
                .filePartDiffTypeAnd(_objectType());
        childDiffList.add(deleteDiff);
        return deleteDiff;
    }

    public void insertChildDiff(DiffItem childDiff, int position) {
        childDiffList.add(position, childDiff);
    }

    public void removeChildDiff(int position) {
        childDiffList.remove(position);
    }

    public void removeChildDiff(DiffItem childDiff) {
        childDiffList.remove(childDiff);
    }

    public Iterable<DiffItem> childDiffs() {
        return childDiffList;
    }

    @Override
    public FilePartDiff clone() {
        FilePartDiff cloned = new FilePartDiff(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FilePartDiff from) {
        this.href = from.href;
        int count = from.childDiffList.size();
        for (int index = 0; index < count; index++) {
            DiffItem childDiff = (DiffItem) from.childDiffList.get(index);
            childDiffList.add((DiffItem) childDiff.clone());
        }

        super.copyFrom(from);
    }
}
