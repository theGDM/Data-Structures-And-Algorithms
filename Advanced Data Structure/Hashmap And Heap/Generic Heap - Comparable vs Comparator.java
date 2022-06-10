import java.io.*;
import java.util.*;

public class Main {
  public static class PriorityQueue<T> {
    ArrayList<T> data;
    Comparator comp;

    public PriorityQueue() {
      data = new ArrayList<>();
      comp = null;
    }

    public PriorityQueue(Comparator comp) {
      data = new ArrayList<>();
      this.comp = comp;
    }

    public void add(T val) {
      data.add(val); //add at the end
      upHeapify(data.size() - 1); //place it at right place by Heapify method
    }

    public void upHeapify(int i){
      if(i == 0){ //base case
        return;
      }

      int pi = (i - 1) / 2; //get parent index
      if(isSmaller(i, pi)){
        swap(pi, i);
        upHeapify(pi);
      }// if parent value is less, we simply return
    }

    private boolean isSmaller(int i, int j){
      if(comp == null){
        Comparable ith = (Comparable)data.get(i);
        Comparable jth = (Comparable)data.get(j);

        if(ith.compareTo(jth) < 0){
          return true;
        }else{
          return false;
        }
      }else{
        T ith = data.get(i);
        T jth = data.get(j);
        if(comp.compare(ith, jth) < 0){
          return true;
        }else{
          return false;
        }
      }
    }

    public T remove() {
      if(this.size() == 0){
        System.out.println("Underflow");
        return null;
      }

      swap(0, data.size() - 1);
      T val = data.remove(data.size() - 1);
      downHepify(0);
      return val;
    }

    public void downHepify(int pi){
      int mini = pi; //assume parent is smallest element

      int li = 2 * pi + 1;
      if(li < data.size() && isSmaller(li, mini)){
        mini = li;
      }

      int ri = 2 * pi + 2;
      if(ri < data.size() && isSmaller(ri, mini)){
        mini = ri;
      }

      if(pi != mini){ //if pi == mini, that means parent is at right position, return
        swap(pi, mini);
        downHepify(mini);
      }
    }

    public void swap(int i, int j){
      T ith = data.get(i);
      T jth = data.get(j);
      data.set(i, jth);
      data.set(j, ith);
    }

    public T peek() {
      if(this.size() == 0){
        System.out.println("Underflow");
        return null;
      }
      
      return data.get(0); //return element at peek, as it has heighest priority
    }

    public int size() {
      return data.size();
    }
  }

  static class Student implements Comparable<Student>{
    int rno;
    int ht;
    int wt;

    Student(int rno, int ht, int wt){
      this.rno = rno;
      this.ht = ht;
      this.wt = wt;
    }

    public int compareTo(Student o){
      return this.rno - o.rno;
    }

    public String toString(){
      return "Rno = " + this.rno + ", Ht = " + this.ht + ", Wt = " + this.wt;
    }
  }

  //comparison on the basis of height
  static class StudentHtComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
      return s1.ht - s2.ht;
    }
  }

  //comparison on the basis of weight
  static class StudentWtComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
      return s1.wt - s2.wt;
    }
  }

  public static void main(String[] args) throws Exception {
    // PriorityQueue<Student> pq = new PriorityQueue<>(); //on the basis of rno
    // PriorityQueue<Student> pq = new PriorityQueue<>(new StudentWtComparator());
    PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator());

    pq.add(new Student(10, 180, 81));
    pq.add(new Student(2, 185, 85));
    pq.add(new Student(12, 170, 84));
    pq.add(new Student(18, 179, 88));
    pq.add(new Student(7, 182, 82));

    while(pq.size() > 0){
      System.out.println(pq.peek());
      pq.remove();
    }
  }
}
