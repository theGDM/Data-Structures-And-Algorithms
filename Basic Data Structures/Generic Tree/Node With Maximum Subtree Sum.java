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

  public static int maxS;
  public static int maxNodeS;
  public static int sum(Node node){
    if(node == null){ //no tree
      return 0;
    }

    int cSum = 0;
    for(Node child : node.children){
      cSum += sum(child);//getting sum of all subtrees rooted at current node
    }

    cSum += node.data;//adding current node data to cSum of subtree in post order
    if(cSum > maxS){ //checking whether cSum is greater than maxS
      maxS = cSum;
      maxNodeS = node.data;
    }

    return cSum;
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

    maxS = Integer.MIN_VALUE;
    maxNodeS = Integer.MIN_VALUE;
    sum(root);

    System.out.println(maxNodeS + "@" + maxS);
  } 

}
