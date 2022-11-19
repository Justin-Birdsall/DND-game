package entity;

import java.awt.image.BufferedImage;

//import game_implementations.entity;
/** Entity is a class for any one entity in the game such as the player enemy or NPC
 * 
 * @author jlb74
 *
 */
public class Entity { 
	/**
	 * the starting position of the sprite on the screen
	 */
	public int worldX, worldY;
	/**
	 *  Speed of what the sprite moves across the Screen
	 */
	public int speed;
	/**
	 * BufferedImage sets up images 1 and 2 for each direction to alternate to get the animation of character moving
	 */
	public BufferedImage up1, up2, down1, down2, left1 ,left2, right1, right2;
	/**
	 * the starting direction of the entity is facing
	 */
	public String direction;
	/**
	 * spriteCounter holds the ammount of seconds since the buffered image was displayed
	 */
	public int spriteCounter =0;
	/**
	 * spriteNum holds either a 0 or 1 that alternates the image 1 or 2 for each direction to get an animation of walking
	 */
	public int spriteNum =0;

	
    private int hp;
    private int maxhp;
    private int level;
    private int defense;
    private String damage;

    

    /*public String getDamage() {
        return damage;
    }*/

    /*public void setDamage(String d) {
        damage = d;
    }*/
    /**
     * getHp of the entity
     * @return returns the hp
     */
    public int getHp() {
        return hp;
    }

    //set hp between 1 and max (cannot die from this)
    /**
     * sets hp between 1 and max (cannot die from this)
     * @param newHp new hp of the entity
     */
    public void setHp(int newHp) {
        //checks if newHp is greater than maxhp
        //checks if newHp is at least 1
        if(newHp <= maxhp && newHp > 0) {
            hp = newHp;
        //in the case that newHp is greater than max
        //set hp to max
        } else if(newHp > maxhp) {
            hp = maxhp;
        //if newHp is less than 1 set hp to 1
        } else {
            hp = 1;
        }
    }
    /**
     * gets the max hp of the entity
     * @return entity 
     */
    public int getMaxHp() {
        return maxhp;
    }
    /**
     * setsMax hp
     * @param newMax new max hp
     */
    public void setMaxHp(int newMax) {
        //checks that newMax is a positive integer
        if(newMax > 0) {
            //as long as newMax is greater than the
            //current hp, update maxhp
            if(hp <= newMax) {
                maxhp = newMax;
            //if hp is greater than newMax
            //lower hp to meet the newMax
            } else {
                hp = newMax;
                maxhp = newMax;
            }
        }
    }

    //method to be called in combatSystem
    /**
     * method to be called in the combat system
     * @param damage how much damage entity takes
     */
    public void takeDamage(int damage) {
        //check if entity dies
        if(hp - damage > 0) {
            hp -= damage;
        //entity dies
        } else {
            hp = 0;
            //TODO: implement player/enemy death
            //TODO: end combat(if 1v1)
        }
    }

    //method to be called in combatSystem
    /**
     * method to be called in combat system to heal
     * @param heal gains health to the entity
     */
    public void gainHealth(int heal) {
        //checks if heal is negative or 0
        if(heal > 0) {
            //checks if heal goes over maxhp
            if(hp + heal <= maxhp) {
                hp += heal;
            //if healing goes over maxhp
            //hp sets to maxhp
            } else {
                hp = maxhp;
            }
        }

    }

    //may be removed
    /**
     * may be removed later but gets level 
     * @return returns the level of the entity
     */
    public int getLevel() {
        return level;
    }

    //may be removed 
    /**
     * setLevel may not be needed
     * @param newlvl levels up entity
     */
    public void setLevel(int newlvl) {
        //newlvl must be positive integer
        if(newlvl > 0) {
            level = newlvl;
        //if newlvl is not a positive integer
        //default to 1
        } else {
            level = 1;
        }
    }
    /**
     * gets defense of the entity
     * @return defense 
     */
    public int getDefense() {
        return defense;
    }
    /**
     * setDefense of the entity
     * @param newDef updates the defense 
     */
    public void setDefense(int newDef) {
        //newDef must be at least 0
        if(newDef >= 0) {
            defense = newDef;
        //if newDef is negative
        //default to 0
        } else {
            defense = 0;
        }
    }

    //may be unneeded
    //called when equipping armor/shields
    //called if buffs are implemented
    /**
     * adds defense 
     * @param def if defense is a non negative number or not 0 then its adds the defense 
     */
    public void addDefense(int def) {
        //can't add 0 or negative defense
        if(def > 0) {
            defense += def;
        }
    }

    //may be unneeded
    //called when equipping/unequipping armor/shields
    //called if debuffs are implemented
    /**
     * removes defense for unequiping or a debuff
     * @param def the defense modifier
     */
    public void removeDefense(int def) {
        //defense cannot go lower than 0
            //TODO: (diff method/class) if debuffs are implemented
            //remove them upon end of combat to avoid exploits
        if(defense - def >= 0) {
            defense -= def;
        //if defense is lowered below 0
        //default to 0
        } else {
            defense = 0;
        }
    }
/**
 * gets the damage
 * @return the amount of damage
 */
    public String getDamage() {
        return damage;
    }
    /**
     * setDamage for the dice roll
     * @param d dice roll for the damage 
     */
    public void setDamage(String d) {
        switch(d) {
            case "d4": damage = "d4";
            break;
            case "d6": damage = "d6";
            break;
            case "d8": damage = "d8";
            break;
            case "d10": damage = "d10";
            break;
            case "d12": damage = "d12";
            break;
            default: damage = "";
            break;
        }
    }
}
