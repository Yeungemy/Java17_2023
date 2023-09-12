package OOP.tryCatchFinal;

import java.io.IOException;

import shared.FileCrud;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/assets/cards.txt";
        FileCrud file = new FileCrud();
        try{
            String fileContent = file.readFile(fileName);
            System.out.println(fileContent);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
