package Leetcode.BitManipulation;

//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
// Find the two elements that appear only once.
//
// Example:
//
//
//Input:  [1,2,1,3,2,5]
//Output: [3,5]
//
// Note:
//
//
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
//
// Related Topics 位运算

import java.util.Arrays;

public class Q260_SingleNumberIII {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(twoSingleNumbers(arr)));
    }

    static int[] twoSingleNumbers(int[] arr) {
        // 假设两个只出现一次的数为 a, b
        int xor = 0;
        for (int ele : arr) {
            xor = xor ^ ele;
        }
        // 此时 xor = a ^ b
        // 因为 a ≠ b，因此 xor ≠ 0，其二进制必然至少有一个1
        // 假设 a 在第 N 位为 1
        int rightestBitOne = getRightestOne(xor);
        int elementA = 0;
        for (int ele : arr) {
            if ((ele & rightestBitOne) != 0) {
                // 过滤出第 N 位为 1 的元素
                elementA = elementA ^ ele;
            }
        }
        int elementB = xor ^ elementA;
        return new int[]{elementA, elementB};
    }

    static int getRightestOne(int N) {
        return N & (~N + 1);
    }
}
