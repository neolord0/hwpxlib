package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ListBox;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox.ListItem;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromFormObject;

public class FromListBox extends FromFormObject {
    public FromListBox(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_listBox;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ListBox listBox = (ListBox) from;
        pushPath(listBox);

        checkFromFormObject(listBox);

        for (ListItem listItem : listBox.listItems()) {
            check(listItem);
        }

        checkSwitchList(listBox.switchList());
        popPath();
    }
}
