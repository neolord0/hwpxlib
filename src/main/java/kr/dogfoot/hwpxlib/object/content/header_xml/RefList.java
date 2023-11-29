package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.*;

public class RefList extends SwitchableObject {
    private Fontfaces fontfaces;
    private ObjectList<BorderFill> borderFills;
    private ObjectList<CharPr> charProperties;
    private ObjectList<TabPr> tabProperties;
    private ObjectList<Numbering> numberings;
    private ObjectList<Bullet> bullets;
    private ObjectList<ParaPr> paraProperties;
    private ObjectList<Style> styles;
    private ObjectList<MemoPr> memoProperties;
    private ObjectList<TrackChange> trackChanges;
    private ObjectList<TrackChangeAuthor> trackChangeAuthors;

    public RefList() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_refList;
    }

    public Fontfaces fontfaces() {
        return fontfaces;
    }

    public void createFontfaces() {
        fontfaces = new Fontfaces();
    }

    public void removeFontfaces() {
        fontfaces = null;
    }

    public ObjectList<BorderFill> borderFills() {
        return borderFills;
    }

    public void createBorderFills() {
        borderFills = new ObjectList<BorderFill>(ObjectType.hh_borderFills, BorderFill.class);
    }

    public void removeBorderFills() {
        borderFills = null;
    }

    public ObjectList<CharPr> charProperties() {
        return charProperties;
    }

    public void createCharProperties() {
        charProperties = new ObjectList<CharPr>(ObjectType.hh_charProperties, CharPr.class);
    }

    public void removeCharProperties() {
        charProperties = null;
    }

    public ObjectList<TabPr> tabProperties() {
        return tabProperties;
    }

    public void createTabProperties() {
        tabProperties = new ObjectList<TabPr>(ObjectType.hh_tabProperties, TabPr.class);
    }

    public void removeTabProperties() {
        tabProperties = null;
    }

    public ObjectList<Numbering> numberings() {
        return numberings;
    }

    public void createNumberings() {
        numberings = new ObjectList<Numbering>(ObjectType.hh_numberings, Numbering.class);
    }

    public void removeNumberings() {
        numberings = null;
    }

    public ObjectList<Bullet> bullets() {
        return bullets;
    }

    public void createBullets() {
        bullets = new ObjectList<Bullet>(ObjectType.hh_bullets, Bullet.class);
    }

    public void removeBullets() {
        bullets = null;
    }

    public ObjectList<ParaPr> paraProperties() {
        return paraProperties;
    }

    public void createParaProperties() {
        paraProperties = new ObjectList<ParaPr>(ObjectType.hh_paraProperties, ParaPr.class);
    }

    public void removeParaProperties() {
        paraProperties = null;
    }

    public ObjectList<Style> styles() {
        return styles;
    }

    public void createStyles() {
        styles = new ObjectList<Style>(ObjectType.hh_styles, Style.class);
    }

    public void removeStyles() {
        styles = null;
    }

    public ObjectList<MemoPr> memoProperties() {
        return memoProperties;
    }

    public void createMemoProperties() {
        memoProperties = new ObjectList<MemoPr>(ObjectType.hh_memoProperties, MemoPr.class);
    }

    public void removeMemoProperties() {
        memoProperties = null;
    }

    public ObjectList<TrackChange> trackChanges() {
        return trackChanges;
    }

    public void createTrackChanges() {
        trackChanges = new ObjectList<TrackChange>(ObjectType.hh_trackChanges, TrackChange.class);
    }

    public void removeTrackChanges() {
        trackChanges = null;
    }

    public ObjectList<TrackChangeAuthor> trackChangeAuthors() {
        return trackChangeAuthors;
    }

    public void createTrackChangeAuthors() {
        trackChangeAuthors = new ObjectList<TrackChangeAuthor>(ObjectType.hh_trackChangeAuthors, TrackChangeAuthor.class);
    }

    public void removeTrackChangeAuthors() {
        trackChangeAuthors = null;
    }

    @Override
    public RefList clone() {
        RefList cloned = new RefList();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(RefList from) {
        if (from.fontfaces != null) {
            fontfaces = from.fontfaces.clone();
        } else {
            fontfaces = null;
        }

        if (from.borderFills != null) {
            createBorderFills();
            for (BorderFill borderFill : from.borderFills.items()) {
                borderFills.add(borderFill.clone());
            }
        } else {
            borderFills = null;
        }

        if (from.charProperties != null) {
            createCharProperties();
            for (CharPr charPr : from.charProperties.items()) {
                charProperties.add(charPr.clone());
            }
        } else {
            charProperties = null;
        }

        if (from.tabProperties != null) {
            createTabProperties();
            for (TabPr tabPr : from.tabProperties.items()) {
                tabProperties.add(tabPr.clone());
            }
        } else {
            tabProperties = null;
        }

        if (from.numberings != null) {
            createNumberings();
            for (Numbering numbering : from.numberings.items()) {
                numberings.add(numbering.clone());
            }
        } else {
            numberings = null;
        }

        if (from.bullets != null) {
            createBullets();
            for (Bullet bullet : from.bullets.items()) {
                bullets.add(bullet.clone());
            }
        } else {
            bullets = null;
        }

        if (from.paraProperties != null) {
            createParaProperties();
            for  (ParaPr paraPr : from.paraProperties.items()) {
                paraProperties.add(paraPr.clone());
            }
        } else {
            paraProperties = null;
        }

        if (from.styles != null) {
            createStyles();
            for (Style style : from.styles.items()) {
                styles.add(style.clone());
            }
        } else {
            styles = null;
        }

        if (from.memoProperties != null) {
            createMemoProperties();
            for (MemoPr memoPr : from.memoProperties.items()) {
                memoProperties.add(memoPr.clone());
            }
        } else {
            memoProperties = null;
        }

        if (from.trackChanges != null) {
            createTrackChanges();
            for (TrackChange trackChange : from.trackChanges.items()) {
                trackChanges.add(trackChange.clone());
            }
        } else {
            trackChanges = null;
        }

        if (from.trackChangeAuthors != null) {
            createTrackChangeAuthors();
            for (TrackChangeAuthor trackChangeAuthor : from.trackChangeAuthors.items()) {
                trackChangeAuthors.add(trackChangeAuthor.clone());
            }
        } else {
            trackChangeAuthors = null;
        }

        super.copyFrom(from);
    }
}
