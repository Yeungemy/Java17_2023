package OOP.player;
import OOP.player.Team.Position;;

public class Main {
    public static void main(String[] args) {
        Team bulls = new Team("Chicago Bulls");
        bulls.setPlayer(Position.SHOOTING_GUARD, "Michael Jordan");
        bulls.setPlayer(Position.SMALL_FORWARD, "Scottie Pippen");
        bulls.setPlayer(Position.POWER_FORWARD, "Dennis Rodman");
        bulls.setPlayer(Position.CENTER, "Bill Wennington");
        bulls.setPlayer(Position.POINT_GUARD, "Randy Brown");

        Team pistons = new Team("Detroit Pistons");
        pistons.setPlayer(Position.SHOOTING_GUARD, "Joe Dumars");
        pistons.setPlayer(Position.SMALL_FORWARD, "Grant Hill");
        pistons.setPlayer(Position.POWER_FORWARD, "Otis Thorpe");
        pistons.setPlayer(Position.CENTER, "William Bedford");
        pistons.setPlayer(Position.POINT_GUARD, "Isiah Thomas");

        Game game = new Game("Etihad Stadium");
        game.begin(bulls, pistons);
    }
}
