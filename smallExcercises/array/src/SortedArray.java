import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    // write code here
    public int[] getIntegers(int size){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++){
            try{
                System.out.print("Please enter a whole number: ");
                String userInput = scanner.next();
                numbers[i] = Integer.parseInt(userInput);
            }catch(NumberFormatException e){
                System.out.print("Sorry, that is an invalid number.\n");
                i--;
            }
        }
        scanner.close();
        return  numbers;
    }

    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }

    public int[] sortIntegers(int[] arr){
        int[] numbers = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int temp = 0;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
