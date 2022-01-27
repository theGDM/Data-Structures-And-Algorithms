import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode getTailNode(ListNode head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        ListNode dummyLeft = new ListNode(-1);
        ListNode leftTail = dummyLeft;
        ListNode dummyRight = new ListNode(-1);
        ListNode rightTail = dummyRight;
        ListNode tail = getTailNode(head);
        while(head != null){
            if(head.val <= tail.val){
                leftTail.next = head;
                leftTail = head;
            }else{
                rightTail.next = head;
                rightTail = head;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = dummyRight.next;
        return leftTail;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}
