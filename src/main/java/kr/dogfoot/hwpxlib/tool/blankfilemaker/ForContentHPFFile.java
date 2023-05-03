package kr.dogfoot.hwpxlib.tool.blankfilemaker;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ContentHPFFile;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.content.context_hpf.MetaData;
import kr.dogfoot.hwpxlib.object.content.context_hpf.SpineItemRef;
import kr.dogfoot.hwpxlib.tool.util.DateTimeString;

import java.util.Calendar;
import java.util.Date;

public class ForContentHPFFile {
    public static void make(ContentHPFFile contentHPFFile) {
        contentHPFFile
                .versionAnd("")
                .uniqueIdentifierAnd("")
                .id("");

        contentHPFFile.createMetaData();
        metaData(contentHPFFile.metaData());

        contentHPFFile.createManifest();
        manifest(contentHPFFile.manifest());

        contentHPFFile.createSpine();
        spine(contentHPFFile.spine());
    }

    private static void metaData(MetaData metaData) {
        metaData.createTitle();

        metaData.createLanguage();
        metaData.language().addText("ko");

        metaData.addNewMeta()
                .nameAnd("creator")
                .contentAnd("text");

        metaData.addNewMeta()
                .nameAnd("subject")
                .content("text");

        metaData.addNewMeta()
                .nameAnd("description")
                .content("text");

        metaData.addNewMeta()
                .nameAnd("lastsaveby")
                .content("text");

        Date now = new Date();
        String dateString1 = DateTimeString.toGMTString(now);

        metaData.addNewMeta()
                .nameAnd("CreatedDate")
                .contentAnd("text")
                .text(dateString1);

        metaData.addNewMeta()
                .nameAnd("ModifiedDate")
                .contentAnd("text")
                .text(dateString1);

        metaData.addNewMeta()
                .nameAnd("date")
                .contentAnd("text")
                .text(DateTimeString.toString(Calendar.getInstance()));

        metaData.addNewMeta()
                .nameAnd("keyword")
                .content("text");
    }

    private static void manifest(ObjectList<ManifestItem> manifest) {
        manifest.addNew()
                .idAnd("header")
                .hrefAnd("Contents/header.xml")
                .mediaType("application/xml");

        manifest.addNew()
                .idAnd("section0")
                .hrefAnd("Contents/section0.xml")
                .mediaType("application/xml");

        manifest.addNew()
                .idAnd("settings")
                .hrefAnd("settings.xml")
                .mediaType("application/xml");
    }

    private static void spine(ObjectList<SpineItemRef> spine) {
        spine.addNew()
                .idref("header");

        spine.addNew()
                .idref("section0");
    }
}
