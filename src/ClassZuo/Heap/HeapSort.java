package ClassZuo.Heap;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[] {-9, 4, 0, 3, 2, 7, -5, 6, 4};
        heapSort.heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // 时间复杂度 O(N * log N)
    // 额外空间复杂度 O(1)
    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // Init max heap 1: O(N * log N)
//		for (int i = 0; i < arr.length; i++) {
//			heapInsert(arr, i);
//		}

		// Init max heap 2: O(log N)
        // 优化：从后往前做heapify下沉，最后一层节点（后 N/2 数）不需要动
        for (int i = arr.length - 1; i >= 0; i--) {
            // heapSize = arr.length
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        // 排序：将第一个数（最大值）与最后一个交换，heapSize--
        swap(arr, 0, --heapSize);
        // O(N * log N)
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
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

    // 从 index 开始下沉，直到比左右子节点都大，或者已经没有子节点了
    private void heapify(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = heap[index] > heap[left] ? index : left;
            largest = left + 1 < heapSize && heap[left + 1] > heap[largest] ?
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

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
