// Question Link: https://leetcode.com/problems/two-sum/

import java.util.*;

// Class containing different approaches to solve Two Sum
class Solution {

    /*
    1️⃣ Brute Force Approach: 
    - Check every possible pair using 2 nested loops.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public int[] twoSumBruteForce(int[] nums, int target) {
        // Iterate through each element
        for (int i = 0; i < nums.length - 1; i++) {
            // For each element, iterate through the remaining elements to the right
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the current pair sums to target
                if (nums[i] + nums[j] == target) {
                    // Return their indices
                    return new int[]{i, j};
                }
            }
        }
        // If no pair found, return {-1, -1}
        return new int[]{-1, -1};
    }

    /*
    2️⃣ Optimal Approach (Single-Pass HashMap):
    - Use a HashMap to store numbers and their indices as you traverse the array.
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public int[] twoSumHashMap(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the number needed to reach the target
            int moreNeeded = target - nums[i];

            // If needed number exists in map, return the indices
            if (map.containsKey(moreNeeded)) {
                return new int[]{map.get(moreNeeded), i};
            }

            // Otherwise, store current number and its index
            map.put(nums[i], i);
        }

        // If no pair found, return {-1, -1}
        return new int[]{-1, -1};
    }

    /*
    3️⃣ Sorting + Two Pointers Approach:
    - Sort the array while keeping track of original indices.
    - Move two pointers to find the target sum.
    - Time Complexity: O(n log n)
    - Space Complexity: O(n)
    */
    class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] twoSumTwoPointers(int[] nums, int target) {
        int n = nums.length;

        // Create an array of Pair objects to store value and original index
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // Sort the array based on values
        Arrays.sort(arr, (a, b) -> a.value - b.value);

        // Initialize two pointers
        int left = 0, right = n - 1;

        // Traverse with two pointers
        while (left < right) {
            int sum = arr[left].value + arr[right].value;

            if (sum == target) {
                // Return original indices if pair found
                return new int[]{arr[left].index, arr[right].index};
            } else if (sum < target) {
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }

        // If no pair found, return {-1, -1}
        return new int[]{-1, -1};
    }

    /*
    4️⃣ HashSet Approach (Only check if a pair exists — no indices):
    - Use a HashSet to check if (target - current number) exists.
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public boolean hasTwoSumHashSet(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            // Check for complement in set
            if (set.contains(target - num)) {
                return true;
            }
            // Add current number to set
            set.add(num);
        }
        // No such pair exists
        return false;
    }
}
