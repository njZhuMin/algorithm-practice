package ClassZuo.LinkedList;

public class StackAndQueueWithDoubleEndQueue {

}

class MyLinkedStack<T> {
    private final DoubleEndQueue<T> queue;

    public MyLinkedStack() {
        queue = new DoubleEndQueue<T>();
    }

    public void push(T value) {
        queue.addFromHead(value);
    }

    public T pop() {
        return queue.popFromHead();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class MyLinkedQueue<T> {
    private final DoubleEndQueue<T> queue;

    public MyLinkedQueue() {
        queue = new DoubleEndQueue<T>();
    }

    public void put(T value) {
        queue.addFromHead(value);
    }

    public T get() {
        return queue.popFromBottom();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class Node<T> {
    public T value;
    public Node<T> last;
    public Node<T> next;

    public Node(T data) {
        value = data;
    }
}

class DoubleEndQueue<T> {
    public Node<T> head;
    public Node<T> tail;

    public void addFromHead(T value) {
        Node<T> cur = new Node<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
    }

    public void addFromBottom(T value) {
        Node<T> cur = new Node<>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            cur.last = tail;
            tail = cur;
        }
    }

    public T popFromHead() {
        if (head == null) {
            return null;
        }
        Node<T> cur = head;
        // 只剩一个节点
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.last = null;
            cur.next = null;
        }
        return cur.value;
    }

    public T popFromBottom() {
        if (head == null) {
            return null;
        }
        Node<T> cur = tail;
        // 只剩一个节点
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
            cur.last = null;
        }
        return cur.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}