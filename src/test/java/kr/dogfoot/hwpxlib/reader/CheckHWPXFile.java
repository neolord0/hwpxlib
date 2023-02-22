package kr.dogfoot.hwpxlib.reader;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.fail;

public class CheckHWPXFile {
    @Test
    void openZip(){
        try {
            HWPXFile file  = HWPXReader.fromFilepath("testFile/sample1.hwpx");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void openNoZip() {
        try {
            HWPXReader.fromFilepath("testFile/section0.xml");
            fail();
        } catch (Exception e) {
        }
    }
}
