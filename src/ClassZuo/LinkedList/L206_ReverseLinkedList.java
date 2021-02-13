package ClassZuo.LinkedList;

//Reverse a singly linked list.
//
// Example:
//
//
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you implement both?
// Related Topics 链表

public class L206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            // 记住下一个位置
            next = head.next;
            // 当前位置 next 向前指
            head.next = pre;
            // pre 来到当前位置
            pre = head;
            // head 来到下一个
            head = next;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
