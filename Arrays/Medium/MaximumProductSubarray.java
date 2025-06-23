// Question Link: https://leetcode.com/problems/maximum-product-subarray/

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - Check product of every possible subarray.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public int maxProductBruteForce(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        // Consider every possible subarray
        for (int i = 0; i < n; i++) {
            int currentProduct = 1;
            for (int j = i; j < n; j++) {
                currentProduct *= nums[j];
                // Update maxProduct if currentProduct is greater
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }

    /*
    2️⃣ Optimal Approach (Kadane’s Modified for Products):
    - Keep track of both current maximum and minimum product at each step.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int maxProductKadane(int[] nums) {
        int maxProduct = nums[0];   // Initialize maxProduct to first element
        int currMax = nums[0];      // Current maximum product ending here
        int currMin = nums[0];      // Current minimum product ending here

        // Iterate from second element onwards
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If current number is negative, swap currMax and currMin
            if (num < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Update currMax and currMin
            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);

            // Update global maxProduct
            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }
}
