package ClassZuo.Heap;

// 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，
// 每个元素移动的距离一定不超过`k`，并且`k`相对于数组长度来说是比较小的。
// 请选择一个合适的排序策略，对这个数组进行排序。

import java.util.PriorityQueue;

public class SortArrayWithinKthDistance {

    public static void main(String[] args) {
        SortArrayWithinKthDistance sorter = new SortArrayWithinKthDistance();
        int[] arr = new int[] {1, 2, 6, 4, 7, 3, 5, 8, 11, 10, 9, 13, 12};
        sorter.sortWithinKthDistance(arr, 5);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void sortWithinKthDistance(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k == 0) {
            return;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <= k; index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; i++, index++) {
            arr[i] = heap.poll();
            // 保持堆中有 k+1 个数
            heap.add(arr[index]);
        }
        // 处理最后k个
        while (i < arr.length && ! heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
