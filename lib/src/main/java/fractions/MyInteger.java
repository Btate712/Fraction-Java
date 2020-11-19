package fractions;

public class MyInteger {
  public static int lowestCommonDenominator(int a, int b) {
    int answer = 1;
    int bigger = biggest(a, b);
    int smaller = smallest(a, b);

    if(bigger % smaller == 0){
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
}