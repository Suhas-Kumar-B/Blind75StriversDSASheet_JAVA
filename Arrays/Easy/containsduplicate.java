// Question Link: https://leetcode.com/problems/contains-duplicate/

import java.util.*;

class Solution {

    /*
    1️⃣ Brute Force Approach:
    - Check every possible pair for equality.
    - Time Complexity: O(n^2)
    - Space Complexity: O(1)
    */
    public boolean containsDuplicateBruteForce(int[] nums) {
        int n = nums.length;

        // Compare each element with every other element
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // If a duplicate is found, return true
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // No duplicates found
        return false;
    }

    /*
    2️⃣ Sorting Approach:
    - Sort the array and check consecutive elements.
    - Time Complexity: O(n log n)
    - Space Complexity: O(1) or O(n) depending on sorting algorithm
    */
    public boolean containsDuplicateSorting(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Check consecutive elements for duplicates
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /*
    3️⃣ HashSet Approach (Optimal):
    - Use a HashSet to track seen elements.
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public boolean containsDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Iterate through each number in the array
        for (int num : nums) {
            // If number already exists in set, duplicate found
            if (set.contains(num)) {
                return true;
            }
            // Add number to set
            set.add(num);
        }
        // No duplicates found
        return false;
    }

    /*
    4️⃣ Stream + Set (Java 8 One-liner Fun Approach — for concept)
    - Time Complexity: O(n)
    - Space Complexity: O(n)
    */
    public boolean containsDuplicateStream(int[] nums) {
        // Convert array to stream, box to Integer, collect into set, and compare sizes
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() < nums.length;
    }
}
