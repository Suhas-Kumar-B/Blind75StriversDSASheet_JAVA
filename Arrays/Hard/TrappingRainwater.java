// Question Link: https://leetcode.com/problems/trapping-rain-water/

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - For every bar, find the maximum height to its left and right.
    - Water trapped on top of current bar = min(leftMax, rightMax) - height[i]
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public int trapBruteForce(int[] height) {
        int n = height.length;
        int totalWater = 0;

        // For each bar
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            // Find maximum bar on the left
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find maximum bar on the right
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Water trapped at current bar
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        return totalWater;
    }

    /*
    2️⃣ Better Approach: Precomputed Left and Right Max Arrays
    - Precompute max to the left and right of each bar.
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public int trapWithExtraArrays(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int totalWater = 0;

        // Precompute left max for each bar
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Precompute right max for each bar
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Compute trapped water
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    /*
    3️⃣ Optimal Approach: Two Pointer Technique
    - Use two pointers moving towards each other, keeping track of leftMax and rightMax.
    - Time Complexity: O(n)
    - Space Complexity: O(1)
    */
    public int trapTwoPointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Update left max
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water trapped at current left
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // Update right max
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water trapped at current right
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
