import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int maxDia;
  public static int diameter(Node node){
    if(node == null){
      return 0;
    }

    int fdh = -1;
    int sdh = -1;
    for(Node child : node.children){
      int ch = diameter(child);
      //edge postorder
      if(ch >= fdh){
        sdh = fdh;//update second deepest height with fdh
        fdh = ch; //update first deepest height with current height
      }else if(ch >= sdh){
        sdh = ch; 
      }
    }

    //node postorder
    if(fdh + sdh + 2 > maxDia){
      maxDia = fdh + sdh + 2;
    }

    return fdh + 1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    
    maxDia = 0;
    diameter(root);
    System.out.println(maxDia);
  }

}
