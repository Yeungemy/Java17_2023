import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinimumElement minEle = new MinimumElement();

        int[] myArr = minEle.readElements(sc,5);
        int minEl = minEle.findMin(myArr);

        System.out.println("Minimum Ele: " + minEl);
    }
}