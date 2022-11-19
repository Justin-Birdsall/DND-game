package game_implementations;
/**
 * items class for the game
 * @author jlb74
 *
 */
public class Items {
    private String name;
    /**
     * sets up item string to N/A
     */
    public Items() {
        name = "N/A";
    }
    /**
     * gets the name of the item
     * @return item name
     */
    public String getName() {
        return name;
    }
    /**
     * sets the name of the item
     * @param n name of item
     * 
     */
    public void setName(String n) {
        if(n == null) {
            name = "N/A";
        } else {
            name = n;
        }
    }


}