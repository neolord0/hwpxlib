package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.reader.HWPXReader;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.header_xml.HeaderWriter;
import kr.dogfoot.hwpxlib.writer.section_xml.SectionWriter;
import kr.dogfoot.hwpxlib.writer.settings_xml.SettingsWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipFile;

public class TestUtil {
    public static Result headerXML(String hwpxFilepath) throws Exception {
        String originXML = zipFileString(hwpxFilepath, "Contents/header.xml", StandardCharsets.UTF_8);
        String madeXML = makeHeaderXML(hwpxFilepath);
        return new Result(madeXML, originXML);
    }

    public static Result sectionXML(String hwpxFilepath) throws Exception {
        String originXML = zipFileString(hwpxFilepath, "Contents/section0.xml", StandardCharsets.UTF_8);
        String madeXML = makeSectionXML(hwpxFilepath);
        return new Result(madeXML, originXML);
    }

    public static Result settingsXML(String hwpxFilepath) throws Exception {
        String originXML = zipFileString(hwpxFilepath, "settings.xml", StandardCharsets.UTF_8);
        String madeXML = makeSettingsXML(hwpxFilepath);
        return new Result(madeXML, originXML);
    }


    private static String zipFileString(String filePath, String zipEntryName, Charset charset) throws IOException {
        ZipFile zipFile = new ZipFile(filePath);

        InputStream is = zipFile.getInputStream(zipFile.getEntry(zipEntryName));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int length;
        byte[] buffer = new byte[2048];
        try {
            while ((length = is.read(buffer, 0, buffer.length)) != -1) {
                bos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(bos.toByteArray(), charset);
    }

    private static String makeHeaderXML(String hwpxFilepath) throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath(hwpxFilepath);
        ElementWriterManager manager = new ElementWriterManager();
        new HeaderWriter(manager).write(hwpxFile.headerXMLFile());
        String madeXML = manager.xsb().toString();
        return madeXML;
    }

    private static String makeSectionXML(String hwpxFilepath) throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath(hwpxFilepath);
        ElementWriterManager manager = new ElementWriterManager();
        new SectionWriter(manager).write(hwpxFile.sectionXMLFileList().get(0));
        String madeXML = manager.xsb().toString();
        return madeXML;
    }


    private static String makeSettingsXML(String hwpxFilepath) throws Exception {
        HWPXFile hwpxFile = HWPXReader.fromFilepath(hwpxFilepath);
        ElementWriterManager manager = new ElementWriterManager();
        new SettingsWriter(manager).write(hwpxFile.settingsXMLFile());
        String madeXML = manager.xsb().toString();
        return madeXML;
    }


    public static class Result {
        private String actual;
        private String expected;

        public Result(String actual, String expected) {
            this.actual = actual;
            this.expected = expected;
        }

        public String actual() {
            return actual;
        }

        public String expected() {
            return expected;
        }
    }

}
