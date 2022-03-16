import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void preorder(Node node){
    if(node == null) return;
  
    //pre region
    System.out.print(node.data + " ");
    //in rigion
    preorder(node.left);
    //post region
    preorder(node.right);
  }

  public static void inorder(Node node){
    if(node == null){
      return;
    }

    //pre
    inorder(node.left);
    //in
    System.out.print(node.data + " ");
    //post
    inorder(node.right);
  }

  public static void postorder(Node node){
    if(node == null){
      return;
    }

    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data + " ");
  }

  public static void levelOrder(Node node) {
    if(node == null) return;

    Queue<Node> q = new ArrayDeque<>();
    q.add(node); //adding root node

    while(q.size() != 0){
      int size = q.size();

      while(size-- > 0){
        Node rnode = q.remove(); //remove
        System.out.print(rnode.data + " "); //print

        if(rnode.left != null){ //adding left & right child of rnode to queue if they are not null
          q.add(rnode.left);
        }

        if(rnode.right != null){
          q.add(rnode.right);
        }
      }
      System.out.println(); //new line
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    levelOrder(root);
    // preorder(root);
    // System.out.println();
    // inorder(root);
    // System.out.println();
    // postorder(root);
  }

}
