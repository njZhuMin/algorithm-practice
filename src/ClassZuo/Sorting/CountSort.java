package ClassZuo.Sorting;

public class CountSort {

    // 假设样本为年龄，分布在 [0 - 100]的整数
    public void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];

        // calculate data in bucket
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        // refill data array with bucket index
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
