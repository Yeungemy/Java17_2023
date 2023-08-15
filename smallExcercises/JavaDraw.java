package smallExcercises;

import java.util.Scanner;

public class JavaDraw {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice;

        displayMenu();

        // Pick up the user's choice.
        choice = scan.nextInt();

        // Call the draw function by user's choice.
        System.out.println("\n\n\nHere is Java draw according to your choice as below: ");
        draw(choice);

        scan.close();
    }

    public static void displayMenu(){
        System.out.print("\nWhich animal would you like to draw?\n");
        System.out.println("Write 1 for Butterfly ");
        System.out.println("Write 2 for Elephant  ");
        System.out.println("Write 3 for Teddy Bear");
        System.out.println("Write 4 for Snake     ");
        System.out.print("\nYour choice: ");
    }

    /**
     * Function name: draw - draws an animal that the user chooses.
     * 
     * @param choice: (int)
     * 
     *                Inside the function:
     *                • Based on the choice, draw:
     *                1. a butterfly
     *                2. elephant
     *                3. bear
     *                4. snake
     */
    public static void draw(int choice) {
        switch (choice) {
            case 1:
                drawButterfly();
                break;
            case 2:
                drawElephant();
                break;
            case 3:
                drawBear();
                break;
            case 4:
                drawSnake();
                break;
            default:
                break;
        }
    }

    public static void drawButterfly() {
        System.out.println("  .==-.                   .-==.     ");
        System.out.println("   \\()8`-._  `.   .'  _.-'8()/     ");
        System.out.println("   (88\"   ::.  \\./  .::   \"88)     ");
        System.out.println("    \\_.'`-::::.(#).::::-'`._/      ");
        System.out.println("      `._... .q(_)p. ..._.'         ");
        System.out.println("        \"\"-..-'|=|`-..-\"\"       ");
        System.out.println("        .\"\"' .'|=|`. `\"\".       ");
        System.out.println("      ,':8(o)./|=|\\.(o)8:`.        ");
        System.out.println("     (O :8 ::/ \\_/ \\:: 8: O)      ");
        System.out.println("      \\O `::/       \\::' O/       ");
        System.out.println("       \"\"--'         `--\"\"      ");
    }

    public static void drawElephant() {
        System.out.println("       _..--\"\"-.                  .-\"\"--.._ ");
        System.out.println("   _.-'         \\ __...----...__ /         '-._");
        System.out.println(" .'      .:::...,'              ',...:::.      '.");
        System.out.println("(     .'``'''::;                  ;::'''``'.     )");
        System.out.println(" \\             '-)              (-'             /");
        System.out.println("  \\             /                \\             /");
        System.out.println("   \\          .'.-.            .-.'.          /");
        System.out.println("    \\         | \\0|            |0/ |         /");
        System.out.println("    |          \\  |   .-==-.   |  /          |");
        System.out.println("     \\          `/`;          ;`\\`          /");
        System.out.println("      '.._      (_ |  .-==-.  | _)      _..'");
        System.out.println("          `\"`\"-`/ `/'        '\\` \\`-\"`\"`");
        System.out.println("               / /`;   .==.   ;`\\ \\");
        System.out.println("         .---./_/   \\  .==.  /   \\ \\");
        System.out.println("        / '.    `-.__)       |    `\"");
        System.out.println("       | =(`-.        '==.   ;");
        System.out.println("        \\  '. `-.           /");
        System.out.println("         \\_:_)   `\"--.....-'");
    }

    public static void drawBear() {
        System.out.println("            ___   .--. ");
        System.out.println("      .--.-\"   \"-' .- |");
        System.out.println("     / .-,`          .'");
        System.out.println("     \\   `           \\");
        System.out.println("      '.            ! \\");
        System.out.println("        |     !  .--.  |");
        System.out.println("        \\        '--'  /.____");
        System.out.println("       /`-.     \\__,'.'      `\\");
        System.out.println("    __/   \\`-.____.-' `\\      /");
        System.out.println("    | `---`'-'._/-`     \\----'    _");
        System.out.println("    |,-'`  /             |    _.-' `\\");
        System.out.println("   .'     /              |--'`     / |");
        System.out.println("  /      /\\              `         | |");
        System.out.println("  |   .\\/  \\      .--. __          \\ |");
        System.out.println("   '-'      '._       /  `\\         /");
        System.out.println("               `\\    '     |------'`");
        System.out.println("                 \\  |      |");
        System.out.println("                  \\        /");
        System.out.println("                   '._  _.'");
        System.out.println("                      ``");
    }

    public static void drawSnake() {
        System.out.println("         ,,'6''-,.");
        System.out.println("        <====,.;;--.");
        System.out.println("        _`---===. \"\"\"==__");
        System.out.println("      //\"\"@@-\\===\\@@@@ \"\"\\\\");
        System.out.println("     |( @@@  |===|  @@@  ||");
        System.out.println("      \\\\ @@   |===|  @@  //");
        System.out.println("        \\\\ @@ |===|@@@ //");
        System.out.println("         \\\\  |===|  //");
        System.out.println("___________\\\\|===| //_____,----\"\"\"\"\"\"\"\"\"\"-----,_");
        System.out.println("  \"\"\"\"---,__`\\===`/ _________,---------,____    `,");
        System.out.println("             |==||                           `\\   \\");
        System.out.println("            |==| |                             )   |");
        System.out.println("           |==| |       _____         ______,--'   '");
        System.out.println("           |=|  `----\"\"\"     `\"\"\"\"\"\"\"\"         _,-'");
        System.out.println("            `=\\     __,---\"\"\"-------------\"\"\"''");
        System.out.println("                \"\"\"\"		");
    }
}
