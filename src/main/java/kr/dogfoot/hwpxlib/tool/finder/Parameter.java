package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.tool.finder.comm.FoundFirstResultException;
import kr.dogfoot.hwpxlib.tool.finder.comm.ObjectFilter;

import java.util.ArrayList;

public class Parameter {
    private final ArrayList<HWPXObject> parentsPath;
    private final ArrayList<ObjectFinder.Result> result;
    private final ObjectFilter filter;
    private final boolean findFirstOnly;

    public Parameter(ObjectFilter filter, boolean findFirstOnly) {
        parentsPath = new ArrayList<HWPXObject>();
        result = new ArrayList<ObjectFinder.Result>();
        this.filter = filter;
        this.findFirstOnly = findFirstOnly;
    }

    public void pushPath(HWPXObject object) {
        parentsPath.add(object);
    }

    public void popPath() {
        if (parentsPath.size() > 0) {
            parentsPath.remove(parentsPath.size() - 1);
        }
    }

    public ObjectFilter checkFilter() {
        return filter;
    }

    public ArrayList<ObjectFinder.Result> result() {
        return result;
    }

    public void checkFilter(HWPXObject object) throws FoundFirstResultException {
        if (filter.isMatched(object, parentsPath)) {
            addResult(object);
        }
    }

    public void addResult(HWPXObject object) throws FoundFirstResultException {
        result.add(new ObjectFinder.Result(object, parentsPath));
        if (findFirstOnly == true) {
            throw new FoundFirstResultException();
        }
    }
}