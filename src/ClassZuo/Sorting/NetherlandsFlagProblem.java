package ClassZuo.Sorting;

// 给定一个数组arr，和一个整数num。请把数组 L...R 上的部分按num划分，小于num的数放在数组的左边，等于的数放在中间，大于num的数放在数组的右边。（但左右两部分中的数不需要有序）
// 返回等于区的左右下标。
// 要求：num = arr[R]，额外空间复杂度`O(1)`，时间复杂度`O(N)`。
//
// 示例：[7, 2, 4, 6, 8, 5, 4]，num = 4
// 排序后： [2 | 4, 4 | 7, 6, 5, 8]
// 返回值： [1, 2]

public class NetherlandsFlagProblem {

    public static void main(String[] args) {
        NetherlandsFlagProblem netherlandsFlag = new NetherlandsFlagProblem();
        int[] arr = new int[] {7, 1, 3, 8, 2, 5, 3, 4};
        int L = 1;
        int R = 6;
        int[] equalArea = netherlandsFlag.partition(arr, L, R);
        for (int i : equalArea) {
            System.out.print(i + " ");
        }
    }

    private void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = partition(arr, L, R);
        int less = equalArea[0];
        int larger = equalArea[1];
        process1(arr, L, less - 1);
        process1(arr, larger + 1, R);
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
