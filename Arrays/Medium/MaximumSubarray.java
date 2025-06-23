// Question Link: https://leetcode.com/problems/maximum-subarray/

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - Check sum of every possible subarray.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public int maxSubArrayBruteForce(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        // Consider every subarray starting from index i
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Add elements till the end of array
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                // Update maxSum if currentSum is greater
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    /*
    2️⃣ Kadane's Algorithm (Optimal):
    - Keep track of currentSum and reset if it drops below 0.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int maxSubArrayKadane(int[] nums) {
        int maxSum = nums[0];         // Initialize maxSum to first element
        int currentSum = nums[0];     // Initialize currentSum to first element

        // Iterate from second element onwards
        for (int i = 1; i < nums.length; i++) {
            // Either start new subarray at current element, or continue existing
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    /*
    3️⃣ Dynamic Programming (Tabulation):
    - Store maximum subarray sum ending at each index.
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public int maxSubArrayDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];

        // Build DP array where dp[i] is max subarray sum ending at i
        for (int i = 1; i < n; i++) {
            // Either extend previous subarray or start new at current
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            // Update maxSum if dp[i] is greater
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
