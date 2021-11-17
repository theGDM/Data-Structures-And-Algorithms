import java.util.*;

public class Subsets_Of_An_Array {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        //size of array
        int n = scn.nextInt();

        //declaration and initialization of array
        int[] arr = new int[n];

        //taking inputs in array
        for (int i = 0; i < n; ++i) {
            arr[i] = scn.nextInt();
        }

        //total subsets
        int totalSubsets = (int) Math.pow(2, n);

        //decimal number to binary number
        for (int dec = 0; dec < totalSubsets; ++dec) {
            int binaryNo = decimalToBinary(dec);
            int power = (int) Math.pow(10, n - 1);

            //convert binaryNo to equivalent subset
            for (int j = 0; j < n; ++j) {
                int bit = binaryNo / power;
                binaryNo = binaryNo % power;
                if (bit == 1) {
                    System.out.print(arr[j] + "\t");
                } else {
                    System.out.print("-" + "\t");
                }
                power = power / 10;
            }
            System.out.println();
            scn.close();
        }

    }
        

  public static int decimalToBinary(int decimal) {
    int binary = 0;
    int mul = 1;
    while (decimal != 0) {
      int rem = decimal % 2;
      decimal = decimal / 2;
      binary = binary + rem * mul;
      mul = mul * 10;
    }
    return binary;
  }

}