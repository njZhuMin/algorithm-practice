package ClassZuo.LinkedList;

public class ReverseDoubleList {

    static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            // 记录当前节点的下一个
            next = head.next;

            // 当前节点下一个指向前一个
            head.next = pre;
            // 当前节点前一个指向下一个
            head.last = next;
            // pre指向当前节点
            pre = head;

            // head节点处理完毕，进行下一个节点
            head = next;
        }
        return pre;
    }
}
