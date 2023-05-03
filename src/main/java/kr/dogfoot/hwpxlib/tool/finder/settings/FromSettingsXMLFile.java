package kr.dogfoot.hwpxlib.tool.finder.settings;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromSettingsXMLFile extends FinderBase {
    public FromSettingsXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.ha_HWPApplicationSetting;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        SettingsXMLFile settingsXMLFile = (SettingsXMLFile) from;
        pushPath(settingsXMLFile);

        check(settingsXMLFile.caretPosition());

        checkWithChildren(settingsXMLFile.configItemSet());

        checkSwitchObject(settingsXMLFile.switchObject());
        popPath();
    }
}
