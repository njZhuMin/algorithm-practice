package ClassZuo.Sorting;

public class O51_InversePairs {

    public static void main(String[] args) {
        O51_InversePairs inversePairs = new O51_InversePairs();
        int[] arr = new int[] {1, 3, 2, 3, 1};
//        int[] arr = new int[] {2,3,3,4,1,1,2,2};
        System.out.println(inversePairs.getInversePairs(arr));
    }

    public int getInversePairs(int[] arr) {
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
                mergeAndCalcInversePairs(arr, left, mid, right);
    }

    private int mergeAndCalcInversePairs(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        int inversePair = 0;
        // 找出左组中多少数比右组大
        while (p1 <= mid && p2 <= right) {
            // 左组小于等于右组时，都先归并左组的数
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                // 左组严格大于右组时，先归并右组小的数
                help[i++] = arr[p2++];
                // 同时在左组产生 p1 右边的数，都是大于右组的
                inversePair += mid - p1 + 1;
            }
        }
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
        return inversePair;
    }
}
