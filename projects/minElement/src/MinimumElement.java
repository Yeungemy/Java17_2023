import java.util.Scanner;

public class MinimumElement {
    public int readInteger(Scanner sc){
        int temp = 0;
        boolean flag = true;

        while (flag) {
            try {
                flag = false;
                System.out.print("Please enter a whole number: ");
                String userInput = sc.next();
                temp = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                flag = true;
                System.out.print("Sorry, that is an invalid number.\n");
            }
        }

        return temp;
    }

    public int[] readElements(Scanner sc, int size){
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++) {
            numbers[i] = readInteger(sc);
        }
        return numbers;
    }

    public int findMin(int[] myArr){
        int min = myArr[0];

        for(int i = 1; i < myArr.length; i++){
            min = Math.min(min, myArr[i]);
        }

        return min;
    }
}