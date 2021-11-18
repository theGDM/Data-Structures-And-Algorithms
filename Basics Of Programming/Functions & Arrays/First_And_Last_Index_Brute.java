import java.util.*;

public class First_And_Last_Index_Brute {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        //taking array size
        int n = scn.nextInt();

        //declaring and initializing array
        int[] arr = new int[n];

        //getting elements in array
        for (int i = 0; i < n; ++i) {
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();

        //checking first index 
        int pos = -1;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == d) {
                pos = i;
                break;
            }
        }

        //first index
        System.out.println(pos);

        if (pos == -1) { //if there is no element found
            //last index
            System.out.println(pos);
        } else if (pos == n - 1) { //if element is present at last index 
            System.out.println(pos);
        } else if (arr[pos + 1] != arr[pos]) { //if there is only one matched element
            //last index
            System.out.println(pos);
        } else { //more than one matched element  
            while (pos < n && arr[pos] == d) {
                ++pos;
            }
            //last index
            System.out.println(pos - 1);
        }
        scn.close();
    }

}