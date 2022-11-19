package game_implementations;
/**
 * Armor class for entitys 
 * @author jlb74
 *
 */
public class Armor extends Items {
    private String slot;
    private int defense;

/**
 * base armor variables 
 */
    public Armor() {
        setName("N/A");
        slot = "";
        defense = 0;
    }
/**
 * setting the armor to values
 * @param n name of the armor
 * @param s slot that it goes in
 * @param d amount of defence or bonus to ac 
 */
    public Armor(String n, String s, int d) {
        setName(n);
        slot = s;
        defense = d;
    }
/**
 * getSlot function
 * @return returns the slot called
 */
    public String getSlot() {
        return slot;
    }
/**
 * sets the slot of the defense 
 * @param s what slot is attempting to be used
 */
    public void setSlot(String s) {
        switch(s) {
            case "Head": slot = s;
            break;
            case "Body": slot = s;
            break;
            case "Legs": slot = s;
            break;
            default: slot = null;
            break;
        } 
    }
/**
 * gets the defense stats
 * @return returns defense slot
 */
    public int getDefense() {
        if(this.equals(null)) {
            return 0;
        } else {
            return defense;
        }
    }
/**
 * sets the defense
 * @param d amount of bonus the armor gives
 */
    public void setDefense(int d) {
        if(d >= 0) {
            defense = d;
        } else {
            defense = 0;
        }
    }


    
}
