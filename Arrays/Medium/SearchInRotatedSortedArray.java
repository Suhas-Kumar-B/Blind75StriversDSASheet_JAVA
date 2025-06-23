// Question Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {

    /*
    1️⃣ Linear Search (Brute Force)
    - Scan through the array one by one.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int searchLinear(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /*
    2️⃣ Optimal Approach: Modified Binary Search
    - Use binary search to handle rotated sorted array.
    - Time Complexity: O(log n)
    - Space Complexity: O(1)
    */
    public int searchBinary(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Standard binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                // If target lies within left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else { // Target is in right half
                    left = mid + 1;
                }
            }
            // Else right half is sorted
            else {
                // If target lies within right half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else { // Target is in left half
                    right = mid - 1;
                }
            }
        }
        // Target not found
        return -1;
    }
}
