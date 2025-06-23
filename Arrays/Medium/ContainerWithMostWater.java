// Question Link: https://leetcode.com/problems/container-with-most-water/

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - Check area formed by every possible pair of lines.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        int n = height.length;

        // Check every pair of lines
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate area formed between lines at i and j
                int area = (j - i) * Math.min(height[i], height[j]);
                // Update maximum area
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /*
    2️⃣ Optimal Approach (Two Pointer Technique)
    - Start with two pointers at both ends of the array.
    - Move the pointer with the shorter line inward.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int maxAreaTwoPointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // Loop until pointers meet
        while (left < right) {
            // Calculate area between the two lines
            int area = (right - left) * Math.min(height[left], height[right]);
            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
