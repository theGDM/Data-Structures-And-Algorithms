import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children;

    Node(){//default explicit constructor
      this.data = 0;
      this.children = new ArrayList<>();
    }

    Node(int val){//parametrized constructor
      this.data = val;
      this.children = new ArrayList<>();
    }
  }

  public static void display(Node node) {
    if(node == null){
      //there is no tree
      return;
    }

    //Node preorder(meeting expectation), root tum apne childs ko pahle print kara lo
    System.out.print(node.data + " -> ");
    for(Node child : node.children){
      System.out.print(child.data + ", ");
    }
    System.out.println(".");

    for(Node child : node.children){
      //Edge preorder
      display(child); //faith, har node apni subtree print kara lo
      //Edge postorder
    }

    //Node postorder
  }

  public static Node construct(int[] arr) {
    Node root = null;
    Stack<Node> stk = new Stack<>();
    for(int i = 0;i < arr.length; ++i){
      if(arr[i] == -1){ //postorder (child -> parent)
        stk.pop();
      }else{
        //1. creation of node
        Node curr = new Node(arr[i]);
        if(stk.size() == 0){
          //curr node is the root Node(root has no parent)
          root = curr;
        }else{
          stk.peek().children.add(curr);
        }
        //3.preorder(push curr node in stack)
        stk.push(curr);
      }
    }
    return root;
  }

  public static int size(Node node){
    //Base case
    if(node == null){ //no tree
      return 0;
    }

    int count = 0;
    for(Node child : node.children){
      count = count + size(child); //faith -> get size of subtrees whose root are the child
    }                              //of root tree.
    return count + 1; //add root node too//meeting expectation
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
    int sz = size(root);
    System.out.println(sz);
    // display(root);
  }

}
