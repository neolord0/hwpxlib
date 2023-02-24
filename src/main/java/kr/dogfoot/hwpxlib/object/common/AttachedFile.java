package kr.dogfoot.hwpxlib.object.common;

public class AttachedFile {
    private byte[] data;

    public AttachedFile() {
    }

    public byte[] data() {
        return data;
    }

    public void data(byte[] data) {
        this.data = data;
    }

    public AttachedFile dataAnd(byte[] data) {
        this.data = data;
        return this;
    }
}
