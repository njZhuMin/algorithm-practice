package ClassZuo.Sorting;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int arr[] = new int[] {7, 3, 2, 4, -9, 0, -5, 11};
        quickSort.quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // 随机选择一个数，与arr[R]交换
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);

        int[] equalArea = partition(arr, L, R);
        int less = equalArea[0];
        int larger = equalArea[1];
        process(arr, L, less - 1);
        process(arr, larger + 1, R);
    }

    private int[] partition(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] {-1, -1};
        }
        if (L == R) {
            return new int[] {L, R};
        }
        int less = L - 1;
        // 就用 arr[R] 划分，先把 arr[R] 放在大于区，最后再调整
        int larger = R;
        int i = L;
        while (i < larger) {
            if (arr[i] == arr[R]) {
                i++;
            } else if (arr[i] < arr[R]) {
                swap(arr, i++, ++less);
            } else {
                swap(arr, i, --larger);
            }
        }
        // 最后处理 arr[R]，和大于区第一个数交换
        // 这个数来到大于区第一个，真正大于区范围 [larger + 1 ... R]
        // 小于区范围 [L ... less]，等于区范围 [ less + 1, larger]
        swap(arr, larger, R);
        return new int[]{less + 1, larger};
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
