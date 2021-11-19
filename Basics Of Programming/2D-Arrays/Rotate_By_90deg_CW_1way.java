import java.util.*;

public class Rotate_By_90deg_CW_1way {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] mat = new int[n][n];
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        
        transpose(mat);
        reverseEachRow(mat);
        display(mat);
        scn.close();
    }
    
    //reversing one row at a time
    public static void reverse(int[][] mat,int row){
        int left = 0;
        int right = mat[0].length - 1;
        while(left < right){
            int temp = mat[row][left];
            mat[row][left] = mat[row][right];
            mat[row][right] = temp;
            ++left;
            --right;
        }
        
    }
    
    //row by row reversal after transposing
    public static void reverseEachRow(int[][] mat){
        for(int i = 0; i < mat.length; ++i){
            reverse(mat,i);
        }
    }
    
    //swap the elements of matrix, in upperhalf to get transpose
    public static void swap(int[][] mat,int i,int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
    
    //transpose the given matrix 
    public static void transpose(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = i+1; j < mat[0].length; j++){
                swap(mat,i,j);
            }
        }
    }
    
    //display function
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}