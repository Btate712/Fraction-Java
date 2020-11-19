package fractions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    @Test void testConstructor() {
      Fraction fraction1 = new Fraction(2, 3);
      assertEquals(2, fraction1.getNumerator(), "should return correct numerator for fraction that does not require reduction");
      assertEquals(3, fraction1.getDenominator(), "should return correct denominator for fraction that does not require reduction");

      Fraction fraction2 = new Fraction(300, 600);
      assertEquals(1, fraction2.getNumerator(), "should return correct numerator for fraction that requires reduction");
      assertEquals(2, fraction2.getDenominator(), "should return correct denominator for fraction that requires reduction");
    }

    @Test void testStringOutput() {
      Fraction fraction1 = new Fraction(5, 6);
      assertEquals("5/6", fraction1.toString(), "should correctly return string representation of fraction");
    }
}
