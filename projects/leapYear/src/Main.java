public class Main {
    public static void main(String[] args) {
        int year = 1924;
        LeapYear leapYear = new LeapYear();

        System.out.println("Year " + year + " is " + (leapYear.isLeapYear(year)? "a " : " not a") + "leap year.");
    }
}
