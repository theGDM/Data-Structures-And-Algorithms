import java.util.*;

public class Toggle_Case {

	public static String toggleCase(String str){
		//write your code here
		//can not do inplace
		String res = "";
        for(int i = 0;i < str.length();++i){
            char ch = str.charAt(i);
            
            if( ch >= 'a' && ch <= 'z'){
                res = res + (char)(ch - 32);//explicit type casting
            }else{
                res = res + (char)(ch + 32);//explicit type casting
            }
        }
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        System.out.println(toggleCase(str));
        scn.close();
	}

}