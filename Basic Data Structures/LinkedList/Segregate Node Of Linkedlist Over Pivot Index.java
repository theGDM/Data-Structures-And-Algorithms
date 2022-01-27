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
  
  public static int getPivotElement(int pivotIdx, ListNode head){
      int i = 0;
      while(i < pivotIdx && head != null){
          head = head.next;
          ++i;
      }
      return head.val;
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
    ListNode leftHead = new ListNode(-1);
    ListNode leftTail = leftHead;
    ListNode rightHead = new ListNode(-1);
    ListNode rightTail = rightHead;
    
    int pivot = getPivotElement(pivotIdx, head);
    while(head != null){
        if(head.val <= pivot){
            leftTail.next = head;
            leftTail = head;
        }else{
            rightTail.next = head;
            rightTail = head;
        }
        head = head.next;
    }
    leftTail.next = rightHead.next;
    rightTail.next = null;
    return leftHead.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}
