package smallExcercises;

public class FahrenheitToCelsius {
    public static double fahrenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        double temperature = 77;

        System.out.println(
                "The temperature is " + temperature + "\u00B0F is " + fahrenheitToCelsius(temperature) + "\u00B0C");
    }
}

