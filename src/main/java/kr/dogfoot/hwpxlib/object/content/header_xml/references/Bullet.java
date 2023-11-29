package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;

/**
 * 글머리표 문단 모양
 */
public class Bullet extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 글머리표 글자
     */
    private String _char;
    /**
     * ??
     */
    private String checkedChar;
    /**
     * 이미지 사용 여부
     */
    private Boolean useImage;
    /**
     * 이미지
     */
    private Image img;
    /**
     * 수준별 문단 머리 모양
     */
    private ParaHead paraHead;

    public Bullet() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_bullet;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public Bullet idAnd(String id) {
        this.id = id;
        return this;
    }

    public String _char() {
        return _char;
    }

    public void _char(String _char) {
        this._char = _char;
    }

    public Bullet _charAnd(String _char) {
        this._char = _char;
        return this;
    }

    public String checkedChar() {
        return checkedChar;
    }

    public void checkedChar(String checkedChar) {
        this.checkedChar = checkedChar;
    }

    public Bullet checkedCharAnd(String checkedChar) {
        this.checkedChar = checkedChar;
        return this;
    }

    public Boolean useImage() {
        return useImage;
    }

    public void useImage(Boolean useImage) {
        this.useImage = useImage;
    }

    public Bullet useImageAnd(Boolean useImage) {
        this.useImage = useImage;
        return this;
    }

    public Image img() {
        return img;
    }

    public void createImg() {
        img = new Image();
    }

    public void removeImg() {
        img = null;
    }

    public ParaHead paraHead() {
        return paraHead;
    }

    public void createParaHead() {
        paraHead = new ParaHead();
    }

    public void removeParaHead() {
        paraHead = null;
    }

    @Override
    public Bullet clone() {
        Bullet cloned = new Bullet();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Bullet from) {
        this.id = from.id;
        this._char = from._char;
        this.checkedChar = from.checkedChar;
        this.useImage = from.useImage;

        if (from.img != null) {
            img = from.img.clone();
        } else {
            img = null;
        }

        if (from.paraHead != null) {
            paraHead = from.paraHead.clone();
        } else {
            paraHead = null;
        }

        super.copyFrom(from);
    }
}
