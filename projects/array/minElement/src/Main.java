import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinimumElement minEle = new MinimumElement();
        final int size = 2;

        int[] myArr = minEle.readElements(sc, size);
        int minEl = minEle.findMin(myArr);

        System.out.println("Minimum Ele: " + minEl);
    }
}