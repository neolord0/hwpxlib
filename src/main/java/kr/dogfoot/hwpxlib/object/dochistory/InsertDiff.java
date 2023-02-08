package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
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
    public ObjectType objectType() {
        return ObjectType.InsertDiff;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.InsertDiff.equalElementName(name)) {
            return new InsertDiff();
        } else if (ObjectType.UpdateDiff.equalElementName(name)) {
            return new UpdateDiff();
        } else if (ObjectType.DeleteDiff.equalElementName(name)) {
            return new DeleteDiff();
        }
        return null;
    }

    public int countOfChildDiff() {
        return childDiffList.size();
    }

    public DiffItem getChildDiff(int index) {
        return childDiffList.get(index);
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

    public Iterable<DiffItem> childDiffs() {
        return childDiffList;
    }
}
