package shared;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {
    /**
     * 
     * @param date       - date string
     * @param datePatter - like "dd/MM/yyyy" which can accept '-', '/' or ',' as
     *                   separator
     * @return boolean - the data entered by user is valid or not
     */
    private static boolean dateValidation(String date, String datePattern) {
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

    private static boolean checkDate(String date) {
        String pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;
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
     * @param {String} strDate
     * @param {String} dateFormat For example MM-dd-yyyy, MM.dd.yyyy, dd.MM.yyyy etc
     * @return {boolean}
     */
    public Date parseSimpleDate(String dateString, String dateFormat) {
        Date date = null;
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
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
                System.out.print("Please enter a date in " + dateFormat + " format: ");

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
    public int calculateAge(String dob) {
        LocalDate dob_1 = LocalDate.parse(dob);
        LocalDate curDate = LocalDate.now();
        return Period.between(dob_1, curDate).getYears();
    }
}
