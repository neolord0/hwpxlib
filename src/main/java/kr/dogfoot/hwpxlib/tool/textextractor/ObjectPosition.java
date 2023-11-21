package kr.dogfoot.hwpxlib.tool.textextractor;

public class ObjectPosition {
    private int paraIndex;
    private int runIndex;
    private int runItemIndex;
    private int ctrlItemIndex;

    public ObjectPosition() {
        this.paraIndex = -1;
        this.runIndex = -1;
        this.runItemIndex = -1;
        this.ctrlItemIndex = -1;
    }

    public void set(int paraIndex, int runIndex, int runItemIndex, int ctrlItemIndex) {
        this.paraIndex = paraIndex;
        this.runIndex = runIndex;
        this.runItemIndex = runItemIndex;
        this.ctrlItemIndex = ctrlItemIndex;
    }

    public int paraIndex() {
        return paraIndex;
    }

    public int runIndex() {
        return runIndex;
    }

    public int runItemIndex() {
        return runItemIndex;
    }

    public int ctrlItemIndex() {
        return ctrlItemIndex;
    }

    public String debug() {
        return paraIndex + ";" + runIndex + ";" + runItemIndex + ";" + ctrlItemIndex;
    }

}
