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
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class HWPXReader {
    public static HWPXFile fromFilepath(String filepath) throws Exception {
        return fromFile(new File(filepath), true);
    }

    public static HWPXFile fromFile(File file) throws Exception {
        return fromFile(file, true);
    }

    public static HWPXFile fromFilepath(String filepath, boolean xmlNamespaceAware) throws Exception {
        return fromFile(new File(filepath), xmlNamespaceAware);
    }

    public static HWPXFile fromFile(File file, boolean xmlNamespaceAware) throws Exception {
        HWPXReader reader = new HWPXReader(xmlNamespaceAware);

        try {
            reader.openZipFile(file);
            reader.checkMineType();
            reader.createHWPXFileObject();
            reader.read();
        } finally {
            reader.closeZipFile();
        }

        return reader.hwpxFile;
    }

    private boolean xmlNamespaceAware = true;
    private ZipFile zipFile;
    private HWPXFile hwpxFile;
    private ElementReaderManager entryReaderManager;

    public HWPXReader(boolean xmlNamespaceAware) {
        this.xmlNamespaceAware = xmlNamespaceAware;
        zipFile = null;
        hwpxFile = null;
        entryReaderManager = new ElementReaderManager();
    }

    private void openZipFile(File file) throws IOException {
        zipFile = new ZipFile(file);
    }

    public void checkMineType() throws IOException {
        ZipEntry zipEntry = zipFile.getEntry(ZipEntryName.MineType);
        if (zipEntry == null) throw new IOException(ErrorMessage.Not_HWPX_File);

        InputStream is = null;
        try {
            is = zipFile.getInputStream(zipEntry);
        } catch (IOException e) {
            throw new IOException(ErrorMessage.Not_HWPX_File);
        }

        try {
            String text = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).readLine();

            if (!MineTypes.HWPX.equals(text)) {
                throw new IOException(ErrorMessage.Not_HWPX_File);
            }
        } finally {
            is.close();
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
                .read(hwpxFile.versionXMLFile(), zipFile, xmlNamespaceAware);
    }

    private void containerXML() throws Exception {
        new ContainerXMLFileReader(entryReaderManager)
                .read(hwpxFile.containerXMLFile(), zipFile, xmlNamespaceAware);
    }

    private void manifestXML() {
        try {
            new ManifestXMLFileReader(entryReaderManager)
                    .read(hwpxFile.manifestXMLFile(), zipFile, xmlNamespaceAware);
        } catch (Exception e) {
        }
    }

    private void contentHPF() throws Exception {
        String packageXMLFilePath = hwpxFile.containerXMLFile().packageXMLFilePath();
        if (packageXMLFilePath == null) return;

        new ContentHPFFileReader(entryReaderManager)
                .read(hwpxFile.contentHPFFile(), zipFile, packageXMLFilePath, xmlNamespaceAware);
    }

    private void packagedFiles() throws Exception {
        ContentFilesReader contentFilesReader = new ContentFilesReader(entryReaderManager);

        for (ManifestItem item : hwpxFile.contentHPFFile().manifest().items()) {
            if (MineTypes.XML.equals(item.mediaType())) {
                contentFilesReader.read(hwpxFile, item.href(), zipFile, xmlNamespaceAware);

                if (contentFilesReader.stoppedParsing()) {
                    addUnparsedXMLFile(item.href());
                }
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

    private void addUnparsedXMLFile(String href) throws IOException {
        hwpxFile.addUnparsedXMLFile(href,
                new String(ZipFileReader.readBinary(href, zipFile)));
    }

    private void etcContainedFile() throws IOException {
        if (hwpxFile.containerXMLFile() == null || hwpxFile.containerXMLFile().rootFiles() == null) return;

        for (RootFile rootFile : hwpxFile.containerXMLFile().rootFiles().items()) {
            if (!MineTypes.HWPML_Package.equals(rootFile.mediaType())) {
                rootFile.createAttachedFile();
                rootFile.attachedFile().data(ZipFileReader.readBinary(rootFile.fullPath(), zipFile));
            }
        }
    }

    private void closeZipFile() throws IOException {
        if (zipFile == null) return;

        zipFile.close();
    }
}
