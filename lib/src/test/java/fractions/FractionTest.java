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

      Fraction fraction3 = new Fraction("2 / 3");
      assertEquals(2, fraction3.getNumerator(), "should correctly assign numerator when initialized with a valid string");
      assertEquals(3, fraction3.getDenominator(), "should correctly assign denominator when initialized with a valid string");

      Fraction fraction4 = new Fraction("invalid fraction");
      assertFalse(fraction4.isValid(), "should set valid flag to false if invalid input is used to initialize fraction");
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

      Fraction fraction3 = new Fraction(1, 2);
      fraction3.divideBy(0);
      assertFalse(fraction3.isValid(), "should set valid flag to false when divide by zero is attempted");
    }

    @Test void testAddition() {
      Fraction fraction1 = new Fraction("1/2");
      fraction1.addTo(2);
      assertEquals("5/2", fraction1.toString(), "should correctly add whole number to fraction");

      Fraction fraction2 = new Fraction("3/25");
      Fraction fraction3 = new Fraction("7/30");
      fraction2.addTo(fraction3);
      assertEquals("53/150", fraction2.toString(), "should correctly add another fraction to fraction");
    }

    @Test void testInvert() {
      Fraction fraction1 = new Fraction("2/3");
      fraction1.invert();
      assertEquals("3/2", fraction1.toString());

      Fraction fraction2 = new Fraction(0, 1);
      fraction2.invert();
      assertFalse(fraction2.isValid(), "should set valid flag to false when invert is called on fraction with numerator of zero");
    }
}
