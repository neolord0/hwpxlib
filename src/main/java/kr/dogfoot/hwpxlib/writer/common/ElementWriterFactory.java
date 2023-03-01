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
import kr.dogfoot.hwpxlib.writer.settings_xml.ConfigItemSetWriter;
import kr.dogfoot.hwpxlib.writer.settings_xml.SettingsWriter;

public class ElementWriterFactory {
    public static ElementWriter create(ElementWriterSort sort, ElementWriterManager elementWriterManager) {
        switch (sort) {
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
        }
        return new NothingWriter(elementWriterManager);
    }
}
