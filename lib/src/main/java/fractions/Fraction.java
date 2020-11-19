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

  public void multiplyBy(Fraction a) {
    this.numerator *= a.numerator;
    this.denominator *= a.denominator;
     
    if(this.denominator == 0) {
      this.valid = false;
    }
    
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

  public void addTo(int a) {
    a *= this.denominator;
    this.numerator += a;
  }

  public void addTo(Fraction a) {
    int sumDenominator = MyInteger.leastCommonMultiple(this.denominator, a.denominator);
    this.numerator = this.numerator * (sumDenominator / this.denominator) + a.numerator * (sumDenominator / a.denominator);
    this.denominator = sumDenominator;
    reduce();
  }

  public void subtract(int a) {
    a *= -1;
    addTo(a);
  }

  public void subtract(Fraction a) {
    a.multiplyBy(-1);
    addTo(a);
  }

  public void invert() {
    if(this.numerator == 0) {
      this.valid = false;
    } else {
    int temp = this.numerator;
    this.numerator = this.denominator;
    this.denominator = temp;
    }
  }

  public String toString() {
    return String.format("%d/%d", numerator, denominator);
  }

  public String toMixedNumberString() {
    int wholeNumber = this.numerator / this.denominator;
    String returnString = "";

    if(wholeNumber != 0) {
      returnString = String.format("%d ", wholeNumber);
      returnString += String.format("%d/%d", this.numerator % this.denominator, this.denominator);
    } else {
      returnString = this.toString();
    }

    return returnString;
  }

  private void reduce() {
    if(this.isValid()) {
      int dividend = MyInteger.greatestCommonDenominator(this.numerator, this.denominator);
      if(dividend != 0) {
        this.numerator /= dividend;
        this.denominator /= dividend;
      }
    }
  }
}