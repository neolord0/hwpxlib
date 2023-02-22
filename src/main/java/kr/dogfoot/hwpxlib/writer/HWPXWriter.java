package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.CommonString;
import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.writer.settings_xml.SettingsWriter;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;
import kr.dogfoot.hwpxlib.writer.version_xml.VersionWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class HWPXWriter {
    public static void toFilePath(HWPXFile hwpxFile, String filepath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filepath);
        toStream(hwpxFile, fos);
    }

    public static void toStream(HWPXFile hwpxFile, OutputStream os) throws IOException {
        HWPXWriter writer = new HWPXWriter(hwpxFile);
        writer.createZIPFile(os);
        writer.write();
        writer.close();
        os.close();
    }

    public static byte[] toBytes(HWPXFile hwpxFile) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        toStream(hwpxFile, baos);
        return baos.toByteArray();
    }

    private final HWPXFile hwpxFile;
    private final XMLStringBuilder xsb;
    private ZipOutputStream zos;

    public HWPXWriter(HWPXFile hwpxFile) {
        this.hwpxFile = hwpxFile;
        xsb = new XMLStringBuilder();
    }

    public void createZIPFile(OutputStream outputStream) {
        zos = new ZipOutputStream(outputStream);
    }

    private void write() throws IOException {
        mineType();
        settings_xml();
        version_xml();
    }


    private void mineType() throws IOException {
        putIntoZip(CommonString.ZipEntry_MineType,
                CommonString.MineType_HWPX,
                StandardCharsets.UTF_8);
    }

    private void putIntoZip(String entryName, String data, Charset charset) throws IOException {
        zos.putNextEntry(new ZipEntry(entryName));
        byte[] bytes = data.getBytes(charset);
        zos.write(bytes, 0, bytes.length);
        zos.closeEntry();
    }

    private void settings_xml() throws IOException {
        if (hwpxFile.settingsXMLFile() == null) {
            return;
        }

        xsb.clear();
        SettingsWriter.write(hwpxFile.settingsXMLFile(), xsb);

        putIntoZip(CommonString.ZiPEntry_Settings, xsb.toString(), StandardCharsets.UTF_8);
    }

    private void version_xml() {
        if (hwpxFile.versionXMLFile() == null) {
            return;
        }

        xsb.clear();
        VersionWriter.write(hwpxFile.versionXMLFile(), xsb);
    }





    private void close() throws IOException {
        zos.close();
    }
}
