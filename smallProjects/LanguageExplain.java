package smallProjects;

import java.text.DecimalFormat;

public class LanguageExplain {
    public static String languageExplain(String language) {
        switch (language) {
            case "English":
                return "Area equals length * width.";
            case "French":
                return "La surface est egale a la longueur * la largeur.";
            case "Spanish":
                return "area es igual a largo * ancho.";
            default:
                return "not available!";
        }
    }

    public static double calculateRectangleArea(double width, double length) {
        return width * length;
    }

    public static String roundWithTwoDecimal(double amount) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(amount);
    }

    public static void print(double width, double length, String language) {
        System.out.println("The area calculation formula for the rectangle (" + width + " width, " + length
                + " length) is explained in " + language + ": " + languageExplain(language));
        double area = calculateRectangleArea(3.0, 9.88);
        System.out.println("The area is " + roundWithTwoDecimal(area) + " Square foot.");
    }

    public static void main(String[] args) {
        print(5.5, 7.85, "French");
    }
}
