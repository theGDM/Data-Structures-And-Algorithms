import java.util.*;

public class String_Compression_2nd_Way {

  public static String compression1(String str) {
    // write your code here
    String  outputStr = "";
    for (int i = 0; i < str.length(); ++i) {
      if (i == 0) {
        outputStr = outputStr + str.charAt(0);
      } else if (str.charAt(i) != outputStr.charAt(outputStr.length() - 1)) {
        outputStr = outputStr + str.charAt(i);
      }
    }
    return outputStr;
  }

  public static String compression2(String str) {
    // write your code here
    String outputStr = "";
    int freq = 0;
    for (int i = 0; i < str.length(); ++i) {
      if (i == 0) {
        outputStr = outputStr + str.charAt(0);
      } else if (str.charAt(i) != str.charAt(i - 1)) {
        int j = i - 1;
        while (j >= 0 && str.charAt(j) == str.charAt(i - 1)) {
          ++freq;
          --j;
        }
        if (freq > 1) {
          outputStr = outputStr + freq;
        }
        outputStr = outputStr + str.charAt(i);
        freq = 0;
      } else if (i == str.length() - 1) {
        int j = i;
        while (j >= 0 && str.charAt(j) == str.charAt(i)) {
          ++freq;
          --j;
        }
        if (freq > 1) {
          outputStr = outputStr + freq;
        }
      }
    }
    return outputStr;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(compression1(str));
    System.out.println(compression2(str));
    scn.close();
  }

}