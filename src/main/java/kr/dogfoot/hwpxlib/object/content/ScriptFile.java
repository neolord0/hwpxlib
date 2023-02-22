package kr.dogfoot.hwpxlib.object.content;

public class ScriptFile {
    private String fileName;
    private String script;

    public ScriptFile() {
    }


    public String fileName() {
        return fileName;
    }

    public void fileName(String fileName) {
        this.fileName = fileName;
    }

    public ScriptFile fileNameAnd(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String script() {
        return script;
    }

    public void script(String script) {
        this.script = script;
    }

    public ScriptFile scriptAnd(String script) {
        this.script = script;
        return this;
    }
}
