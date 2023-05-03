package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.ParaListCore;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Ctrl;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldEnd;
import kr.dogfoot.hwpxlib.tool.finder.comm.ObjectFilter;

import java.util.ArrayList;
import java.util.HashMap;

public class FieldFinder {
    public static Result[] find(HWPXObject from, String fieldName, boolean findFirstOnly) throws Exception {
        if (from == null || fieldName == null || fieldName.length() == 0) {
            return new Result[0];
        }

        ObjectFinder.Result[] findResults = ObjectFinder.find(from, new MyFilter(fieldName), findFirstOnly);
        if (findResults.length == 0) {
            return new Result[0];
        }

        HashMap<String, Result> results = new HashMap<String, Result>();

        for (ObjectFinder.Result findResult : findResults) {
            if (findResult.thisObject()._objectType() == ObjectType.hp_fieldBegin) {
                fieldBegin(findResult, results);
            } else if (findResult.thisObject()._objectType() == ObjectType.hp_fieldEnd) {
                fieldEnd(findResult, results);
            }
        }
        return results.values().toArray(new Result[0]);
    }

    private static void fieldBegin(ObjectFinder.Result findResult, HashMap<String, Result> results) {
        FieldBegin fieldBegin = (FieldBegin) findResult.thisObject();
        Result result = results.get(fieldBegin.id());
        if (result != null) {
            result.setBegin(fieldBegin, findResult.parentsPath());
        } else {
            results.put(fieldBegin.id(), Result.createWithBegin(fieldBegin, findResult.parentsPath()));
        }
    }

    private static void fieldEnd(ObjectFinder.Result findResult, HashMap<String, Result> results) {
        FieldEnd fieldEnd = (FieldEnd) findResult.thisObject();
        Result result = results.get(fieldEnd.beginIDRef());
        if (result != null) {
            result.setEnd(fieldEnd, findResult.parentsPath());
        } else {
            results.put(fieldEnd.beginIDRef(), Result.createWithEnd(fieldEnd, findResult.parentsPath()));
        }
    }

    private static class MyFilter implements ObjectFilter {
        private final String fieldName;
        private final ArrayList<String> fieldBeginIDs;

        public MyFilter(String fieldName) {
            this.fieldName = fieldName;
            fieldBeginIDs = new ArrayList<String>();
        }

        @Override
        public boolean isMatched(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
            if (thisObject._objectType() == ObjectType.hp_fieldBegin) {
                FieldBegin fieldBegin = (FieldBegin) thisObject;
                if (fieldName.equals(fieldBegin.name())) {
                    fieldBeginIDs.add(fieldBegin.id());
                    return true;
                }
            }
            if (thisObject._objectType() == ObjectType.hp_fieldEnd) {
                FieldEnd fieldEnd = (FieldEnd) thisObject;
                int index = fieldBeginIDs.indexOf(fieldEnd.beginIDRef());
                if (index != -1) {
                    fieldBeginIDs.set(index, null);
                    return true;
                }
            }
            return false;
        }
    }



    public static class Result {
        public static Result createWithBegin(FieldBegin fieldBegin, ArrayList<HWPXObject> parentsPath) {
            Result result = new Result();
            result.paraList = (ParaListCore) parentsPath.get(parentsPath.size() - 4);
            result.setBegin(fieldBegin, parentsPath);
            return result;
        }

        public static Result createWithEnd(FieldEnd fieldEnd, ArrayList<HWPXObject> parentsPath) {
            Result result = new Result();
            result.paraList = (ParaListCore) parentsPath.get(parentsPath.size() - 4);
            result.setEnd(fieldEnd, parentsPath);
            return result;
        }

        private ParaListCore paraList;

        private Para beginPara;
        private Run beginRun;
        private Ctrl beginCtrl;
        private FieldBegin beginField;

        private Para endPara;
        private Run endRun;
        private Ctrl endCtrl;
        private FieldEnd endField;

        public void setBegin(FieldBegin fieldBegin, ArrayList<HWPXObject> parentsPath) {
            beginPara = (Para) parentsPath.get(parentsPath.size() - 3);
            beginRun = (Run) parentsPath.get(parentsPath.size() - 2);
            beginCtrl = (Ctrl) parentsPath.get(parentsPath.size() - 1);
            beginField = fieldBegin;
        }

        public void setEnd(FieldEnd fieldEnd, ArrayList<HWPXObject> parentsPath) {
            endPara = (Para) parentsPath.get(parentsPath.size() - 3);
            endRun = (Run) parentsPath.get(parentsPath.size() - 2);
            endCtrl = (Ctrl) parentsPath.get(parentsPath.size() - 1);
            endField = fieldEnd;
        }

        public ParaListCore paraList() {
            return paraList;
        }

        public Para beginPara() {
            return beginPara;
        }

        public Run beginRun() {
            return beginRun;
        }

        public Ctrl beginCtrl() {
            return beginCtrl;
        }

        public FieldBegin beginField() {
            return beginField;
        }

        public Para endPara() {
            return endPara;
        }

        public Run endRun() {
            return endRun;
        }

        public Ctrl endCtrl() {
            return endCtrl;
        }

        public FieldEnd endField() {
            return endField;
        }
    }
}
