package fractions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyIntegerTest {
  @Test void testLowestCommonDenominator() {
    assertEquals(MyInteger.lowestCommonDenominator(30, 10), 10, "returns correctly for bigger % smaller == 0");
    assertEquals(MyInteger.lowestCommonDenominator(30, 20), 10, "returns correctly for 30 and 20");
  }

  @Test void testIsMultiple() {
    assertTrue(MyInteger.isMultiple(25, 5), "25 is a multiple of 5");
    assertFalse(MyInteger.isMultiple(10, 3), "10 is NOT a multiple of 3");
  }    

  @Test void testBiggest() {
    assertEquals(MyInteger.biggest(20, 30), 30, "30 is bigger than 20");
    assertNotEquals(MyInteger.biggest(20, 30), 20, "20 is NOT bigger than 30");
  }

  @Test void testSmallest() {
    assertEquals(MyInteger.smallest(20, 30), 20, "30 is NOT smaller than 20");
    assertNotEquals(MyInteger.smallest(20, 30), 30, "20 is smaller than 30");
  }
}
