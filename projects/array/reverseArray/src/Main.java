import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] myArr = { 1, 2, 3, 4, 5, 6 };

        System.out.println("Array: " + Arrays.toString(myArr));

        ReverseArray reversedArray = new ReverseArray();

        int[] reversedArr = reversedArray.reverse(myArr);

        System.out.println("Reversed Array: " + Arrays.toString(reversedArr));

        // Arrays.stream(reversedArr).forEach(System.out::println);

        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.CEILING);
        for (Number n : Arrays.asList(12, 123.12345, 0.23, 0.1, 2341234.212431324)) {
            Double d = n.doubleValue();
            System.out.println(df.format(d));
        }
    }
}
