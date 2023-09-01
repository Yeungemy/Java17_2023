package shared;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class DateUtil {
    NumberUtil numberUtil = new NumberUtil();

    /**
     * Prompt for date values of year, month, and date
     * @param {Scanner} scanner - System scanner
     * @return
     */
    public ArrayList<Integer> userInputDateValues(Scanner scanner) {
        ArrayList<Integer> dateValues = new ArrayList<Integer>();
        int year = 0;
        int month = 0;
        int date = 0;
        int maxDate = 0;

        year = numberUtil.userInputIntegerNumber(scanner, 1000, Year.now().getValue());
        month = numberUtil.userInputIntegerNumber(scanner, 1, 12);

        if ((month == 4 || month == 6 || month == 9 || month == 11))
            maxDate = 30;
        else if ((month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12))
            maxDate = 31;
        else if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                maxDate = 29;
            } else {
                maxDate = 28;
            }
        }

        date = numberUtil.userInputIntegerNumber(scanner, 1, maxDate);

        dateValues.add(year);
        dateValues.add(month);
        dateValues.add(date);
        return dateValues;
    }

    static int wd(int year, int month, int day) {
        int wday = 0;
        wday = (day + ((153 * (month + 12 * ((14 - month) / 12) - 3) + 2) / 5) +
                (365 * (year + 4800 - ((14 - month) / 12))) +
                ((year + 4800 - ((14 - month) / 12)) / 4) -
                ((year + 4800 - ((14 - month) / 12)) / 100) +
                ((year + 4800 - ((14 - month) / 12)) / 400) -
                32045) % 7;
        return wday;
    }

    /**
     * Get a date input from user side and validate it accordingly
     * @param {Scanner} scanner - System scanner
     * @param {String} format - date formate using dd for date, mm for month, yyyy for year
     * @param {String} separator - the separator of the date formattor
     * @return
     */
    public String userInputDate(Scanner scanner, String format, String separator){
        String dateStr = "";
        
        ArrayList<Integer> dateValues = userInputDateValues(scanner);
        dateStr = composeDateString(dateValues, format, separator);
        System.out.println(dateStr);

        return dateStr;
    }

    /**
     * 
     * @param {ArrayList<Integer>} dateValues - hold date values of year, month, and then date 
     * @param {String} dateFormat - date formate using dd for date, mm for month, yyyy for year
     * @return {String} date string
     */
    public String composeDateString(ArrayList<Integer> dateValues, String dateFormat, String separator){
        String dateStr = "";
        int index = 0;
        

        for( String dateValue : dateFormat.split(separator)){
            index++;
            String temp = "";

            if(dateValue.toLowerCase().startsWith("d")){
                if(dateValues.get(2) < 10 ) {
                    temp += "0" + String.valueOf(dateValues.get(2));
                }else{
                    temp = String.valueOf(dateValues.get(2));
                }

                dateStr += temp + (index < 3 ? separator : "");
            }else if(dateValue.toLowerCase().startsWith("m")){
                
                if(dateValues.get(1) < 10 ) {
                    temp += "0" + String.valueOf(dateValues.get(1));
                }else{
                    temp = String.valueOf(dateValues.get(1));
                }

                dateStr += temp + (index < 3 ? separator : "");
            }else{
                dateStr += String.valueOf(dateValues.get(0)) + (index < 3 ? separator : "");
            }
        }

        return dateStr;
    }

    private static boolean checkDate(String date) {
        String pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 
     * @param date       - date string
     * @param datePatter - required date format like "dd/MM/yyyy" which can accept
     *                   '-', '/' or ',' as
     *                   separator
     * @return boolean - the data entered by user is valid or not
     */
    public boolean dateValidation(String date, String datePattern) {
        boolean status = false;
        if (checkDate(date)) {
            DateFormat dateFormat = new SimpleDateFormat(datePattern);
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(date);
                status = true;
            } catch (Exception e) {
                status = false;
            }
        }
        return status;
    }

    public LocalDate parseLocalDate(String dateStr, String dateFormat) {
        LocalDate date = null;
        final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(dateFormat);

        try {
            date = LocalDate.parse(dateStr, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            // handle exception
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Verify user input a date valid or not
     * 
     * @param scanner    - the system scanner
     * @param dateFormat - the date format like "dd/MM/yyyy" which can accept '-',
     *                   '/' or ',' as
     *                   separator
     * @return a local date
     */
    public String enterDate(Scanner scanner, String dateFormat) {
        String userinput = "";
        boolean isValid;
        do {
            try {
                System.out.print("a date in 'dd/MM/yyyy' format: ");

                userinput = scanner.next();

                isValid = dateValidation(userinput, dateFormat);

                if (!isValid) {
                    System.out.println("Sorry, the date is invalid!");
                }
            } catch (DateTimeParseException exception) {
                isValid = false;
                System.out.println("Sorry, the date is invalid!");
            }
        } while (!isValid);

        return userinput;
    }

    /**
     * Get age by dati of birth
     * 
     * @param dob - The date of birth in YYYY-MM-DD
     * @return age
     */
    public int calculateAge(String dob, String datePattern) {
       LocalDate dt = parseLocalDate(dob, datePattern);

        return Period.between(dt, LocalDate.now()).getYears();
    }
}
