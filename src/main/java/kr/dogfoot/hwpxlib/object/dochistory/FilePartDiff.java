package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

public abstract class FilePartDiff<ChildType> extends SwitchableObject {
    private String href;
    /**
     * 하위 이력 리스트
     */
    private final ArrayList<DiffItem> childDiffList;

    public FilePartDiff() {
        childDiffList = new ArrayList<DiffItem>();
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

    public Iterable<DiffItem> childDiffs() {
        return childDiffList;
    }
}
