package smallProjects;
public class MarketingReport {
    public static void main(String[] args) {
        double sales = 24309.65;
        double profit = 18562.18;
        double refunds = 888.78;
        double shipping = 1233.57;

        System.out.println("This month we made $" + (int)sales + " in sales.");
        System.out.println("Facotoring in costs, we made $" + (int)profit + " in profit.");
        System.out.println("The refunds are at a low $" + (int)refunds + ". This is a good sign!");
        System.out.println("Shipping cost were high. we paid $" + (int)shipping + " in shipping.");
    }
}
