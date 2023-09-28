import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] myArr = {1, 2, 3, 4, 5, 6};

        ReverseArray reversedArray = new ReverseArray();

        int[] reversedArr = reversedArray.reverse(myArr);

        Arrays.stream(reversedArr).forEach(System.out::println);
    }
}
