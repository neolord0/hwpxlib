package kr.dogfoot.hwpxlib.writer.header_xml.reflist.bullet;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Bullet;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class BulletsWriter extends ElementWriter {
    public BulletsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<Bullet> bullets = (ObjectList<Bullet>) object;
        switchList(bullets.switchList());
        if (bullets.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_bullets)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, bullets.count());

        for (Bullet bullet : bullets.items()) {
            writeChild(ElementWriterSort.Bullet, bullet);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_bullet:
                writeChild(ElementWriterSort.Bullet, child);
                break;
        }
    }
}
