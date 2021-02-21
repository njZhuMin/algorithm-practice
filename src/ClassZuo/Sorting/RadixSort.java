package ClassZuo.Sorting;

import java.util.ArrayList;
import java.util.List;

// 数据特征：非负数，十进制，最多N位数
public class RadixSort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = new int[] {3, 17, 241, 31, 22, 8, 10, 100, 56, 19};
//        radixSort.plainRadixSort(arr);
        radixSort.classicRadixSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void classicRadixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        final int RADIX = 10;
        int maxDigit = getMaxDigit(arr);

        int[] help = new int[arr.length];

        // 时间复杂度 O(N * log_{10}{max})
        for (int digit = 1; digit <= maxDigit; digit++) {
            // calculate digit buckets
            int[] count = new int[RADIX];
            for (int i = 0; i < arr.length; i++) {
                int digitNum = getDigit(arr[i], digit);
                count[digitNum]++;
            }

            // count[i]： 当前位(d位)是(0~i)的数字有多少个
            // count  [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
            //         0   2   1   3   2   4   1   2   0   0
            // count'  0   2   3   6   8   12  13  15  15  15
            for (int i = 1; i < RADIX; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 从右向左反过来倒出数字
            for (int i = arr.length - 1; i >= 0; i--) {
                int digitNum = getDigit(arr[i], digit);
                int pos = count[digitNum] - 1;
                help[pos] = arr[i];
                count[digitNum]--;
            }

            // copy back
            for (int i = 0; i < arr.length; i++) {
                arr[i] = help[i];
            }
        }
    }

    public void plainRadixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        final int RADIX = 10;
        // prepare buckets
        List<List<Integer>> buckets = new ArrayList<>(RADIX);
        for (int i = 0; i < RADIX; i++) {
            buckets.add(new ArrayList<>());
        }

        int maxDigit = getMaxDigit(arr);

        // 时间复杂度 O(N * log_{10}{max})
        for (int digit = 1; digit <= maxDigit; digit++) {
            // put into buckets
            for (int i = 0; i < arr.length; i++) {
                int digitNum = getDigit(arr[i], digit);
                buckets.get(digitNum).add(arr[i]);
            }

            // pour back with origin order by current digit number
            int k = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    arr[k++] = num;
                }
            }
            for (List<Integer> bucket : buckets) {
                bucket.clear();
            }
        }
    }

    private int getMaxDigit(int[] arr) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        int maxDigit = 0;
        while (maxNum % 10 != 0) {
            maxDigit++;
            maxNum = maxNum / 10;
        }
        return maxDigit;
    }

    private int getDigit(int num, int digit) {
        return (num / ((int) Math.pow(10, digit - 1))) % 10;
    }
}
