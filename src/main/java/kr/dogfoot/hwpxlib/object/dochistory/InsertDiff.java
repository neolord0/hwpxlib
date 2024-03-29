package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

import java.util.ArrayList;

/**
 * 추가된 내용에 대한 이력
 */
public class InsertDiff extends DiffItem<InsertDiff> {
    /**
     * 하위 이력 리스트
     */
    private final ArrayList<DiffItem> childDiffList;

    public InsertDiff() {
        childDiffList = new ArrayList<DiffItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_insert;
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
                .filePartDiffTypeAnd(this.filePartDiffType());
        childDiffList.add(insertDiff);
        return insertDiff;
    }

    public UpdateDiff addNewUpdateDiff() {
        UpdateDiff updateDiff = new UpdateDiff()
                .filePartDiffTypeAnd(this.filePartDiffType());
        childDiffList.add(updateDiff);
        return updateDiff;
    }

    public DeleteDiff addNewDeleteDiff() {
        DeleteDiff deleteDiff = new DeleteDiff()
                .filePartDiffTypeAnd(this.filePartDiffType());
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

    public void removeAllChildDiffs() {
        childDiffList.clear();
    }

    public Iterable<DiffItem> childDiffs() {
        return childDiffList;
    }

    @Override
    public InsertDiff clone() {
        InsertDiff cloned = new InsertDiff();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(InsertDiff from) {
        for (DiffItem childDiff : from.childDiffList) {
            childDiffList.add((DiffItem) childDiff.clone());
        }

        super.copyFrom(from);
    }
}
