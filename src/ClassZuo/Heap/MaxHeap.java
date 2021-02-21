package ClassZuo.Heap;

public class MaxHeap {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        int[] arr = new int[] {-9, 4, 0, 3, 2, 7, -5, 6, 4};

        for (int i : arr) {
            heap.push(i);
        }
        while (! heap.isEmpty()) {
            System.out.println(heap.pop() + " ");
        }
    }

    public MaxHeap(int limit) {
        this.limit = limit;
        heap = new int[limit];
        heapSize = 0;
    }

    public void push(int value) {
        if (heapSize == limit) {
            throw new UnsupportedOperationException("Heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    // 插入的数放在最后一个，然后上浮
    // O(log N)
    private void heapInsert(int[] heap, int index) {
        while ((index - 1) / 2 >= 0 &&
                heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 弹出堆顶的数并删掉，维护剩下的数依然是大根堆
    public int pop() {
        if (heapSize == 0) {
            throw new UnsupportedOperationException("Heap is empty");
        }
        int value = heap[0];

        // 先 heapSize - 1 缩小范围
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);

        return value;
    }

    // 从 index 开始下沉，直到比左右子节点都大，或者已经没有子节点了
    private void heapify(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = heap[index] > heap[left] ? index : left;
            largest = (left + 1 < heapSize) && (heap[left + 1] > heap[largest]) ?
                    left + 1 : largest;
            if (largest == index) {
                // 自己就是最大，不需要再下沉了
                break;
            }
            swap(heap, largest, index);
            index = largest;

            // 继续向下找左子节点
            left = index * 2 + 1;
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
