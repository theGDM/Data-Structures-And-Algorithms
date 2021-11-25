import java.util.*;

public class Remove_Primes_1Way {

  public static void solution(ArrayList<Integer> al) {
    // write your code here
    int flag;
    for (int i = 0; i < al.size(); ++i) {
      flag = 1;
      for (int j = 2; j * j <= al.get(i); ++j) {
        if (al.get(i) % j == 0) {
          flag = 0;
          break;
        }
      }
      if (flag == 1) {
        al.remove(i);
        --i;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0 ; i < n; i++) {
      al.add(scn.nextInt());
    }
    solution(al);
    System.out.println(al);
    scn.close();
  }

}