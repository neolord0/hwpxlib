package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
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
            case ElementNames.hh_fontfaces:
                refList.createFontfaces();
                fontFaces(refList.fontfaces(), name, attrs);
                break;
            case ElementNames.hh_borderFills:
                refList.createBorderFills();
                borderFills(refList.borderFills(), name, attrs);
                break;
            case ElementNames.hh_charProperties:
                refList.createCharProperties();
                charProperties(refList.charProperties(), name, attrs);
                break;
            case ElementNames.hh_tabProperties:
                refList.createTabProperties();
                tabProperties(refList.tabProperties(), name, attrs);
                break;
            case ElementNames.hh_numberings:
                refList.createNumberings();
                numberings(refList.numberings(), name, attrs);
                break;
            case ElementNames.hh_bullets:
                refList.createBullets();
                bullets(refList.bullets(), name, attrs);
                break;
            case ElementNames.hh_paraProperties:
                refList.createParaProperties();
                paraProperties(refList.paraProperties(), name, attrs);
                break;
            case ElementNames.hh_styles:
                refList.createStyles();
                styles(refList.styles(), name, attrs);
                break;
            case ElementNames.hh_memoProperties:
                refList.createMemoProperties();
                memoProperties(refList.memoProperties(), name, attrs);
                break;
            case ElementNames.hh_trackChanges:
                refList.createTrackChanges();
                trackChanges(refList.trackChanges(), name, attrs);
                break;
            case ElementNames.hh_trackChangeAuthors:
                refList.createTrackChangeAuthors();
                trackChangeAuthors(refList.trackChangeAuthors(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_fontfaces:
                Fontfaces fontfaces = new Fontfaces();
                fontFaces(fontfaces, name, attrs);
                return fontfaces;
            case ElementNames.hh_borderFills:
                ObjectList<BorderFill> borderFills = new ObjectList<BorderFill>(ObjectType.hh_borderFills, BorderFill.class);
                borderFills(borderFills, name, attrs);
                return borderFills;
            case ElementNames.hh_charProperties:
                ObjectList<CharPr> charProperties = new ObjectList<CharPr>(ObjectType.hh_charProperties, CharPr.class);
                charProperties(charProperties, name, attrs);
                return charProperties;
            case ElementNames.hh_tabProperties:
                ObjectList<TabPr> tabProperties = new ObjectList<TabPr>(ObjectType.hh_tabProperties, TabPr.class);
                tabProperties(tabProperties, name, attrs);
                return tabProperties;
            case ElementNames.hh_numberings:
                ObjectList<Numbering> numberings = new ObjectList<Numbering>(ObjectType.hh_numberings, Numbering.class);
                numberings(numberings, name, attrs);
                return numberings;
            case ElementNames.hh_bullets:
                ObjectList<Bullet> bullets = new ObjectList<Bullet>(ObjectType.hh_bullets, Bullet.class);
                bullets(bullets, name, attrs);
                return bullets;
            case ElementNames.hh_paraProperties:
                ObjectList<ParaPr> paraProperties = new ObjectList<ParaPr>(ObjectType.hh_paraProperties, ParaPr.class);
                paraProperties(paraProperties, name, attrs);
                return paraProperties;
            case ElementNames.hh_styles:
                ObjectList<Style> styles = new ObjectList<Style>(ObjectType.hh_styles, Style.class);
                styles(styles, name, attrs);
                return styles;
            case ElementNames.hh_memoProperties:
                ObjectList<MemoPr> memoProperties = new ObjectList<MemoPr>(ObjectType.hh_memoProperties, MemoPr.class);
                memoProperties(memoProperties, name, attrs);
                return memoProperties;
            case ElementNames.hh_trackChanges:
                ObjectList<TrackChange> trackChanges = new ObjectList<TrackChange>(ObjectType.hh_trackChanges, TrackChange.class);
                trackChanges(trackChanges, name, attrs);
                return trackChanges;
            case ElementNames.hh_trackChangeAuthors:
                ObjectList<TrackChangeAuthor> trackChangeAuthors = new ObjectList<TrackChangeAuthor>(ObjectType.hh_trackChangeAuthors, TrackChangeAuthor.class);
                trackChangeAuthors(trackChangeAuthors, name, attrs);
                return trackChangeAuthors;
        }
        return null;
    }

    private void fontFaces(Fontfaces fontfaces, String name, Attributes attrs) {
        ((FontfacesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Fontfaces))
                .fontfaces(fontfaces);

        xmlFileReader().startElement(name, attrs);
    }

    private void borderFills(ObjectList<BorderFill> borderFills, String name, Attributes attrs) {
        ((BorderFillsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.BorderFills))
                .borderFills(borderFills);

        xmlFileReader().startElement(name, attrs);
    }

    private void charProperties(ObjectList<CharPr> charProperties, String name, Attributes attrs) {
        ((CharPropertiesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.CharProperties))
                .charProperties(charProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void tabProperties(ObjectList<TabPr> tabProperties, String name, Attributes attrs) {
        ((TabPropertiesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TabProperties))
                .tabProperties(tabProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void numberings(ObjectList<Numbering> numberings, String name, Attributes attrs) {
        ((NumberingsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Numberings))
                .numberings(numberings);

        xmlFileReader().startElement(name, attrs);
    }

    private void bullets(ObjectList<Bullet> bullets, String name, Attributes attrs) {
        ((BulletsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Bullets))
                .bullets(bullets);

        xmlFileReader().startElement(name, attrs);
    }

    private void paraProperties(ObjectList<ParaPr> paraProperties, String name, Attributes attrs) {
       ((ParaPropertiesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ParaProperties))
                .paraProperties(paraProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void styles(ObjectList<Style> styles, String name, Attributes attrs) {
        ((StylesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Styles))
                .styles(styles);

        xmlFileReader().startElement(name, attrs);
    }

    private void memoProperties(ObjectList<MemoPr> memoProperties, String name, Attributes attrs) {
        ((MemoPropertiesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.MemoProperties))
                .memoProperties(memoProperties);

        xmlFileReader().startElement(name, attrs);
    }

    private void trackChanges(ObjectList<TrackChange> trackChanges, String name, Attributes attrs) {
        ((TrackChangesReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChanges))
                .trackChanges(trackChanges);

        xmlFileReader().startElement(name, attrs);
    }

    private void trackChangeAuthors(ObjectList<TrackChangeAuthor> trackChangeAuthors, String name, Attributes attrs) {
        ((TrackChangeAuthorsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChangeAuthors))
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
