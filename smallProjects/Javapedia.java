package smallProjects;
import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfFigures = 0;
        
        System.out.print("How many historical figures will you register?\nUser: ");
        numOfFigures = scanner.nextInt();

        //define an array
        String[][] historicalFigures = new String[numOfFigures][3];

        scanner.nextLine();
    
        //store user's database
        for(int i = 0; i < numOfFigures; i++){
            int j = 0;
            System.out.print("\n\tFigure " + (i + 1) + "\n\t - Name: ");
            historicalFigures[i][j++] = scanner.nextLine();

            System.out.print("\t - Date of Birth: ");
            historicalFigures[i][j++] = scanner.nextLine();

            System.out.print("\t - Occupation: ");
            historicalFigures[i][j++] = scanner.nextLine();
        }
        
        System.out.println("\nHere is your data stored: ");
        print2DArray(historicalFigures);

        System.out.print("\nWho do you want information on? ");
        String figureName = scanner.nextLine();

        int indexOfFigure = findFigure(figureName, historicalFigures);

        if(indexOfFigure >= 0){
            displayFigureInfo(historicalFigures, indexOfFigure);
        }else{
            System.out.println("\nSorry, that figure cannot be found!");
        }
        

        scanner.close();
    }

    public static void print2DArray(String[][] historicalFigures){
        for(int i = 0; i < historicalFigures.length; i++){
            for(int j = 0; j < historicalFigures[i].length; j++){
                System.out.print("\t" + historicalFigures[i][j]);
            }

            System.out.println();
        }
    }

    public static int findFigure(String figureName, String[][] historicalFigures){
        int indexOfFigure = -1;

        for(int i = 0; i < historicalFigures.length; i++){
            for(int j = 0; j < historicalFigures[i].length; j++){
                if(historicalFigures[i][j].equals(figureName)){
                    indexOfFigure = i;
                }
            }
        }

        return indexOfFigure;
    }

    public static void displayFigureInfo(String[][] historicalFigures, int indexOfFigure){
        System.out.println("\n\tName: " + historicalFigures[indexOfFigure][0]);
        System.out.println("\tDate of Birth: " + historicalFigures[indexOfFigure][1]);
        System.out.println("\tOccupation: " + historicalFigures[indexOfFigure][2]);
    }
}
