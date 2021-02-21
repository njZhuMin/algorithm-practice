package ClassZuo.Sorting;

public class MergeSmallSum {

    public static void main(String[] args) {
        MergeSmallSum smallSum = new MergeSmallSum();
        int[] arr = new int[] {1, 3, 4, 2, 5};

        System.out.println(smallSum.getSmallSum(arr));
    }

    public int getSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private int process(int[] arr, int left, int right) {
        // base case
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) +
                process(arr, mid + 1, right) +
                mergeAndCalcSmallSum(arr, left, mid, right);
    }

    private int mergeAndCalcSmallSum(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;

        int smallSum = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                help[i] = arr[p1];
                // 产生小和
                smallSum += (right - p2 + 1) * arr[p1];
                p1++;
            } else {
                // 左右相等，不产生小和，但先归并右组
                // 因为需要右组的下标计算比左边大的数的个数，必须严格大于左数
                help[i] = arr[p2];
                p2++;
            }
            i++;
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return smallSum;
    }
}
