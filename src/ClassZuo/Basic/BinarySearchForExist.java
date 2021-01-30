package ClassZuo.Basic;

/**
 * 查找一个有序数列中，一个数是否存在
 */
public class BinarySearchForExist {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{-256, -88, -9, -6, 0, 3, 7, 144, 276, 466};
        System.out.println(numberExists(sortedArr, -9));
        System.out.println(numberExists(sortedArr, 77));
    }

    static boolean numberExists(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int left = 0;
        int mid = 0;
        int right = sortedArr.length - 1;
        while (left < right) {
            // 更安全的写法, int left + int right 可能溢出
            mid = left + ((right - left) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return sortedArr[left] == num;
    }
}
