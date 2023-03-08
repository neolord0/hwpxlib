package kr.dogfoot.hwpxlib.writer.common;

import kr.dogfoot.hwpxlib.writer.VersionWriter;
import kr.dogfoot.hwpxlib.writer.contaier_xml.ContainerWriter;
import kr.dogfoot.hwpxlib.writer.contaier_xml.RootFilesWriter;
import kr.dogfoot.hwpxlib.writer.content_hpf.ContentManifestWriter;
import kr.dogfoot.hwpxlib.writer.content_hpf.ContentWriter;
import kr.dogfoot.hwpxlib.writer.content_hpf.MetaDataWriter;
import kr.dogfoot.hwpxlib.writer.content_hpf.SpineWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.DocOptionWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.ForbiddenWordListWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.HeaderWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.compatibledocument.CompatibleDocumentWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.compatibledocument.LayoutCompatibilityWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.*;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill.*;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.bullet.BulletWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.bullet.BulletsWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.charpr.CharPrWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.charpr.CharPropertiesWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.fontface.FontFaceWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.fontface.FontFacesWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.fontface.FontWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.numbering.NumberingWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.numbering.NumberingsWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.parapr.ParaMarginWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.parapr.ParaPrWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.parapr.ParaPropertiesWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.tabpr.TabPrWriter;
import kr.dogfoot.hwpxlib.writer.header_xml.reflist.tabpr.TabPropertiesWriter;
import kr.dogfoot.hwpxlib.writer.manifest_xml.EncryptionDataWriter;
import kr.dogfoot.hwpxlib.writer.manifest_xml.FileEntryWriter;
import kr.dogfoot.hwpxlib.writer.manifest_xml.ManifestWriter;
import kr.dogfoot.hwpxlib.writer.masterpage_xml.MasterPageWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.*;
import kr.dogfoot.hwpxlib.writer.section_xml.ctrl.*;
import kr.dogfoot.hwpxlib.writer.section_xml.object.*;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawTextWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.formobject.ButtonCoreWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.picture.*;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapecomponent.RenderingInfoWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject.CaptionWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.table.CellZoneListWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.table.TcWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.table.TrWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.textart.OutlineWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.object.textart.TextArtPrWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.secpr.*;
import kr.dogfoot.hwpxlib.writer.settings_xml.ConfigItemSetWriter;
import kr.dogfoot.hwpxlib.writer.settings_xml.SettingsWriter;

public class ElementWriterFactory {
    public static ElementWriter create(ElementWriterSort sort, ElementWriterManager elementWriterManager) {
        switch (sort) {
            case ParameterListCore:;
                return new ParameterListCoreWriter(elementWriterManager);
            case Version:
                return new VersionWriter(elementWriterManager);
            case Manifest:
                return new ManifestWriter(elementWriterManager);
            case FileEntry:
                return new FileEntryWriter(elementWriterManager);
            case EncryptionData:
                return new EncryptionDataWriter(elementWriterManager);
            case Container:
                return new ContainerWriter(elementWriterManager);
            case RootFiles:
                return new RootFilesWriter(elementWriterManager);
            case Content:
                return new ContentWriter(elementWriterManager);
            case MetaData:
                return new MetaDataWriter(elementWriterManager);
            case ContentManifest:
                return new ContentManifestWriter(elementWriterManager);
            case Spine:
                return new SpineWriter(elementWriterManager);
            case Settings:
                return new SettingsWriter(elementWriterManager);
            case ConfigItemSet:
                return new ConfigItemSetWriter(elementWriterManager);
            case Header:
                return new HeaderWriter(elementWriterManager);
            case RefList:
                return new RefListWriter(elementWriterManager);
            case FontFaces:
                return new FontFacesWriter(elementWriterManager);
            case FontFace:
                return new FontFaceWriter(elementWriterManager);
            case Font:
                return new FontWriter(elementWriterManager);
            case BorderFills:
                return new BorderFillsWriter(elementWriterManager);
            case BorderFill:
                return new BorderFillWriter(elementWriterManager);
            case FillBrush:
                return new FillBrushWriter(elementWriterManager);
            case Gradation:
                return new GradationWriter(elementWriterManager);
            case ImageBrush:
                return new ImageBrushWriter(elementWriterManager);
            case CharProperties:
                return new CharPropertiesWriter(elementWriterManager);
            case CharPr:
                return new CharPrWriter(elementWriterManager);
            case TabProperties:
                return new TabPropertiesWriter(elementWriterManager);
            case TabPr:
                return new TabPrWriter(elementWriterManager);
            case Numberings:
                return new NumberingsWriter(elementWriterManager);
            case Numbering:
                return new NumberingWriter(elementWriterManager);
            case Bullets:
                return new BulletsWriter(elementWriterManager);
            case Bullet:
                return new BulletWriter(elementWriterManager);
            case ParaProperties:
                return new ParaPropertiesWriter(elementWriterManager);
            case ParaPr:
                return new ParaPrWriter(elementWriterManager);
            case ParaMargin:
                return new ParaMarginWriter(elementWriterManager);
            case Styles:
                return new StylesWriter(elementWriterManager);
            case MemoProperties:
                return new MemoPropertiesWriter(elementWriterManager);
            case TrackChanges:
                return new TrackChangesWriter(elementWriterManager);
            case TrackChangeAuthors:
                return new TrackChangeAuthorsWriter(elementWriterManager);
            case ForbiddenWordList:
                return new ForbiddenWordListWriter(elementWriterManager);
            case CompatibleDocument:
                return new CompatibleDocumentWriter(elementWriterManager);
            case LayoutCompatibility:
                return new LayoutCompatibilityWriter(elementWriterManager);
            case DocOption:
                return new DocOptionWriter(elementWriterManager);
            case Section:
                return new SectionWriter(elementWriterManager);
            case SubList:
                return new SubListWriter(elementWriterManager);
            case Para:
                return new ParaWriter(elementWriterManager);
            case Run:
                return new RunWriter(elementWriterManager);
            case SecPr:
                return new SecPrWriter(elementWriterManager);
            case PagePr:
                return new PagePrWriter(elementWriterManager);
            case FootNotePr:
                return new FootNotePrWriter(elementWriterManager);
            case EndNotePr:
                return new EndNotePrWriter(elementWriterManager);
            case PageBorderFill:
                return new PageBorderFillWriter(elementWriterManager);
            case Presentation:
                return new PresentationWriter(elementWriterManager);
            case Ctrl:
                return new CtrlWriter(elementWriterManager);
            case ColPr:
                return new ColPrWriter(elementWriterManager);
            case FieldBegin:
                return new FieldBeginWriter(elementWriterManager);
            case HeaderFooter:
                return new HeaderFooterWriter(elementWriterManager);
            case FootNoteEndNote:
                return new FootNoteEndNoteWriter(elementWriterManager);
            case AutoNumNewNum:
                return new AutoNumNewNumWriter(elementWriterManager);
            case Indexmark:
                return new IndexmarkWriter(elementWriterManager);
            case HiddenComment:
                return new HiddenCommentWriter(elementWriterManager);
            case T:
                return new TWriter(elementWriterManager);
            case Caption:
                return new CaptionWriter(elementWriterManager);
            case Table:
                return new TableWriter(elementWriterManager);
            case CellZoneList:
                return new CellZoneListWriter(elementWriterManager);
            case Tr:
                return new TrWriter(elementWriterManager);
            case Tc:
                return new TcWriter(elementWriterManager);
            case Equation:
                return new EquationWriter(elementWriterManager);
            case Chart:
                return new ChartWriter(elementWriterManager);
            case RenderingInfo:
                return new RenderingInfoWriter(elementWriterManager);
            case Picture:
                return new PictureWriter(elementWriterManager);
            case ImageRect:
                return new ImageRectWriter(elementWriterManager);
            case Effects:
                return new EffectsWriter(elementWriterManager);
            case EffectsShadow:
                return new EffectsShadowWriter(elementWriterManager);
            case EffectsColor:
                return new EffectsColorWriter(elementWriterManager);
            case EffectsGlow:
                return new EffectsGlowWriter(elementWriterManager);
            case EffectsReflection:
                return new EffectsReflectionWriter(elementWriterManager);
            case OLE:
                return new OLEWriter(elementWriterManager);
            case ContainerControl:
                return new ContainerControlWriter(elementWriterManager);
            case DrawText:
                return new DrawTextWriter(elementWriterManager);
            case Line:
                return new LineWriter(elementWriterManager);
            case Rectangle:
                return new RectangleWriter(elementWriterManager);
            case Ellipse:
                return new EllipseWriter(elementWriterManager);
            case Arc:
                return new ArcWriter(elementWriterManager);
            case Polygon:
                return new PolygonWriter(elementWriterManager);
            case Curve:
                return new CurveWriter(elementWriterManager);
            case ConnectLine:
                return new ConnectLineWriter(elementWriterManager);
            case TextArt:
                return new TextArtWriter(elementWriterManager);
            case TextArtPr:
                return new TextArtPrWriter(elementWriterManager);
            case Outline:
                return new OutlineWriter(elementWriterManager);
            case Compose:
                return new ComposeWriter(elementWriterManager);
            case Dutmal:
                return new DutmalWriter(elementWriterManager);
            case ButtonCore:
                return new ButtonCoreWriter(elementWriterManager);
            case ComboBox:
                return new ComboBoxWriter(elementWriterManager);
            case Edit:
                return new EditWriter(elementWriterManager);
            case ListBox:
                return new ListBoxWriter(elementWriterManager);
            case ScrollBar:
                return new ScrollBarWriter(elementWriterManager);
            case Video:
                return new VideoWriter(elementWriterManager);
            case LineSegArray:
                return new LineSegArrayWriter(elementWriterManager);
            case MasterPage:
                return new MasterPageWriter(elementWriterManager);
        }
        return new NothingWriter(elementWriterManager);
    }
}
