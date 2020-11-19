package fractions;

public class Fraction {
  private int numerator;
  private int denominator;

  public Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    reduce();
  }

  public int getNumerator() {
    return this.numerator;
  }

  public int getDenominator() {
    return this.denominator;
  }

  private void reduce() {
    int dividend = MyInteger.lowestCommonDenominator(this.numerator, this.denominator);
    this.numerator /= dividend;
    this.denominator /= dividend;
    System.out.printf("dividend: %d, fraction: %d/%d\n", dividend, this.numerator, this.denominator);
  }
}