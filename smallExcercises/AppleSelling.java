package smallExcercises;
public class AppleSelling {
    public static void main(String[] args) {
        double profit = 0;
        int numOfCustomers = 0;
        int numOfApples = 0;
        double price = 0.40;
        int numOfAppleSold = 0;

        System.out.println("I picked 500 apples from an apple orchard");
        numOfApples = 500;

        System.out.println("I would like to sell an apple for $" + price * 100 + "cents.");

        System.out.println("A customer came in and bought for 4 apples.");
        numOfAppleSold += 4;
        numOfCustomers += 1;
        numOfApples -= numOfAppleSold;

        System.out.println("Another customer came in and bought for 150 apples.");
        numOfCustomers++;
        numOfAppleSold += 150;
        numOfApples -= numOfAppleSold;

        System.out.println("The last customer came in and bought for 70 apples.");
        numOfCustomers++;
        numOfAppleSold += 70;
        numOfApples -= numOfAppleSold;
        profit = numOfAppleSold * .4;

        System.out.println("\n\n\nVow! So far, I have sold "+ numOfAppleSold + " apples and made: $" + profit + ".");
        System.out.println(numOfCustomers + " customers love my apples.");
        System.out.println("I have " + numOfApples + " apples left.");
    }
}
