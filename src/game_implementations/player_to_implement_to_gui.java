package game_implementations;

import entity.Player;
/**
 * class to implement to player for combat system
 * @author jlb74
 *
 */
public class player_to_implement_to_gui {
/*	publicPlayer() {
        setHp(100);
        setMaxHp(100);
        setLevel(1);
        setDefense(0);
        setDamage("");
        setXp(0);
        setGold(0);
        setHead(null);
        setBody(null);
        setLegs(null);
        setWeapon(null);
        setShield(null);
        return null;
    }

    public Player(int h, int x, int l, int g, 
    Armor he, Armor b, Armor le, Weapon w, Shield s) {
        //hp = h;
        xp = x;
        //level = l;
        gold = g;
        head = he;
        body = b;
        legs = le;
        weapon = w;
        shield = s;
        //defense = he.getDefense() + b.getDefense() + le.getDefense() + s.getDefense();
    }
*/	
	
	/**
	 * gets player information
	 * @return player information
	 */
    public Player getPlayer() {
        return this;
    }

    //may be phased out alongside levels
    /**
     * gets the exp
     * @return xp pints
     */
    public int getXp() {
        return xp;
    }

    //^
    /**
     * sets new exp
     * @param newxp new exp points
     */
    public void setXp(int newxp) {
        //xp cannot be less than 0
        if(newxp >= 0) {
            xp = newxp;
        //if newxp is less than 0
        //default to 0
        } else {
            xp = 0;
        }
    }

    //may be phased out
    /**
     * levels up the player
     */
    public void levelUp() {
        setLevel(getLevel() + 1);
    }

    //may be phased out alongside NPCs
    /**
     * gets the gold 
     * @return gold amount
     */
    public int getGold() {
        return gold;
    }

    //^
    /**
     * sets the new gold
     * @param newgold amount
     */
    public void setGold(int newgold) {
        //cannot have debt
        if(newgold >= 0) {
            gold = newgold;
        //if newgold is negative
        //default to 0
        } else {
            gold = 0;
        }
    }

    //player funtionality for equipping armor
    //TODO: check if armor is in inv
    /**
     * equips the armor
     * @param armor what armor wearing stast
     * @param inv whats in inventory
     */
    public void equipArmor(Armor armor, Inventory inv) {
        //cannot equip nothing
        if(armor == null) {
            return;
        }
        //if armor's slot is head
        if(armor.getSlot().equals("Head")) {
            //if head slot is empty
            if(head == null) {
                //updates player head slot
                head = armor;
                //removes armor from inv
                inv.getInventory().remove(armor);
                //updates player defense
                addDefense(armor.getDefense());
            //if head slot is not empty
            } else {
                //unequips current head armor
                unequipArmor(head, inv);
                //updates player head slot
                head = armor;
                //removes armor from inv
                inv.getInventory().remove(armor);
                //updates player defense
                addDefense(armor.getDefense());
            }
        //if armor's slot is body
        } else if(armor.getSlot().equals("Body")) {
            //if the body slot is empty
            if(body == null) {
                //updates player body slot
                body = armor;
                //removes armor from inv
                inv.getInventory().remove(armor);
                //updates player defense
                addDefense(armor.getDefense());
            //if body slot is not empty
            } else {
                //unequips current body armor
                unequipArmor(body, inv);
                //updates player body slot
                body = armor;
                //removes armor from inv
                inv.getInventory().remove(armor);
                //updates player defense
                addDefense(armor.getDefense());
            }
        //if armor's slot is legs
        } else if(armor.getSlot().equals("Legs")) {
            //if the legs slot is empty
            if(legs == null) {
                //updates the player legs slot
                legs = armor;
                //removes armor from inv
                inv.getInventory().remove(armor);
                //updates player defense
                addDefense(armor.getDefense());
            //if legs slot is not empty
            } else {
                //unequips current legs armor
                unequipArmor(legs, inv);
                //updates player legs slot
                legs = armor;
                //removes armor from inv
                inv.getInventory().remove(armor);
                //updates player defense
                addDefense(armor.getDefense());
            }
        }
    }

    //player functionality form unequipping armor
    /**
     * unequips the armor
     * @param armor stats
     * @param inv whats in inventory
     */
    public void unequipArmor(Armor armor, Inventory inv) {
        //cannot unequip nothing
        if(armor == null) {
            return;
        }
        //if armor's slot is head
        if(armor.getSlot().equals("Head")) {
            //verifies armor is actually equipped
            if(head.equals(armor)) {
                //updates player head slot
                head = null;
                //adds armor to inv
                inv.getInventory().add(armor);
                //updates player defense
                removeDefense(armor.getDefense());
            //cannot unequp armor that isn't equipped
            } else {
                return;
            }
        //if armor's slot is body
        } else if(armor.getSlot().equals("Body")) {
            //verifies armor is actually equipped
            if(body.equals(armor)) {
                //updates player body slot
                body = null;
                //adds armor to inv
                inv.getInventory().add(armor);
                //updates player defense
                removeDefense(armor.getDefense());
            //cannot unequip armor that isn't equipped
            } else {
                return;
            }
        //if armor's slot is legs
        } else if(armor.getSlot().equals("Legs")) {
            //verifies armor is actually equipped
            if(legs.equals(armor)) {
                //updates player legs slot
                legs = null;
                //adds armor to inv
                inv.getInventory().add(armor);
                //updates player defense
                removeDefense(armor.getDefense());
            //cannot unequip armor that isn't equipped
            } else {
                return;
            }
        }
    }

    //player functionality for equipping weapons
    //TODO: check if weapon is in inv
    /**
     * equips the weapon
     * @param newWeapon new weapon to equip
     * @param inv whats in inventory
     */
    public void equipWeapon(Weapon newWeapon, Inventory inv) {
        //cannot equip nothing
        if(newWeapon == null) {
            return;
        }
        //if weapon slot is empty
        if(weapon == null) {
            //update player weapon slot
            weapon = newWeapon;
            //remove newWeapon from inv
            inv.getInventory().remove(newWeapon);
            //update player damage
            setDamage(newWeapon.getDamage());
        //if weapon slot is not empty
        } else {
            //unequips current weapon
            unequipWeapon(weapon, inv);
            //updates player weapon slot
            weapon = newWeapon;
            //remove newWeapon from inv
            inv.getInventory().remove(newWeapon);
            //update player damage
            setDamage(newWeapon.getDamage());
        }
        
    }

    //player functionality for unequipping weapons
    /**
     * unequips the weapon
     * @param oldWeapon old weapon now
     * @param inv adds to inventory
     */
    public void unequipWeapon(Weapon oldWeapon, Inventory inv) {
        //cannot unequip nothing
        if(oldWeapon == null) {
            return;
        }
        //verifies weapon is actually equipped
        if(weapon.equals(oldWeapon)) {
            //update player weapon slot
            weapon = null;
            //adds weapon to inv
            inv.getInventory().add(oldWeapon);
            //update player damage
            setDamage("");
        //cannot unequip weapon that isn't equipped
        } else {
            return;
        }
    }
    
    //player functionality for equipping shields
    //TODO: check if newShield is in inv
    /**
     * equips the shield
     * @param newShield sheild stats
     * @param inv looks in inventory 
     */
    public void equipShield(Shield newShield, Inventory inv) {
        //cannot equip nothing
        if(newShield == null) {
            return;
        }
        //if shield slot is empty
        if(shield == null) {
            //update player shield slot
            shield = newShield;
            //remove newShield from inv
            inv.getInventory().remove(newShield);
            //updates player defense
            addDefense(newShield.getDefense());
        //if shield slot is not empty
        } else {
            //unequips current shield
            unequipShield(shield, inv);
            //updates player shield slot
            shield = newShield;
            //remove newShield from inv
            inv.getInventory().remove(newShield);
            //updates player defense
            addDefense(newShield.getDefense());
        }
    }

    //player functionality for unequipping shields
    /**
     * unequips the shield
     * @param oldShield takes sheild off
     * @param inv adds to inventory 
     */
    public void unequipShield(Shield oldShield, Inventory inv) {
        //cannot unequip nothing
        if(oldShield == null) {
            return;
        }
        //verifies oldShield is actually equipped
        if(shield.equals(oldShield)) {
            //update player shield slot
            shield = null;
            //adds oldShield to inv
            inv.getInventory().add(oldShield);
            //update player defense
            removeDefense(oldShield.getDefense());
        //cannot unequip shield that isn't equipped
        } else {
            return;
        }
    }
    /**
     * gets head armor
     * @return head armor
     */
    public Armor getHead() {
        return head;
    }
    /**
     * gets body armor
     * @return body armor
     */
    public Armor getBody() {
        return body;
    }
    /**
     * gets leg armor
     * @return leg armor
     */
    public Armor getLegs() {
        return legs;
    }
    /**
     * gets weapon
     * @return return weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }
    /**
     * gets the shield
     * @return returns the shield
     */
    public Shield getShield() {
        return shield;
    }
    
    

    //Not to be used by player, underlying code for testing(does not manipulate inventory)
    /**
     * sets head armor
     * @param armor head
     */
    public void setHead(Armor armor) {
        //set head slot to null
        if(armor == null) {
            //head slot is not empty
            if(head != null) {
                //update player defense
                removeDefense(head.getDefense());
                //update player head slot
                head = null;
            }
        }
        //can only set head slot to head armor
        if(armor.getSlot().equals("Head")) {
            //head slot is empty
            if(head == null) {
                //update player head slot
                head = armor;
                //update player defense
                addDefense(armor.getDefense());
            //head slot is not empty
            } else {
                //update player defense
                removeDefense(head.getDefense());
                addDefense(armor.getDefense());
                //update player head slot
                head = armor;
            }
        }
    }

    //Not to be used by player, underlying code for testing(does not manipulate inventory)
    /**
     * setsbody armor 
     * @param armor body armor
     */
    public void setBody(Armor armor) {
        //set body slot to null
        if(armor == null) {
            //body slot is not empty
            if(body != null) {
                //update player defense
                removeDefense(body.getDefense());
                //update player body slot
                body = null;
            }
        }
        //can only set body slot to body armor
        if(armor.getSlot().equals("Body")) {
            //body slot is empty
            if(body == null) {
                //update player body slot
                body = armor;
                //update player defense
                addDefense(armor.getDefense());
            //body slot is not empty
            } else {
                //update player defense
                removeDefense(body.getDefense());
                addDefense(armor.getDefense());
                //update player body slot
                body = armor;
            }
        }
    }

    //Not to be used by player, underlying code for testing(does not manipulate inventory)\
    /**
     * setsLeg armor
     * @param armor leg armor
     */
    public void setLegs(Armor armor) {
        //set legs slot to null
        if(armor == null) {
            //legs slot is not empty
            if(legs != null) {
                //update player defense
                removeDefense(legs.getDefense());
                //update player legs slot
                legs = null;
            }
        }
        //can only set legs slot to legs armor
        if(armor.getSlot().equals("Legs")) {
            //legs slot is empty
            if(legs == null) {
                //update player legs slot
                legs = armor;
                //update player defense
                addDefense(armor.getDefense());
            //legs slot is not empty
            } else {
                //update player defense
                removeDefense(legs.getDefense());
                addDefense(armor.getDefense());
                //update player legs slot
                legs = armor;
            }
        }
    }

    //Not to be used by player, underlying code for testing(does not manipulate inventory)
    /**
     * sets the weapon
     * @param newWeapon weapon set 
     */
    public void setWeapon(Weapon newWeapon) {
        //updates player weapon slot
        weapon = newWeapon;
        //update player damage
        setDamage(newWeapon.getDamage());
        //TODO: implement damage increase for two handing
    }

    //Not to be used by player, underlying code for testing(does not manipulate inventory)
    /**
     * sets the shield
     * @param newShield sets sheild
     */
    public void setShield(Shield newShield) {
        //shield slot is empty
        if(shield == null) {
            //update player shield slot
            shield = newShield;
            //update player defense
            addDefense(newShield.getDefense());
        //shield slot is not empty
        } else {
            //update player defense
            removeDefense(shield.getDefense());
            addDefense(newShield.getDefense());
            //update player shield slot
            shield = newShield;
        }
    }
}
