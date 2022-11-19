package game_implementations;
/**
 * weapons of the game
 * @author jlb74
 *
 */
public class Weapon extends Items {
    //Weapon types: Sword, Axe, etc.

    //may not be needed
    private String weaponType;
    private String damage;
    /**
     * creates weapon information
     */
    public Weapon() {
        setName("N/A");
        weaponType = "N/A";
        setDamage(null);
    }
    /**
     * sets weapon information
     * @param n name
     * @param wT what ype of  weapon
     * @param d damage dice
     */
    public Weapon(String n, String wT, String d) {
        setName(n);
        weaponType = wT;
        setDamage(d);
    }

    //may not be needed
    /**
     * gets weapons type
     * @return returns type
     */
    public String getWeaponType() {
        return weaponType;
    }

    //^
    /**
     * sets weapon type
     * @param t sets weapons type
     */
    public void setWeaponType(String t) {
        weaponType = t;
    }
    /**
     * gets damage
     * @return returns damage
     */
    public String getDamage() {
        if(this.equals(null)) {
            return null;
        } else {
            return damage;
        }
    }
    /**
     * sets the damage
     * @param d damage dice
     */
    public void setDamage(String d) {
        switch(d) {
            case "d4": damage = d; 
            break;
            case "d6": damage = d;
            break;
            case "d8": damage = d;
            break;
            case "d10": damage = d;
            break;
            case "d12": damage = d;
            break;
            default: damage = null;
            break;
        }
    }

}
