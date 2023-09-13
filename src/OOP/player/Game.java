package OOP.player;
import OOP.player.Team.Position;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Game {
    private String arena;
    private LocalDate date;

    public Game(String arena) {
        this.arena = arena;
        this.date = LocalDate.now();
    }

    public void begin(Team home, Team guest) {
        // String formattedDate = this.date.getDayOfMonth() + "/" +
        // this.date.getMonthValue() + "/" + this.date.getYear();
        String formattedDate = this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println(
                "\n - This matchup takes place at the " + this.arena + " arena on " + formattedDate + "." +
                        "\n - Tonight's game is between the " + home.getName() + " and the " + guest.getName() + ".\n" +
                        "\n - The starting lineup for the home team is: at point guard, "
                        + home.getPlayer(Position.POINT_GUARD) + "; at shooting guard, " + home.getPlayer(Position.SHOOTING_GUARD)
                        + "; at small forward, " + home.getPlayer(Position.SMALL_FORWARD) + "; at power forward, "
                        + home.getPlayer(Position.POWER_FORWARD) + "; and at center, " + home.getPlayer(Position.CENTER) + ".\n" +
                        "\n - The starting lineup for the visiting team is: at point guard, "
                        + guest.getPlayer(Position.POINT_GUARD) + "; at shooting guard, " + guest.getPlayer(Position.SHOOTING_GUARD)
                        + "; at small forward, " + guest.getPlayer(Position.SMALL_FORWARD) + "; at power forward, "
                        + guest.getPlayer(Position.POWER_FORWARD) + "; and at center, " + guest.getPlayer(Position.CENTER) + ".\n" +
                        "\n - Let's give a warm round of applause for both teams as they take the court!");
    }
}
