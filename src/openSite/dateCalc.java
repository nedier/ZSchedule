package openSite;

public class dateCalc {

    public static int MonthDays(int year, int month) {
        int dayOfMonth;
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 !=0)) || year % 400 == 0;
        boolean is31 = (month == 1) || (month == 3) || (month == 5) || (month == 7)
                || (month == 8) || (month == 10) || (month == 12);

        if (isLeapYear && month == 2) {
            dayOfMonth = 29;
        } else if (!isLeapYear && month == 2) {
            dayOfMonth = 28;
        } else if (is31) {
            dayOfMonth = 31;
        } else {
            dayOfMonth = 30;
        }
        return dayOfMonth;
    }
    public static int DayOfDate(int year, int month, int day) {
        int dayOfWeek;
        int totalDay = 0;
        for(int i = 1900; i <= year; i++) {
            if (i < year) {
                for(int j = 1; j <= 12; j++) {
                    totalDay += MonthDays(i, j);
                }
            } else {
                for(int j = 1; j < month; j++) {
                    totalDay += MonthDays(i, j);
                }
            }
        }
        totalDay += day;
        dayOfWeek = (totalDay % 7);
        return dayOfWeek;
    }
}
