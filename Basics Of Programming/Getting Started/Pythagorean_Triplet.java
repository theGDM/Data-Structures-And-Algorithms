//Pythgorean triplets 
import java.util.*;

public class Pythagorean_Triplet {

  public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);

    //taking input value in variables a, b, c
    int a = scn.nextInt();
    int b = scn.nextInt();
    int c = scn.nextInt();


    if (a > b && a > c) { //if a is greater
      if (a * a == b * b + c * c) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
    } else if (b > a && b > c) { // if b is greater
      if (b * b == a * a + c * c) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
    } else { //if c is greater
      if (c * c == a * a + b * b) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
    }
    scn.close();
  }
}