package ClassZuo.Recursive;

public class RecursiveGetMax {

    public static void main(String[] args) {
        int[] arr = new int[] {-10, 0, 33, 4, 17};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
         if (left < 0 || right > arr.length - 1 || left > right) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = process(arr, left, mid);
        int rightMax = process(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
