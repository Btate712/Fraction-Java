package fractions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyIntegerTest {
  @Test void testGreatestCommonDenominator() {
    assertEquals(10, MyInteger.greatestCommonDenominator(30, 10), "returns correctly for bigger % smaller == 0");
    assertEquals(10, MyInteger.greatestCommonDenominator(30, 20), "returns correctly for 30 and 20");
  }

  @Test void testIsMultiple() {
    assertTrue(MyInteger.isMultiple(25, 5), "25 is a multiple of 5");
    assertFalse(MyInteger.isMultiple(10, 3), "10 is NOT a multiple of 3");
  }    

  @Test void testBiggest() {
    assertEquals(30, MyInteger.biggest(20, 30), "30 is bigger than 20");
    assertNotEquals(20, MyInteger.biggest(20, 30), "20 is NOT bigger than 30");
  }

  @Test void testSmallest() {
    assertEquals(20, MyInteger.smallest(20, 30), "30 is NOT smaller than 20");
    assertNotEquals(30, MyInteger.smallest(20, 30), "20 is smaller than 30");
  }

  @Test void testLeastCommonMultiple() {
    assertEquals(300, MyInteger.leastCommonMultiple(25, 60), "should find the least common multiple between two numbers");
  }
}
