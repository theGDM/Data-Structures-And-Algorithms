import java.util.*;

public class Main {

  public static void main(String[] args) {
    int[] a = new int[]{1, 22, 4, -6, 89, 0};

    //Priority Queue devlaration and initialisation
    PriorityQueue<Integer> pq = new PriorityQueue<>(); //min-heap

    //O(nlog(n))
    for(int val : a){ 
      pq.add(val);
    }

    //increasing order print
    while(pq.size() > 0){
      System.out.println(pq.remove());
    }

    pq = new PriorityQueue<>(Collections.reverseOrder()); //min-heap

    //O(nlog(n))
    for(int val : a){ 
      pq.add(val);
    }

    //decreasing order print
    while(pq.size() > 0){
      System.out.println(pq.remove());
    }
  }
}
