package kr.dogfoot.hwpxlib.writer.header_xml.reflist.bullet;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Bullet;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill.ImageBrushWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.numbering.NumberingWriter;

public class BulletWriter extends ElementWriter {
    public BulletWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Bullet;
    }

    @Override
    public void write(HWPXObject object) {
        Bullet bullet = (Bullet) object;
        switchList(bullet.switchList());

        xsb()
                .openElement(ElementNames.hh_bullet)
                .elementWriter(this)
                .attribute(AttributeNames.id, bullet.id())
                .attribute(AttributeNames._char, bullet._char())
                .attribute(AttributeNames.checkedChar, bullet.checkedChar())
                .attribute(AttributeNames.useImage, bullet.useImage());

        if (bullet.img() != null) {
            ImageBrushWriter.img(bullet.img(), xsb());
        }

        if (bullet.paraHead() != null) {
            NumberingWriter.paraHead(bullet.paraHead(),xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_img:
                ImageBrushWriter.img((Image) child, xsb());
                break;
            case hh_paraHead:
                NumberingWriter.paraHead((ParaHead) child, xsb());
                break;
        }
    }
}
