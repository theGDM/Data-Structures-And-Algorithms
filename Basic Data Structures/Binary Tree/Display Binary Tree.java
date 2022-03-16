import java.util.*;

public class constructBT {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        } // default constructor

        Node(int data, Node left, Node right) { // parametrized constructor
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair() {
        }

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        if (arr.length == 0) {
            return new Node();
        }

        Node root = new Node(arr[0], null, null); // root node creation
        Pair rtp = new Pair(root, 1); // root pair creation

        Stack<Pair> stk = new Stack<>();
        stk.push(rtp);

        int i = 1;

        while (i < arr.length) {
            Pair top = stk.peek();

            if (top.state == 1) {
                if (arr[i] != null) {
                    Node left = new Node(arr[i], null, null); // left node
                    top.node.left = left; // making left node as the left child of top

                    Pair lp = new Pair(left, 1);
                    stk.push(lp);
                }
                ++i;
                ++top.state;
            } else if (top.state == 2) {
                if (arr[i] != null) {
                    Node right = new Node(arr[i], null, null); // left node
                    top.node.right = right; // making right node as the right child of top

                    Pair rp = new Pair(right, 1);
                    stk.push(rp);
                }
                ++i;
                ++top.state;
            } else {
                stk.pop();
            }
        }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        // print left child
        if (node.left != null) {
            System.out.print(node.left.data + " -> ");
        } else {
            System.out.print(". -> ");
        }

        System.out.print(node.data);

        // print right child
        if (node.right != null) {
            System.out.print(" <- " + node.right.data);
        } else {
            System.out.print(" <- .");
        }
        System.out.println();

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 57, null,
                null };
        Node root = construct(arr);
        display(root);
    }
}
