package OOP.player;
import java.util.HashMap;
import java.util.Map;
import OOP.player.contants.Position;

public class Team { 
    private String name;
    private Map<Position, String> players;

    public Team(String name){
        this.name = name;
        this.players = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Player's name cannot be null or blank!");
        }

        this.name = name;
    }

    public String getPlayer(Position position) {
        if(position == null){
            throw new IllegalArgumentException("Team player's position cannot be null or blank!");
        }

        // return a player from the HashMap.
        return this.players.get(position);
     }
 
 
     public void setPlayer(Position position, String player) {
        if(position == null){
            throw new IllegalArgumentException("Team player's position cannot be null or blank!");
        }

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Player's name cannot be null or blank!");
        }

         // Add a <String, String> entry into the HashMap
         this.players.put(position, player);
     }
}
