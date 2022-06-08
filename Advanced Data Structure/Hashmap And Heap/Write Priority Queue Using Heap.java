import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
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
      downHepify(0);
      return val;
    }

    public void downHepify(int pi){
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
        downHepify(mini);
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
