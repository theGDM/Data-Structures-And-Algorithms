import java.util.*;

public class ArrayList_Basic_Operation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //declartion of arraylist, having 0 size
        ArrayList<Integer> al = new ArrayList<>();

        //getting elements in arraylist
        for (int i = 0; i < n; ++i) {
            Integer x = scn.nextInt();
            al.add(x);
        }

        al.add(56);
        al.add(34);

        System.out.println(al); //This prints the entire list in one go, it call toString method by default

        //toString()
        String str = al.toString(); //so toString method get invoked automatically when we directly prints an arraylist
        //as this proves that concept
        System.out.println(str);

        //using for loop display, to print arrayList just like the way above
        System.out.print("[");
        for (int i = 0; i < al.size() - 1; ++i) {
            System.out.print(al.get(i) + ", ");
        }
        System.out.print(al.get(al.size() - 1) + "]\n");

        //declaring array literal
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };

        //set element at any index in arraylist
        al.set(2, 199);

        //for each loop to display
        for (Integer val : al) {
            System.out.print(val + " ");
        }
        System.out.println();

        //delete any entry
        al.remove(3);
        System.out.println(al);
        
        System.out.println(arr);//we will get array in has format
        System.out.print(arr.toString());//sam format as above
        scn.close();
    }
}
