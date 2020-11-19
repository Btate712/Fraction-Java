package fractions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    @Test void testLowestCommonDenominator() {
      assertEquals(Fraction.lowestCommonDenominator(30, 20), 10, "lowestCommonDenominator of 30 and 20 should be 10");
    }

    @Test void testIsMultiple() {
      assertTrue(Fraction.isMultiple(25, 5), "25 is a multiple of 5");
      assertFalse(Fraction.isMultiple(10, 3), "10 is NOT a multiple of 3");
    }    

    @Test void testBiggest() {
      assertEquals(Fraction.biggest(20, 30), 30, "30 is bigger than 20");
      assertNotEquals(Fraction.biggest(20, 30), 20, "20 is NOT bigger than 30");
    }
}