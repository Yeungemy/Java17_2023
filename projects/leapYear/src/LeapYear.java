import java.util.Calendar;

public class LeapYear {
    /**
     * To determine whether a year is a leap year, follow these steps:
     * 1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step
     * 5.
     * 2. If the year is evenly divisible by 100, go to step 3. Otherwise, go to
     * step 4.
     * 3. If the year is evenly divisible by 400, go to step 4. Otherwise, go to
     * step 5.
     * 4. The year is a leap year (it has 366 days). The method isLeapYear needs to
     * return true.
     * 5. The year is not a leap year (it has 365 days).
     * 
     * @param year - greater than or equal to 1 and less than or equal to 9999
     * @return true if it is a leap year, otherwise return false
     */
    public boolean isLeapYear(int year) {
        // Calendar cal = Calendar.getInstance();
        // cal.set(Calendar.YEAR, year);
        // boolean isLeap = cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;

        // return isLeap;

        if (year % 4 != 0) {
            return false;
          } else if (year % 400 == 0) {
            return true;
          } else if (year % 100 == 0) {
            return false;
          } else {
            return true;
          }
    }
}