package smallExcercises;
import java.text.DecimalFormat;

public class tips {
    public static double tips(double price){
       return price * .15;
    }

    public static String roundWithTwoDecimal(double amount){
        //round with 2 decimal
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(amount);
    }

    public static void main(String[] args) {
        System.out.println("You should pay $" + roundWithTwoDecimal(tips(83.98)) + " for the tips!");
    }
}
