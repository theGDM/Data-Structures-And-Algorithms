import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long same = k * 1; //last two fence have same color
        long diff = k * (k - 1); //last two fence have diff color
        long total = same + diff;
        for(int i = 3; i <= n; ++i){
            same = diff * 1; //current same = pichli baar ka diff contribute karega
            diff = total * (k - 1); //current diff = pichli baar ka total contribute karega
            total = same + diff;
        }

        System.out.println(total);
    }
}
