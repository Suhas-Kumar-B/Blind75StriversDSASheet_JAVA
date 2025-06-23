// Question Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {

    /*
    1️⃣ Linear Search (Brute Force)
    - Check every element.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int findMinLinear(int[] nums) {
        int minVal = nums[0];
        for (int num : nums) {
            if (num < minVal) {
                minVal = num;
            }
        }
        return minVal;
    }

    /*
    2️⃣ Optimal Approach: Binary Search
    - Use binary search to find pivot point (smallest element)
    - Time Complexity: O(log n)
    - Space Complexity: O(1)
    */
    public int findMinBinarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If array is not rotated at all
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        // Binary search loop
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost, min is to the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Else min is to the left including mid
            else {
                right = mid;
            }
        }
        // When loop ends, left == right pointing to the min element
        return nums[left];
    }
}
