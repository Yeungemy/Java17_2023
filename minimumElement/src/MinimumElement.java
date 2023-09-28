import java.util.Scanner;

public class MinimumElement {
    public int readInteger(){
        int temp = 0;
        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                System.out.print("Please enter a whole number: ");
                String userInput = scanner.next();
                temp = Integer.parseInt(userInput);
                scanner.close();
                return temp;
            }catch (NumberFormatException e){
                System.out.println("Sorry, it is invalid! \n");
            }
        }
    }

    int[] readElements(int size){
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++) {
            numbers[i] = readInteger();
        }
        return numbers;
    }

    public int findMin(int[] myArr){
        int min = myArr[0];

        for(int i = 0; i < myArr.length; i++){
            min = min > myArr[i]? myArr[i] : min;
        }

        return min;
    }
}
