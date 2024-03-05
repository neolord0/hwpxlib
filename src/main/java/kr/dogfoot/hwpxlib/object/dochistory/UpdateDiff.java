package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

import java.util.ArrayList;

/**
 * 변경된 내용에 대한 이력
 */
public class UpdateDiff extends DiffItem<UpdateDiff> {
    /**
     * 이전 값
     */
    private String oldValue;
    /**
     * 하위 이력 리스트
     */
    private final ArrayList<DiffItem> childDiffList;

    public UpdateDiff() {
        childDiffList = new ArrayList<DiffItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_update;
    }

    public String oldValue() {
        return oldValue;
    }

    public void oldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public UpdateDiff oldValueAnd(String oldValue) {
        this.oldValue = oldValue;
        return this;
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
        InsertDiff insertDiff = new InsertDiff();
        childDiffList.add(insertDiff);
        return insertDiff;
    }

    public UpdateDiff addNewUpdateDiff() {
        UpdateDiff updateDiff = new UpdateDiff();
        childDiffList.add(updateDiff);
        return updateDiff;
    }

    public DeleteDiff addNewDeleteDiff() {
        DeleteDiff deleteDiff = new DeleteDiff();
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
    public UpdateDiff clone() {
        UpdateDiff cloned = new UpdateDiff();
        cloned.copyFrom(this);
        return cloned;
    }


    public void copyFrom(UpdateDiff from) {
        this.oldValue = from.oldValue;

        for (DiffItem childDiff : from.childDiffList) {
            childDiffList.add((DiffItem) childDiff.clone());
        }

        super.copyFrom(from);
    }
}
