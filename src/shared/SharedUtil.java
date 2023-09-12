package shared;

public class SharedUtil {
    public String[] reverse(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        return arr;
    }

    /**  create a method called isNullOrBlank that takes a String input and 
     * returns true if the input is null or blank 
     */
    public boolean isNullOrBlank(String input) {
        return input.isBlank() && input == null;
    }
}
