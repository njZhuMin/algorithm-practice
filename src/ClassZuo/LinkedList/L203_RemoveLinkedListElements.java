package ClassZuo.LinkedList;

public class L203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }

        // 此时 head 来到第一个不需要删除的节点
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            // pre 留在上一个不需要删除的位置
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
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
