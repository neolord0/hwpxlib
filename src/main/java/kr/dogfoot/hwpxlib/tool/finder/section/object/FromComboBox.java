package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ComboBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromFormObject;

public class FromComboBox extends FromFormObject {
    public FromComboBox(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_comboBox;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ComboBox comboBox = (ComboBox) from;
        pushPath(comboBox);

        checkFromFormObject(comboBox);

        for (ListItem listItem : comboBox.listItems()) {
            check(listItem);
        }

        checkSwitchList(comboBox.switchList());
        popPath();
    }
}
