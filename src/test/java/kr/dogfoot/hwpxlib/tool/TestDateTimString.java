package kr.dogfoot.hwpxlib.tool;

import kr.dogfoot.hwpxlib.tool.util.DateTimeString;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TestDateTimString {
    @Test
    public void test() {
        Date date = new Date();
        date.setYear(2012-1900);
        date.setMonth(11 - 1);
        date.setDate(16);
        date.setHours(4);
        date.setMinutes(37);
        date.setSeconds(41);

        Assert.assertEquals(DateTimeString.toGMTString(date), "2012-11-15T19:37:41Z");
    }

    @Test
    public void test2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 03, 21, 10, 11, 23);
        Assert.assertEquals(DateTimeString.toString(calendar), "2024년 3월 21일 일요일 오전 10:11:23");

        calendar.set(2023, 01, 11, 15, 03, 03);
        Assert.assertEquals(DateTimeString.toString(calendar), "2023년 1월 11일 토요일 오후 3:03:03");
    }

}
