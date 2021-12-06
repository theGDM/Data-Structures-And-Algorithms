import java.util.*;

public class tower_of_hanoi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sT = scn.nextInt();
        int dT = scn.nextInt();
        int aT = scn.nextInt();
        toh(n, sT, dT, aT);
        scn.close();
    }

    public static void toh(int n, int sT, int dT, int aT){
        if(n == 0) return; //Base case
        
        toh(n - 1, sT, aT, dT);
        //Faith -> n - 1 disks from source to auxiliary
        
        System.out.println(n + "[" + sT + " -> " + dT + "]");
        //Move nth disks from source to source to destination
        
        toh(n - 1, aT, dT, sT);
        //Faith -> n - 1 disks from auxiliary to destination
        
    }

}