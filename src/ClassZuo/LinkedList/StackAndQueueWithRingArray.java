package ClassZuo.LinkedList;

public class StackAndQueueWithRingArray {
    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue(5);
        System.out.println(queue.isEmpty());

        for (int i = 0; i < 5; i++) {
            queue.put(i);
        }
        System.out.println(queue.isFull());

        for (int i = 0; i < 3; i++) {
            System.out.println(queue.get());
        }
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        for (int i = 0; i < 3; i++) {
            queue.put(10 - i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.get());
        }
    }
}

class MyArrayQueue {
    private final int limit;
    private int[] arr;

    private int putIdx;
    private int getIdx;
    private int size;

    public MyArrayQueue(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit must be positive integer");
        }
        this.limit = limit;
        this.arr = new int[limit];
        putIdx = 0;
        getIdx = 0;
        size = 0;
    }

    public void put(int value) {
        if (size == limit) {
            throw new UnsupportedOperationException("Queue is already full");
        }
        arr[putIdx] = value;
        size ++;
        putIdx = nextIndex(putIdx);
    }

    public int get() {
        if (size == 0) {
            throw new UnsupportedOperationException("Queue is empty");
        }
        int value = arr[getIdx];
        size --;
        getIdx = nextIndex(getIdx);
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    private int nextIndex(int index) {
        return (index + 1) % limit;
    }
}
