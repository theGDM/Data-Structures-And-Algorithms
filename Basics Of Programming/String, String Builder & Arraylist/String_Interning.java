public class String_Interning {
    public static void main(String[] args) {
        //String interning understanding
        String str1 = "pepcoder";
        String str2 = new String("hello");
        String str3 = "hello";
        String str4 = new String("hello");
        String str5 = "hello";
        
        System.out.println(str2 == str3);
        System.out.println(str2 == str5);
        System.out.println(str3 == str5);
        System.out.println(str2 == str4);
        System.out.println(str1 == str3);
        System.out.println(str2.equals(str3));
        System.out.println(str2.equals(str5));
        System.out.println(str2.equals(str4));
        System.out.println(str1.equals(str2));
    }
}
