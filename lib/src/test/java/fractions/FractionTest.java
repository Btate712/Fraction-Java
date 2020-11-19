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
      Fraction fraction = new Fraction(5, 6);
      assertEquals("5/6", fraction.toString(), "should correctly return string representation of fraction");
    }

    @Test void testMultiplication() {
      Fraction fraction1 = new Fraction(4, 9);
      fraction1.multiplyBy(2);
      assertEquals("8/9", fraction1.toString(), "should correctly multiply without the need for reduction");

      Fraction fraction2 = new Fraction(1, 6);
      fraction2.multiplyBy(2);
      assertEquals("1/3", fraction2.toString(), "should correctly multiply when reduction is required");
    }

    @Test void testDivision() {
      Fraction fraction1 = new Fraction(4, 9);
      fraction1.divideBy(2);
      assertEquals("2/9", fraction1.toString(), "should correctly divide when reduction is required");

      Fraction fraction2 = new Fraction(1, 6);
      fraction2.divideBy(2);
      assertEquals("1/12", fraction2.toString(), "should correctly divide without the need for reduction");
    }
}
