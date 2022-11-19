package game_implementations;

import entity.Entity;
/**
 * Combat System class for fighting in the dungeon
 * @author jlb74
 *
 */
public class CombatSystem {

    //temp for testing
	
	/**
	 * This is temperary function for testing
	 * @param e1 first entity making  an attack
	 * @param e2 second entity is taking damage if dice roll is sucessful
	 */
    public void weaponAttack(Entity e1, Entity e2) {
        Dice dice = new Dice();
        //Dice playerDamage = new Dice(p.getWeapon().getDamage());
        //don't remember if d20 can be the same as def
        //update for crits
        if(dice.d20() >= e2.getDefense()) {
            dice.setDiceType(e1.getDamage());
            e2.takeDamage(dice.roll());
        }
    }
    //TODO: add damage to entity class
    //player damage is weapon damage (or bare hands damage)
    //enemy damage is based on the invididual (claws, sword, fire, etc.)


}
