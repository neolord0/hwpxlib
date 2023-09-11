package kr.dogfoot.hwpxlib.reader.header_xml.bullet;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Bullet;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.borderfill.ImageReader;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.ParaHeadReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class BulletReader extends ElementReader {
    private Bullet bullet;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Bullet;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                bullet.id(value);
                break;
            case AttributeNames._char:
                bullet._char(value);
                break;
            case AttributeNames.checkedChar:
                bullet.checkedChar(value);
                break;
            case AttributeNames.useImage:
                bullet.useImage(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_img:
                bullet.createImg();
                img(bullet.img(), name, attrs);
                break;
            case ElementNames.hh_paraHead:
                bullet.createParaHead();
                paraHead(bullet.paraHead(), name, attrs);
                break;
        }
   }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_img:
                Image image = new Image();
                img(image, name, attrs);
                return image;
            case ElementNames.hh_paraHead:
                ParaHead paraHead = new ParaHead();
                paraHead(paraHead, name, attrs);
                return paraHead;
        }
        return null;
    }

    private void img(Image img, String name, Attributes attrs) {
        ((ImageReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Image))
                .img(img);

        xmlFileReader().startElement(name, attrs);
    }

    private void paraHead(ParaHead paraHead, String name, Attributes attrs) {
        ((ParaHeadReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ParaHead))
                .paraHead(paraHead);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return bullet;
    }

    public void bullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
