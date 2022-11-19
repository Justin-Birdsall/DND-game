package game_implementations;

//import java.util.LinkedList;
//import java.io.*;
import java.util.*;
/**
 * inventory class for the player
 * @author jlb74
 *
 */
public class Inventory {
  //private int slots = 10;

  /**Items[] inventory;
  inventory = 
  public 
  */
  //Items[] inventory = new Items[slots];
  private ArrayList<Items> inventory = new ArrayList<>();
  /**
   * gets the inventory 
   * @return returns whats in the inventory
   */
  public ArrayList<Items> getInventory() {
      return inventory;
  }
  /**
   * adds item to the Inventory
   * @param i ads the item to the array
   */
  public void addToInventory(Items i) {
      inventory.add(i);
  }
  /**
   * removes items from inventory
   * @param item to be removed
   */
  public void removeFromInventory(Items item) {
      for(int i = 0; i < inventory.size(); i++) {
          if(inventory.get(i).equals(item)) {
              inventory.remove(i);
          }
      }
  }
/**
 * prints the inventory 
 */
  public void printInv() {
      System.out.println(inventory);
  }

}
