import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      data.add(val); //add at the end O(1)
      int ci = data.size() - 1; //get the position at which val addede(ci)
      upHeapify(ci); //place it at right place by Up Heapify method O(log(n))
    }

    public void upHeapify(int ci){
      if(ci <= 0){ //base case
        return;
      }

      int pi = (ci - 1) / 2; //get parent index
      if(data.get(pi) > data.get(ci)){
        swap(pi, ci);
      }

      upHeapify(pi);
      // if parent value is less, we simply return
    }

    public int remove() {
      if(this.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      int rData = data.get(0);
      data.set(0, data.get(data.size() - 1)); //bring at peek O(1)
      data.remove(data.size() - 1); //remove from end O(1)
      downHepify(0); //place it at right place by Up Heapify method O(log(n))
      return rData;
    }

    public void downHepify(int pi){
      if(pi >= data.size()){ //base cases
        return;
      }

      //getting left and right child indices
      int lci = 2 * pi + 1;
      int rci = 2 * pi + 2;

      if(lci >= data.size() && rci >= data.size()){ //both child are not there
        return;
      }else if(rci >= data.size()){ //no right child
        if(data.get(pi) <= data.get(lci)){
          return;
        }else{
          swap(pi, lci);
          downHepify(lci);
        }
      }else if(lci >= data.size()){ //no left child
        if(data.get(pi) <= data.get(rci)){
          return;
        }else{
          swap(pi, rci);
          downHepify(rci);
        }
      }else{ //both child are there
        if(data.get(pi) <= data.get(lci) && data.get(pi) <= data.get(rci)){ //if parent is less than both child, then return
          return;
        }else if(data.get(lci) <= data.get(pi) && data.get(lci) <= data.get(rci)){
          swap(pi, lci);
          downHepify(lci);
        }else{
          swap(pi, rci);
          downHepify(rci);
        }
      }
    }

    public void swap(int pi, int ci){
      int pith = data.get(pi);
      int cith = data.get(ci);
      data.set(pi, cith);
      data.set(ci, pith);
    }

    public int peek() {
      if(this.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      return data.get(0); //return element at peek, as it has heighest priority O(1)
    }

    public int size() {
      return data.size(); //O(n)
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
