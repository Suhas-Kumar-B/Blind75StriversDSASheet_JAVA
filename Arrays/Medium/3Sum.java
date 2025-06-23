// Question Link: https://leetcode.com/problems/3sum/

import java.util.*;

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - Check all possible triplets.
    - Time Complexity: O(n^3)
    - Space Complexity: O(1) (excluding result)
    */
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Check all triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        // Avoid adding duplicate triplets
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }

    /*
    2️⃣ Optimal Approach (Sorting + Two Pointer Technique)
    - Sort the array and use two pointers to find pairs.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1) (excluding result)
    */
    public List<List<Integer>> threeSumTwoPointer(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Valid triplet found
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;  // Increase sum
                }
                else {
                    right--; // Decrease sum
                }
            }
        }
        return result;
    }
}
