import java.util.*;

public class StringBuilder_Basic_Operation {
    public static void main(String[] args) {
        //String declartion 
        String str = "RDJ";

        //StringBuilder declaration
        StringBuilder sb = new StringBuilder(str);

        //length -> o(n)
        System.out.println(sb.length()); //3

        //traversing -> o(n)
        for (int i = 0; i < sb.length(); ++i) {
            System.out.print(sb.charAt(i) + ", "); //R, D, J,
        }
        System.out.println();

        //adding string at last -> constant time
        sb.append(" is awesome"); //RDJ is awesome
        System.out.println(sb);

        //adding character at last
        sb.append("!"); //RDJ is awesome!
        System.out.println(sb);

        //updating an entry -> o(1)
        sb.setCharAt(sb.length()-1, '.'); //RDJ is awesome.
        System.out.println(sb);

        //Deleting an entry -> not constant time
        sb.deleteCharAt(3); //RDJis awesome.
        System.out.println(sb);

        //inserting character at specified index
        sb.insert(3, ' '); //RDJ is awesome.
        System.out.println(sb);

        sb.insert(8, 's'); // RDJ iss awesome.
        System.out.println(sb);

        //replace substr between start and ending index
        sb.replace(0, 3, "Captain America"); //Captain America iss awesome.
        System.out.println(sb);

        //converting StringBuilder back to String
        str = sb.toString();
        System.out.println(str); //Captain America iss awesome.
    }
}
