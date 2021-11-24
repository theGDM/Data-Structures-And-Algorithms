import java.util.*;

public class String_With_Differences_Of_Every_Two_Con {

  public static String solution(String str) {
    String oStr = "";
    for (int i = 0; i < str.length() - 1; ++i) {
      //first concatenating ith character
      oStr = oStr + str.charAt(i);

      //then concatenating diff of (i+1) and ith character
      int diff = str.charAt(i + 1) - str.charAt(i);
      oStr = oStr + diff;
    }

    //concatenation the last remaining character
    oStr = oStr + str.charAt(str.length() - 1);

    return oStr;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
    scn.close();
  }

}