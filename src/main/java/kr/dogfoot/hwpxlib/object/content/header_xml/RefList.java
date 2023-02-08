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
    public ObjectType objectType() {
        return ObjectType.RefList;
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
        borderFills = new ObjectList<BorderFill>(ObjectType.BorderFills, BorderFill.class);
    }

    public void removeBorderFills() {
        borderFills = null;
    }

    public ObjectList<CharPr> charProperties() {
        return charProperties;
    }

    public void createCharProperties() {
        charProperties = new ObjectList<CharPr>(ObjectType.CharProperties, CharPr.class);
    }


    public void removeCharProperties() {
        charProperties = null;
    }

    public ObjectList<TabPr> tabProperties() {
        return tabProperties;
    }

    public void createTabProperties() {
        tabProperties = new ObjectList<TabPr>(ObjectType.TabProperties, TabPr.class);
    }

    public void removeTabProperties() {
        tabProperties = null;
    }

    public ObjectList<Numbering> numberings() {
        return numberings;
    }

    public void createNumberings() {
        numberings = new ObjectList<Numbering>(ObjectType.Numberings, Numbering.class);
    }

    public void removeNumberings() {
        numberings = null;
    }

    public ObjectList<Bullet> bullets() {
        return bullets;
    }

    public void createBullets() {
        bullets = new ObjectList<Bullet>(ObjectType.Bullets, Bullet.class);
    }

    public void removeBullets() {
        bullets = null;
    }

    public ObjectList<ParaPr> paraProperties() {
        return paraProperties;
    }

    public void createParaProperties() {
        paraProperties = new ObjectList<ParaPr>(ObjectType.ParaProperties, ParaPr.class);
    }

    public void removeParaProperties() {
        paraProperties = null;
    }

    public ObjectList<Style> styles() {
        return styles;
    }

    public void createStyles() {
        styles = new ObjectList<Style>(ObjectType.Styles, Style.class);
    }

    public void removeStyles() {
        styles = null;
    }

    public ObjectList<MemoPr> memoProperties() {
        return memoProperties;
    }

    public void createMemoProperties() {
        memoProperties = new ObjectList<MemoPr>(ObjectType.MemoProperties, MemoPr.class);
    }

    public void removeMemoProperties() {
        memoProperties = null;
    }

    public ObjectList<TrackChange> trackChanges() {
        return trackChanges;
    }

    public void createTrackChanges() {
        trackChanges = new ObjectList<TrackChange>(ObjectType.TrackChanges, TrackChange.class);
    }

    public void removeTrackChanges() {
        trackChanges = null;
    }

    public ObjectList<TrackChangeAuthor> trackChangeAuthors() {
        return trackChangeAuthors;
    }

    public void createTrackChangeAuthors() {
        trackChangeAuthors = new ObjectList<TrackChangeAuthor>(ObjectType.TrackChangeAuthors, TrackChangeAuthor.class);
    }

    public void removeTrackChangeAuthors() {
        trackChangeAuthors = null;
    }
}
