package OOP.cityPopulationTracker;

import java.util.Scanner;

import shared.NumberUtil;
import shared.StringUtil;

public class Main {
    static StringUtil stringUtil = new StringUtil();
    static NumberUtil numberUtil = new NumberUtil();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cityName = promptForCityName(scanner);

        String country = promptForCountry(scanner);

        int population = promptForPopulation(scanner);

        City newCity = new City(cityName, country, population);

        CityPopulationTracker tracker = new CityPopulationTracker();
        tracker.addCity(newCity);

        System.out.println(newCity);
    }

    public static String promptForCityName(Scanner scanner){
        return stringUtil.promptForString(scanner);
    }

    public static String promptForCountry(Scanner scanner){
        return stringUtil.promptForString(scanner);
    }

    public static int promptForPopulation(Scanner scanner){
        return numberUtil.userInputIntegerNumber(scanner, 0, Integer.MAX_VALUE);
    }
}
