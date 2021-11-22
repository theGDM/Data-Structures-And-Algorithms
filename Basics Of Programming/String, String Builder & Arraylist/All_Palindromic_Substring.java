import java.util.*;

public class All_Palindromic_Substring {

	public static void solution(String str){
		//write your code here
		for(int st = 0;st < str.length();++st){
		    for(int en = st;en < str.length();++en){
		      String substr = str.substring(st,en+1);
		      if(isPalindrome(substr)){
		          System.out.println(str.substring(st,en+1));
		      }
		    }
		}
		
	}
    
    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
        solution(str);
        scn.close();
	}

}