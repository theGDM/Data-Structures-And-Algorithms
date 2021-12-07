import java.io.*;

public class All_Indices {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int count) {
        // write ur code here
        //base case
        if(idx == arr.length){
            int[] tempArr = new int[count];
            return tempArr;
        }
        
        if(arr[idx] == x){
            int[] tempArr = allIndices(arr, x, idx + 1, count + 1);
            tempArr[count] = idx;
            return tempArr;
            
        }else{
            int[] tempArr = allIndices(arr, x, idx + 1, count);
            return tempArr;
        }
    }

}