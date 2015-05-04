/**
 * You are given the following information, but you may prefer to do
 * some research for yourself.
 *
 * o 1 Jan 1900 was a Monday.
 * o Thirty days has September,
 *   - April, June and November.
 *   _ All the rest have thirty-one,
 *   - Saving February alone,
 *   - Which has twenty-eight, rain or shine.
 *   - And on leap years, twenty-nine.
 * o A leap year occurs on any year evenly divisible by 4, but not 
 *   on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the
 * twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class P019 {

    public static enum DaysOfTheWeek { SUNDAY, MONDAY, TUESDAY,
                                       WEDNESDAY, THURSDAY,
                                       FRIDAY, SATURDAY };

    public static boolean isLeapYear(int n) {
        if      (n % 400 == 0) { return true; }
        else if (n % 100 == 0) { return false; }
        else                   { return n % 4 == 0; }
    }

    public static int getNumberOfDayInMonth(int month, int year) {
        if (month == 9 || month == 4 || month == 6 || month == 11) {
            return 30;
        }
        else if (month == 1 || month == 3 || month == 5 || month == 7 ||
                 month == 8 || month == 10 || month == 12) {
            return 31;
        }
        else {
            return isLeapYear(year) ? 29 : 28;
        }
    }

    public static void main(String[] args) {
        int daysCounter = 1;
        int sundaysCounter = 0;

        for (int year = 1900; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= getNumberOfDayInMonth(month, year); day++) {
                    if (day == 1 &&
                        "SUNDAY".equalsIgnoreCase(DaysOfTheWeek.values()[daysCounter % 7] + "") &&
                        year != 1900) {
                        sundaysCounter++;
                    }
                    daysCounter++;
                }
            }
        }

        System.out.println("Answer: " + sundaysCounter);
    }
}
