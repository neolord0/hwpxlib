package kr.dogfoot.hwpxlib.object.content;

public class BinaryDataFile {
    private String fileName;
    private byte[] data;

    public BinaryDataFile() {
    }

    public String fileName() {
        return fileName;
    }

    public void fileName(String fileName) {
        this.fileName = fileName;
    }

    public BinaryDataFile fileNameAnd(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public byte[] data() {
        return data;
    }

    public void data(byte[] data) {
        this.data = data;
    }

    public BinaryDataFile dataAnd(byte[] data) {
        this.data = data;
        return this;
    }
}
