package Leetcode.BinarySearch;

//A peak element is an element that is greater than its neighbors.
//
// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
// You may imagine that nums[-1] = nums[n] = -∞.
//
// Example 1:
//
//
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index number 2.
//
// Example 2:
//
//
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5
//Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
//
//
// Follow up: Your solution should be in logarithmic complexity.
// Related Topics 数组 二分查找

public class L162_FindPeekElement {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 1};
        int[] arr2 = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr1));
        System.out.println(findPeakElement(arr2));
    }

    static int findPeakElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] > arr[1]) {
            // 第一个数即是峰值
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            // 最后一个数即是峰值
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            // 比前一个数小，前一半必然存在峰值，丢弃后一半
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                // 比后一个数小，后一半必然存在峰值，丢弃前一半
                left = mid + 1;
            } else {
                // 比前数大，比后数大，找到峰值
                return mid;
            }
        }
        return left;
    }
}
