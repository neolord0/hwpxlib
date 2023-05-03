package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.tool.finder.comm.*;

import java.util.ArrayList;

public class ObjectFinder {
    public static Result[] find(HWPXObject from, ObjectFilter objectFilter, boolean findFirstOnly) throws Exception {
        Parameter parameter = new Parameter(objectFilter, findFirstOnly);
        try {
            FinderBase finder = new FinderManager(parameter).get(from._objectType());
            if (finder == null) {
                throw new NoFinderException(from);
            }
            finder.find(from);
        } catch (FoundFirstResultException e) {
        } catch (NoFinderException e) {
            throw e;
        }

        return parameter.result().toArray(new Result[0]);
    }

    public static class Result {
        private HWPXObject thisObject;
        private ArrayList<HWPXObject> parentsPath;

        public Result(HWPXObject thisObject, ArrayList<HWPXObject> parentsPath) {
            this.thisObject = thisObject;
            copyParentsPath(parentsPath);
        }

        private void copyParentsPath(ArrayList<HWPXObject> origin) {
            if (origin != null) {
                parentsPath = new ArrayList<HWPXObject>();
                for (HWPXObject parent : origin) {
                    parentsPath.add(parent);
                }
            } else {
                parentsPath = null;
            }
        }

        public HWPXObject thisObject() {
            return thisObject;
        }

        public ArrayList<HWPXObject> parentsPath() {
            return parentsPath;
        }
    }
}

