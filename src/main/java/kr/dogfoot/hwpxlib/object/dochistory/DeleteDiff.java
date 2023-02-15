package kr.dogfoot.hwpxlib.object.dochistory;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;


/**
 * 삭제된 내용에 대한 이력
 */
public class DeleteDiff extends DiffItem<DeleteDiff> {
    /**
     * 삭제된 내용
     */
    private HWPXObject deletedObject;

    public DeleteDiff() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hhs_delete;
    }

    public HWPXObject deletedObject() {
        return deletedObject;
    }

    public void deletedObject(HWPXObject deletedObject) {
        this.deletedObject = deletedObject;
    }

    public DeleteDiff deletedObjectAnd(HWPXObject deletedObject) {
        this.deletedObject = deletedObject;
        return this;
    }
}
