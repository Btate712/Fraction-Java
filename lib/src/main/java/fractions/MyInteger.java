package fractions;

public class MyInteger {
  public static int greatestCommonDenominator(int a, int b) {
    int answer = 1;
    int bigger = biggest(a, b);
    int smaller = smallest(a, b);

    if(bigger == 0 || smaller == 0) {
      answer = 0;
    } else if (bigger % smaller == 0){
      answer = smaller;
    } else {
      for(int i = smaller / 2; i > 1; i --) {
        if(isMultiple(smaller, i) && isMultiple(bigger, i)) {
          answer = i;
          i = 0;
        }
      }
    } 

    return answer;
  }

  public static boolean isMultiple(int a, int b) {
    return a % b == 0;
  }

  public static int biggest(int a, int b) {
    return a > b ? a : b;
  }

  public static int smallest(int a, int b) {
    return a < b ? a : b;
  }

  public static int leastCommonMultiple(int a, int b) {
    int smaller = smallest(absoluteValue(a), absoluteValue(b));
    int larger = biggest(absoluteValue(a), absoluteValue(b));
    int answer = 0;

    for(int i = smaller; i <= smaller * larger; i += smaller) {
      if (i % larger == 0 || i == smaller * larger) {
        answer = i;
        i = smaller * larger + 1;
      }
    }

    return answer;
  }

  public static int absoluteValue(int a) {
    return a >= 0 ? a : a * -1;
  }
}