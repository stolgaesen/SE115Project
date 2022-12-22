public class Player {

    private String PlayerName;

    public Player(String name) {
        PlayerName = name;
    }
    //This set method sets the name of the player.
     
    public void setName(String name) {
        this.PlayerName = name;
    }
    //This get method returns the String value of player name.
    public String getName() {
        return PlayerName;
    }


}