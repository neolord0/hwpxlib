package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.reader.common.baseobject.*;
import kr.dogfoot.hwpxlib.reader.common.compatibility.CaseReader;
import kr.dogfoot.hwpxlib.reader.common.compatibility.DefaultReader;
import kr.dogfoot.hwpxlib.reader.common.compatibility.SwitchReader;
import kr.dogfoot.hwpxlib.reader.common.parameter.*;
import kr.dogfoot.hwpxlib.reader.container_xml.ContainerReader;
import kr.dogfoot.hwpxlib.reader.container_xml.RootFileReader;
import kr.dogfoot.hwpxlib.reader.container_xml.RootFilesReader;
import kr.dogfoot.hwpxlib.reader.content_hpf.*;
import kr.dogfoot.hwpxlib.reader.header_xml.*;
import kr.dogfoot.hwpxlib.reader.header_xml.borderfill.*;
import kr.dogfoot.hwpxlib.reader.header_xml.bullet.BulletReader;
import kr.dogfoot.hwpxlib.reader.header_xml.bullet.BulletsReader;
import kr.dogfoot.hwpxlib.reader.header_xml.charpr.*;
import kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument.CompatibleDocumentReader;
import kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument.LayoutCompatibilityItemReader;
import kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument.LayoutCompatibilityReader;
import kr.dogfoot.hwpxlib.reader.header_xml.docoption.DocOptionReader;
import kr.dogfoot.hwpxlib.reader.header_xml.docoption.LinkInfoReader;
import kr.dogfoot.hwpxlib.reader.header_xml.fontface.*;
import kr.dogfoot.hwpxlib.reader.header_xml.memopr.MemoPrReader;
import kr.dogfoot.hwpxlib.reader.header_xml.memopr.MemoPropertiesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.NumberingReader;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.NumberingsReader;
import kr.dogfoot.hwpxlib.reader.header_xml.numbering.ParaHeadReader;
import kr.dogfoot.hwpxlib.reader.header_xml.parapr.*;
import kr.dogfoot.hwpxlib.reader.header_xml.style.StyleReader;
import kr.dogfoot.hwpxlib.reader.header_xml.style.StylesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.tabpr.TabItemReader;
import kr.dogfoot.hwpxlib.reader.header_xml.tabpr.TabPrReader;
import kr.dogfoot.hwpxlib.reader.header_xml.tabpr.TabPropertiesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchange.TrackChangeReader;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchange.TrackChangesReader;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchangeauthor.TrackChangeAuthorReader;
import kr.dogfoot.hwpxlib.reader.header_xml.trackchangeauthor.TrackChangeAuthorsReader;
import kr.dogfoot.hwpxlib.reader.manifest_xml.*;
import kr.dogfoot.hwpxlib.reader.masterpage_xml.MasterPageReader;
import kr.dogfoot.hwpxlib.reader.section_xml.*;
import kr.dogfoot.hwpxlib.reader.section_xml.ctrl.*;
import kr.dogfoot.hwpxlib.reader.section_xml.object.*;
import kr.dogfoot.hwpxlib.reader.section_xml.object.connectline.ConnectLinePointReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.connectline.ControlPointsReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.connectline.PointForControlPointsReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.drawingobject.DrawTextReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.drawingobject.DrawingShadowReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.etc.*;
import kr.dogfoot.hwpxlib.reader.section_xml.object.formobject.ButtonCoreReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.formobject.FormCharPrReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.picture.ImageDimReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.picture.ImageRectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.picture.LineShapeReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.picture.effects.*;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent.FlipReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent.MatrixReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent.RenderingInfoReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent.RotationInfoReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.CaptionReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapePositionReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapeSizeReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.table.*;
import kr.dogfoot.hwpxlib.reader.section_xml.secpr.*;
import kr.dogfoot.hwpxlib.reader.section_xml.t.*;
import kr.dogfoot.hwpxlib.reader.settings_xml.CaretPositionReader;
import kr.dogfoot.hwpxlib.reader.settings_xml.ConfigItemReader;
import kr.dogfoot.hwpxlib.reader.settings_xml.ConfigItemSetReader;
import kr.dogfoot.hwpxlib.reader.settings_xml.SettingsReader;
import kr.dogfoot.hwpxlib.reader.version_xml.VersionReader;
import kr.dogfoot.hwpxlib.reader.versionlog_xml.*;

public class ElementReaderFactory {
    public static ElementReader create(ElementReaderSort sort) {
        switch (sort.type()) {
            case Basic:
                return createElementReaderForBasic(sort);
            case Package:
                return createElementReaderForPackage(sort);
            case Header:
                return createElementReaderForHeader(sort);
            case Section_MasterPage:
                return createElememntReaderForSectionMasterPage(sort);
            case Controls:
                return createElementReaderForControls(sort);
            case History:
                return createElementReaderForHistory(sort);
        }
        return null;
    }


    private static ElementReader createElementReaderForBasic(ElementReaderSort sort) {
        switch (sort) {
            case Unreadable:
                return new UnreadableElementReader();
            case Empty:
                return new NoAttributeNoChildReader();
            case Switch:
                return new SwitchReader();
            case Case:
                return new CaseReader();
            case Default:
                return new DefaultReader();
            case HasOnlyText:
                return new HasOnlyTextReader();
            case LeftRightTopBottom:
                return new LeftRightTopBottomReader();
            case WidthAndHeight:
                return new WidthAndHeightReader();
            case StartAndEndFloat:
                return new StartAndEndFloatReader();
            case XAndY:
                return new XAndYReader();
            case XAndYFloat:
                return new XAndYFloatReader();
            case Point:
                return new PointReader();
            case UnknownElement:
                return new UnknownElementReader();
            case ParameterList:
                return new ParameterListReader();
            case IntegerParam:
                return new IntegerParamReader();
            case UnsignedIntegerParam:
                return new UnsignedIntegerParamReader();
            case StringParam:
                return new StringParamReader();
            case BooleanParam:
                return new BooleanParamReader();
            case FloatParam:
                return new FloatParamReader();
            case ListParam:
                return new ListParamReader();
        }
        return null;
    }

    private static ElementReader createElementReaderForPackage(ElementReaderSort sort) {
        switch (sort) {
            case Version:
                return new VersionReader();
            case Manifest:
                return new ManifestReader();
            case FileEntry:
                return new FileEntryReader();
            case EncryptionData:
                return new EncryptionDataReader();
            case Algorithm:
                return new AlgorithmReader();
            case KeyDerivation:
                return new KeyDerivationReader();
            case StartKeyGeneration:
                return new StartKeyGenerationReader();
            case Container:
                return new ContainerReader();
            case RootFiles:
                return new RootFilesReader();
            case RootFile:
                return new RootFileReader();
            case Package:
                return new PackageReader();
            case Metadata:
                return new MetadataReader();
            case Meta:
                return new MetaReader();
            case PackageManifest:
                return new PackageManifestReader();
            case ManifestItem:
                return new ManifestItemReader();
            case Spine:
                return new SpineReader();
            case SpineItemRef:
                return new SpineItemRefReader();
            case Settings:
                return new SettingsReader();
            case CaretPosition:
                return new CaretPositionReader();
            case ConfigItemSet:
                return new ConfigItemSetReader();
            case ConfigItem:
                return new ConfigItemReader();
        }
        return null;
    }

    private static ElementReader createElementReaderForHeader(ElementReaderSort sort) {
        switch (sort) {
            case Head:
                return new HeadReader();
            case BeginNum:
                return new BeginNumReader();
            case RefList:
                return new RefListReader();
            case Fontfaces:
                return new FontfacesReader();
            case Fontface:
                return new FontfaceReader();
            case Font:
                return new FontReader();
            case SubstFont:
                return new SubstFontReader();
            case TypeInfo:
                return new TypeInfoReader();
            case BorderFills:
                return new BorderFillsReader();
            case BorderFill:
                return new BorderFillReader();
            case SlashCore:
                return new SlashCoreReader();
            case Border:
                return new BorderReader();
            case FillBrush:
                return new FillBrushReader();
            case WinBrush:
                return new WinBrushReader();
            case Gradation:
                return new GradationReader();
            case Color:
                return new ColorReader();
            case ImageBrush:
                return new ImageBrushReader();
            case Image:
                return new ImageReader();
            case CharProperties:
                return new CharPropertiesReader();
            case CharPr:
                return new CharPrReader();
            case StringValuesByLanguageReader:
                return new StringValuesByLanguageReader();
            case ShortValuesByLanguageReader:
                return new ShortValuesByLanguageReader();
            case Underline:
                return new UnderlineReader();
            case Strikeout:
                return new StrikeoutReader();
            case Outline:
                return new OutlineReader();
            case CharShadow:
                return new CharShadowReader();
            case TabProperties:
                return new TabPropertiesReader();
            case TabPr:
                return new TabPrReader();
            case TabItem:
                return new TabItemReader();
            case Numberings:
                return new NumberingsReader();
            case Numbering:
                return new NumberingReader();
            case ParaHead:
                return new ParaHeadReader();
            case Bullets:
                return new BulletsReader();
            case Bullet:
                return new BulletReader();
            case ParaProperties:
                return new ParaPropertiesReader();
            case ParaPr:
                return new ParaPrReader();
            case Align:
                return new AlignReader();
            case Heading:
                return new HeadingReader();
            case BreakSetting:
                return new BreakSettingReader();
            case ParaMargin:
                return new ParaMarginReader();
            case ValueAndUnit:
                return new ValueAndUnitReader();
            case LineSpacing:
                return new LineSpacingReader();
            case ParaBorder:
                return new ParaBorderReader();
            case AutoSpacing:
                return new AutoSpacingReader();
            case Styles:
                return new StylesReader();
            case Style:
                return new StyleReader();
            case MemoProperties:
                return new MemoPropertiesReader();
            case MemoPr:
                return new MemoPrReader();
            case TrackChanges:
                return new TrackChangesReader();
            case TrackChange:
                return new TrackChangeReader();
            case TrackChangeAuthors:
                return new TrackChangeAuthorsReader();
            case TrackChangeAuthor:
                return new TrackChangeAuthorReader();
            case ForbiddenWordList:
                return new ForbiddenWordListReader();
            case ForbiddenWord:
                return new ForbiddenWordReader();
            case CompatibleDocument:
                return new CompatibleDocumentReader();
            case LayoutCompatibility:
                return new LayoutCompatibilityReader();
            case LayoutCompatibilityItem:
                return new LayoutCompatibilityItemReader();
            case DocOption:
                return new DocOptionReader();
            case LinkInfo:
                return new LinkInfoReader();
            case TrackChangeConfig:
                return new TrackChangeConfigReader();
        }
        return null;
    }

    private static ElementReader createElememntReaderForSectionMasterPage(ElementReaderSort sort) {
        switch (sort) {
            case Sec:
                return new SecReader();
            case SubList:
                return new SubListReader();
            case Para:
                return new ParaReader();
            case Run:
                return new RunReader();
            case SecPr:
                return new SecPrReader();
            case Grid:
                return new GridReader();
            case StartNum:
                return new StartNumReader();
            case Visibility:
                return new VisibilityReader();
            case LineNumberShape:
                return new LineNumberShapeReader();
            case PagePr:
                return new PagePrReader();
            case PageMargin:
                return new PageMarginReader();
            case FootNotePr:
                return new FootNotePrReader();
            case AutoNumFormat:
                return new AutoNumFormatReader();
            case NoteLine:
                return new NoteLineReader();
            case NoteSpacing:
                return new NoteSpacingReader();
            case FootNoteNumbering:
                return new FootNoteNumberingReader();
            case FootNotePlacement:
                return new FootNotePlacementReader();
            case EndNotePr:
                return new EndNotePrReader();
            case EndNoteNumbering:
                return new EndNoteNumberingReader();
            case EndNotePlacement:
                return new EndNotePlacementReader();
            case PageBorderFill:
                return new PageBorderFillReader();
            case Presentation:
                return new PresentationReader();
            case Ctrl:
                return new CtrlReader();
            case ColPr:
                return new ColPrReader();
            case ColSz:
                return new ColSzReader();
            case ColLine:
                return new ColLineReader();
            case FieldBegin:
                return new FieldBeginReader();
            case FieldEnd:
                return new FieldEndReader();
            case Bookmark:
                return new BookmarkReader();
            case HeaderFooter:
                return new HeaderFooterReader();
            case FootNoteEndNote:
                return new FootNoteEndNoteReader();
            case AutoNumNewNum:
                return new AutoNumNewNumReader();
            case PageNumCtrl:
                return new PageNumCtrlReader();
            case PageHiding:
                return new PageHidingReader();
            case PageNum:
                return new PageNumReader();
            case Indexmark:
                return new IndexmarkReader();
            case HiddenComment:
                return new HiddenCommentReader();
            case T:
                return new TReader();
            case MarkpenBegin:
                return new MarkpenBeginReader();
            case TitleMark:
                return new TitleMarkReader();
            case Tab:
                return new TabReader();
            case TrackChangeTag:
                return new TrackChangeTagReader();
            case LineSegArray:
                return new LineSegArrayReader();
            case LineSeg:
                return new LineSegReader();
            case MasterPage:
                return new MasterPageReader();
        }
        return null;
    }


    private static ElementReader createElementReaderForControls(ElementReaderSort sort) {
        switch (sort) {
            case ShapeSize:
                return new ShapeSizeReader();
            case ShapePosition:
                return new ShapePositionReader();
            case Caption:
                return new CaptionReader();
            case Tbl:
                return new TableReader();
            case CellZoneList:
                return new CellzoneListReader();
            case CellZone:
                return new CellZoneReader();
            case Tr:
                return new TrReader();
            case Tc:
                return new TcReader();
            case CellAddr:
                return new CellAddrReader();
            case CellSpan:
                return new CellSpanReader();
            case Equation:
                return new EquationReader();
            case Chart:
                return new ChartReader();
            case Flip:
                return new FlipReader();
            case RotationInfo:
                return new RotationInfoReader();
            case RenderingInfo:
                return new RenderingInfoReader();
            case Matrix:
                return new MatrixReader();
            case Pic:
                return new PictureReader();
            case LineShape:
                return new LineShapeReader();
            case ImageRect:
                return new ImageRectReader();
            case ImageDim:
                return new ImageDimReader();
            case Effects:
                return new EffectsReader();
            case EffectsShadow:
                return new EffectsShadowReader();
            case EffectsColor:
                return new EffectsColorReader();
            case ColorRGB:
                return new ColorRGBReader();
            case ColorCMYK:
                return new ColorCMYKReader();
            case ColorScheme:
                return new ColorSchemeReader();
            case ColorSystem:
                return new ColorSystemReader();
            case ColorEffect:
                return new ColorEffectReader();
            case EffectsGlow:
                return new EffectsGlowReader();
            case EffectsSoftEdge:
                return new EffectsSoftEdgeReader();
            case EffectsReflection:
                return new EffectsReflectionReader();
            case ContainerControl:
                return new ContainerControlReader();
            case OLE:
                return new OLEReader();
            case DrawText:
                return new DrawTextReader();
            case DrawingShadow:
                return new DrawingShadowReader();
            case Line:
                return new LineReader();
            case Rect:
                return new RectangleReader();
            case Ellipse:
                return new EllipseReader();
            case Arc:
                return new ArcReader();
            case Polygon:
                return new PolygonReader();
            case Curve:
                return new CurveReader();
            case CurveSegment:
                return new CurveSegmentReader();
            case ConnectLine:
                return new ConnectLineReader();
            case ConnectLinePoint:
                return new ConnectLinePointReader();
            case ControlPoints:
                return new ControlPointsReader();
            case PointForControlPoints:
                return new PointForControlPointsReader();
            case TextArt:
                return new TextArtReader();
            case TextArtPr:
                return new TextArtPrReader();
            case PointList:
                return new PointListReader();
            case FormCharPr:
                return new FormCharPrReader();
            case ButtonCore:
                return new ButtonCoreReader();
            case ComboBox:
                return new ComboBoxReader();
            case ListItem:
                return new ListItemReader();
            case ListBox:
                return new ListBoxReader();
            case Edit:
                return new EditReader();
            case ScrollBar:
                return new ScrollBarReader();
            case Video:
                return new VideoReader();
            case Compose:
                return new ComposeReader();
            case ComposeCharPr:
                return new ComposeCharPrReader();
            case Dutmal:
                return new DutmalReader();
        }
        return null;
    }

    private static ElementReader createElementReaderForHistory(ElementReaderSort sort) {
        switch (sort) {
            case History:
                return new HistoryReader();
            case HistoryEntry:
                return new HistoryEntryReader();
            case FilePartDiff:
                return new FilePartDiffReader();
            case InsertDiff:
                return new InsertDiffReader();
            case UpdateDiff:
                return new UpdateDiffReader();
            case DeleteDiff:
                return new DeleteDiffReader();
        }
        return null;
    }
}
