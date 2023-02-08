package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.RefList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.borderfill.BorderFillsReader;
import kr.dogfoot.hwpxlib.reader.header_xml.bullet.BulletsReader;
import kr.dogfoot.hwpxlib.reader.header_xml.charpr.CharPropertiesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.fontface.FontfacesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.memopr.MemoPropertiesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.NumberingsReader;
import kr.dogfoot.hwpxlib.reader.header_xml.parapr.ParaPropertiesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.style.StylesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.tabpr.TabPropertiesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchange.TrackChangesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchangeauthor.TrackChangeAuthorsReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class RefListReader extends ElementReader {
    private RefList refList;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.RefList;
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Fontfaces:
                refList.createFontfaces();
                fontFaces(refList.fontfaces(), name, attrs);
                break;
            case ElementNames.BorderFills:
                refList.createBorderFills();
                borderFills(refList.borderFills(), name, attrs);
                break;
            case ElementNames.CharProperties:
                refList.createCharProperties();
                charProperties(refList.charProperties(), name, attrs);
                break;
            case ElementNames.TabProperties:
                refList.createTabProperties();
                tabProperties(refList.tabProperties(), name, attrs);
                break;
            case ElementNames.Numberings:
                refList.createNumberings();
                numberings(refList.numberings(), name, attrs);
                break;
            case ElementNames.Bullets:
                refList.createBullets();
                bullets(refList.bullets(), name, attrs);
                break;
            case ElementNames.ParaProperties:
                refList.createParaProperties();
                paraProperties(refList.paraProperties(), name, attrs);
                break;
            case ElementNames.Styles:
                refList.createStyles();
                styles(refList.styles(), name, attrs);
                break;
            case ElementNames.MemoProperties:
                refList.createMemoProperties();
                memoProperties(refList.memoProperties(), name, attrs);
                break;
            case ElementNames.TrackChanges:
                refList.createTrackChanges();
                trackChanges(refList.trackChanges(), name, attrs);
                break;
            case ElementNames.TrackChangeAuthors:
                refList.createTrackChangeAuthors();
                trackChangeAuthors(refList.trackChangeAuthors(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.Fontfaces:
                Fontfaces fontfaces = new Fontfaces();
                fontFaces(fontfaces, name, attrs);
                return fontfaces;
            case ElementNames.BorderFills:
                ObjectList<BorderFill> borderFills = new ObjectList<BorderFill>(ObjectType.BorderFills, BorderFill.class);
                borderFills(borderFills, name, attrs);
                return borderFills;
            case ElementNames.CharProperties:
                ObjectList<CharPr> charProperties = new ObjectList<CharPr>(ObjectType.CharProperties, CharPr.class);
                charProperties(charProperties, name, attrs);
                return charProperties;
            case ElementNames.TabProperties:
                ObjectList<TabPr> tabProperties = new ObjectList<TabPr>(ObjectType.TabProperties, TabPr.class);
                tabProperties(tabProperties, name, attrs);
                return tabProperties;
            case ElementNames.Numberings:
                ObjectList<Numbering> numberings = new ObjectList<Numbering>(ObjectType.Numberings, Numbering.class);
                numberings(numberings, name, attrs);
                return numberings;
            case ElementNames.Bullets:
                ObjectList<Bullet> bullets = new ObjectList<Bullet>(ObjectType.Bullets, Bullet.class);
                bullets(bullets, name, attrs);
                return bullets;
            case ElementNames.ParaProperties:
                ObjectList<ParaPr> paraProperties = new ObjectList<ParaPr>(ObjectType.ParaProperties, ParaPr.class);
                paraProperties(paraProperties, name, attrs);
                return paraProperties;
            case ElementNames.Styles:
                ObjectList<Style> styles = new ObjectList<Style>(ObjectType.Styles, Style.class);
                styles(styles, name, attrs);
                return styles;
            case ElementNames.MemoProperties:
                ObjectList<MemoPr> memoProperties = new ObjectList<MemoPr>(ObjectType.MemoProperties, MemoPr.class);
                memoProperties(memoProperties, name, attrs);
                return memoProperties;
            case ElementNames.TrackChanges:
                ObjectList<TrackChange> trackChanges = new ObjectList<TrackChange>(ObjectType.TrackChanges, TrackChange.class);
                trackChanges(trackChanges, name, attrs);
                return trackChanges;
            case ElementNames.TrackChangeAuthors:
                ObjectList<TrackChangeAuthor> trackChangeAuthors = new ObjectList<TrackChangeAuthor>(ObjectType.TrackChangeAuthors, TrackChangeAuthor.class);
                trackChangeAuthors(trackChangeAuthors, name, attrs);
                return trackChangeAuthors;
        }
        return null;
    }

    private void fontFaces(Fontfaces fontfaces, String name, Attributes attrs) {
        ((FontfacesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Fontfaces))
                .fontfaces(fontfaces);

        xmlFileReader().startElement(name, attrs);
    }

    private void borderFills(ObjectList<BorderFill> borderFills, String name, Attributes attrs) {
        ((BorderFillsReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.BorderFills))
                .borderFills(borderFills);

        xmlFileReader().startElement(name, attrs);
    }

    private void charProperties(ObjectList<CharPr> charProperties, String name, Attributes attrs) {
        ((CharPropertiesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CharProperties))
                .charProperties(charProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void tabProperties(ObjectList<TabPr> tabProperties, String name, Attributes attrs) {
        ((TabPropertiesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TabProperties))
                .tabProperties(tabProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void numberings(ObjectList<Numbering> numberings, String name, Attributes attrs) {
        ((NumberingsReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Numberings))
                .numberings(numberings);

        xmlFileReader().startElement(name, attrs);
    }

    private void bullets(ObjectList<Bullet> bullets, String name, Attributes attrs) {
        ((BulletsReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Bullets))
                .bullets(bullets);

        xmlFileReader().startElement(name, attrs);
    }

    private void paraProperties(ObjectList<ParaPr> paraProperties, String name, Attributes attrs) {
       ((ParaPropertiesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ParaProperties))
                .paraProperties(paraProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void styles(ObjectList<Style> styles, String name, Attributes attrs) {
        ((StylesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Styles))
                .styles(styles);

        xmlFileReader().startElement(name, attrs);
    }

    private void memoProperties(ObjectList<MemoPr> memoProperties, String name, Attributes attrs) {
        ((MemoPropertiesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.MemoProperties))
                .memoProperties(memoProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void trackChanges(ObjectList<TrackChange> trackChanges, String name, Attributes attrs) {
        ((TrackChangesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChanges))
                .trackChanges(trackChanges);

        xmlFileReader().startElement(name, attrs);
    }

    private void trackChangeAuthors(ObjectList<TrackChangeAuthor> trackChangeAuthors, String name, Attributes attrs) {
        ((TrackChangeAuthorsReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChangeAuthors))
                .trackChangeAuthors(trackChangeAuthors);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return refList;
    }

    public void refList(RefList refList) {
        this.refList = refList;
    }
}
