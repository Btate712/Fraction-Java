package fractions;

public class Fraction {
  private int numerator;
  private int denominator;
  private boolean valid = true;
  
  public Fraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    reduce();
  }

  public Fraction(String fractionString) {
    String [] splitString = fractionString.split("/");
    
    try {
      this.numerator = Integer.parseInt(splitString[0].strip());
      this.denominator = Integer.parseInt(splitString[1].strip());
      reduce();
    } catch(Exception e) {
      this.valid = false;
      System.out.println("String provided is not valid for conversion to a fraction");
      this.numerator = 1;
      this.denominator = 0;
    } 
  }

  public boolean isValid() {
    if(this.denominator == 0) {
      this.valid = false;
    }

    return this.valid;
  }

  public int getNumerator() {
    return this.numerator;
  }

  public int getDenominator() {
    return this.denominator;
  }

  public void multiplyBy(int a) {
    this.numerator *= a;
    reduce();
  }

  public void divideBy(int a) {
    if (a == 0) {
      this.valid = false;
    } else {
      this.denominator *= a;
      reduce();
    }
  }

  public String toString() {
    return String.format("%d/%d", numerator, denominator);
  }

  private void reduce() {
    int dividend = MyInteger.lowestCommonDenominator(this.numerator, this.denominator);
    this.numerator /= dividend;
    this.denominator /= dividend;
  }
}