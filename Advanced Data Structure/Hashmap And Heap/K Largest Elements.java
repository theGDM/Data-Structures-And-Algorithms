import java.util.*;
import java.lang.*;
import java.io.*;
class Main{
 	public static void main (String[] args) throws IOException{
 	 	Scanner scn= new Scanner(System.in);
 	    int n = scn.nextInt();
 	 	int[] num = new int[n];
 	 	for (int i = 0; i < n; i++) {
 	 	 	num[i] = scn.nextInt();
 	 	}
 	 	int k = scn.nextInt();
 	 	solve(n,num,k);
 	}
 	// -----------------------------------------------------
 	// This is a functional problem. Only this function has to be written.
 	// This function takes as input an array,n length of array and k.
 	// It should print required output.

	//O((n+k)logn)
 	public static void solve(int n, int[] arr, int k){
		//max-heap
 	    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		//O(nlogn)
		for(int i = 0;i < arr.length; ++i){
			pq.add(arr[i]);
		}
	
		ArrayList<Integer> res = new ArrayList<>();

		//O(klogn) //since the number of elements in priority queue is n(size of array)
		while(k-- > 0){
			res.add(pq.remove());
		}

		for(int i = 0;i < res.size(); ++i){
			System.out.print(res.get(i) + " ");
		}
    }
 }
