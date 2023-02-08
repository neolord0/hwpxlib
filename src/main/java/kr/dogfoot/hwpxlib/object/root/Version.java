package kr.dogfoot.hwpxlib.object.root;

/**
 * 버전 정보
 */
public class Version {
    private Integer major;
    private Integer minor;
    private Integer micro;
    private Integer buildNumber;

    public Version() {
    }

    public Integer major() {
        return major;
    }

    public void major(Integer major) {
        this.major = major;
    }

    public Version majorAnd(Integer major) {
        this.major = major;
        return this;
    }

    public Integer minor() {
        return minor;
    }

    public void minor(Integer minor) {
        this.minor = minor;
    }

    public Version minorAnd(Integer minor) {
        this.minor = minor;
        return this;
    }

    public Integer micro() {
        return micro;
    }

    public void micro(Integer micro) {
        this.micro = micro;
    }

    public Version microAnd(Integer micro) {
        this.micro = micro;
        return this;
    }

    public Integer buildNumber() {
        return buildNumber;
    }

    public void buildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Version buildNumberAnd(Integer buildNumber) {
        this.buildNumber = buildNumber;
        return this;
    }
}
