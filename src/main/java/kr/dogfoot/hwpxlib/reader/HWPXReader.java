package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.commonstrings.ErrorMessage;
import kr.dogfoot.hwpxlib.commonstrings.MineTypes;
import kr.dogfoot.hwpxlib.commonstrings.ZipEntryName;
import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ManifestItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Chart;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderManager;
import kr.dogfoot.hwpxlib.reader.util.ZipFileReader;

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

        reader.read();

        reader.closeZipFile();

        return reader.hwpxFile;
    }

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
        ZipEntry zipEntry = zipFile.getEntry(ZipEntryName.MineType);
        if (zipEntry != null) {
            InputStream is = zipFile.getInputStream(zipEntry);

            String text = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            if (!MineTypes.HWPX.equals(text)) {
                throw new IOException(ErrorMessage.Not_HWPX_File);
            }
        } else {
            throw new IOException(ErrorMessage.Not_HWPX_File);
        }
    }

    private void createHWPXFileObject() {
        hwpxFile = new HWPXFile();
    }


    private void read() throws Exception {
        versionXML();
        containerXML();
        manifestXML();
        contentHPF();
        packagedFiles();
        etcContainedFile();
    }


    private void versionXML() throws Exception {
        new VersionXMLFileReader(entryReaderManager)
                .read(hwpxFile.versionXMLFile(), zipFile);
    }

    private void containerXML() throws Exception {
        new ContainerXMLFileReader(entryReaderManager)
                .read(hwpxFile.containerXMLFile(), zipFile);
    }

    private void manifestXML() throws Exception {
        new ManifestXMLFileReader(entryReaderManager)
                .read(hwpxFile.manifestXMLFile(), zipFile);
    }

    private void contentHPF() throws Exception {
        String packageXMLFilePath = hwpxFile.containerXMLFile().packageXMLFilePath();
        if (packageXMLFilePath != null) {
            new ContentHPFFileReader(entryReaderManager)
                    .read(hwpxFile.contentHPFFile(), zipFile, packageXMLFilePath);
        }
    }

    private void packagedFiles() throws Exception {
        ContentFilesReader contentFilesReader = new ContentFilesReader(entryReaderManager);

        for (ManifestItem item : hwpxFile.contentHPFFile().manifest().items()) {
            if (MineTypes.XML.equals(item.mediaType())) {
                contentFilesReader.read(hwpxFile, item.href(), zipFile);
            } else if (item.hasAttachedFile()) {
                item.createAttachedFile();
                item.attachedFile().data(ZipFileReader.readBinary(item.href(), zipFile));
            }
        }

        for (Chart chart : contentFilesReader.charts()) {
            hwpxFile.chartXMLFileList().addNew()
                    .pathAnd(chart.chartIDRef())
                    .data(ZipFileReader.readBinary(chart.chartIDRef(), zipFile));
        }
    }

    private void etcContainedFile() throws IOException {
        if (hwpxFile.containerXMLFile() != null &&
                hwpxFile.containerXMLFile().rootFiles() != null) {
            for (RootFile rootFile : hwpxFile.containerXMLFile().rootFiles().items()) {
                if (!MineTypes.HWPML_Package.equals(rootFile.mediaType())) {
                    rootFile.createAttachedFile();
                    rootFile.attachedFile().data(ZipFileReader.readBinary(rootFile.fullPath(), zipFile));
                }
            }
        }
    }


    private void closeZipFile() throws IOException {
        zipFile.close();
    }
}
