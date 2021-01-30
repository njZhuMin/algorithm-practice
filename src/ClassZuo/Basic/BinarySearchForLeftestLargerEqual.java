package ClassZuo.Basic;

/**
 * 在有序数列中，返回第一个大于等于某值的数的位置
 */
public class BinarySearchForLeftestLargerEqual {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{-6, -5, 2, 2, 3, 3, 3, 144, 276, 466};
        System.out.println(leftLargerEqual(sortedArr, -8));
        System.out.println(leftLargerEqual(sortedArr, 2));
        System.out.println(leftLargerEqual(sortedArr, 3));
    }
    
    static int leftLargerEqual(int[] sortedArr, int value) {
        int left = 0;
        int mid = 0;
        int right = sortedArr.length - 1;
        int index = -1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (sortedArr[mid] >= value) {
                index = mid;
                // 还没结束，左边可能还有相等的
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
