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
        return fromFile(new File(filepath));
    }

    public static HWPXFile fromFile(File file) throws Exception {
        HWPXReader reader = new HWPXReader();

        // zipFile 을 생성하게 되면 저 깊숙한 내부에서 RandomAccessFile 을 사용한다.
        // RandomAccessFile 을 안전하게 close 해 주려면, 예외 상황 발생시 zipFile 을 잘 닫아 주어야 한다.
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

        if ( zipEntry == null ) {
            throw new IOException(ErrorMessage.Not_HWPX_File);
        }

        InputStream is = null;
        try {
            is = zipFile.getInputStream(zipEntry);
        } catch (IOException e) {
            // stream 을 읽어 오지 못했기 때문에, HWPX 파일인지 조차도 모르지만, 에러 정의가 부족해서 이것을 활용한다.
            throw new IOException(ErrorMessage.Not_HWPX_File);
        }

        try {
            String text = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8)).readLine();

            if (!MineTypes.HWPX.equals(text)) {
                throw new IOException(ErrorMessage.Not_HWPX_File);
            }
        } finally {
            // Stream 을 사용하고 나면, 닫아 주는것을 잊지 말자.
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
                .read(hwpxFile.versionXMLFile(), zipFile);
    }

    private void containerXML() throws Exception {
        new ContainerXMLFileReader(entryReaderManager)
                .read(hwpxFile.containerXMLFile(), zipFile);
    }

    private void manifestXML() throws Exception {
        try {
            new ManifestXMLFileReader(entryReaderManager)
                    .read(hwpxFile.manifestXMLFile(), zipFile);
        } catch (Exception e) {
        }
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
        if ( zipFile != null ) {
            zipFile.close();
        }
    }
}
