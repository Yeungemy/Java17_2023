package shared;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public final class NumberUtil {
    public static String decimalFormat(double value, int decimalDigit) {
        String formatStr = "#.";

        for (int i = 0; i < decimalDigit; i++) {
            formatStr += "0";
        }

        DecimalFormat numberFormat = new DecimalFormat(formatStr);

        return numberFormat.format(value);
    }

    public int userInputIntegerNumber(Scanner scanner, int minVal, int maxVal) {
        int tempVal = maxVal + 1;

        while (tempVal < minVal || tempVal > maxVal) {
            try {
                System.out.print("Please enter a number between " + minVal + " and " + maxVal + ": ");
                String userInput = scanner.next();
                tempVal = Integer.parseInt(userInput);

                if (tempVal < minVal || tempVal > maxVal) {
                    System.out.println("Sorry, the number is outside of valid range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number and please try again!");
            }
        }

        return tempVal;
    }

    public static double userInputDoubleValue(Scanner scanner, double minVal, double maxVal, int decimalDigit) {
        double tempVal = maxVal + 1;

        while (tempVal < minVal || tempVal > maxVal) {
            try {
                System.out.print("Please enter a number between " + minVal + " and " + maxVal + ": ");
                String userInput = scanner.next();
                tempVal = Double.parseDouble(userInput);
                tempVal = Double.parseDouble(decimalFormat(tempVal, decimalDigit));

                if (tempVal < minVal || tempVal > maxVal) {
                    System.out.println("Sorry, the number is outside of valid range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number and please try again!");
            }
        }

        return tempVal;
    }

    private int getAge(String dobString){

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(dobString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(date == null) return 0;

        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.setTime(date);

        int year = dob.get(Calendar.YEAR);
        int month = dob.get(Calendar.MONTH);
        int day = dob.get(Calendar.DAY_OF_MONTH);

        dob.set(year, month+1, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
}
}
