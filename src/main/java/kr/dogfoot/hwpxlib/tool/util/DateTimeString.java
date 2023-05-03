package kr.dogfoot.hwpxlib.tool.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeString {
    public static String toGMTString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(date);
    }

    public static String toString(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(calendar.get(Calendar.YEAR))
                .append("년 ")
                .append(calendar.get(Calendar.MONTH))
                .append("월 ")
                .append(calendar.get(Calendar.DAY_OF_MONTH))
                .append("일 ")
                .append(weekString(calendar.get(Calendar.DAY_OF_WEEK)))
                .append(" ")
                .append(ampm(calendar.get(Calendar.AM_PM)))
                .append(" ")
                .append(calendar.get(Calendar.HOUR))
                .append(":")
                .append(twoDigit(calendar.get(Calendar.MINUTE)))
                .append(":")
                .append(twoDigit(calendar.get(Calendar.SECOND)));
        return sb.toString();
    }

    private static String weekString(int week) {
        switch (week) {
            case Calendar.SUNDAY:
                return "일요일";
            case Calendar.MONDAY:
                return "월요일";
            case Calendar.TUESDAY:
                return "화요일";
            case Calendar.WEDNESDAY:
                return "수요일";
            case Calendar.THURSDAY:
                return "목요일";
            case Calendar.FRIDAY:
                return "금요일";
            case Calendar.SATURDAY:
                return "토요일";
        }
        return "";
    }

    private static String ampm(int ampm) {
        switch (ampm) {
            case Calendar.AM:
                return "오전";
            case Calendar.PM:
                return "오후";
        }
        return "";
    }

    private static String twoDigit(int num) {
        return (num >= 10) ? Integer.toString(num) : "0" + Integer.toString(num);
    }
}
