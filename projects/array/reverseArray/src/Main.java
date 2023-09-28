import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] myArr = {1, 2, 3, 4, 5, 6};

        System.out.println("Array: " + Arrays.toString(myArr));

        ReverseArray reversedArray = new ReverseArray();

        int[] reversedArr = reversedArray.reverse(myArr);
               
        System.out.println("Reversed Array: " + Arrays.toString(reversedArr));

        // Arrays.stream(reversedArr).forEach(System.out::println);
    }
}
