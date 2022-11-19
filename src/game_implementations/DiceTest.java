package game_implementations;

//import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertTrue;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
/**
 * class of dice test to make sure the rolls arent fixed
 * @author jlb74
 *
 */
public class DiceTest {

  /**
   * tests the d4 roll
   */
  public void testd4() {
      Dice d = new Dice("d4");
      int x = d.roll();
      assertTrue(x >= 1 && x <=4);
      System.out.println("d4: " + x);
  }
  
  /**
   * tests the d6
   */
  public void testd6() {
      Dice d = new Dice("d6");
      int x = d.roll();
      assertTrue(x >= 1 && x <=6);
      System.out.println("d6: " + x);
  }

  /**
   * tests the d8
   */
  public void testd8() {
      Dice d = new Dice("d8");
      int x = d.roll();
      assertTrue(x >= 1 && x <= 8);
      System.out.println("d8: " + x);
  }

  /**
   * tests the d10
   */
  public void testd10() {
      Dice d = new Dice("d10");
      int x = d.roll();
      assertTrue(x >= 0 && x <= 10);
      System.out.println("d10: " + x);
  }

  /**
   * tests the d12
   */
  public void testd12() {
      Dice d = new Dice("d12");
      int x = d.roll();
      assertTrue(x >= 1 && x <= 12);
      System.out.println("d12: " + x);
  }

  /**
   * tests the d20
   */
  public void testd20() {
      Dice d = new Dice("d20");
      int x = d.roll();
      assertTrue(x >= 1 && x <= 20);
      System.out.println("d20: " + x);
  }
  /**
   * tests the d100
   */
  public void testd100() {
      Dice d = new Dice("d100");
      int x = d.roll();
      assertTrue(x >= 0 && x <= 100);
      System.out.println("d100: " + x);
  }
}
