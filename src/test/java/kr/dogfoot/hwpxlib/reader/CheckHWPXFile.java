package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import org.junit.Assert;
import org.junit.Test;

public class CheckHWPXFile {
    @Test
    public void openZip(){
        try {
            HWPXFile file  = HWPXReader.fromFilepath("testFile/reader_writer//sample1.hwpx");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void openNoZip() {
        try {
            HWPXReader.fromFilepath("testFile/reader_writer/section0.xml");
            Assert.fail();
        } catch (Exception e) {
        }
    }
}
