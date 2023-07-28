package kr.dogfoot.hwpxlib.tool.finder.settings;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.object.root.ConfigItemSet;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromConfigItemSet extends FinderBase {
    public FromConfigItemSet(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.config_item_set;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ConfigItemSet configItemSet = (ConfigItemSet) from;
        pushPath(configItemSet);

        for (ConfigItem configItem : configItemSet.configItems()) {
            check(configItem);
        }

        checkSwitchList(configItemSet.switchList());
        popPath();
    }
}
