package kr.dogfoot.hwpxlib.reader.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileReader {
    public static byte[] readBinary(String zipEntryName, ZipFile zipFile) throws IOException {
        ZipEntry zipEntry = zipFile.getEntry(zipEntryName);
        if (zipEntry != null) {
            return readAllBytes(zipFile.getInputStream(zipEntry));
        }
        return null;
    }

    public static String readString(String href, ZipFile zipFile) throws IOException {
        return new String(readBinary(href, zipFile), StandardCharsets.UTF_16LE);
    }

    private static byte[] readAllBytes(InputStream inputStream) throws IOException {
        final int bufLen = 4 * 0x400; // 4KB
        byte[] buf = new byte[bufLen];
        int readLen;
        IOException exception = null;

        try {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
                    outputStream.write(buf, 0, readLen);

                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) inputStream.close();
            else try {
                inputStream.close();
            } catch (IOException e) {
                exception.addSuppressed(e);
            }
        }
    }
}
