package Leetcode.BitManipulation;

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
// Example 1:
//
//
//Input: [2,2,1]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,1,2,1,2]
//Output: 4
//
// Related Topics 位运算 哈希表

public class L136_SingleNumber {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 2, 1};
        int[] arr2 = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumberWithXor(arr1));
        System.out.println(singleNumberWithXor(arr2));
    }

    static int singleNumberWithXor(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        return xor;
    }
}
