import java.util.*;

public class Any_Base_To_Any {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sourceBase = scn.nextInt();
    int destBase = scn.nextInt();
    int res = anyBase(n, sourceBase, destBase);
    System.out.println(res);
    scn.close();
  }

  public static int anyBase(int n, int sB, int dB) {
    int m = anyBaseToDecimal(n, sB); //function to convert any base number to decimal number
    return decimalToAnyBase(m, dB); //function to covert decimal number to any base number
  }

  public static int anyBaseToDecimal(int n, int sB) {
    int res = 0;
    int mul = 1;
    while (n != 0) {
      int rem = n % 10;
      int div = n / 10;
      n = div;
      res = res + rem * mul;
      mul *= sB;
    }
    return res;
  }

  public static int decimalToAnyBase(int n, int dB) {
    int res = 0;
    int mul = 1;
    while (n != 0) {
      int rem = n % dB;
      int div = n / dB;
      n = div;
      res = res + rem * mul;
      mul *= 10;
    }
    return res;
  }

}