package shared;

import java.util.Scanner;
import java.text.DecimalFormat;

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

        if (minVal > maxVal) {
            throw new IllegalArgumentException("The maximum value should be greater than minimum value!");
        }

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

    public double userInputDoubleValue(Scanner scanner, double minVal, double maxVal, int decimalDigit) {
        double tempVal = maxVal + 1;

        if (minVal > maxVal) {
            throw new IllegalArgumentException("The maximum value should be greater than minimum value!");
        } else {

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
        }

        return tempVal;
    }
}
