import java.util.*;

public class Sum_Of_Two_Arrays {

  public static void main(String[] args) throws Exception {
    // write your code here

    Scanner scn = new Scanner(System.in);
    //array 1
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];

    for (int i = 0; i < n1; ++i) {
      arr1[i] = scn.nextInt();
    }

    //array 2
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];

    for (int i = 0; i < n2; ++i) {
      arr2[i] = scn.nextInt();
    }

    //array 3
    int n3 = Math.max(n1, n2) + 1;
    int[] arr3 = new int[n3];

    int carry = 0;
    int d1, d2, temp, rem;
    int i1 = n1 - 1, i2 = n2 - 1, i3 = n3 - 1;

    while (i1 >= 0 || i2 >= 0) {
      //negative index -> Index out of bound
      d1 = i1 >= 0 ? arr1[i1] : 0;
      d2 = i2 >= 0 ? arr2[i2] : 0;

      temp = d1 + d2 + carry;
      rem = temp % 10;
      carry = temp / 10;

      arr3[i3] = rem;
      --i1;
      --i2;
      --i3;
    }
    
    //skipping leading zeroes
    int idx =0;
    while(arr3[idx]==0){
       ++idx; 
    }
    
    for (int i = idx; i < arr3.length; ++i) {
      System.out.println(arr3[i]);
    }
    scn.close();
  }

}