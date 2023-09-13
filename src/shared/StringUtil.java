package shared;

import java.util.Scanner;

public class StringUtil {
    /**  create a method called isNullOrBlank that takes a String input and 
     * returns true if the input is null or blank 
     */
    public boolean isNullOrBlank(String input) {
        return input.isBlank() || input == null;
    }

    public String promptForString(Scanner scanner){
        String userInput = "";

        while(true){
            System.out.print("Enter a string of content: ");
            userInput = scanner.nextLine();

            if(!isNullOrBlank(userInput)){
               return userInput;
            }else{
                System.out.println("That string of content cannot be null or blank!");
            }
        }
    }
}
