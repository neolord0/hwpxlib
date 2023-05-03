package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Bullet;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromBullet extends FinderBase {
    public FromBullet(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_bullet;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Bullet bullet = (Bullet) from;
        pushPath(bullet);

        for (ParaHead paraHead : bullet.paraHeads()) {
            check(paraHead);
        }

        checkSwitchObject(bullet.switchObject());
        popPath();
    }
}
