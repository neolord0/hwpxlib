package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public abstract class FromFormObject extends FromShapeObject {
    public FromFormObject(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    public void checkFromFormObject(FormObject formObject) throws Exception {
        checkFromShapeObject(formObject);

        check(formObject.formCharPr());
    }
}
