import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue(int[] arr) {
      // data = new ArrayList<>();
      // for(int val : arr){ //TC : (n/2).h + (n/4).(h-1) + (h/8).(h-2) + ...... + 1.0 = O(nlogn)
      //   this.add(val);
      // }

      //efficient constructor
      data = new ArrayList<>();
      for(int val : arr){ //TC : O(n)
        data.add(val);
      }

      for(int i = data.size() / 2 - 1; i >= 0; --i){ //TC : (n/2).1 + (n/4).2 + (n/8).3 + .... + 1 * log(n) = O(logn)
        downHeapify(i);
      }
      //Overall TC : O(n) + O(logn) = O(n)
    }

    public void add(int val) {
      data.add(val); //add at the end
      upHeapify(data.size() - 1); //place it at right place by Heapify method
    }

    public void upHeapify(int i){
      if(i == 0){ //base case
        return;
      }

      int pi = (i - 1) / 2; //get parent index
      if(data.get(pi) > data.get(i)){
        swap(pi, i);
        upHeapify(pi);
      }// if parent value is less, we simply return
    }

    public int remove() {
      if(this.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      swap(0, data.size() - 1);
      int val = data.remove(data.size() - 1);
      downHeapify(0);
      return val;
    }

    public void downHeapify(int pi){
      int mini = pi; //assume parent is smallest element

      int li = 2 * pi + 1;
      if(li < data.size() && data.get(li) < data.get(mini)){
        mini = li;
      }

      int ri = 2 * pi + 2;
      if(ri < data.size() && data.get(ri) < data.get(mini)){
        mini = ri;
      }

      if(pi != mini){ //if pi == mini, that means parent is at right position, return
        swap(pi, mini);
        downHeapify(mini);
      }
    }

    public void swap(int i, int j){
      int ith = data.get(i);
      int jth = data.get(j);
      data.set(i, jth);
      data.set(j, ith);
    }

    public int peek() {
      if(this.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      return data.get(0); //return element at peek, as it has heighest priority
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    int[] arr = new int[]{10, 2, 17, 3, 18, 9, 21};
    
    PriorityQueue pq = new PriorityQueue(arr);

    while(pq.size() > 0){
      System.out.println(pq.peek());
      pq.remove();
    }
  }
}
