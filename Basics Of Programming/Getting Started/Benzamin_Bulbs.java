//Curious case of benzamin bulbs
import java.util.*;
  public class Benzamin_Bulbs{
  public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i=1;
    while (i <= n) {
        if (i * i <= n) {
            System.out.println(i * i);
        } else {
            break;
        }
        ++i;
    }
    scn.close();
   }
  }
