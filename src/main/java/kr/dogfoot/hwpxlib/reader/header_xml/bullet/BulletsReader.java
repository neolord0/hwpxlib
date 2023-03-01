package kr.dogfoot.hwpxlib.reader.header_xml.bullet;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Bullet;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class BulletsReader extends ElementReader {
    private ObjectList<Bullet> bullets;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Bullets;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_bullet:
                bullet(bullets.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_bullet:
                Bullet bullet = new Bullet();
                bullet(bullet, name, attrs);
                return bullet;
        }
        return null;
    }

    private void bullet(Bullet bullet, String name, Attributes attrs) {
        ((BulletReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Bullet))
                .bullet(bullet);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return bullets;
    }

    public void bullets(ObjectList<Bullet> bullets) {
        this.bullets = bullets;
    }
}
