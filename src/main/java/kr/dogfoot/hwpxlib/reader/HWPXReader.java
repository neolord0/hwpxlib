package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.util.ZipFileReader;
import kr.dogfoot.hwpxlib.CommonString;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class HWPXReader {

    public static HWPXFile fromFilepath(String filepath) throws Exception {
        return fromFile(new File(filepath));
    }

    public static HWPXFile fromFile(File file) throws Exception {
        HWPXReader reader = new HWPXReader();
        reader.openZipFile(file);
        reader.checkMineType();

        reader.createHWPXFileObject();

        reader.readVersionXMLFile();
        reader.readManifestXMLFile();
        reader.readContainerXMLFile();
        reader.readPackageXMLFile();
        reader.readContentFiles();

        reader.closeZipFile();

        return reader.hwpxFile;
    }

    private static final String MineType_XML = "application/xml";
    private static final String BinDataPath = "BinData/";
    private static final String ScriptsPath = "Scripts/";
    private static final String Package_Media_Type = "application/hwpml-package+xml";

    private ZipFile zipFile;
    private HWPXFile hwpxFile;
    private ElementReaderManager entryReaderManager;

    public HWPXReader() {
        zipFile = null;
        hwpxFile = null;
        entryReaderManager = new ElementReaderManager();
    }

    private void openZipFile(File file) throws IOException {
        zipFile = new ZipFile(file);
    }

    public void checkMineType() throws IOException {
        ZipEntry zipEntry = zipFile.getEntry(CommonString.ZipEntry_MineType);
        if (zipEntry != null) {
            InputStream is = zipFile.getInputStream(zipEntry);

            String text = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            if (!CommonString.MineType_HWPX.equals(text)) {
                throw new IOException(CommonString.Error_Not_HWPX_File);
            }
        } else {
            throw new IOException(CommonString.Error_Not_HWPX_File);
        }
    }

    private void createHWPXFileObject() {
        hwpxFile = new HWPXFile();
    }

    private void readVersionXMLFile() throws Exception {
        new VersionXMLFileReader(entryReaderManager)
                .read(hwpxFile.versionXMLFile(), zipFile);
    }

    private void readManifestXMLFile() throws Exception {
        new ManifestXMLFileReader(entryReaderManager)
                .read(hwpxFile.manifestXMLFile(), zipFile);
    }

    private void readContainerXMLFile() throws Exception {
        new ContainerXMLFileReader(entryReaderManager)
                .read(hwpxFile.containerXMLFile(), zipFile);
    }

    private void readPackageXMLFile() throws Exception {
        String packageXMLFilePath = packageXMLFilePath();
        new PackageXMLFileReader(entryReaderManager)
                .read(hwpxFile.contentHPFFile(), zipFile, packageXMLFilePath);
    }

    private String packageXMLFilePath() {
        if (hwpxFile.containerXMLFile() != null &&
                hwpxFile.containerXMLFile().rootFiles() != null) {
            for (RootFile rootFile : hwpxFile.containerXMLFile().rootFiles().items()) {
                if (Package_Media_Type.equals(rootFile.mediaType())) {
                    return rootFile.fullPath();
                }
            }
        }
        return null;
    }


    private void readContentFiles() throws Exception {
        ContentFilesReader contentFilesReader = new ContentFilesReader(entryReaderManager);

        for (ManifestItem item : hwpxFile.contentHPFFile().manifest().items()) {
            if (MineType_XML.equals(item.mediaType())) {
                contentFilesReader.read(hwpxFile, item.href(), zipFile);
            } else if (item.href().startsWith(BinDataPath)) {
                hwpxFile.binaryDataFileList().addNew()
                        .fileNameAnd(item.href().substring(8))
                        .data(ZipFileReader.readBinary(item.href(), zipFile));
            } else if (item.href().startsWith(ScriptsPath)) {
                hwpxFile.scriptFileList().addNew()
                        .fileNameAnd(item.href().substring(8))
                        .script(ZipFileReader.readString(item.href(), zipFile));
            }
        }
    }

    private void closeZipFile() throws IOException {
        zipFile.close();
    }
}
