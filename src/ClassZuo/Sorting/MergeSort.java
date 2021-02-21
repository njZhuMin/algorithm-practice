package ClassZuo.Sorting;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = new int[] {17, 3, -6, 9, 11, 2, -4, 5};

        sort.recursiveMergeSort(arr);
//        sort.iterativeMergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void recursiveMergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int left, int right) {
        // base case
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            // 等于时先拷贝左侧，具有排序稳定性
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        // 要么p1越界，要么p2越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        // 刷回结果
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public void iterativeMergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 左组size
        int mergeSize = 1;
        // mergeSize = 1: [ 0 | 1 ] [ 2 | 3 ] [4 | 5 ] [ 6 | 7 ]
        // mergeSize = 2: [ 0...1 | 2...3 ] [ 4...5 | 6...7 ]
        // mergeSize = 4: [ 0...3 | 4...7 ]
        // mergeSize = 8: done

        while (mergeSize < N) {
            // 总是从0开始
            int left = 0;
            while (left < N) {
                int mid = left + mergeSize - 1;
                if (mid >= N) {
                    break;
                }
                int right = Math.min(mid + mergeSize, N - 1);
                merge(arr, left, mid, right);

                // move on next iteration
                left = right + 1;
            }

            // 此时左组长度已经超过了整个数组的一半，不需要再做下一轮归并了
            // 为了防止这时mergeSize很大（如已经逼近 N）
            // 乘 2 后远大于 N，在下一轮判断前就溢出，所以直接break
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize = mergeSize << 1;
        }
    }
}
