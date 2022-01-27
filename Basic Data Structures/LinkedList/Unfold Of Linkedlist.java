import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    public static void unfold(ListNode head) {
        ListNode firstHead = new ListNode(-1);
        ListNode firstTail = firstHead;
        ListNode secondHead = new ListNode(-1);
        ListNode secondTail = secondHead;
        
        while(head != null){
            firstTail.next = head;
            firstTail = head;
            head = head.next;
            
            if(head != null){
               secondTail.next = head;
               secondTail = head;
               head = head.next;
            }
        }
        
        firstTail.next = null;
        secondTail.next = null;
        
        firstTail.next = reverse(secondHead.next);
        head = firstHead.next;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
